package org.mmo.restaurantx.app.domain;

import org.mmo.restaurantx.app.domain.enums.RoleName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity()
@Table(name = "roles", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"role_name"})
})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    
    @Column(name = "role_name")
    @Size(max = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleName roleName;
    
    public Role() {
    }
    
    public Role(@Size(max = 50) RoleName roleName) {
        this.roleName = roleName;
    }
    
    public Integer getRoleId() {
        return roleId;
    }
    
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    
    public RoleName getRoleName() {
        return roleName;
    }
    
    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
