package dominio;

import java.util.ArrayList;

public class Carrinho{
    
    private ArrayList<ControleDeProduto> produtos;
    private double precoTotal;

    public Carrinho(ArrayList<ControleDeProduto> produtos){
        this.produtos=produtos;
    }
    public Carrinho(){
        this.produtos = new ArrayList<ControleDeProduto>();
    }
    
    public ArrayList<ControleDeProduto> getProdutos() {
        return produtos;
    }
    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
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

    public void calcularPrecoTotal(){
        double precoTotal = 0;
        for(ControleDeProduto a:produtos){
            double preco = a.getProduto().getPreco()*a.getQuantidade();
            precoTotal+=(preco+preco*a.getProduto().calcularImposto());
        }
        this.precoTotal=precoTotal;
    }

    public void cancelarCompra(){
        this.precoTotal = 0;
        for(ControleDeProduto a:produtos){
            a.setQuantidade(0);
        }

    }
}