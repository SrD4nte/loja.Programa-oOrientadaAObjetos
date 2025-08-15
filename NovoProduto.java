public class Produto {
	private boolean ativo;
	private int id;
	private double preco;
	private int quantidade;
	private String nome;
	
	public Produto(boolean ativo, int codigo, String nome, double preco, int quantidade) {
		this.setAtivo(ativo);
		this.setId(codigo);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
		this.setNome(nome);
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco < 0) {
        throw new IllegalArgumentException("O preço não pode ser um valor negativo.");
    }
    this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int verificarEstoque() {
	return getQuantidade();	
}
	public boolean retirarEstoque(int quantidadeRetirada) {
		if (quantidadeRetirada > 0 && quantidadeRetirada <= getQuantidade()) {
			setQuantidade(getQuantidade() - quantidadeRetirada);
			return true;
		} else {
			return false;
		}
	}

	String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
