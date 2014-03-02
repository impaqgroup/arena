package com.impaq.arena.server.login.util

import org.hibernate.validator.constraints.Email
import org.springframework.mock.web.MockHttpServletResponse
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import spock.lang.Specification

import javax.validation.ConstraintViolationException
import javax.validation.Validator

import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

class ExceptionsResolverTest extends Specification {

    ExceptionsResolver resolver = new ExceptionsResolver()


    def "Should report validation errors"() {
        given:
            LocalValidatorFactoryBean factoryBean = new LocalValidatorFactoryBean()
            factoryBean.afterPropertiesSet()
            Validator validator = factoryBean.getValidator()
            ConstraintViolationException ex =
                new ConstraintViolationException(validator.validate(new TestBean(email: "test")))
            MockHttpServletResponse response = new MockHttpServletResponse()
        when:
            resolver.handle(ex, response)
        then:
            response.getStatus() == UNPROCESSABLE_ENTITY.value()
            response.getErrorMessage() ==
                "Validation error(s): 'email' property value of 'test': not a well-formed email address"

    }

    static class TestBean {

        @Email
        String email

    }

}
