import java.util.ArrayList;

	public class Carrinho {
    private int id;
    public ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
    private double valorTotal;

    //sobrecarga\polimorfismo
    public Carrinho(int id, double valorTotal) {
        this.setId(id);
        this.setValorTotal(valorTotal);
    }
    public Carrinho(int id) {
        this.id = id;
        this.valorTotal = 0;
    }

    //create
    public void adicionarProduto(Produto produto) {
        try {
            if (produto == null) throw new IllegalArgumentException("o produto adicionado não poder nulo");
            getListaDeProdutos().add(produto);
            recalcularTotal();
        } catch (IllegalArgumentException e) {
            System.out.println("erro ao adicionar produto" + e.getMessage());
        } catch (Exception e) {
            System.out.println("erro inesperado ao adicionar produto" + e.getMessage());
        }
    }

    //read
    public void listarProdutos() {
        try {
            if (getListaDeProdutos().isEmpty()) {
                System.out.println("Carrinho vazio");
                return;
            }
            for (Produto produto : getListaDeProdutos()) {
                System.out.println("ID: " + produto.getId() + " Nome: " + produto.getNome() + " Preço Unitário: " + produto.getPreco());
            }
        } catch (Exception e) {
            System.out.println("erro ao listar produto"+e.getMessage());
        }
    }

    //update
    public boolean atualizarProduto(int idProduto, String novoNome, double novoPreco) {
        try {
            Produto produto = obterProdutoPeloId(idProduto);
            if (produto != null) {
                produto.setNome(novoNome);
                produto.setPreco(novoPreco);
                recalcularTotal();
                return true;
            } else {
                System.out.println("Produto com ID " + idProduto + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("erro ao atualizar o produto"+e.getMessage());
        }
        return false;
    }
    public Produto obterProdutoPeloId(int idProduto) {
        try {
            for (Produto produto : getListaDeProdutos()) {
                if (produto.getId() == idProduto) {
                    return produto;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao procurar pelo produto " + e.getMessage());
        }
        return null;
    }

    //delete
    public boolean removerProdutoPorId(int idProduto) {
        try {
            Produto produto = obterProdutoPeloId(idProduto);
            if (produto != null) {
                getListaDeProdutos().remove(produto);
                recalcularTotal();
                return true;
            } else {
                System.out.println("Produto com ID " + idProduto + " não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("erro ao obter produto pelo id"+e.getMessage());
        }
        return false;
    }

    public void recalcularTotal() {
        try {
            setValorTotal(0);
            for (Produto produto : getListaDeProdutos()) {
                setValorTotal(getValorTotal() + produto.getPreco());
            }
        } catch (Exception e) {
            System.out.println("erro ao recalcular" + e.getMessage());
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    ArrayList<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }
    void setListaDeProdutos(ArrayList<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
