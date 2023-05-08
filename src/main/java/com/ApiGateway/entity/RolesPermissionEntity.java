package com.ApiGateway.entity;



	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;

	import org.hibernate.annotations.SQLDelete;
	import org.hibernate.annotations.Where;

	@Entity 
	@SQLDelete(sql = "update roles_permission_entity set is_active=false where id=?")
	@Where(clause = "is_active=true")
	public class RolesPermissionEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id ;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Permissions permissions;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Roles roleEntity;
		
		private boolean isActive=true;

		public long getId() {
			return id;
		}

		
		public void setId(long id) {
			this.id = id;
		}

		public Permissions getPermissions() {
			return permissions;
		}

		public void setPermissions(Permissions permissions) {
			this.permissions = permissions;
		}

		public Roles getRoleEntity() {
			return roleEntity;
		}

		public void setRoleEntity(Roles roleEntity) {
			this.roleEntity = roleEntity;
		}

		

		

		public RolesPermissionEntity(long id, Permissions permissions, Roles roleEntity, boolean isActive) {
			super();
			this.id = id;
			this.permissions = permissions;
			this.roleEntity = roleEntity;
			this.isActive = isActive;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public RolesPermissionEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	}


