/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class antiguoClienteController {
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
	@FXML
	private Button btnCancelar;
        @FXML
	private Button btnRegistrar;
        
        
        
        @FXML
	private ComboBox<String> comboProveedores;
	/*
	ObservableList<String> Proveedores = FXCollections.observableArrayList("Entregado","SinObservaciones","Danhado","En Deposito");
	
	@FXML
	private void inicializar(){
		comboProveedores.setItems(Proveedores);
	}*/
	

}
