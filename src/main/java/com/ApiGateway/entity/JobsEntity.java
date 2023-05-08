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
	import javax.persistence.Table;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.SQLDelete;
	import org.hibernate.annotations.UpdateTimestamp;
	import org.hibernate.annotations.Where;

	@Entity
	@SQLDelete(sql = "update jobs_entity set is_active=false where id=?")
	@Where(clause = "is_active=true")
	@Table(name = "JobsEntity" )
	public class JobsEntity {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		private String jobs;
		
		private String role;
		
		private String discription;
		
		private String salary;
		
		private String company;
		
		private String requirement;
		
		private Timestamp dueDate;
		
		private String helplineDetails;
		
		private int opening ;
		
		private String city;
		
		private String state;
		
		
		
		@CreationTimestamp
		private Timestamp creationTime;
		
		@UpdateTimestamp
		private Timestamp updationTime;
		
		private boolean is_active=true;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "jobEntity")
		private List<UserJobsEntity> userJobsEntities;
		
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "jobs")
		private List<RecruiterJobsEntity> recruiter;
		
		private long createdBy;
		
		
		
		

		public long getCreatedBy() {
			return createdBy;
		}

		public void setCreatedBy(long createdBy) {
			this.createdBy = createdBy;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getJobs() {
			return jobs;
		}

		public void setJobs(String jobs) {
			this.jobs = jobs;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getDiscription() {
			return discription;
		}

		public void setDiscription(String discription) {
			this.discription = discription;
		}

		public String getSalary() {
			return salary;
		}

		
		
		
		public String getHelplineDetails() {
			return helplineDetails;
		}

		public void setHelplineDetails(String helplineDetails) {
			this.helplineDetails = helplineDetails;
		}

		

		public JobsEntity(long id, String jobs, String role, String discription, String salary, String company,
				String requirement, Timestamp dueDate, String helplineDetails, Timestamp creationTime,
				Timestamp updationTime, boolean is_active, List<UserJobsEntity> userJobsEntities) {
			super();
			this.id = id;
			this.jobs = jobs;
			this.role = role;
			this.discription = discription;
			this.salary = salary;
			this.company = company;
			this.requirement = requirement;
			this.dueDate = dueDate;
			this.helplineDetails = helplineDetails;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
			this.is_active = is_active;
			this.userJobsEntities = userJobsEntities;
		}

		public Timestamp getDueDate() {
			return dueDate;
		}

		public void setDueDate(Timestamp dueDate) {
			this.dueDate = dueDate;
		}

		public void setSalary(String salary) {
			this.salary = salary;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getRequirement() {
			return requirement;
		}

		public void setRequirement(String requirement) {
			this.requirement = requirement;
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

		public boolean isIs_active() {
			return is_active;
		}

		public void setIs_active(boolean is_active) {
			this.is_active = is_active;
		}
		
		

		public List<UserJobsEntity> getUserJobsEntities() {
			return userJobsEntities;
		}

		public void setUserJobsEntities(List<UserJobsEntity> userJobsEntities) {
			this.userJobsEntities = userJobsEntities;
		}

		
		
		public JobsEntity(long id, String jobs, String role, String discription, String salary, String company,
				String requirement, Timestamp dueDate, String helplineDetails, Timestamp creationTime,
				Timestamp updationTime, boolean is_active, List<UserJobsEntity> userJobsEntities, long createdBy) {
			super();
			this.id = id;
			this.jobs = jobs;
			this.role = role;
			this.discription = discription;
			this.salary = salary;
			this.company = company;
			this.requirement = requirement;
			this.dueDate = dueDate;
			this.helplineDetails = helplineDetails;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
			this.is_active = is_active;
			this.userJobsEntities = userJobsEntities;
			this.createdBy = createdBy;
		}

		public JobsEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getOpening() {
			return opening;
		}

		public void setOpening(int opening) {
			this.opening = opening;
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

		public JobsEntity(long id, String jobs, String role, String discription, String salary, String company,
				String requirement, Timestamp dueDate, String helplineDetails, int opening, String city, String state,
				Timestamp creationTime, Timestamp updationTime, boolean is_active, List<UserJobsEntity> userJobsEntities,
				long createdBy) {
			super();
			this.id = id;
			this.jobs = jobs;
			this.role = role;
			this.discription = discription;
			this.salary = salary;
			this.company = company;
			this.requirement = requirement;
			this.dueDate = dueDate;
			this.helplineDetails = helplineDetails;
			this.opening = opening;
			this.city = city;
			this.state = state;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
			this.is_active = is_active;
			this.userJobsEntities = userJobsEntities;
			this.createdBy = createdBy;
		}

		public List<RecruiterJobsEntity> getRecruiter() {
			return recruiter;
		}

		public void setRecruiter(List<RecruiterJobsEntity> recruiter) {
			this.recruiter = recruiter;
		}

		public JobsEntity(long id, String jobs, String role, String discription, String salary, String company,
				String requirement, Timestamp dueDate, String helplineDetails, int opening, String city, String state,
				Timestamp creationTime, Timestamp updationTime, boolean is_active, List<UserJobsEntity> userJobsEntities,
				List<RecruiterJobsEntity> recruiter, long createdBy) {
			super();
			this.id = id;
			this.jobs = jobs;
			this.role = role;
			this.discription = discription;
			this.salary = salary;
			this.company = company;
			this.requirement = requirement;
			this.dueDate = dueDate;
			this.helplineDetails = helplineDetails;
			this.opening = opening;
			this.city = city;
			this.state = state;
			this.creationTime = creationTime;
			this.updationTime = updationTime;
			this.is_active = is_active;
			this.userJobsEntities = userJobsEntities;
			this.recruiter = recruiter;
			this.createdBy = createdBy;
		}

		
		
		
		
		 
		
	}


