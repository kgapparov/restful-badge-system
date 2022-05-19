package com.example.restfullbadgesystem.service;

import org.keycloak.representations.AccessToken;

import java.util.Collection;
import java.util.Map;

public interface FetchDataFromJwt {
    String getUsername();
    String getEmail();
    public Map<String, AccessToken.Access> getResourceAccess();
}
