import java.util.ArrayList;

public class Carrinho {
	
	int id;
	ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
	double valorTotal;

	public Carrinho(int id, double valorTotal) {
		this.id = id;
		this.valorTotal = valorTotal;
	}

	public void adicionarProduto(Produto Produto) {
		this.listaDeProdutos.add(Produto);
	}

	public void removerProduto(int id) {
		this.listaDeProdutos.remove(id);
	}

	public void listarProdutos() {
		if (listaDeProdutos.size() == 0) {
			System.out.println("Carrinho vazio!");
		}

		for (Produto produto : listaDeProdutos) {
			System.out.println("ID: " + Produto.id);
			System.out.println("Nome: " + Produto.nome);

		}
	}
}