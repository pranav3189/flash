package com.bookstore.model;

public class UploadFileResponse {
	 private String fileName;
	    private String status;
	    private String code;
	    
		public UploadFileResponse(String fileName, String status, String code) {
			super();
			this.fileName = fileName;
			this.status = status;
			this.code = code;
		}
		public String getFileName() {
			return fileName;
		}
		public void setFileName(String fileName) {
			this.fileName = fileName;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
	   

	   
	    
	    
	    
	    
}
