package com.ApiGateway.entity;



	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.Id;
	import javax.persistence.ManyToOne;

	@Entity
	public class RecruiterJobsEntity {

		@Id
		private long id;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private JobsEntity jobs;
		
		@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
		private RecruterEntity recruter;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public JobsEntity getJobs() {
			return jobs;
		}

		public void setJobs(JobsEntity jobs) {
			this.jobs = jobs;
		}

		public RecruterEntity getRecruter() {
			return recruter;
		}

		public void setRecruter(RecruterEntity recruter) {
			this.recruter = recruter;
		}

		public RecruiterJobsEntity(long id, JobsEntity jobs, RecruterEntity recruter) {
			super();
			this.id = id;
			this.jobs = jobs;
			this.recruter = recruter;
		}

		public RecruiterJobsEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
	}


