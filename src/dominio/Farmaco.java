package dominio;

public class Farmaco extends Produto {
    
    private String receita;
    private String tipo; //Categoria Terapêutica
    private String contraIndicacao; //Se contem Gluten, Lactose etc 

    public Farmaco(String nome, String codigo, String marca, double preco, String receita, String tipo, String contraIndicacao){
        super(nome, codigo, marca, preco);
        this.receita = receita;
        this.tipo = tipo;
        this.contraIndicacao = contraIndicacao;
    }

    public Farmaco(){}

    public String getReceita() {
        return receita;
    }

    public String getTipo() {
        return tipo;
    }

    public String getContraIndicacao() {
        return contraIndicacao;
    }

    public void setReceita(String receita) {
        this.receita = receita;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setContraIndicacao(String contraIndicacao) {
        this.contraIndicacao = contraIndicacao;
    }

    public double calcularImposto(){
        return 0.02;
    }
}