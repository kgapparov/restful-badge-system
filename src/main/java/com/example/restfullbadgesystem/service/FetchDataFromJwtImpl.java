package com.example.restfullbadgesystem.service;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

@Service
public class FetchDataFromJwtImpl implements FetchDataFromJwt{

    @Autowired
    private HttpServletRequest request;

    @Override
    public String getUsername() {
        return getAccessToken().getPreferredUsername();
    }

    @Override
    public String getEmail() {
        return getAccessToken().getEmail();
    }

    @Override
    public Map<String, AccessToken.Access> getResourceAccess() {
        return getAccessToken().getResourceAccess();
    }

    public AccessToken getAccessToken(){
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal = (KeycloakPrincipal) token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        return session.getToken();
    }
}
