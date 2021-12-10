package com.gabo32.dev4j.users.modelos;

public class AuditDetails {
	private String createBy;
	private String roleName;
	
	public AuditDetails() {
	}
	
	public AuditDetails(String createBy, String roleName) {
		super();
		this.createBy = createBy;
		this.roleName = roleName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}
