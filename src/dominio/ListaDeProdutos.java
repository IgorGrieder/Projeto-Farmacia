package dominio;

import java.util.ArrayList;

public class ListaDeProdutos {

    public ArrayList<Produto> produtos;

    public ListaDeProdutos(){
        produtos = new ArrayList<>();
    }

    public ListaDeProdutos(ArrayList<Produto> produtos){
        this.produtos = produtos;
    }
    
    public void adicionarProduto(Produto a){
        if(!(produtos.contains(a))){
            produtos.add(a);
        }
    }

    public void removerProduto(Produto a){
        if(produtos.contains(a)){
            produtos.remove(a);
        }
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
    
    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
