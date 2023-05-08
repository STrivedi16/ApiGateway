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
	@SQLDelete(sql = "update permissions set is_active=false where id=?")
	@Where(clause = "is_active=true")
	public class Permissions {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id ;
		
		private String permissions;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "permissions")
		private List<RolesPermissionEntity> roles;
		
		@CreationTimestamp
		private Timestamp creationTime;
		
		@UpdateTimestamp
		private Timestamp updationTime;
		
		private boolean isActive=true;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getPermissions() {
			return permissions;
		}

		public void setPermissions(String permissions) {
			this.permissions = permissions;
		}

		public List<RolesPermissionEntity> getRoles() {
			return roles;
		}

		public void setRoles(List<RolesPermissionEntity> roles) {
			this.roles = roles;
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

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public Permissions(long id, String permissions, List<RolesPermissionEntity> roles, Timestamp creationTime,
				Timestamp updationTime, boolean isActive) {
			super();
			this.id = id;
			this.permissions = permissions;
			this.roles = roles;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
			this.isActive = isActive;
		}

		public Permissions() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	}


