package org.mmo.restaurantx.app.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LoginRequest implements Serializable {
    
    @NotBlank
    @NotNull
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String password;
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
}
