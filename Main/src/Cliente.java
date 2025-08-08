import java.time.LocalDate;

public class Cliente {
    int id;
    int cpf;
    String endereco;
    Carrinho carrinho;
    
    public Cliente(int id, int cpf, String endereco, Carrinho carrinho) {
        this.id = id;
        this.cpf = cpf;
        this.endereco = endereco;
        this.carrinho = carrinho;
    }

    public void logar() { //Simula o Login do usuário
        System.out.println("Usuário logado com sucesso!");
    }

    public void comprar(String metodo_pagamento) { //Faz o cálculo total no carrinho e "finaliza" a compra
    	for (Produto produto : carrinho.listaDeProdutos) {
			carrinho.valorTotal += produto.getPreco();
		}
    	Pagamento pagamento = new Pagamento(metodo_pagamento, carrinho.valorTotal, LocalDate.now(), true);
    	
    	System.out.println("-----NOTA FISCAL E CHECKOUT------");
    	carrinho.listarProdutos();
    	pagamento.listarInfoPagamento();
    }

    public void adicionar(Estoque estoque, int codigo) { //Adiciona um produto ao carrinho
    	carrinho.adicionarProduto(estoque.produtos.get(codigo));
    	estoque.produtos.get(codigo).retirarEstoque(1);
    }
}