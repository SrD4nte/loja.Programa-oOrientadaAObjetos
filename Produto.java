package Projeto1;

public class Produto {
	private boolean ativo;
	private int codigo;
	private double preco;
	private int quantidade;
	
	public Produto(boolean ativo, int codigo, double preco, int quantidade) {
		this.ativo = ativo;
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int verificarEstoque() {
		return quantidade;
	}

	public int retirarEstoque(int quantidadeRetirada) {
		if (quantidadeRetirada > 0 && quantidadeRetirada <= quantidade) {
		quantidade -= quantidadeRetirada;
		return true;
	} else {
		return false;
	
	   }
		
      }
 }

