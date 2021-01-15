package br.garou.com.br._4pay;

import javax.validation.constraints.Pattern;

public class CardData {


    @Pattern(regexp = "\\d{16}", message = "O número do cartão é inválido")
    private String numCard;

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }
}
