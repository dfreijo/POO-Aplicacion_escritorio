package Vista;

import controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class VistaMenuPrincipal {
    private Scene scene;
    private Stage stage;
    private Parent root;
    private Controlador controlador;

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
        System.out.println("El controlador es" + controlador.toString());
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
    public void cambiarMenuArticulo(ActionEvent event) throws IOException {
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
    public void cambiarMenuPedido(ActionEvent event) throws IOException {
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
    public void cambiarMenuInicial(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/principal.fxml"));
        root = loader.load();

        VistaInicial VistaInicialControlador = loader.getController();
        VistaInicialControlador.setControlador(controlador);

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
