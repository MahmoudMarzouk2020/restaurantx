package org.mmo.restaurantx.app.domain;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity()
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"mobile_number"}),
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    
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
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles = new HashSet<>();
    
    public User() {
    }
    
    public User(@Size(min = 2, max = 80) String firstName, @Size(min = 2, max = 120) String lastName, @NotBlank @Size(max = 50) @Email String email, @NotBlank @Size(max = 100) String password, @NotBlank @Size(max = 11) String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.mobileNumber = mobileNumber;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
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
    
    public Set<Role> getUserRoles() {
        return userRoles;
    }
    
    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
