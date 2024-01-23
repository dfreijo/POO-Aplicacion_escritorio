package Vista;

import controlador.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaMenuListarPedidos {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void mostrarPedidoId(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mostrarPedidoID.fxml"));
        root = loader.load();

        VistaMostrarPedidoID VistaMostrarPedidoIDControlador = loader.getController();
        VistaMostrarPedidoIDControlador.setControlador(controlador);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void mostrarPedidoPendiente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mostrarPedidosPendientes.fxml"));
        root = loader.load();

        VistaMostrarPedidoPendiente VistaMostrarPedidoPendienteControlador = loader.getController();
        VistaMostrarPedidoPendienteControlador.setControlador(controlador);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void mostrarPedidoEnviado(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mostrarPedidosEnviados.fxml"));
        root = loader.load();

        VistaMostrarPedidoEnviados VistaMostrarPedidoEnviadosoControlador = loader.getController();
        VistaMostrarPedidoEnviadosoControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

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
