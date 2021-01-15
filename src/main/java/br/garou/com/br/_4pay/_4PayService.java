package br.garou.com.br._4pay;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class _4PayService {
	
	private static final String AUTH_TOKEN = "r2d2";

	@PostMapping(path = "/pay", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PaymentResponse> pay(
			@RequestHeader("Token") String token,
			@RequestBody CardData cardData,
			Errors errors) {
		
		if(!AUTH_TOKEN.equals(token)) {
			return ResponseEntity.badRequest().body(new PaymentResponse("Token Inválido"));
		}
		
		if (errors.hasErrors()) {
			return ResponseEntity.ok(new PaymentResponse(PaymentStatus.InvalidCard));
		}
		
		String numCard = cardData.getNumCard();
		
		PaymentStatus status = numCard.startsWith("1111") ? PaymentStatus.Authorized : PaymentStatus.Unauthorized;
		return ResponseEntity.ok(new PaymentResponse(status));
		
		
	}
}
