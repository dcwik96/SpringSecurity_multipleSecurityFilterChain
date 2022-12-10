package com.example.server;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

public class BasicHeaderFilter extends AbstractPreAuthenticatedProcessingFilter {
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        String expected = "Basic user:password";
        if (header.equals(expected)) {
            return true;
        }
        return false;
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return null;
    }
}


//public class SecondHeaderFilter extends GenericFilterBean {
//
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
//        SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();
//        SecurityContext securityContext = securityContextHolderStrategy.createEmptyContext();
//
//        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;
//
//        String header = servletRequest1.getHeader(HttpHeaders.AUTHORIZATION);
//        String expected = "Basic user:password";
//        if (header.equals(expected)) {
//            securityContext.setAuthentication(
//                    new AnonymousAuthenticationToken(
//                            "auth",
//                            "client-id",
//                            Collections.singleton(new SimpleGrantedAuthority("token"))
//                    )
//            );
//        }
//    }
//}
