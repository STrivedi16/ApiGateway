package com.ApiGateway.entity;

	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;

	import org.hibernate.annotations.SQLDelete;
	import org.hibernate.annotations.Where;

	

	@Entity
	@SQLDelete(sql = "update user_jobs_entity set is_active=false where id=?")
	@Where(clause = "is_active=true")
	public class UserJobsEntity {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private UserEntity userEntity;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private JobsEntity  jobEntity;
		
		@Enumerated(EnumType.STRING)
		private Status status; 
		
		private boolean is_active=true;
		
		
		
		 

		public UserJobsEntity(long id, UserEntity userEntity, JobsEntity jobEntity, Status status, boolean is_active) {
			super();
			this.id = id;
			this.userEntity = userEntity;
			this.jobEntity = jobEntity;
			this.status = status;
			this.is_active = is_active;
		}

		public boolean isIs_active() {
			return is_active;
		}

		public void setIs_active(boolean is_active) {
			this.is_active = is_active;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public UserEntity getUserEntity() {
			return userEntity;
		}

		public void setUserEntity(UserEntity userEntity) {
			this.userEntity = userEntity;
		}

		public JobsEntity getJobEntity() {
			return jobEntity;
		}

		public void setJobEntity(JobsEntity jobEntity) {
			this.jobEntity = jobEntity;
		}

		

		public UserJobsEntity(long id, UserEntity userEntity, JobsEntity jobEntity, Status status) {
			super();
			this.id = id;
			this.userEntity = userEntity;
			this.jobEntity = jobEntity;
			this.status = status;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public UserJobsEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
	}


