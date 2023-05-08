package com.ApiGateway.Response;



	public class ErrorMessageKey {

		
		private static final String HEADER="JP-E03";
		
		private static  final String USER="11";
		private static final String ROLE="12";
		private static final String USER_ROLE="13";
		private static final String PERMISSION="14";
		private static final String ROLE_PERMISSION="15";
		private static final String JOB="16";
		private static final String USER_JOB="17";
		private static final String FILE="18";	
		private static final String RECRUITER="19";
		private static final String TOKEN="21";
		
		
		
		public static final String REQUEST_E0300=HEADER+"00";// requset incorrect

		public static final String ACCESS_DENIED=HEADER+USER+"001";
		
		public static final String TOKEN_E032100=HEADER+TOKEN+"00";	
		
		//USER
		public static final String USER_EO311OO=HEADER+USER+"00";// not login
		public static final String USER_E031101=HEADER+USER+"01";// not  register 
		public static final String USER_E031102=HEADER+USER+"02";//user detail not found
		public static final String USER_E031103=HEADER+USER+"03";// password not updated 
		public static final String USER_E031104=HEADER+USER+"04";// user not deleted
		
		// user role
		public static final String USER_ROLE_E031301=HEADER+USER_ROLE+"01";//user role  not added
		public static final String USER_ROLE_E031302=HEADER+USER_ROLE+"02";// user role not remove
		
		// role
		public static final String ROLE_E031201=HEADER+ROLE+"01"; //role not  added;
		public static final String ROLE_E031202=HEADER+ROLE+"02";// role  not remove;
		
		//role permission
		public static final String PERMISSION_E031401=HEADER+PERMISSION+"01";//permission not stored
		public static final String PERMISSION_E031402=HEADER+PERMISSION+"02";// permission not delete
		public static final String ROLE_PERMISSION_E031501=HEADER+ROLE_PERMISSION+"01";// role permission not stored
		
		//job 
		public static final String JOB_E031601=HEADER+JOB+"01";//job not stored
		public static final String JOB_E031602=HEADER+JOB+"02";// job not found
		public static final String JOB_E031603=HEADER+JOB+"03";// job not delete
		public static final String USER_JOB_E031701=HEADER+USER_JOB+"01"; // user job not  added
		public static final String USER_JOB_E031702=HEADER+USER_JOB+"02";	/// user job  not remove;
		public static final String USER_JOB_E031704=HEADER+USER_JOB+"04";//user job status 
		
		
		//file 
		public static final String FILE_E031801=HEADER+FILE+"01";//file not stored
		public static final String FILE_E031802=HEADER+FILE+"02";//file formate is not matched
		
		//recruiter
		
		//recruter
		public static final String RECRUITER_E031901=HEADER+RECRUITER+"01";// recruter is not stored
		public static final String RECRUITER_E031902=HEADER+RECRUITER+"02";// recruter status is not updated
		
	}


