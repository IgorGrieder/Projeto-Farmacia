package dominio;

public class ControleDeProduto {

    private Produto produto;
    private int quantidade;

    public ControleDeProduto(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public ControleDeProduto(){};

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarProdutos(int quantidade){
        this.quantidade+=quantidade;
    }
    
    public void retirarProdutos(int quantidade){
        this.quantidade-=quantidade;
    }  
}