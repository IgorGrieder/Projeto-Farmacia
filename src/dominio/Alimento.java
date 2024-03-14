package dominio;

public class Alimento extends Produto {
    
    private String contraIndicacao; //Se contem Cluten, Lactose etc 
    private double valorCalorico;

    public Alimento(String nome, String codigo, String marca, double preco, String contraIndicacao, double valorCalorico){
        super(nome, codigo, marca, preco);
        this.contraIndicacao = contraIndicacao;
        this.valorCalorico = valorCalorico;
    }

    public Alimento(){}

    public double getValorCalorico() {
        return valorCalorico;
    }

    public String getContraIndicacao() {
        return contraIndicacao;
    }

    public void setValorCalorico(double valorCalorico) {
        this.valorCalorico = valorCalorico;
    }

    public void setContraIndicacao(String contraIndicacao) {
        this.contraIndicacao = contraIndicacao;
    }

    public double calcularImposto(){
        return 0.01;
    }
}