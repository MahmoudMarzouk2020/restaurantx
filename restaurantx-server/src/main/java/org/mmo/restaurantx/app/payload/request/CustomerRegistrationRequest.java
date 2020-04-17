package org.mmo.restaurantx.app.payload.request;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CustomerRegistrationRequest implements Serializable {
    
    @Column(name = "first_name")
    @NotBlank
    @NotNull
    @Size(min = 2, max = 80)
    private String firstName;
    
    @Column(name = "last_name")
    @Size(min = 2, max = 120)
    private String lastName;
    
    @NotBlank
    @NotNull
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @NotNull
    @Size(max = 100)
    private String password;
    
    @Column(name = "mobile_number")
    @NotBlank
    @NotNull
    @Size(max = 11)
    private String mobileNumber;
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
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
    
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
}
