/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class cancelarPedidoController  {
    //LABEL ID PEDIDO A LADO DE CAMPO DE TEXTO PARA BUSCAR
    @FXML
    private Label titIdPedido; 
     // TODOS LOS QUE LLEVAN TIT SON LOS LABELS QUE DESCRIBEN LOS CAMPOS 
    //Son labels de la consulta 
    @FXML
    private Label titProducto;
    @FXML
    private Label titCantidad;
    @FXML
    private Label titFechaPedido;
    @FXML
    private Label titCancelar;
    @FXML 
    private Label titSupID;
    @FXML
    // LOS LABELS QUE LLEVAN RESP SON LOS QUE PONDRAN LA RESPUESTA DESPUES DE LA CONSULTA
    private Label respProducto; 
    @FXML
    private Label respCantidad;
    @FXML
    private Label respFechaPedido;
    @FXML
    private Label respCancelar;
    @FXML
    private Label respIdProducto;
    //Aqui va el id del producto a buscar
    @FXML 
    private TextField campoBusqueda; 
    //botones
    @FXML
    private Button btnBuscarPedido; 
    @FXML
    private Button btnCancelarPedido;

    @FXML
    private void buscarPedido(ActionEvent event) {
        String idPedido = campoBusqueda.getText();
        System.out.println("ID PEDIDO " + idPedido );
    }
    @FXML
    private void cancelarPedido(ActionEvent a){
        System.out.println("Cancelando pedido");
    }
    
    public void setRespuestas(){
        
    }
    
}
