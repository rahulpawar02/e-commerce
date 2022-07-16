package com.authservice.domain;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @Column(name = "role")
    private String roleName;

    private String roleDescription;

    public Role() {
    	
    }
    
	public Role(String roleName, String roleDescription) {
		super();
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
  
}
