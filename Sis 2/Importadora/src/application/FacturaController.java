package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FacturaController {
	@FXML
	private Label numeroFactura;
	@FXML
	private TextField campoNombre,campoNit,campoTotal;
	@FXML
	private DatePicker fecha;
	@FXML
	private Button imprimir;
}
