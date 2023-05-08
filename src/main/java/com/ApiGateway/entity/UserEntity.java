package com.ApiGateway.entity;

	import java.sql.Timestamp;
	import java.util.List;

	import javax.annotation.Generated;
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.OneToOne;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.SQLDelete;
	import org.hibernate.annotations.UpdateTimestamp;
	import org.hibernate.annotations.Where;

	@Entity
	@SQLDelete(sql = "update user_entity set is_active=false where id=?")
	@Where(clause = "is_active=true")
	public class UserEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE)
		private long id;

		
		private String name;
		
		private String city;
		
		private String state;
		
		private String email;
		
		private String password;
		
		private String mobileNo;
		
		private boolean is_active=true;
		
		@CreationTimestamp
		private Timestamp creationTime;
		
		@UpdateTimestamp
		private Timestamp updationTime;

		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userEntity")
		private List<UserJobsEntity> jobsEntities;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "users")
		private List<UserRolesEntity> roles;
		
		@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "userEntity")
		private UserProfile userProfile;
		
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		
		
		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public List<UserJobsEntity> getJobsEntities() {
			return jobsEntities;
		}

		public void setJobsEntities(List<UserJobsEntity> jobsEntities) {
			this.jobsEntities = jobsEntities;
		}

		public List<UserRolesEntity> getRoles() {
			return roles;
		}

		public void setRoles(List<UserRolesEntity> roles) {
			this.roles = roles;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getState() {
			return state;
		}

		public void setState(String state) {
			this.state = state;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isIs_active() {
			return is_active;
		}

		public void setIs_active(boolean is_active) {
			this.is_active = is_active;
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

		
		public UserEntity(long id, String name, String city, String state, String email, String password, String mobileNo,
				boolean is_active, Timestamp creationTime, Timestamp updationTime, List<UserJobsEntity> jobsEntities,
				List<UserRolesEntity> roles) {
			super();
			this.id = id;
			this.name = name;
			this.city = city;
			this.state = state;
			this.email = email;
			this.password = password;
			this.mobileNo = mobileNo;
			this.is_active = is_active;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
			this.jobsEntities = jobsEntities;
			this.roles = roles;
		}
		
		

		public UserProfile getUserProfile() {
			return userProfile;
		}

		public void setUserProfile(UserProfile userProfile) {
			this.userProfile = userProfile;
		}

		public UserEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

//		@Override
//		public String toString() {
//			return "UserEntity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + "]";
//		}

		
		@Override
	    public String toString() {
	        return "{\"id\":" + id + ",\"name\":\"" + name + "\",\"email\":\"" + email + "\",\"password\":\"" + password
	                + "\"}";
	    }
		
		
		
	}


