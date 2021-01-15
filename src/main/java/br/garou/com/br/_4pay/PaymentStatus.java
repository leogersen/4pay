package br.garou.com.br._4pay;

public enum PaymentStatus {
	
	Authorized("Autorizado"),
	Unauthorized("Não Autorizado pela instituição financeira"),
	InvalidCard("Cartão Inválido");
	
	
	String description;
	
	PaymentStatus(String description) {
		this.description = description;
		
	}
	
	public String getDescription() {
		return description;
	}

}
