package Vista;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaAnadirCliente {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private TextField nombre;
    @FXML
    private TextField domicilio;
    @FXML
    private TextField nif;
    @FXML
    private TextField email;
    @FXML
    private ChoiceBox<String> tipoCliente;
    @FXML
    private TextField descuento;
    @FXML
    private TextField cuota;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void initialize() {
        tipoCliente.getItems().addAll("ESTANDAR", "PREMIUM");
        tipoCliente.setValue("ESTANDAR");
    }
    public void anadirCliente(ActionEvent event) {
        String nom = nombre.getText();
        String dom = domicilio.getText();
        String dni = nif.getText();
        String mail = email.getText();
        String tC = tipoCliente.getValue();
        String desc = descuento.getText();
        String cuot = cuota.getText();

        try{
            controlador.agregarCliente(dni, nom, dom, mail, tC, Float.parseFloat(desc), Float.parseFloat(cuot));
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en la Insercion de Datos");
            alert.setContentText("Error en la Insercion de Datos. Compruebe los datos ingresados.");
            alert.showAndWait();
        }
        nombre.clear();
        domicilio.clear();
        nif.clear();
        email.clear();
        tipoCliente.setValue("ESTANDAR");
        descuento.clear();
        cuota.clear();
    }
    public void cambiarMenuCliente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/menuCliente.fxml"));
        root = loader.load();

        VistaGestionCliente VistaGestionClienteControlador = loader.getController();
        VistaGestionClienteControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
