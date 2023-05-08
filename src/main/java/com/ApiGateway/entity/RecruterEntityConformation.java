package com.ApiGateway.entity;

	import java.sql.Timestamp;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	import org.hibernate.annotations.CreationTimestamp;
	import org.hibernate.annotations.UpdateTimestamp;

	@Entity
	public class RecruterEntityConformation {


		
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			private long id ;
			
			private String 	name;
			
			private String companyEmail;
			
			private String companyDiscription;
			
			private String registrationNumber;
			
			private String password;
			
			private CompanyStatus status;
			
			@CreationTimestamp
			private Timestamp creationTime;
			
			@UpdateTimestamp
			private Timestamp updationTime;
			
			private boolean is_active=true;

			public long getId() {
				return id;
			}

			public void setId(long id) {
				this.id = id;
			}

			public String getName() {
				return name;
			}

			public void setName(String name) {
				this.name = name;
			}

			

			public String getCompanyEmail() {
				return companyEmail;
			}

			public void setCompanyEmail(String companyEmail) {
				this.companyEmail = companyEmail;
			}

			public String getCompanyDiscription() {
				return companyDiscription;
			}

			public void setCompanyDiscription(String companyDiscription) {
				this.companyDiscription = companyDiscription;
			}

			public String getRegistrationNumber() {
				return registrationNumber;
			}

			public void setRegistrationNumber(String registrationNumber) {
				this.registrationNumber = registrationNumber;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
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

			
			
			

			

			

			public CompanyStatus getStatus() {
				return status;
			}

			public void setStatus(CompanyStatus status) {
				this.status = status;
			}

			public RecruterEntityConformation(long id, String name, String companyEmail, String companyDiscription,
					String registrationNumber, String password, CompanyStatus status, Timestamp creationTime,
					Timestamp updationTime, boolean is_active) {
				super();
				this.id = id;
				this.name = name;
				this.companyEmail = companyEmail;
				this.companyDiscription = companyDiscription;
				this.registrationNumber = registrationNumber;
				this.password = password;
				this.status = status;
				this.creationTime = creationTime;
				this.updationTime = updationTime;
				this.is_active = is_active;
			}

			public RecruterEntityConformation() {
				super();
				// TODO Auto-generated constructor stub
			}

			
			
		}




