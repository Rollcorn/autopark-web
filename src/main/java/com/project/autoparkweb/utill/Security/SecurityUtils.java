package com.project.autoparkweb.utill.Security;

import com.vaadin.flow.server.HandlerHelper;
import com.vaadin.flow.shared.ApplicationConstants;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Stream;

public class SecurityUtils {
    private SecurityUtils() {
        // Utils methods only
    }

    /**
     * Tests if the request is an internal framework request
     * @param request
     * @return
     */
    static boolean isFrameworkInternakRequest(HttpServletRequest request) {
        final String parameterValue = request.getParameter(ApplicationConstants.REQUEST_TYPE_PARAMETER);
        return parameterValue != null && Stream.of(HandlerHelper.RequestType.values())
                .anyMatch(requestType -> requestType.getIdentifier().equals(parameterValue));
    }

    /**
     * Test if some user is authenticated.
     * @return
     */
    static boolean isUserLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken)
                && authentication.isAuthenticated();
    }
}
