package dominio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class ArquivoEstoque{
  
  private String nomeArquivo;
  private Formatter formatter;
  private Scanner scanner;

  public ArquivoEstoque(String nomeArquivo){
      this.nomeArquivo = nomeArquivo;
  }

  public void abrirArquivoEscrita(){
    try{
      formatter = new Formatter(nomeArquivo);
    }catch(FileNotFoundException e){
       e.printStackTrace();
    }
  }

  public void gravarArquivo(ArrayList<ControleDeProduto> array){
      for(ControleDeProduto controleDeProdutos : array){
        formatter.format("%s;%d%n", controleDeProdutos.getProduto().getCodigo(), controleDeProdutos.getQuantidade());
      }
      this.fecharArquivoEscrita();
  }

  public void fecharArquivoEscrita(){
    formatter.close();
  }

  public void abrirArquivoGravacao(){
    try{ scanner = new Scanner(new File(nomeArquivo));
       } catch(FileNotFoundException e){
       e.printStackTrace();
    }
  }

  public ArrayList<ControleDeProduto> lerArquivo(ListaDeProdutos lista){
    ArrayList<ControleDeProduto> array = new ArrayList<>();
    while(scanner.hasNext()){
      String[] linha = scanner.nextLine().split(";");
      for(Produto i:lista.getProdutos()){
        if(i.getCodigo().equals(linha[0])){
          ControleDeProduto controleDeProduto = new ControleDeProduto(i, Integer.parseInt(linha[1]));
          array.add(controleDeProduto);
        }  
      }
    }
    fecharArquivoGravacao();
    return array;
  }
  
  public void fecharArquivoGravacao(){
    scanner.close();
  }
}