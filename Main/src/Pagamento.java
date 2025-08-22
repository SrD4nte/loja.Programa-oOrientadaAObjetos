import java.text.DecimalFormat;
import java.time.LocalDate;

public class Pagamento {
	// Atributos
	private String Metodo_Pagamento;
	private Double Valor_Total;
	private LocalDate Vencimento;
	private Boolean Status;
	
	// Construtor
	public Pagamento (String Metodo_Pagamento, Double Valor_Total, LocalDate Vencimento, Boolean Status) {
		this.setMetodo_Pagamento(Metodo_Pagamento);
		this.setValor_Total(Valor_Total);
		this.setVencimento(Vencimento);
		this.setStatus(Status);
	}
	public Pagamento(String metodoPagamento, Double valorTotal, LocalDate vencimento) {
        this(metodoPagamento, valorTotal, vencimento, false);
        }
	
	// Metodos especificos da classe
	 public boolean Vencimento() {
	        return !getStatus() && LocalDate.now().isAfter(getVencimento());
	 }
	
	 public void processarPagamento(int opcao) {
 		try {
		DecimalFormat valor = new DecimalFormat("#.##");
	        switch (opcao) {
	            case 1 : 
	            	System.out.println("Gerando boleto no valor de R$ " + valor.format(getValor_Total()) + "...");
	            	break;
	            case 2 : 
	            	System.out.println("Gerando QR Code para pagamento via Pix...");
	            	break;
	            case 3 : 
	            	System.out.println("Gerando comprovante de pagamento...");
	            	break;
	            case 4 : 
	                if (getStatus()) {
	                    System.out.println("Pagamento já realizado.");
	                } else if (Vencimento()) {
	                    System.out.println("Pagamento pendente e vencido!");
	                } else {
	                    System.out.println("Pagamento pendente, dentro do prazo.");
	                }
	                break;
	            default : 
	            	System.out.println("Opção inválida!");
	            	break;
	        }
		} catch (Exception e) {
            System.out.println("Ocorreu um erro ao processar o pagamento: " + e.getMessage());
        }
	    }
	
	 public void listarInfoPagamento() {
		try {
		 System.out.println("Método de Pagamento: " + getMetodo_Pagamento());
		 System.out.println("Vencimento: " + getVencimento());
		 DecimalFormat valor = new DecimalFormat("#.##");
		 
		 System.out.println("Valor Total: " + valor.format(getValor_Total()));
		 } catch (Exception e) {
            System.out.println("Erro ao listar informações do pagamento: " + e.getMessage());
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
		try {
			if (Valor_Total < 0) {
				 throw new IllegalArgumentException("O valor total não pode ser negativo.");
            }
		Valor_Total = Valor_Total;
		} catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir valor: " + e.getMessage());
        }
	}
	public LocalDate getVencimento() {
		return Vencimento;
	}
	public void setVencimento(LocalDate Vencimento) {
		Vencimento = Vencimento;
	}
	public Boolean getStatus() {
		return Status;
	}
	public void setStatus(Boolean Status) {
		Status = Status;
	}
}