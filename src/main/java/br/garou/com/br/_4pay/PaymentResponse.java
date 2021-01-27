package br.garou.com.br._4pay;

public class PaymentResponse {

	
		private PaymentStatus status;
		private String error;
		
		public PaymentResponse(PaymentStatus status) {
			this.status = status;
		}
		
		public PaymentResponse(String error) {
			this.error = error;
		}
		
		public PaymentStatus getStatus() {
			return status;
		}

		public String getError() {
		return error;
	}

}