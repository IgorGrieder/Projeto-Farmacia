package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dominio.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SceneController implements Initializable {
    static Farmacia  farmacia = new Farmacia();


    private Stage stage;
    private Scene scene;
    private Parent root;
     

    @FXML
    private TextArea TextAreaProdutos;

    @FXML
    private AnchorPane TextAreaValorCompra;
    @FXML
    private TextArea TextAreaEstoque;

    @FXML
    private TextField TxFieldTipoFarmacos;

    @FXML
    private TextField TxFieldCodigoAlimentos;

    @FXML
    private TextField TxFieldCodigoCosmeticos;

    @FXML
    private TextField TxFieldCodigoFarmacos;

    @FXML
    private TextField TxFieldContraIndicacao;

    @FXML
    private TextField TxFieldMarcaAlimentos;

    @FXML
    private TextField TxFieldMarcaCosmeticos;

    @FXML
    private TextField TxFieldMarcaFarmacos;

    @FXML
    private TextArea TxFieldPrecoVenda;

    @FXML
    private TextArea TxFieldQteVenda;

    @FXML
    private TextArea TxFieldCodigoVenda;

    @FXML
    private TextField TxFieldNomeAlimentos;

    @FXML
    private TextField TxFieldNomeCosmeticos;
    
    @FXML
    private TextField TxFieldContraIndicacaoFarmacos;

    @FXML
    private TextField TxFieldNomeFarmacos;

    @FXML
    private TextField TxFieldPrecoAlimentos;

    @FXML
    private TextField TxFieldPrecoCosmeticos;

    @FXML
    private TextField TxFieldPrecoFarmacos;

    @FXML
    private TextField TxFieldReceita;

    @FXML
    private TextField TxFieldTipoCosmeticos;

    @FXML
    private TextField TxFieldValorCalorico;

    @FXML
    void ManipulaAdicionaAlimentos(ActionEvent event) {

        String nome;
        double preco;
        String marca;
        String codigo;
        double valorCalorico;
        String contraIndicacao;

        try {
            nome = TxFieldNomeAlimentos.getText();
            preco = Double.parseDouble(TxFieldPrecoAlimentos.getText());
            marca = TxFieldMarcaAlimentos.getText();
            codigo = TxFieldCodigoAlimentos.getText();
            valorCalorico = Double.parseDouble(TxFieldValorCalorico.getText());
            contraIndicacao = TxFieldContraIndicacao.getText();

            Alimento novoAlimento = new Alimento(nome, codigo, marca, preco, contraIndicacao, valorCalorico);
            farmacia.getListaDeProdutos().adicionarProduto(novoAlimento);
             farmacia.atualizarProdutos();
             farmacia.gravarListaProdutos();



        } catch (NumberFormatException e) {
            
            this.lancaAlarme();
            this.limpaAlimentos();
        }

        // instanciar produto com esses atributos e adicionar

        // resetando os campos
        this.limpaAlimentos();
    }

    @FXML
    void ManipulaAdicionaFarmacos(ActionEvent event) {

        String nome;
        double preco;
        String marca;
        String codigo;
        String receita;
        String tipo;
        String contraIndicacaoFarmacos;

        try {

            nome = TxFieldNomeFarmacos.getText();
            preco = Double.parseDouble(TxFieldPrecoFarmacos.getText());
            marca = TxFieldMarcaFarmacos.getText();
            codigo = TxFieldCodigoFarmacos.getText();
            receita = TxFieldReceita.getText();
            tipo = TxFieldTipoFarmacos.getText();
            contraIndicacaoFarmacos = TxFieldContraIndicacaoFarmacos.getText();

            Farmaco novoFarmaco = new Farmaco(nome, codigo, marca, preco, receita, tipo, contraIndicacaoFarmacos);
            farmacia.getListaDeProdutos().adicionarProduto(novoFarmaco);
                farmacia.atualizarProdutos();

            farmacia.gravarListaProdutos();

        } catch (NumberFormatException e) {
            
            this.lancaAlarme();
            this.limpaFarmacos();
        }

        // instanciar produto com esses atributos e adicionar

        // resetando os campos
        this.limpaFarmacos();
    }

    @FXML
    void ManipulaAdicionaCosmetiscos(ActionEvent event) {

        String nome;
        double preco;
        String marca;
        String codigo;
        String tipo;

        try {

            nome = TxFieldNomeCosmeticos.getText();
            preco = Double.parseDouble(TxFieldPrecoCosmeticos.getText());
            marca = TxFieldMarcaCosmeticos.getText();
            codigo = TxFieldCodigoCosmeticos.getText();
            tipo = TxFieldTipoCosmeticos.getText();

            Cosmetico novoCosmetico = new Cosmetico(nome, codigo, marca, preco, tipo);
            farmacia.getListaDeProdutos().adicionarProduto(novoCosmetico);
            farmacia.atualizarProdutos();
                        farmacia.gravarListaProdutos();


        } catch (NumberFormatException e) {
            
            this.lancaAlarme();
            this.limpaComesmeticos();
        }

        // instanciar produto com esses atributos e adicionar

        // resetando os campos
        this.limpaComesmeticos();
    }
    @FXML
    void ManipulaBotaoListarEstoque(ActionEvent event) {
        

        for (ControleDeProduto  produto : farmacia.getEstoque().getProdutos()) {
            TextAreaEstoque.appendText("Nome Produto : " + produto.getProduto().getNome()+ " Quantidade: "+ produto.getQuantidade() + " \n");

            
        }

    }

    @FXML
    void ManipulaBotoes(ActionEvent evento) throws IOException {

        String face = ((Button) evento.getSource()).getText();

        if (face.equals("VENDA")) {

            switchToScene1(evento);

        } else if (face.equals("ESTOQUE")) {
            switchToScene2(evento);
        } else if (face.equalsIgnoreCase("Voltar")) {

            switchToScene0(evento);
        } else if (face.equalsIgnoreCase("Adicionar Carrinho")){
            //implementar
            String codigo;
            int qte;

            try {
                codigo = TxFieldCodigoVenda.getText();
                qte = Integer.parseInt(TxFieldQteVenda.getText());
                farmacia.adicionarAoCarrinho(codigo, qte);
                TextAreaProdutos.appendText("Codigo Produto: " + codigo + "Quantidade: " + qte + "\n");
                // armazenando para fazer a busca tem que implementar como chama para ser feita
                // pegar onde que for o valro total do carrinho TxFieldPrecoVenda.setText();
                // adicioanr tbm na tela TextAreaProdutos.setTex(Conteudo do carrinho atual)
            } catch (NumberFormatException e) {
                
                this.lancaAlarme();
                this.limpaOpcoesCarrinho();
            }
        } else if (face.equalsIgnoreCase("Esvaziar")){
            farmacia.esvaziarCarrinho();

            TextAreaProdutos.setText("");
            TxFieldPrecoVenda.setText("");
            
        } else if (face.equalsIgnoreCase("Finalizar")){
            farmacia.getCarrinho().calcularPrecoTotal();
            double precoTotal = farmacia.getCarrinho().getPrecoTotal();
            TxFieldPrecoVenda.setText("R$:"+precoTotal);

            // implementar
        }

    }

    private void lancaAlarme() {

        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro de Entrada");
        alerta.setHeaderText("Erro");
        alerta.setContentText("Entrada inválida de dados, tente novamente.");
        alerta.showAndWait();
    }

    private void limpaOpcoesCarrinho(){
        TxFieldCodigoVenda.setText("");
        TxFieldQteVenda.setText("");
    }

    private void limpaComesmeticos() {

        TxFieldNomeCosmeticos.setText("");
        TxFieldPrecoCosmeticos.setText("");
        TxFieldMarcaCosmeticos.setText("");
        TxFieldCodigoCosmeticos.setText("");
        TxFieldTipoCosmeticos.setText("");

    }

    private void limpaFarmacos() {

        TxFieldNomeFarmacos.setText("");
        TxFieldPrecoFarmacos.setText("");
        TxFieldMarcaFarmacos.setText("");
        TxFieldCodigoFarmacos.setText("");
        TxFieldReceita.setText("");
        TxFieldTipoFarmacos.setText("");
        TxFieldContraIndicacaoFarmacos.setText("");

    }

    private void limpaAlimentos(){

        TxFieldNomeAlimentos.setText("");
        TxFieldPrecoAlimentos.setText("");
        TxFieldMarcaAlimentos.setText("");
        TxFieldCodigoAlimentos.setText("");
        TxFieldValorCalorico.setText("");
        TxFieldContraIndicacao.setText("");

    }

    public void switchToScene0(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXML1.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FXMLTelaVenda.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaEstoque.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        


    }

}
