/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import static application.Main.conector;
import java.awt.Image;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
//import javafx.event.
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class clienteExistenteController implements Initializable {
    //ConectaDB conector=new ConectaDB();
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
        @FXML
	private TextField mostrarFecha;
        //datepicker
        @FXML 
        private DatePicker fechaLlegada;
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
        private Label validarCantidad;
        @FXML
        private Label validarCostPrd;
        @FXML
        private Label validarCostoPed;
        @FXML
        private Label validarFechaLlegada;
        @FXML
        private ComboBox<String>  comboProveedores;
        @FXML
        
       private void registrar(ActionEvent e){
           //String fechaPed=fechaPedido.getValue().toString();
           //v1=primera verificacion y asi hasta la verificacion 6
         boolean v1,v2,v3,v4,v5,v6;  
           if(verificar.validarTelyCi(campoCiNit.getText())==true){
               v1=true;
               validarNitCi.setText("Correcto");
           }else{
               v1=false;
               validarNitCi.setText("El Nit/Ci debe contener solo Numeros ejemplo:144895");
           }
           if((verificar.validarTextoyNumeros(campoNombrePrd.getText())==true)){
               v2=true;
               validarPrd.setText("Correcto");
           }else{
               v2=false;
               validarPrd.setText("El nombre debe contener numeros o letras ejemplo: PS4 ");
           }
           if(verificar.validarTelyCi(campoCantidad.getText())==true){
               v3=true;
               validarCantidad.setText("Correcto");
           }else{
               v3=false;
               validarCantidad.setText("La cantidad solo debe ser numero ejemplo: 10");
           }
           if(verificar.validarTelyCi(campoCostProducto.getText())==true){
               v4=true;
               validarCostPrd.setText("Correcto");
           }else{
               v4=false;
               validarCostPrd.setText("El costo producto deben ser numeros enteros ejemplo: 105");
           }
           if(verificar.validarTelyCi(campoCostoPedido.getText())==true){
               v5=true;
               validarCostoPed.setText("Correcto");
           }else{
               v5=false;
               validarCostoPed.setText("El costo pedido deben ser numeros enteros ejemplo:5279");
           }
           if(v1==true && v2==true &&v3==true &&v4==true &&v5==true ){
               //JOptionPane.showMessageDialog(null, "REGISTRADO");
                insertarPedido();
           }else{
               JOptionPane.showMessageDialog(null, "NO REGISTRADO REVISE SI TIENE ERRORES");
           }
           
        //JOptionPane.showMessageDialog(null, "REGISTRADO");
         } 
       @FXML
       private void cancel(ActionEvent e){
        //JOptionPane.showMessageDialog(null, "Hola Mundo");
        try{
            Main.stage.close();
            Parent root = FXMLLoader.load(getClass().getResource("SeleccionUsuario.fxml"));
            Scene scene = new Scene(root);
	 
            Main.stage.setScene(scene);
            Main.stage.setTitle("Seleccion Usuario");
            Main.stage.show();
        }catch(Exception ess){
            System.err.println(ess);
        }
        
      }

     private void insertarPedido(){
         int ci= Integer.parseInt(campoCiNit.getText());
         String nombreProd=campoNombrePrd.getText();
         int cantidad=Integer.parseInt(campoCantidad.getText());
         int costProd=Integer.parseInt(campoCostProducto.getText());
         String proveedor= comboProveedores.getValue().toString();
         //String fechaPed= fechaPedido.getValue().toString();
         String fechaPed= verificar.fechaGuardar();
         String fechaLlegadA= fechaLlegada.getValue().toString();
         int costoPed=Integer.parseInt(campoCostoPedido.getText());
         ResultSet res;
         try {
             //(integer,Character Varying, integer, integer,Character Varying,date,date,integer
            res=Main.conector.consultar("Select registrarPedido("+ci+",'"+nombreProd+"',"+cantidad+","+costProd+",'"+proveedor+"','"+fechaPed+"','"+fechaLlegadA+"',"+costoPed+");");
            if (res.next()) {
                String retorno=res.getString("registrarPedido");
                //falta capturar mensaje
                System.out.println(retorno);
                if(retorno.equalsIgnoreCase("UsuarioNoEncotrado")){
                     JOptionPane.showMessageDialog(null, "EL USUARIO NO ESTA REGISTRADO");
                
                }else{
                    if(retorno.equalsIgnoreCase("registrado")){
                        JOptionPane.showMessageDialog(null, "EL PEDIDO FUE REGISTRADO");
                    }else{
                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR EN LA BASE DE DATOS");
                    }
                }
                
            } else {
                System.err.println("Datos Incorrecto");
            }
        } catch (Exception e) {
            System.err.println("Error : "+e);
        }
     }
     
     private ObservableList<String> llenarComboProveedor() { 

     ObservableList<String> items=FXCollections.observableArrayList();
     
      try {    
        ResultSet rs=null; 
        rs = conector.consultar("SELECT proveedor.nombre_prov FROM proveedor");
            System.out.println("104");
                while (rs.next()) {
                    items.add(rs.getString(1));
                    System.out.println(rs.getString(1));
                    System.err.println(rs.getString(1) +"**");
            
        }
        
                } catch(Exception err){err.printStackTrace();} 
     return items;
    }
    public void initialize(URL url, ResourceBundle rb) {
        comboProveedores.setItems(llenarComboProveedor());
        comboProveedores.getSelectionModel().selectFirst();
        campoCiNit.setFocusTraversable(true);
        mostrarFecha.setText(verificar.fechaMostrar());
        mostrarFecha.setEditable(false);
    }    
    

	

}
