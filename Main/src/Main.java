import java.util.*;

public class Main {
	public static void main(String[] args) {
		// Inicializa um Scanner.
		Scanner sc = new Scanner(System.in);
		// Cria o Estoque de Produtos.
		Estoque estoquePrincipal = new Estoque();

		Cliente clienteAtual = null;
		int opcao;
		do {
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

			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Digite o Endereço: ");
				sc.nextLine();
				String endereco = sc.nextLine();
				System.out.println("Digite o CPF: ");
				String cpf = sc.next();
				clienteAtual = new Cliente(cpf, endereco, new Carrinho(0, 0));

				break;
			case 2:
				System.out.println("Digite o ID do cliente para logar: ");
				int idLogin = sc.nextInt();
				if (idLogin >= 0 && idLogin < Cliente.listaClientes.size()) {
					clienteAtual = Cliente.listaClientes.get(idLogin);
					clienteAtual.logar();
				} else {
					System.out.println("ID inválido.");
				}
				break;

			case 3:
				System.out.println("Digite o nome do produto:");
				String nomeProduto = sc.next();
				System.out.println("Digite o preço do produto: ");
				double precoProduto = sc.nextDouble();
				sc.nextLine();
				System.out.println("Digite a quantidade disponível de produtos: ");
				int qntDisponivel = sc.nextInt();
				estoquePrincipal.adicionarProduto(
						new Produto(true, estoquePrincipal.produtos.size(), nomeProduto, precoProduto, qntDisponivel));

				System.out.println("Produto cadastrado com sucesso! Estoque atual:");
				estoquePrincipal.listarProdutos();
				break;

			case 4:
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

			case 5:
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

			case 6:
				estoquePrincipal.listarProdutos();
				System.out.println("Digite o código do produto para remover: ");
				int codRemover = sc.nextInt();
				System.out.println("Digite a quantidade para remover: ");
				int qtdRemover = sc.nextInt();
				estoquePrincipal.removerProduto(codRemover, qtdRemover);
				break;

			case 7:
				if (clienteAtual != null) {
					clienteAtual.getCarrinho().listarProdutos();
				} else {
					System.out.println("Nenhum cliente logado.");
				}
				break;

			case 8:
				estoquePrincipal.listarProdutos();
				break;

			case 9:
				if (clienteAtual == null) {
					System.out.println("Cadastro não finalizado!");
					break;
				}
				if (clienteAtual.carrinho.listaDeProdutos.size() <= 0) {
					System.out.println("Carrinho vazio!");
					break;
				}

			}

		} while (opcao != 0);
		sc.close();
	}
}