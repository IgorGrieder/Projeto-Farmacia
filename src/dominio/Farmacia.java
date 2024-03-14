package dominio;

import java.util.ArrayList;

public class Farmacia {
    
    private Carrinho carrinho;
    private Estoque estoque;
    private ListaDeProdutos listaDeProdutos;

    public Farmacia(){
        this.carrinho = new Carrinho();
        this.estoque = new Estoque();
        this.listaDeProdutos = new ListaDeProdutos();
    }

    // Construtor para caso já exista uma lista de produtos pronta (arquivo). Falta adicionar a parte de atualizar as quantidades.
    public Farmacia(ListaDeProdutos lista){
        this.carrinho = new Carrinho();
        this.estoque = new Estoque();
        for(Produto a:lista.getProdutos()){
            carrinho.getProdutos().add(new ControleDeProduto(a, 0));
            estoque.getProdutos().add(new ControleDeProduto(a, 0));
        }
    }

    public void atualizarProdutos(){
        ArrayList<Produto> arrayE=new ArrayList<>();
        ArrayList<Produto> arrayC=new ArrayList<>();
        for(ControleDeProduto a:estoque.getProdutos()){
            arrayE.add(a.getProduto());
        }
        for(ControleDeProduto a:carrinho.getProdutos()){
            arrayC.add(a.getProduto());
        }

        for(Produto a:listaDeProdutos.getProdutos()){
            if(!arrayE.contains(a)){
                estoque.getProdutos().add(new ControleDeProduto(a,0));
            }
            if(!arrayC.contains(a)){
                carrinho.getProdutos().add(new ControleDeProduto(a,0));
            }
        }
    }

    public void gravarListaProdutos(){
        Arquivo arquivo = new Arquivo("Alimentos.txt","Farmacos.txt","Cosmeticos.txt");
        arquivo.abrirGravacaoProdutos();
        arquivo.gravaArquivoProdutos(this.listaDeProdutos);
      }
  
      public void atualizarListaProdutos(){
        Arquivo arquivo = new Arquivo("Alimentos.txt","Farmacos.txt","Cosmeticos.txt");
        arquivo.abrirLeituraProdutos();
        this.listaDeProdutos = arquivo.lerArquivoProdutos();
      }
  
      public void gravarEstoque(){
        ArquivoEstoque arquivo = new ArquivoEstoque("Estoque.txt");
        arquivo.abrirArquivoGravacao();
        arquivo.gravarArquivo(this.estoque.getProdutos());
      }
  
      public void atualizarEstoque(){
        atualizarListaProdutos();
        ArquivoEstoque arquivo = new ArquivoEstoque("Estoque.txt");
        arquivo.lerArquivo(this.listaDeProdutos);
        estoque.setProdutos(arquivo.lerArquivo(this.listaDeProdutos));;
      }

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public ListaDeProdutos getListaDeProdutos() {
        return listaDeProdutos;
    }
    
    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public void setListaDeProdutos(ListaDeProdutos listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }

    public void esvaziarCarrinho(){
        for(ControleDeProduto a:carrinho.getProdutos()){
            String codigo = a.getProduto().getCodigo();
            int quantidade = a.getQuantidade();
            this.estoque.controlarProdutos(quantidade, codigo, true);
        }
        this.carrinho.cancelarCompra();
    }

    public void adicionarAoCarrinho(String codigo,int quantidade){
        for(ControleDeProduto a:estoque.getProdutos()){
            if(a.getProduto().getCodigo().equals(codigo)){
                this.estoque.controlarProdutos(quantidade, codigo, false);
            }
        }
        for(ControleDeProduto a:carrinho.getProdutos()){
            if(a.getProduto().getCodigo().equals(codigo)){
                this.carrinho.controlarProdutos(quantidade, codigo, true);
            }
        }
    }

    public void removerDoCarrinho(String codigo, int quantidade){
        for(ControleDeProduto a:estoque.getProdutos()){
            if(a.getProduto().getCodigo().equals(codigo)){
                this.estoque.controlarProdutos(quantidade, codigo, true);
            }
        }
        for(ControleDeProduto a:carrinho.getProdutos()){
            if(a.getProduto().getCodigo().equals(codigo)){
                this.carrinho.controlarProdutos(quantidade, codigo, false);
            }
        }
    }
}
