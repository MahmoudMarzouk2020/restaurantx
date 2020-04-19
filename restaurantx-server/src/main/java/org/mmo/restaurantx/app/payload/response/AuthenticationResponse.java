package org.mmo.restaurantx.app.payload.response;

import org.mmo.restaurantx.app.security.UserPrincipal;

public class AuthenticationResponse extends ApiResponse {
    
    private String accessToken;
    private final String tokenType = "Bearer";
    private UserPrincipal userPrincipal;
    
    public AuthenticationResponse() {
    }
    
    public AuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public String getTokenType() {
        return tokenType;
    }
    
    public UserPrincipal getUserPrincipal() {
        return userPrincipal;
    }

    public void setUserPrincipal(UserPrincipal user) {
        this.userPrincipal = user;
    }
}
