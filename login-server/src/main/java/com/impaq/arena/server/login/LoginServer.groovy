package com.impaq.arena.server.login

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.joda.JodaModule
import com.impaq.arena.server.login.user.CurrentUserResolver
import com.impaq.arena.server.login.user.UserService
import org.apache.catalina.connector.Connector
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.autoconfigure.security.SecurityPrequisite
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainerFactory
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.web.SpringBootServletInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.core.io.ResourceLoader
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint
import org.springframework.util.ResourceUtils
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE
import static org.springframework.http.HttpMethod.GET
import static org.springframework.http.HttpMethod.POST

@EnableAutoConfiguration
@ComponentScan
@EnableJpaRepositories
class LoginServer extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LoginServer.class, args)
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LoginServer)
    }

    @Configuration
    @ConditionalOnExpression('${security.requireSsl:false}')
    @ConfigurationProperties(name = "ssl", ignoreUnknownFields = false)
    static class SslConfog {

        @Autowired
        ResourceLoader resourceLoader

        int port = 8443

        String keystoreFile

        String keystorePass

        String keystoreType

        @Bean
        EmbeddedServletContainerCustomizer containerCustomizer() {
            return { ConfigurableEmbeddedServletContainerFactory factory ->
                if (factory instanceof TomcatEmbeddedServletContainerFactory) {
                    TomcatEmbeddedServletContainerFactory containerFactory = (TomcatEmbeddedServletContainerFactory) factory
                    containerFactory.addConnectorCustomizers({ Connector connector ->
                        connector.setPort(port);
                        connector.setSecure(true);
                        connector.setScheme("https");
                        connector.setAttribute("keyAlias", "tomcat");
                        connector.setAttribute("keystorePass", keystorePass);
                        try {
                            connector.setAttribute("keystoreFile", resourceLoader
                                .getResource("file:${keystoreFile}").getFile().getAbsolutePath());
                        } catch (FileNotFoundException e) {
                            throw new IllegalStateException("Cannot load keystore", e);
                        }
                        connector.setAttribute("keystoreType", keystoreType)
                        connector.setAttribute("clientAuth", "false");
                        connector.setAttribute("sslProtocol", "TLS");
                        connector.setAttribute("SSLEnabled", true);
                    } as TomcatConnectorCustomizer);
                }
            } as EmbeddedServletContainerCustomizer;
        }
    }

    @Configuration
    static class ServiceConfig {

        @Bean
        LocalValidatorFactoryBean validatorFactory() {
            return new LocalValidatorFactoryBean()
        }

        @Bean
        MethodValidationPostProcessor validationPostProcessor() {
            MethodValidationPostProcessor processor = new MethodValidationPostProcessor()
            processor.setValidatorFactory(validatorFactory())
            processor.setProxyTargetClass(true)
            processor.setOrder(HIGHEST_PRECEDENCE)
            return processor
        }
    }

    @Configuration
    static class WebConfig extends WebMvcConfigurerAdapter {

        @Bean
        public ObjectMapper objectMapper() {
            return new ObjectMapper()
                    .registerModules(
                new JodaModule())
                    .disable(
                        SerializationFeature.FAIL_ON_EMPTY_BEANS,
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                    .disable(
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
            );
        }

        @Override
        public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setObjectMapper(objectMapper());
            converters.add(converter);
        }

        @Override
        void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
            argumentResolvers.add(new CurrentUserResolver())
        }
    }

    @Configuration
    @EnableWebSecurity
    static class SecurityConfig extends WebSecurityConfigurerAdapter implements SecurityPrequisite {

        @Autowired
        UserService userService;

        @Bean
        PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder()
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder())
        }

        @Override
        @Bean(name = "authenticationManager")
        AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean()
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .httpBasic()
                    .realmName("IMPAQ Arena")
                    .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
            .and()
                .authorizeRequests()
                    .anyRequest().hasAnyRole("USER", "ADMIN")
        }

        @Override
        void configure(WebSecurity web) throws Exception {
            web
                .ignoring()
                    .antMatchers(GET, "/")
                    .antMatchers(POST, "/player")
                    .antMatchers(GET, "/resources/**")

        }
    }
}
