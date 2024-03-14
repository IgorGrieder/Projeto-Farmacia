package dominio;

public abstract class Produto {

    protected String nome;
    protected String codigo;
    protected String marca;
    protected double preco;

    public Produto(String nome,String codigo, String marca, double preco){
        this.nome = nome;
        this.codigo = codigo;
        this.marca = marca;
        this.preco = preco;
    }

    public Produto(){}
    
    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPreco(double preço) {
        this.preco = preço;
    }

    public abstract double calcularImposto();
}