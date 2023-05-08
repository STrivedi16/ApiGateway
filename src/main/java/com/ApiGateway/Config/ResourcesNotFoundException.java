package com.ApiGateway.Config;

	public class ResourcesNotFoundException extends RuntimeException {

		String message;
		
		String key;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public ResourcesNotFoundException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public ResourcesNotFoundException(String message, Throwable cause, boolean enableSuppression,
				boolean writableStackTrace) {
			super(message, cause, enableSuppression, writableStackTrace);
			// TODO Auto-generated constructor stub
		}

		public ResourcesNotFoundException(String message, Throwable cause) {
			super(message, cause);
			// TODO Auto-generated constructor stub
		}

		public ResourcesNotFoundException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

		public ResourcesNotFoundException(Throwable cause) {
			super(cause);
			// TODO Auto-generated constructor stub
		}

		public ResourcesNotFoundException(String message, String key) {
			super();
			this.message = message;
			this.key = key;
		}

		
		
		
	}


