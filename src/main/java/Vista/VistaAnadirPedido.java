package Vista;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.sql.Date;

public class VistaAnadirPedido {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private TextField id_pedido;
    @FXML
    private TextField nif;
    @FXML
    private TextField id_articulo;
    @FXML
    private TextField cantidad;
    @FXML
    private ChoiceBox<String> estadoChoiceBox;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    @FXML
    public void initialize() {
        estadoChoiceBox.getItems().addAll("PENDIENTE", "ENVIADO");
        estadoChoiceBox.setValue("PENDIENTE");
    }
    @FXML
    public void handleAnadirPedido(ActionEvent event) {

        String idPedidoHandle = id_pedido.getText();
        String nifHandle = nif.getText();
        String idArticuloHandle = id_articulo.getText();
        String cantidadHandle = cantidad.getText();
        String estadoHandle = estadoChoiceBox.getValue();

        LocalDateTime fechaActual = LocalDateTime.now();

        try{
            controlador.agregarPedido(idPedidoHandle, nifHandle, idArticuloHandle, Integer.parseInt(cantidadHandle), Date.from(fechaActual.toInstant(ZoneOffset.UTC)), estadoHandle);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error en la Insercion de Datos");
            alert.setHeaderText("Error en la Insercion de Datos");
            alert.setContentText("Error en la Insercion de Datos.");

            alert.showAndWait();
        }
        id_pedido.clear();
        nif.clear();
        id_articulo.clear();
        cantidad.clear();
        estadoChoiceBox.setValue("PENDIENTE");
    }

    public void cambiarMenuPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/menuPedido.fxml"));
        root = loader.load();

        VistaGestionPedido VistaGestionPedidoControlador = loader.getController();
        VistaGestionPedidoControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
