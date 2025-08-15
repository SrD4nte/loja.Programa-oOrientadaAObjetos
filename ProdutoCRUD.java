import java.util.ArrayList;

public class Produto {
	private boolean ativo;
	private int id;
	private double preco;
	private int quantidade;
	private String nome;
	
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public Produto(boolean ativo, int codigo, String nome, double preco, int quantidade) {
		this.ativo = ativo;
		this.id = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
		this.nome = nome;
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

	public boolean retirarEstoque(int quantidadeRetirada) {
		if (quantidadeRetirada > 0 && quantidadeRetirada <= quantidade) {
			quantidade -= quantidadeRetirada;
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
	
	//CRUD do Produto
	
	public void listarProduto() {
		if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Todos os produtos:");
            for (Produto produto : produtos) {
                System.out.println("Código do Produto: " + produto.getId() + ", Nome do Produto: "+ produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
            }
        }
	}
	
	public void removerProduto(int id) {
	    for (Produto produto : produtos) {
	        if (produto.getId() == id) {
	            produtos.remove(produto);
	            return;
	        }
	    }
	    System.out.println("Produto nao encontrado!");
	}
	
	public void atualizarProduto(int id, String novoNome, double novoPreco, int novaQuantidade) {
	    for (Produto produto : produtos) {
	        if (produto.getId() == id) {
	            produto.setNome(novoNome);
	            produto.setPreco(novoPreco);
	            produto.setQuantidade(novaQuantidade);
	            System.out.println("Produto atualizado com sucesso!");
	            return;
	        }
	    }
	    System.out.println("Produto nao encontrado!");
	}
	
	public void adicionarProduto(Produto produto) {
	    produtos.add(produto);
	    System.out.println("Produto adicionado ao estoque!");
	}
	
	@Override
	public String toString() {
	    return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
	}
}


