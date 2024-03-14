package dominio;

public class Cosmetico extends Produto{

    private String tipo; //Higiene, Beleza etc

    public Cosmetico(String nome, String codigo, String marca, double preco, String tipo){
        super(nome, codigo, marca, preco);
        this.tipo = tipo;
    }
    
    public Cosmetico(){}

    public String getTipo() {
        return tipo;
    }

     public void setTipo(String tipo) {
         this.tipo = tipo;
     }

    public double calcularImposto(){
        return 0.05;
    }
}