package com.example.cms.utility;

import org.springframework.stereotype.Component;

@Component
public class ResponseStructure<T> {
		private int statusCode;
		private String message;
		private T body;
		
		
		public int getStatusCode() {
			return statusCode;
		}


		public ResponseStructure<T> setStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}


		public String getMessage() {
			return message;
		}


		public ResponseStructure<T> setMessage(String message) {
			this.message = message;
			return this;
		}


		public T getBody() {
			return body;
		}


		public ResponseStructure<T> setBody(T body) {
			this.body = body;
			return this;
		}

}
