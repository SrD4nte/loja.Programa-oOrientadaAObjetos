import java.util.*;

public class Estoque {
    
    public ArrayList<Produto> produtos; 

    
    public Estoque() {
        this.produtos = new ArrayList<Produto>();
    }

    
    public void adicionarProduto(Produto produto) {
        if (produto.getQuantidade() > 0) {
            produtos.add(produto);
        } else {
            System.out.println("Quantidade deve ser maior que zero.");
        }
    }

    public void removerProduto(int codigo, int quantidade) {
        if (codigo >= produtos.size()) {
        	Produto produto_removido = produtos.get(codigo);
            if (produto_removido.verificarEstoque() >= quantidade) {
            	produto_removido.retirarEstoque(quantidade);
                if (produto_removido.verificarEstoque() == 0) {
                    produtos.remove(produto_removido);
                }
            } else {
                System.out.println("Quantidade a remover é maior que a quantidade disponível.");
            }
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
    public void atualizarProduto(int codigo, double novoPreco, int novaQuantidade) {
        if (codigo < produtos.size()) {
            Produto produto = produtos.get(codigo);
            produto.setPreco(novoPreco);
            produto.setQuantidade(novaQuantidade);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }
    
    public void verificarQuantidade(int codigo) {
    	System.out.println(produtos.get(codigo).verificarEstoque());
    }

  
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Produtos no estoque:");
            for (Produto produto : produtos) {
                System.out.println("Código do Produto: " + produto.getId() + ", Nome do Produto: "+ produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
            }
        }
    }
}
