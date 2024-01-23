package Vista;

import controlador.Controlador;
import excepciones.DAOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class
VistaMostrarPedidoEnviados {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;
    @FXML
    private ListView<String> listView;
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }

    public void mostrarPedidosEnviados(ActionEvent event) {
        String pedido = null;
        try {
            pedido = controlador.mostrarPedidoEnvi();

        } catch (DAOException | SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error en la Lectura de datos");
            alert.setContentText("Error en la Lectura de datos.");

            alert.showAndWait();
        }

        if (pedido != null){
            String[] pedidos = pedido.split("INFO PEDIDO \n");

            for (int i = 1; i < pedidos.length; i++) { // Comienza en 1 porque el primer elemento estará vacío
                String sinLlave1 = pedidos[i].replace("}","");
                String sinLlave2 = sinLlave1.replace("{", "");
                String sinComas = sinLlave2.replace(",", "");
                listView.getItems().add(sinComas);
            }
        }
    }

    public void cambiarMenuPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mostrarPedido.fxml"));
        root = loader.load();

        VistaMenuListarPedidos VistaMenuListarPedidosControlador = loader.getController();
        VistaMenuListarPedidosControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
