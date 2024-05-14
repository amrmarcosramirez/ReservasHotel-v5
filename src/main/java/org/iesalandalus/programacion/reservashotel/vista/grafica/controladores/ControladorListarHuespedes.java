package org.iesalandalus.programacion.reservashotel.vista.grafica.controladores;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import org.iesalandalus.programacion.reservashotel.vista.grafica.VistaGrafica;

import java.time.format.DateTimeFormatter;

import static org.iesalandalus.programacion.reservashotel.modelo.dominio.Huesped.FORMATO_FECHA;

public class ControladorListarHuespedes {
	
	//private IControlador controladorMVC;
	
	@FXML TableColumn<Huesped, String> tcNombre;
	@FXML TableColumn<Huesped, String> tcDni;
	@FXML TableColumn<Huesped, String> tcCorreo;
	@FXML TableColumn<Huesped, String> tcTelefono;
	@FXML TableColumn<Huesped, String> tcFechaNacimiento;
	@FXML TableView<Huesped> tvHuespedes;
	@FXML Button btAceptar;
	
	/*public void setControladorMVC(IControlador controladorMVC) {
		this.controladorMVC = controladorMVC;
	}*/
	
	public void inicializa() {
		tvHuespedes.setItems(FXCollections.observableArrayList(
				VistaGrafica.getInstancia().getControlador().getHuespedes()));
	}

	@FXML
	private void initialize() {
		tcNombre.setCellValueFactory(huesped -> new SimpleStringProperty(huesped.getValue().getNombre()));
		tcDni.setCellValueFactory(huesped -> new SimpleStringProperty(huesped.getValue().getDni()));
		tcCorreo.setCellValueFactory(huesped -> new SimpleStringProperty(huesped.getValue().getCorreo()));
		tcTelefono.setCellValueFactory(huesped -> new SimpleStringProperty(huesped.getValue().getTelefono()));
		tcFechaNacimiento.setCellValueFactory(huesped -> new SimpleStringProperty(huesped.getValue().
				getFechaNacimiento().format(DateTimeFormatter.ofPattern(FORMATO_FECHA))));
	}
	
	@FXML
	private void aceptar() {
		Stage escena = (Stage) btAceptar.getScene().getWindow();
	    escena.close();
	}

}
