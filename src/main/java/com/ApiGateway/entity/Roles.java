package com.ApiGateway.entity;

	import java.sql.Timestamp;
	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.SQLDelete;
	import org.hibernate.annotations.UpdateTimestamp;
	import org.hibernate.annotations.Where;

	@Entity
	@SQLDelete(sql = "update roles set is_active=false where id=?")
	@Where(clause = "is_active=true")
	public class Roles {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id ;
		
		private String roles;
		
		private boolean isActive=true;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "roles")
		private List<UserRolesEntity> userRolesEntities;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "roleEntity")
		private List<RolesPermissionEntity> permissions;
		
		@CreationTimestamp
		private Timestamp creationTime;
		
		@UpdateTimestamp
		private Timestamp updationTime;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getRoles() {
			return roles;
		}

		public void setRoles(String roles) {
			this.roles = roles;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public List<UserRolesEntity> getUserRolesEntities() {
			return userRolesEntities;
		}

		public void setUserRolesEntities(List<UserRolesEntity> userRolesEntities) {
			this.userRolesEntities = userRolesEntities;
		}

		public Timestamp getCreationTime() {
			return creationTime;
		}

		public void setCreationTime(Timestamp creationTime) {
			this.creationTime = creationTime;
		}

		public Timestamp getUpdationTime() {
			return updationTime;
		}

		public void setUpdationTime(Timestamp updationTime) {
			this.updationTime = updationTime;
		}

		
		
		
		
		public Roles(long id, String roles, boolean isActive, List<UserRolesEntity> userRolesEntities,
				List<RolesPermissionEntity> permissions, Timestamp creationTime, Timestamp updationTime) {
			super();
			this.id = id;
			this.roles = roles;
			this.isActive = isActive;
			this.userRolesEntities = userRolesEntities;
			this.permissions = permissions;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
		}

		public List<RolesPermissionEntity> getPermissions() {
			return permissions;
		}

		public void setPermissions(List<RolesPermissionEntity> permissions) {
			this.permissions = permissions;
		}

		public Roles() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	}


