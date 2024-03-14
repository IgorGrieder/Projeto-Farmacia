package dominio;

import java.util.ArrayList;

public class Estoque {

    private ArrayList<ControleDeProduto> produtos;

    public Estoque(ArrayList<ControleDeProduto> produtos){
        this.produtos=produtos;
    }

    public Estoque(){
        this.produtos = new ArrayList<ControleDeProduto>();
    }
    
    public ArrayList<ControleDeProduto> getProdutos() {
        return produtos;
    }
    
    public void setProdutos(ArrayList<ControleDeProduto> produtos) {
        this.produtos = produtos;
    }

    public void controlarProdutos(int quantidade, String codigo, boolean adicionar){
        for(ControleDeProduto a:produtos){
            if(a.getProduto().getCodigo().equals(codigo)){
                if(adicionar){
                    a.adicionarProdutos(quantidade);}
                else{
                    a.retirarProdutos(quantidade);
                }
            }
        }
    }
}
