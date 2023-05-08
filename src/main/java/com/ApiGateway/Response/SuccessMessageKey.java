package com.ApiGateway.Response;



	public class SuccessMessageKey {

		private static final String HEADER="JP-M03";
		
		private static  final String USER="11";
		private static final String ROLE="12";
		private static final String USER_ROLE="13";
		private static final String PERMISSION="14";
		private static final String ROLE_PERMISSION="15";
		private static final String JOB="16";
		private static final String USER_JOB="17";
		private static final String OTP="18";
		private static final String FILE="19";
		private static final String RECUTER="20";
		private static final String TOKEN="21";
		
		
		public static final String TOKEN_M032100=HEADER+TOKEN+"00";
		
		
		public static final String OTP_M031800=HEADER+OTP+"00";
		
		//USER
		public static final String USER_MO311OO=HEADER+USER+"00";// login successfull
		public static final String USER_M031101=HEADER+USER+"01";// register 
		public static final String USER_M031102=HEADER+USER+"02";//user detail fetched
		public static final String USER_M031103=HEADER+USER+"03";// password updated successfully
		public static final String USER_M031104=HEADER+USER+"04";// user delete

		
		// user role
		public static final String USER_ROLE_M031301=HEADER+USER_ROLE+"01";//user role added
		public static final String USER_ROLE_M031302=HEADER+USER_ROLE+"02";// user role remove
		
		// role
		public static final String ROLE_M031201=HEADER+ROLE+"01"; //role added;
		public static final String ROLE_M031202=HEADER+ROLE+"02";// role remove;
		
		//role permission
		public static final String PERMISSION_M031401=HEADER+PERMISSION+"01";//permission added
		public static final String PERMISSION_M031402=HEADER+PERMISSION+"02";// permission deleted
		public static final String ROLE_PERMISSION_M031501=HEADER+ROLE_PERMISSION+"01";// role permission added
		
		//job 
		public static final String JOB_M031601=HEADER+JOB+"01";//job add
		public static final String JOB_M031602=HEADER+JOB+"02";// job details fetched
		public static final String JOB_M031603=HEADER+JOB+"03"; // job removed 
		public static final String USER_JOB_M031701=HEADER+USER_JOB+"01"; // user job added
		public static final String USER_JOB_M031702=HEADER+USER_JOB+"02";	/// user job fetched;
		public static final String USER_JOB_M031703=HEADER+USER_JOB+"03";	// user jobs remove
		public static final String USER_JOB_M031704=HEADER+USER_JOB+"04";	//user job status update 

		//file 
		public static final String FILE_M031901=HEADER+FILE+"01";// file upload successfull
		
		
		//recruer
		
		public static final String RECRUTER_M032001=HEADER+RECUTER+"01";//recruter add successfull
		public static final String RECRUTER_M032002=HEADER+RECUTER+"02";// recruter status updated successfull
		public static final String RECRUTER_M032003=HEADER+RECUTER+"03";// recruter details fetch successfull

	}


