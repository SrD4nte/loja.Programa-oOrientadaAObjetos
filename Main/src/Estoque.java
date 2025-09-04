import java.util.*;

public class Estoque {
    
    public ArrayList<Produto> produtos; 

    public Estoque() {
        this.produtos = new ArrayList<Produto>();
    }

    public void adicionarProduto(Produto produto) {
        try {
            if (produto.getQuantidade() > 0) {
                produtos.add(produto);
            } else {
                System.out.println("Quantidade deve ser maior que zero.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar produto: " + e.getMessage());
        }
    }

    public void removerProduto(int codigo, int quantidade) {
        try {
            for (Produto produto : produtos) {
                if (produto.getId() == codigo) {
                    if (produto.getQuantidade() >= quantidade) {
                        produto.setQuantidade(produto.getQuantidade() - quantidade);
                        if (produto.getQuantidade() == 0) {
                            produtos.remove(produto);
                        }
                    } else {
                        System.out.println("Quantidade a remover é maior que a quantidade disponível.");
                    }
                    return;
                }
            }
            System.out.println("Produto não encontrado no estoque.");
        } catch (Exception e) {
            System.out.println("Erro ao remover produto: " + e.getMessage());
        }
    }

    public void verificarQuantidade(int codigo) {
        try {
            for (Produto produto : produtos) {
                if (produto.getId() == codigo) {
                    System.out.println("Quantidade disponível: " + produto.getQuantidade());
                    return;
                }
            }
            System.out.println("Produto não encontrado no estoque.");
        } catch (Exception e) {
            System.out.println("Erro ao verificar quantidade: " + e.getMessage());
        }
    }

    public boolean listarProdutos() {
        try {
            if (produtos.isEmpty()) {
                System.out.println("O estoque está vazio.");
                return false;
            } else {
                System.out.println("Produtos no estoque:");
                for (Produto produto : produtos) {
                    System.out.println("Código do Produto: " + produto.getId() + ", Nome do Produto: " + produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return false;
    }
}