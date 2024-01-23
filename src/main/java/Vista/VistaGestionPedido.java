package Vista;

import controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class VistaGestionPedido {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
    }
    public void cambiarListarPedido(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/mostrarPedido.fxml"));
        root = loader.load();

        VistaMenuListarPedidos VistaMenuListarPedidosControlador = loader.getController();
        VistaMenuListarPedidosControlador.setControlador(controlador);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarEliminarPedido(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/eliminarPedido.fxml"));
        root = loader.load();

        VistaEliminarPedido VistaEliminarPedidoControlador = loader.getController();
        VistaEliminarPedidoControlador.setControlador(controlador);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarAnadirPedido(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/anadirPedido.fxml"));
        root = loader.load();

        VistaAnadirPedido vistaAnadirPedidoControlador = loader.getController();
        vistaAnadirPedidoControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void cambiarMenuPrincipal(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/menuPrincipal.fxml"));
        root = loader.load();

        VistaMenuPrincipal VistaMenuPrincipalControlador = loader.getController();
        VistaMenuPrincipalControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        scene.getRoot().setStyle("-fx-background-color: #FFEACE;");
        stage.setScene(scene);
        stage.show();

    }
}