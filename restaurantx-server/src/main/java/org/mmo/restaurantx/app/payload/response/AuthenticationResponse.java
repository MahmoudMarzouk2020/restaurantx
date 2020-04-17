package org.mmo.restaurantx.app.payload.response;

public class AuthenticationResponse extends ApiResponse{
    
    private String accessToken;
    private final String tokenType = "Bearer";
    
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
    
}
