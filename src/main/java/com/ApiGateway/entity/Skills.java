package com.ApiGateway.entity;





	import java.util.List;

	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;

	@Entity
	public class Skills {

		@Id
		private long id;
		
		private String skills;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "skills")
		private List<UserSkillsEntity> user;
		
		private boolean isActive=true;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getSkills() {
			return skills;
		}

		public void setSkills(String skills) {
			this.skills = skills;
		}

		public List<UserSkillsEntity> getUser() {
			return user;
		}

		public void setUser(List<UserSkillsEntity> user) {
			this.user = user;
		}

		public boolean isActive() {
			return isActive;
		}

		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}

		public Skills(long id, String skills, List<UserSkillsEntity> user, boolean isActive) {
			super();
			this.id = id;
			this.skills = skills;
			this.user = user;
			this.isActive = isActive;
		}

		public Skills() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		  
		
		
		
		
		
	



}
