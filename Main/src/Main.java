import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Inicializa um Scanner.
		Scanner sc = new Scanner(System.in);
		// Cria o Estoque de Produtos.
		Estoque estoquePrincipal = new Estoque();
		// Adiciona um produto genérico ao Estoque para testes
		estoquePrincipal.produtos.add(new Produto(true, 0, "Leite", 4.99, 10));
		// Inicia a variável para definir o cliente atual logado
		Cliente clienteAtual = null;
		// Inicia a variável opção para o Menu interativo
		int opcao;
		do {
			// Printa as opções no console
			System.out.println("Digite sua opção:");
			System.out.println("1 - Cadastrar um usuário.");
			System.out.println("2 - Logar com cliente.");
			System.out.println("3 - Adicionar um produto ao estoque.");
			System.out.println("4 - Adicionar um produto ao carrinho.");
			System.out.println("5 - Remover um produto do carrinho.");
			System.out.println("6 - Remover um produto do estoque.");
			System.out.println("7 - Listar produtos no carrinho.");
			System.out.println("8 - Listar produtos no estoque.");
			System.out.println("9 - Finalizar a compra.");
			// Lê a opção do usuário pelo console utilizando o Scanner
			opcao = sc.nextInt();
			// Switch-case para processamento de cada opção.
			switch (opcao) {
			case 1: // CADASTRO
				System.out.println("Digite o Endereço: ");
				sc.nextLine();
				String endereco = sc.nextLine();
				System.out.println("Digite o CPF: ");
				String cpf = sc.next();
				clienteAtual = new Cliente(cpf, endereco, new Carrinho(0, 0));

				break;
			case 2: // LOGAR
				try {
					System.out.println("Digite o ID do cliente para logar: ");
					int idLogin = sc.nextInt();
					if (idLogin >= 0 && idLogin < Cliente.listaClientes.size()) {
						clienteAtual = Cliente.listaClientes.get(idLogin);
						clienteAtual.logar();
					} else {
						System.out.println("ID inválido.");
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Digite um número inteiro! " + e);
					sc.next();
					break;
				}

			case 3: // Adicionar um produto ao estoque
				try {
					System.out.println("Digite o nome do produto:");
					String nomeProduto = sc.next();
					System.out.println("Digite o preço do produto: ");
					double precoProduto = sc.nextDouble();
					sc.nextLine();
					System.out.println("Digite a quantidade disponível de produtos: ");
					int qntDisponivel = sc.nextInt();
					estoquePrincipal.adicionarProduto(new Produto(true, estoquePrincipal.produtos.size(), nomeProduto,
							precoProduto, qntDisponivel));

					System.out.println("Produto cadastrado com sucesso! Estoque atual:");
					estoquePrincipal.listarProdutos();
					break;
				} catch (InputMismatchException e) {
					System.out.println("Digite o tipo correto! (Ex: Inteiro, Double). " + e);
					sc.next();
					break;
				}

			case 4: // Adiciona um produto ao carrinho do Cliente.
				if (!estoquePrincipal.listarProdutos()) {
					break;
				}

				try {
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
				} catch (InputMismatchException e) {
					System.out.println("Digite um número inteiro!" + e);
					sc.next();
					break;
				}

			case 5: // Remove um produto do carrinho do Cliente.
				try {
					if (clienteAtual != null) {
						clienteAtual.getCarrinho().listarProdutos();
						System.out.println("Digite o ID do produto para remover: ");
						int idRemover = sc.nextInt();
						if (clienteAtual.getCarrinho().removerProdutoPorId(idRemover)) {
							System.out.println("Produto removido do carrinho!");
						} else {
							System.out.println("Produto não encontrado no carrinho.");
						}
					} else {
						System.out.println("Nenhum cliente logado.");
					}
					break;
				} catch (InputMismatchException e) {
					System.out.println("Digite um número inteiro!" + e);
					sc.next();
					break;
				}

			case 6: // Remove um produto do Estoque
				try {
					estoquePrincipal.listarProdutos();
					System.out.println("Digite o código do produto para remover: ");
					int codRemover = sc.nextInt();
					System.out.println("Digite a quantidade para remover: ");
					int qtdRemover = sc.nextInt();
					estoquePrincipal.removerProduto(codRemover, qtdRemover);
					break;
				} catch (InputMismatchException e) {
					System.out.println("Digite um número inteiro! " + e);
					sc.next();
					break;
				}

			case 7: // Lista os produtos no carrinho.
				if (clienteAtual != null) {
					clienteAtual.getCarrinho().listarProdutos();
				} else {
					System.out.println("Nenhum cliente logado.");
				}
				break;

			case 8:
				estoquePrincipal.listarProdutos();
				break;

			case 9: // Finaliza o pagamento do Cliente
				sc.nextLine();
				if (clienteAtual == null) {
					System.out.println("Cadastro não finalizado!");
					break;
				}
				if (clienteAtual.carrinho.listaDeProdutos.size() <= 0) {
					System.out.println("Carrinho vazio!");
					break;
				}

				System.out.println("Digite o método de pagamento: ");
				String metEscolhido = sc.nextLine();

				clienteAtual.comprar(metEscolhido);
			}
			// Finaliza o Scanner.
		} while (opcao != 0);
		sc.close();
	}
}