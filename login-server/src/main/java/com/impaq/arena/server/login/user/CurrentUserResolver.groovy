package com.impaq.arena.server.login.user

import org.springframework.core.MethodParameter
import org.springframework.security.core.Authentication
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

class CurrentUserResolver implements HandlerMethodArgumentResolver {

    @Override
    boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(CurrentUser) != null \
            && parameter.getParameterType().equals(User)
    }

    @Override
    User resolveArgument(
            MethodParameter parameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        return (User) ((Authentication) webRequest.getUserPrincipal()).getPrincipal()
    }
}
