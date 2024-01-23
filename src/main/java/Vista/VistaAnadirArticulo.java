package Vista;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

public class VistaAnadirArticulo {
    private Scene scene;
    private Stage stage;
    private Parent root;

    @FXML
    private TextField codigo;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField precio;
    @FXML
    private TextField gastosEnvio;
    @FXML
    private TextField tiempoPreparacion;

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }

    @FXML
    public void handleAnadirArticulo(ActionEvent event) {
        String codigoHandle = codigo.getText();
        String descripcionHandle = descripcion.getText();
        String precioHandle = precio.getText();
        String gastosEnvioHandle = gastosEnvio.getText();
        String tiempoPreparacionHandle = tiempoPreparacion.getText();

        try {
            controlador.agregarArticulo(codigoHandle, descripcionHandle, Float.parseFloat(precioHandle), Float.parseFloat(gastosEnvioHandle), Integer.parseInt(tiempoPreparacionHandle));
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en la Inserción de Datos");
            alert.setHeaderText("Error en la Inserción de Datos");
            alert.setContentText("Error en la Inserción de Datos.");

            alert.showAndWait();
        }

        // Limpiar los campos después de la inserción
        codigo.clear();
        descripcion.clear();
        precio.clear();
        gastosEnvio.clear();
        tiempoPreparacion.clear();
    }

    public void cambiarMenuPrincipal (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/menuArticulo.fxml"));
        root = loader.load();
        VistaGestionArticulo VistaGestionArticuloControlador = loader.getController();
        VistaGestionArticuloControlador.setControlador(controlador);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
