package com.ayan.serviceObject;

public class RoleSO {

	private Long roleId;
	
	private String roleName;
	
	private Long userId;

	
	
	public RoleSO(Long roleId, String roleName, Long userId) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	
}
