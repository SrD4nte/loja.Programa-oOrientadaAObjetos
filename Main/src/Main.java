import java.util.*;

public class Main {
    public static void main(String[] args) {
    	//Inicializa um Scanner.
    	Scanner sc = new Scanner(System.in);
    	//Cria o Estoque de Produtos.
    	Estoque estoquePrincipal = new Estoque();

    	Cliente clienteAtual = null;
    	int opcao;
    	do {
    		System.out.println("Digite sua opção:");
    		System.out.println("1 - Cadastrar um usuário.");
    		System.out.println("2 - Adicionar um produto ao estoque.");
    		System.out.println("3 - Adicionar um produto ao carrinho.");
    		System.out.println("4 - Finalizar a compra.");
    		System.out.println("0 - Encerrar o programa.");
    		
    		opcao = sc.nextInt();

    		switch(opcao) {
    			case 1:
    				System.out.println("Digite o Endereço: ");
    				String endereco = sc.nextLine();
    				System.out.println("Digite o CPF: ");
    				int cpf = sc.nextInt();
    				clienteAtual = new Cliente(cpf, endereco, new Carrinho(0, 0));
    				
    			break;
    			
    			case 2:
    				System.out.println("Digite o nome do produto:");
    				String nomeProduto = sc.next();
    				System.out.println("Digite o preço do produto: ");
    				double precoProduto = sc.nextDouble();
    				sc.nextLine();
    				System.out.println("Digite a quantidade disponível de produtos: ");
    				int qntDisponivel = sc.nextInt();
    				estoquePrincipal.adicionarProduto(new Produto(true, estoquePrincipal.produtos.size(), nomeProduto, precoProduto, qntDisponivel));
    				
    				System.out.println("Produto cadastrado com sucesso! Estoque atual:");
    				estoquePrincipal.listarProdutos();
    			break;
    			
    			case 3:
    				if (clienteAtual != null) {
	    				estoquePrincipal.listarProdutos();
	    				System.out.println("Escolha um produto disponível no estoque (Pelo código): ");
	    				int produtoEscolhido = sc.nextInt();
	    				
	    				clienteAtual.adicionar(estoquePrincipal, produtoEscolhido);
	    				System.out.println("Produto adicionado com sucesso!");
    				} else {
    					System.out.println("Cadastro não finalizado!");
    				}
    			break;
    			
    			case 4:
    				if (clienteAtual == null) {
    					System.out.println("Cadastro não finalizado!");
    					break;
    				}
    				if (clienteAtual.carrinho.listaDeProdutos.size() <= 0) {
						System.out.println("Carrinho vazio!");
						break;
    				}
    				
    				System.out.println("Digite um método de pagamento: ");
    				String metodoPag = sc.next();
    				clienteAtual.comprar(metodoPag);
    			break;
    				
    		}
    	} while (opcao!=0);
    	sc.close();
    }
}

