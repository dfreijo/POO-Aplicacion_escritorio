package Vista;

import controlador.Controlador;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class VistaMostrarCliente {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;
    @FXML
    private TextField nif;
    @FXML
    private TextArea textArea;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }

    public void mostrarCliente(ActionEvent event){
        String dni = nif.getText();

        try{
            String cliente = controlador.mostrarCliente(dni);
            String sinComas = cliente.replace(",", "");
            textArea.setText(sinComas);
        }catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error ");
            alert.setHeaderText("Error inesperado");
            alert.setContentText("Los datos introducidos son erróneos o el cliente no existe. Por favor, revise la información ingresada.");

            alert.showAndWait();
        }
        nif.clear();
    }

    public void cambiarMenuPrincipal(javafx.event.ActionEvent event) throws IOException {
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
