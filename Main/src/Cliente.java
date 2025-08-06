public class Cliente {
    int id;
    int cpf;
    String endereco;

    public Cliente(int id, int cpf, String endereco) {
        this.id = id;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    public void logar() { //Simula o Login do usuário
        System.out.println("Usuário logado com sucesso!");
    }

    public void comprar() { //Faz o cálculo total no carrinho e "finaliza" a compra

    }

    public void adicionar(Carrinho carrinho, Produto produto) { //Adiciona um produto ao carrinho

    }
}