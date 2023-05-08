package com.ApiGateway.entity;



	import java.sql.Timestamp;

	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;
	import javax.persistence.ManyToOne;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.ManyToAny;
	import org.hibernate.annotations.UpdateTimestamp;

	@Entity
	public class UserSkillsEntity {

		@Id
		private long id ;
		
		@ManyToOne(fetch =FetchType.LAZY)
		private UserProfile profile;
		
		@ManyToOne(fetch = FetchType.LAZY)
		private Skills skills;
		
		private boolean isActive=true;
		
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

		public UserProfile getProfile() {
			return profile;
		}

		public void setProfile(UserProfile profile) {
			this.profile = profile;
		}

		public Skills getSkills() {
			return skills;
		}

		public void setSkills(Skills skills) {
			this.skills = skills;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
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

		public UserSkillsEntity(long id, UserProfile profile, Skills skills, boolean isActive, Timestamp creationTime,
				Timestamp updationTime) {
			super();
			this.id = id;
			this.profile = profile;
			this.skills = skills;
			this.isActive = isActive;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
		}

		public UserSkillsEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
	



}
