package com.ApiGateway.entity;



	import java.sql.Timestamp;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.UpdateTimestamp;

	@Entity
	public class UserRolesEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id ;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private UserEntity users;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Roles roles;
		
		
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

		public UserEntity getUsers() {
			return users;
		}

		public void setUsers(UserEntity users) {
			this.users = users;
		}

		public Roles getRoles() {
			return roles;
		}

		public void setRoles(Roles roles) {
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

		public UserRolesEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserRolesEntity(long id, UserEntity users, Roles roles, Timestamp creationTime, Timestamp updationTime) {
			super();
			this.id = id;
			this.users = users;
			this.roles = roles;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
		}
		
		
		
		
		
		
		
	}


