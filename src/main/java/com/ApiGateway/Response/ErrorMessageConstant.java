package com.ApiGateway.Response;


	public class ErrorMessageConstant {


	public static final String REQUEST_ERROR = "http request not proper";
		
		public static final String LOGIN_FAIL="login fail";
		
		//Otp not sent
		public static final String OTP_SENT_FAIL="otp not sent ";
		
		public static final String ACCESS_DENIED="you can not show other details";
		
		public static final String TOKEN_NOT_GENERATE="access token not generate";
		
		
		//USER
		public static final String INVALID_USERNAME_PASSWORD="invalid username or password";
		public static final String USER_NOT_REGISTER="user not redister";
		
		public static final String USER_NOT_FOUND="user not found";
		public static final String USER_PASSWROD_NOT_UPDATED="password not updated make sure that your password must contain 1-Uppercase Letter,1- lowercase letter , 1-spcial letter(@$#&!) and 8-15 charector ";
		public static final String USER_NOT_DELETED="user not delete or can't delete user";
		public static final String USER_ROLE_NOT_STORED="user role not add";

		
		public static final String USER_NOT_APPLY="user not applied";
		
		
		//ROLE AND PERMISSION
		public static final String ROLE_NOT_STORED = "role not stored";
		
		public static final String ROLE_PERMISSION_NOT_STORED="role permission not stored ";
		
		public static final String PERMISSION_NOT_STORED="permission not stored";
		public static final String PERMISSION_REMOVE_DENIED="can't remove permission";
		public static final String PERMISSION_NOT_DELETED="permission not delete ";
		
		//JOB
		
		public static final String JOBS_NOT_STORED="job not stored";
		public static final String JOB_NOT_REMOVE="can't remove this job";
		public static final String JOB_PROFILE_NOT_UPDATE="job profile not update";
		public static final String JOB_NOT_FOUND="job not found";
		public static final String USER_JOB_STATUS="status not updated";
		
		
		// FILE 
		public static final String FILE_NOT_STORED="file not stored";
		public static final String FILE_NOT_PROPER="file formate is not matched";
		
		
		// RECRUTER
		public static final String RECRUTER_NOT_STORED="recruter not stored";
		public static final String RECRUTER_STATUS_NOT_UPDATE="recruter status not update";
		
		

	}


