/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.event.ActionEvent;
//import javafx.event.
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class clienteExistenteController {
        private verificacion verificar = new verificacion(); 
        //TextField donde se obtendran datos del producto
        @FXML
	private TextField campoNombrePrd;
        @FXML
	private TextField campoCantidad;
        @FXML
	private TextField campoCostoPedido;
        @FXML
	private TextField campoCostProducto;
	@FXML
	private TextField campoCiNit;
        //botones donde se podra registrar o cancelar el pedido
	@FXML
	private Button btnCancelar;
        @FXML
	private Button btnRegistrar;
        //Labels para validaciones
        @FXML
        private Label validarNitCi;
        @FXML
        private Label validarPrd;
        @FXML
        private Label validarPrd2;
        @FXML
        private Label validarCantidad;
        @FXML
        private Label validarCostPrd;
        @FXML
        private Label validarCostoPed;
        @FXML
       private void registrar(ActionEvent e){
           if(verificar.validarTelyCi(campoCiNit.getText())==true){
               validarNitCi.setText("Correcto");
               if((verificar.validarTextoyNumeros(campoNombrePrd.getText())==true) ){//|| (verificar.validarTelyCi(campoNombrePrd.getText())==true)){
                   validarPrd.setText("Correcto");
                   validarPrd2.setText("");
                   if(verificar.validarTelyCi(campoCantidad.getText())==true){
                       validarCantidad.setText("Correcto");
                       if(verificar.validarTelyCi(campoCostProducto.getText())==true){
                           validarCostPrd.setText("Correcto");
                           if(verificar.validarTelyCi(campoCostoPedido.getText())==true){
                               validarCostoPed.setText("Correcto");
                               JOptionPane.showMessageDialog(null, "REGISTRADO");
                           }else{
                               JOptionPane.showMessageDialog(null, "REGISTRO NO VALIDO");
                               validarCostoPed.setText("El costo pedido deben ser numeros enteros ejemplo: 5279");
                           }
                       }else{
                           JOptionPane.showMessageDialog(null, "REGISTRO NO VALIDO");
                           validarCostPrd.setText("El costo producto deben ser numeros enteros ejemplo: 105");
                       }
                   }else{
                       JOptionPane.showMessageDialog(null, "REGISTRO NO VALIDO");
                       validarCantidad.setText("La cantidad solo debe ser numero ejemplo: 10");
                   }
               }else{
                   JOptionPane.showMessageDialog(null, "REGISTRO NO VALIDO");
                   validarPrd.setText("El nombre debe contener numeros o letras sin caracteres ");
                   validarPrd2.setText("especiales por ejemplo: Samsumg Galaxy S6");
               }
           }else{
                JOptionPane.showMessageDialog(null, "REGISTRO NO VALIDO");
                validarNitCi.setText("El Nit/Ci debe contener solo Numeros ejemplo:144895");
           }
           
           
        //JOptionPane.showMessageDialog(null, "REGISTRADO");
         }
       @FXML
       private void cancel(ActionEvent e){
        JOptionPane.showMessageDialog(null, "Hola Mundo");
         }
        //@FXML
	//private ComboBox<String> comboProveedores;
	/*
	ObservableList<String> Proveedores = FXCollections.observableArrayList("Entregado","SinObservaciones","Danhado","En Deposito");
	
	@FXML
	private void inicializar(){
		comboProveedores.setItems(Proveedores);
	}*/
	

}
