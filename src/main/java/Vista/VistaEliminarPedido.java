package Vista;

import controlador.Controlador;
import excepciones.DAOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class VistaEliminarPedido {
    private Scene scene;
    private Stage stage;
    private Parent root;
    @FXML
    private TextField id_pedido;

    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }

    @FXML
    public void handleEliminarPedido(ActionEvent event) {

        String idPedidoHandle = id_pedido.getText();

        try{
            controlador.borrarPedido(idPedidoHandle);
        }catch (DAOException | SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error eliminando Datos");
            alert.setHeaderText("Error eliminando Datos");
            alert.setContentText("Error eliminando Datos.");

            alert.showAndWait();
        }
       id_pedido.clear();
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