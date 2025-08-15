import java.util.*;

public class Main {
    public static void main(String[] args) {
    	//Cria o Estoque de Produtos.
    	Estoque estoquePrincipal = new Estoque();
    	//Adiciona o produto Leite ao estoque
    	estoquePrincipal.adicionarProduto(new Produto(true, estoquePrincipal.produtos.size(), "Leite", 4.99, 10));
    	//Adiciona o produto Café ao estoque
    	estoquePrincipal.adicionarProduto(new Produto(true, estoquePrincipal.produtos.size(), "Café", 9.99, 10));
    	//Adiciona o produto Arros
    	estoquePrincipal.adicionarProduto(new Produto(true, estoquePrincipal.produtos.size(), "Arroz", 7.99, 10));
    	//Lista todos os produtos existentes no estoque.
    	estoquePrincipal.listarProdutos();
    	//"Cria" um cliente novo
    	Cliente pessoa1 = new Cliente(231234331, "Rua Brasil, 123", new Carrinho(0, 0));
    	
    	//Loga o cliente no sistema.
    	pessoa1.logar();
    	//Adiciona vários produtos ao carrinho do cliente.
    	pessoa1.adicionar(estoquePrincipal, 0);
    	pessoa1.adicionar(estoquePrincipal, 0);
    	pessoa1.adicionar(estoquePrincipal, 0);
    	pessoa1.adicionar(estoquePrincipal, 1);
    	pessoa1.adicionar(estoquePrincipal, 2);
    	pessoa1.adicionar(estoquePrincipal, 2);
    	
    	//Lista novamente os produtos do estoque.
    	estoquePrincipal.listarProdutos();
    	
    	//Finaliza a compra utilizando o método Pix.
    	pessoa1.comprar("Pix");
    }
}