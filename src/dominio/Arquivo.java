package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;


public class Arquivo{

    //Nomes dos arquivos:
    private String arquivoAlimento;
    private String arquivoFarmaco;
    private String arquivoCosmetico;

    //Gravadores dos arquivos:
    private Formatter gravadorAlimento;
    private Formatter gravadorFarmaco;
    private Formatter gravadorCosmetico;

    //Leitor dos arquivos:
    private Scanner lerArquivoAlimento;
    private Scanner lerArquivoFarmaco;
    private Scanner lerArquivoCosmetico;

    //Construtor:
    public Arquivo(String arquivoAlimento, String arquivoFarmaco, String arquivoCosmetico) {
        this.arquivoAlimento = arquivoAlimento;
        this.arquivoFarmaco = arquivoFarmaco;
        this.arquivoCosmetico = arquivoCosmetico;
    }

    //Abaixo estão os métodos de gravação de arquivos dos Produtos:
    public void abrirGravacaoProdutos(){
        try{
            gravadorAlimento = new Formatter(arquivoAlimento);
            gravadorFarmaco = new Formatter(arquivoFarmaco);
            gravadorCosmetico = new Formatter(arquivoCosmetico);
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void gravaArquivoProdutos(ListaDeProdutos produtos){

        for(Produto ex : produtos.getProdutos()){
            if(ex instanceof Alimento){
              Alimento a = (Alimento)ex;
              gravadorAlimento.format("%s;%s;%s;%.2f;%s;%.2f",
                        a.getNome(),
                        a.getCodigo(),
                        a.getMarca(),
                        a.getPreco(),
                        a.getContraIndicacao(),
                        a.getValorCalorico());
            }else if(ex instanceof Farmaco){
              Farmaco a = (Farmaco)ex;
              gravadorFarmaco.format("%s;%s;%s;%.2f;%s;%s;%s%n",
                        a.getNome(),
                        a.getCodigo(),
                        a.getMarca(),
                        a.getPreco(),
                        a.getReceita(),
                        a.getTipo(),
                        a.getContraIndicacao());
            }else if(ex instanceof Cosmetico){
              Cosmetico a = (Cosmetico)ex;
              gravadorCosmetico.format("%s;%s;%s;%.2f;%s%n", 
                        a.getNome(),
                        a.getCodigo(), 
                        a.getMarca(),
                        a.getPreco(), 
                        a.getTipo());
            }
        }
        fecharGravadorProdutos();
    }

    public void fecharGravadorProdutos(){
        gravadorAlimento.close();
        gravadorFarmaco.close();
        gravadorCosmetico.close();
    }

    //Abaixo estão os métodos de leitura de arquivos dos Produtos:
    public void abrirLeituraProdutos(){
        try{
            lerArquivoAlimento = new Scanner(new File(arquivoAlimento));
            lerArquivoFarmaco = new Scanner(new File(arquivoFarmaco));
            lerArquivoCosmetico = new Scanner(new File(arquivoCosmetico));
        }catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public ListaDeProdutos lerArquivoProdutos(){
      ArrayList<Produto> produtos = new ArrayList<>();
      
      while(lerArquivoAlimento.hasNextLine()){
        String[] linha = lerArquivoAlimento.nextLine().split(";");
        Alimento aux = new Alimento(linha[0], linha[1], linha[2], Double.parseDouble(linha[3]), linha[4], Double.parseDouble(linha[5]));
        produtos.add(aux);
      }
      
      while(lerArquivoFarmaco.hasNextLine()){
        String[] linha = lerArquivoFarmaco.nextLine().split(";");
        Farmaco aux = new Farmaco(linha[0], linha[1], linha[2], Double.parseDouble(linha[3]), linha[4], linha[5], linha[6]);
        produtos.add(aux);
      }
      
      while(lerArquivoCosmetico.hasNextLine()){
        String[] linha = lerArquivoCosmetico.nextLine().split(";");
        Cosmetico aux = new Cosmetico(linha[0], linha[1], linha[2], Double.parseDouble(linha[3]), linha[4]);
        produtos.add(aux);
      }

      ListaDeProdutos lista = new ListaDeProdutos(produtos);
      
      fecharLeitorProdutos();
      return lista;
    }

    public void fecharLeitorProdutos(){
      lerArquivoAlimento.close();
      lerArquivoFarmaco.close();
      lerArquivoCosmetico.close();
    }
}
