package com.project.autoparkweb.utill.Security;

import org.springframework.security.web.savedrequest.HttpSessionRequestCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class  CustomRequestCache extends HttpSessionRequestCache {
    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (SecurityUtils.isFrameworkInternakRequest(request)) {
            super.saveRequest(request, response);
        }
    }
}
