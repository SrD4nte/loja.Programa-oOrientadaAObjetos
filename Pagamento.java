package Lojinha;

import java.time.LocalDate;

public class Pagamento {
	// Atributos
	private String Metodo_Pagamento;
	private Double Valor_Total;
	private LocalDate Vencimento;
	private Boolean Status;
	
	// Construtor
	public Pagamento (String Metodo_Pagamento, Double Valor_Total, LocalDate Vencimento, Boolean Status) {
		this.Metodo_Pagamento = Metodo_Pagamento;
		this.Valor_Total = Valor_Total;
		this.Vencimento = Vencimento;
		this.Status = Status;
	}
	
	// Metodos especificos da classe
	 public boolean Vencimento() {
	        return !Status && LocalDate.now().isAfter(Vencimento);
	 }
	public void escolherStatusPagamento(String novoStatus) {
    	setStatusPagamento(novoStatus);
	}
	
	public void FormaPagamento() {
    switch (this.Metodo_Pagamento.toLowerCase()) {
        case "pix":
            System.out.println("QR Code gerado para pagamento via Pix!");
            break;
        case "boleto":
            System.out.println("Boleto gerado! Pague até a data de vencimento.");
            break;
        case "cartão":
            System.out.println("Pagamento via cartão realizado. Comprovante impresso.");
            break;
        default:
            System.out.println("Método de pagamento não reconhecido.");
    }
}
	
	// Metodos Getters e Setters
	public String getMetodo_Pagamento() {
		return Metodo_Pagamento;
	}
	public void setMetodo_Pagamento(String Metodo_Pagamento) {
		this.Metodo_Pagamento = Metodo_Pagamento;
	}
	public Double getValor_Total() {
		return Valor_Total;
	}
	public void setValor_Total(Double Valor_Total) {
		Valor_Total = Valor_Total;
	}
	public LocalDate getVencimento() {
		return Vencimento;
	}
	public void setVencimento(String Vencimento) {
		Vencimento = Vencimento;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean Status) {
		Status = Status;
	}
	
}


