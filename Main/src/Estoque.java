import java.util.HashMap;
import java.util.Map;

public class Estoque {
    
    private Map<Integer, Produto> produtos; 

    
    public Estoque() {
        this.produtos = new HashMap<>();
    }

    
    public void adicionarProduto(Produto produto) {
        if (produto.getQuantidade() > 0) {
            produtos.put(produto.getCodigo(), produto);
        } else {
            System.out.println("Quantidade deve ser maior que zero.");
        }
    }

    public void removerProduto(int codigo, int quantidade) {
        if (produtos.containsKey(codigo)) {
            Produto produto = produtos.get(codigo);
            if (produto.verificarEstoque() >= quantidade) {
                produto.retirarEstoque(quantidade);
                if (produto.verificarEstoque() == 0) {
                    produtos.remove(codigo);
                }
            } else {
                System.out.println("Quantidade a remover é maior que a quantidade disponível.");
            }
        } else {
            System.out.println("Produto não encontrado no estoque.");
        }
    }

    
    public int verificarQuantidade(int codigo) {
        if (produtos.containsKey(codigo)) {
            return produtos.get(codigo).verificarEstoque();
        }
        return 0;
    }

  
    public void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("O estoque está vazio.");
        } else {
            System.out.println("Produtos no estoque:");
            for (Produto produto : produtos.values()) {
                System.out.println("Produto: " + produto.getCodigo() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQuantidade());
            }
        }
    }
}
