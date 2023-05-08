package com.ApiGateway.Config;



	public class UserDto {

		private String name;
		
		private String city;
		
		private String state;
		
		private String email;
		
		private String password;
		
		private String mobileNo;

		public String getName() {
			return name;
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

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public UserDto(String name, String city, String state, String email, String password, String mobileNo) {
			super();
			this.name = name;
			this.city = city;
			this.state = state;
			this.email = email;
			this.password = password;
			this.mobileNo = mobileNo;
		}

		public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		
	

}
