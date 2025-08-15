import java.time.LocalDate;
import java.util.*;

public class Cliente {
    private int id;
    private int cpf;
    private String endereco;
    public Carrinho carrinho;
    public static ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    public Cliente(int cpf, String endereco, Carrinho carrinho) {
        this.setId(listaClientes.size());
        this.setCpf(cpf);
        this.setEndereco(endereco);
        this.setCarrinho(carrinho);
        listaClientes.add(this);
    }
    
    public static void apagarCliente(int id) {
    	if (id < 0 || id >= listaClientes.size()) {
    		System.out.println("ERRO! ID não existente no Banco de Dados.");
    		return;
    	}
    	System.out.println("Cliente ID: " + id + " ------- Removido com sucesso!");
    	listaClientes.remove(id);
    	
    }
    
    public void atualizarCliente(int cpf, String endereco) {
    	this.setCpf(cpf);
    	this.setEndereco(endereco);
    }
    
    public static void listarClientes() {
    	if (listaClientes.isEmpty()) {
    		System.out.println("Lista de Clientes Vazia!");
    		return;
    	}
    	for (Cliente cliente : listaClientes) {
			cliente.verificarCliente();
		}
    }
    
    public void verificarCliente() {
    	System.out.println("ID: " + this.getId());
    	System.out.println("CPF: " + this.getCpf());
    	System.out.println("Endereço: " + this.getEndereco());
    }
    
    
    public void logar() { //Simula o Login do usuário
        System.out.println("Usuário logado com sucesso!");
    }

    public void comprar(String metodo_pagamento) { //Faz o cálculo total no carrinho e "finaliza" a compra
    	for (Produto produto : getCarrinho().getListaDeProdutos()) {
			getCarrinho().setValorTotal(getCarrinho().getValorTotal() + produto.getPreco());
		}
    	Pagamento pagamento = new Pagamento(metodo_pagamento, getCarrinho().getValorTotal(), LocalDate.now(), true);
    	System.out.println("-----NOTA FISCAL E CHECKOUT------");
    	getCarrinho().listarProdutos();
    	pagamento.listarInfoPagamento();
    }

    public void adicionar(Estoque estoque, int codigo) { //Adiciona um produto ao carrinho
    	getCarrinho().adicionarProduto(estoque.produtos.get(codigo));
    	estoque.produtos.get(codigo).retirarEstoque(1);
    }
    public void adicionar(Produto produto) { //sobrecarga
        getCarrinho().adicionarProduto(produto);
    }

	Carrinho getCarrinho() {
		return carrinho;
	}

	void setCarrinho(Carrinho carrinho) {
		this.carrinho = carrinho;
	}

	String getEndereco() {
		return endereco;
	}

	void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	int getCpf() {
		return cpf;
	}

	void setCpf(int cpf) {
		this.cpf = cpf;
	}

	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}
}