package com.ApiGateway.entity;



	import javax.persistence.Entity;

		import java.sql.Timestamp;
		import java.util.List;

		import javax.persistence.CascadeType;
		import javax.persistence.Entity;
		import javax.persistence.FetchType;
		import javax.persistence.GeneratedValue;
		import javax.persistence.GenerationType;
		import javax.persistence.Id;
		import javax.persistence.OneToMany;
		import javax.persistence.OneToOne;

		import org.hibernate.annotations.CreationTimestamp;
		import org.hibernate.annotations.UpdateTimestamp;

		@Entity
		public class UserProfile {

			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id ;
			
			private String expireance;
			
			@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "profile")
			private List<UserSkillsEntity> skills;
			
			@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
			private UserEntity userEntity;
			
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

			public String getExpireance() {
				return expireance;
			}

			public void setExpireance(String expireance) {
				this.expireance = expireance;
			}

			public List<UserSkillsEntity> getSkills() {
				return skills;
			}

			public void setSkills(List<UserSkillsEntity> skills) {
				this.skills = skills;
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

			public UserProfile(long id, String expireance, List<UserSkillsEntity> skills, Timestamp creationTime,
					Timestamp updationTime, boolean isActive) {
				super();
				this.id = id;
				this.expireance = expireance;
				this.skills = skills;
				this.creationTime = creationTime;
				this.updationTime = updationTime;
				this.isActive = isActive;
			}

			public UserProfile() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			
			
			
			
		


}
