
package Vista;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import controlador.Controlador;
import excepciones.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.Scanner;

/**
 * Clase que representa la vista de una tienda en línea.
 */
public class Vista extends Application {

    Controlador controlador = new Controlador();
    Scanner input = new Scanner(System.in);

    /**
     * Constructor de la vista.
     */
    public Vista() {
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/principal.fxml"));
            Parent root = loader.load();

            VistaInicial vistaInicialControlador = loader.getController();
            vistaInicialControlador.setControlador(controlador);

            stage.setTitle("OnlineStore");
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Método principal que muestra el menú y permite interactuar con el Controlador.
     */
    public void menu() throws Exception {
        boolean salir = false;
        launch();
        char opcion;

        do {
            System.out.println("**************");
            System.out.println("*   INICIO   *");
            System.out.println("**************\n");
            System.out.println("1. Gestiónar artículo");
            System.out.println("2. Gestiónar cliente");
            System.out.println("3. Gestión pedido");
            System.out.println("0. SALIR");

            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        menuArticulo();
                        break;
                    case '2':
                        menuCliente();
                        break;
                    case '3':
                        menuPedido();
                        break;
                    case '0':
                        salir = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (!salir);
    }

    /**
     * Lee una opción del menú desde la entrada estándar.
     *
     * @return La opción seleccionada como un carácter.
     */
    char opcionMenu() {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Seleccione una de las siguientes opciones: ");
        String respuesta = entrada.nextLine();
        if (respuesta.isEmpty()) {
            respuesta = " ";
        }
        return respuesta.charAt(0);
    }

    /**
     * Muestra un menú para la gestión de artículos.
     */
    private void menuArticulo() {
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENÚ DE GESTIÓN DE ARTÍCULOS \n");
            System.out.println("1. Añadir artículo");
            System.out.println("2. Mostrar artículo");
            System.out.println("0. Volver al menu");

            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        leerInfoArticulo();
                        break;
                    case '2':
                        mostrarArticulo();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Lee la información de un artículo desde la entrada estándar y lo agrega al sistema.
     */
    private void leerInfoArticulo() {
        try {
            System.out.println("- Inserta el codigo");
            String codigo = input.nextLine();
            if (controlador.articuloExiste(codigo)) {
                throw new ElementoExistente();
            }

            System.out.println("- Inserta la descripcion");
            String descripcion = input.nextLine();

            System.out.println("- Inserta el precio");
            float precio = Float.valueOf(input.nextLine());

            System.out.println("- Inserta los gastos de envio");
            float gastos = Float.valueOf(input.nextLine());

            System.out.println("- Inserta tiempo de preparacion");
            int preparacion = Integer.valueOf(input.nextLine());

            controlador.agregarArticulo(codigo, descripcion, precio, gastos, preparacion);
        }
        catch (ElementoExistente e) {
            System.out.println(e.getMessage());
        } catch (DAOException | SQLException e) {
            System.out.println("Error insertando Articulo.");
        }
    }

    /**
     * Muestra un artículo en base a su código.
     */
    private void mostrarArticulo() {
        System.out.println("- Inserta el codigo del articulo");
        String codigo = input.nextLine();

        try {
            String articulo = controlador.mostrarArticulo(codigo);

            if (articulo != null) {
                String art = articulo.toString();
                System.out.println(art);
            } else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DAOException | SQLException e) {
            System.out.println("El Articulo no existe o se a producido un error leyendo Articulo");
        }
    }

    /**
     * Muestra un menú para la gestión de clientes.
     */
    private void menuCliente() {
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENÚ DE GESTIÓN DE CLIENTE \n");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Mostrar cliente");
            System.out.println("0. Volver al menú");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        leerInfoCliente();
                        break;
                    case '2':
                        menuMostrarCliente();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    private String menuTipoCliente() {
        char opcion;
        String tipo = "ESTANDAR";
        System.out.println("\nMENÚ TIPO DE CLIENTE \n");
        System.out.println("1. Estandar");
        System.out.println("2. Premium");
        opcion = opcionMenu();
        try {
            switch (opcion) {
                case '1':
                    tipo = "Estandar";
                    break;
                case '2':
                    tipo = "Premium";
                    break;
                default:
                    throw new OpcionInvalida();
            }
        } catch (OpcionInvalida e){
            System.out.println("Error: " + e.getMessage());
        }
        return tipo;
    }

    private String menuEstadoPedido() {
        char opcion;
        String tipo = "Pendiente";
        System.out.println("\nMENÚ DE ESTADO PEDIDO  \n");
        System.out.println("1. Pendiente");
        System.out.println("2. Enviado");
        opcion = opcionMenu();
        try {
            switch (opcion) {
                case '1':
                    tipo = "Pendiente";
                    break;
                case '2':
                    tipo = "Enviado";
                    break;
                default:
                    throw new OpcionInvalida();
            }
        } catch (OpcionInvalida e){
            System.out.println("Error: " + e.getMessage());
        }
        return tipo;
    }

    /**
     * Lee la información de un cliente desde la entrada estándar y lo agrega al sistema.
     */
    private void leerInfoCliente() {
        try {
            System.out.println("- Inserta el nombre (Nombre y apellidos)");
            String nombre = input.nextLine();

            System.out.println("- Inserta la direccion del domicilio (calle y número, ciudad, provincia)");
            String domicilio = input.nextLine();

            System.out.println("- Inserta el NIF (00000000X)");
            String nif = input.nextLine();

            if (controlador.clienteExiste(nif)){
                throw new ElementoExistente();
            }

            System.out.println("- Inserta el correo electronico");
            String email = input.nextLine();

            System.out.println("- Inserta el tipo de cliente (Estandar o Premium)");

            String tipo = menuTipoCliente(); // Inicializa tipo

            if (tipo.equals("Estandar")) {
                controlador.agregarCliente(nif, nombre, domicilio, email, tipo, null, null);

            } else if (tipo.equals("Premium")) {
                System.out.println("- Inserta el tipo de descuento para cliente premium");
                Float desc = Float.valueOf(input.nextLine());

                System.out.println("- Inserta la cuota MENSUAL para cliente premium");
                Float cuota = Float.valueOf(input.nextLine());

                controlador.agregarCliente(nif, nombre, domicilio, email, tipo, desc, cuota);

            } else {
                System.out.println("Tipo de cliente no válido.");
            }
        }
        catch (ElementoExistente e) {
            System.out.println(e.getMessage());
        } catch (DAOException | SQLException e) {
            System.out.println("Error insertando Cliente");
        }
    }

    /**
     * Muestra un cliente en base a su nif.
     */
    private void mostrarClienteById() {
        System.out.println("- Inserta el NIF del cliente ");
        String nif = input.nextLine();

        try {
            String cliente = controlador.mostrarCliente(nif);

            if (cliente != null) {
                String cli = cliente.toString();
                System.out.println(cli);
            } else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e) {
            System.out.println("Error: " + e.getMessage());
        } catch (DAOException | SQLException e) {
            System.out.println("El cliente no existe o se a producido un error mostrando Cliente");
        }
    }

    private void menuMostrarCliente(){
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\n1.Mostrar clientes estandar'");
            System.out.println("2. Mostrar clientes premium");
            System.out.println("3. Listar clientes por ID");
            System.out.println("0. Volver al menú principal");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        mostrarClientesEstandar();
                        break;
                    case '2':
                        mostrarClientesPremium();
                        break;
                    case '3':
                        mostrarClienteById();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    private void mostrarClientesPremium() {
        String tipo = null;
        try {
            tipo = controlador.mostrarClientePremium();
        } catch (DAOException | SQLException e) {
            System.out.println("Error mostrando Pedidos Pendientes");
        }

        if (tipo != null){
            String info = tipo.toString();
            System.out.println(info);
        }
    }

    private void mostrarClientesEstandar() {
        String tipo = null;
        try {
            tipo = controlador.mostrarClienteEstandar();
        } catch (DAOException | SQLException e) {
            System.out.println("Error mostrando Pedidos Estandar");
        }

        if (tipo != null){
            String info = tipo.toString();
            System.out.println(info);
        }
    }


    /**
     * Menú de gestión de pedidos que permite al usuario agregar, eliminar y listar pedidos.
     * Proporciona opciones para gestionar pedidos y volver al menú principal.
     */
    private void menuPedido(){
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\nMENÚ DE GESTIÓN DE PEDIDOS \n");
            System.out.println("1. Agregar Pedido");
            System.out.println("2. Eliminar Pedido");
            System.out.println("3. Listar Pedidos");
            System.out.println("0. Volver al menú principal");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        leerInfoPedido();
                        break;
                    case '2':
                        eliminarPedido();
                        break;
                    case '3':
                        menuMostrarPedido();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Menú para mostrar pedidos pendientes, pedidos enviados y listar un pedido por ID.
     * Proporciona opciones para mostrar diferentes tipos de pedidos y volver al menú principal.
     */
    private void menuMostrarPedido(){
        char opcion;
        boolean volver = false;
        do {
            System.out.println("\n1. Mostrar pedidos 'Pendientes'");
            System.out.println("2. Mostrar pedidos 'Enviados'");
            System.out.println("3. Listar Pedido por ID");
            System.out.println("0. Volver al menú principal");
            opcion = opcionMenu();

            try {
                switch (opcion) {
                    case '1':
                        mostrarPedidoPen();
                        break;
                    case '2':
                        mostrarPedidoEnv();
                        break;
                    case '3':
                        mostrarPedido();
                        break;
                    case '0':
                        volver = true;
                        break;
                    default:
                        throw new OpcionInvalida();
                }
            } catch (OpcionInvalida e){
                System.out.println("Error: " + e.getMessage());
            }
        } while (!volver);
    }

    /**
     * Lee la información necesaria para agregar un nuevo pedido.
     * Solicita los datos del pedido, verifica si el ID del pedido ya existe y maneja la excepción ElementoExistente.
     * Luego, agrega el pedido a la base de datos.
     */
    private void leerInfoPedido(){

       try {
            System.out.println("- Inserta el ID del pedido: ");
            String id = input.next();
            input.nextLine(); // Consumir la nueva línea pendiente

            if (controlador.pedidoExiste(id)){
                throw new ElementoExistente();
            }
            System.out.println("- Inserta el nif del cliente: ");
            String nifCliente = input.nextLine();

            System.out.println("- Inserta el codigo del artículo: ");
            String articulo = input.nextLine();

            System.out.println("- Inserta la cantidad: ");
            int cantidad = input.nextInt();
            input.nextLine(); // Consumir la nueva línea pendiente

            LocalDateTime fechaActual = LocalDateTime.now();
            //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            System.out.print("- Inserta el estado del pedido (PENDIENTE/ENVIADO): ");
            String estadoPedido = menuEstadoPedido();

            controlador.agregarPedido(id, nifCliente, articulo,  cantidad, Date.from(fechaActual.toInstant(ZoneOffset.UTC)), estadoPedido);

        } catch (ElementoExistente e){
            System.out.println(e.getMessage());
       } catch (DAOException | SQLException e) {
           System.out.println(e.getMessage());
            System.out.println("Error insertando Pedido");
        } catch (CliArtNoExisteException e) {
            System.out.println("Error:" + e.getMessage());
       }
    }

    /**
     * Elimina un pedido identificado por su ID.
     * Solicita el ID del pedido al usuario y elimina el pedido si es posible.
     * Muestra un mensaje de éxito o error según el resultado.
     */
    private void eliminarPedido(){
        System.out.println("- Inserta el ID del pedido: ");
        String id = input.nextLine();
        try{
            controlador.borrarPedido(id);
            System.out.println("Pedido eliminado con éxito");
        }
        catch (DAOException | SQLException e) {
            System.out.println("No se ha podido eliminar el pedido, porque ya ha sido enviado");
        }
    }

    /**
     * Muestra la información de un pedido identificado por su ID.
     * Solicita el ID del pedido al usuario y muestra los detalles del pedido si se encuentra en la base de datos.
     */
    private void mostrarPedido(){
        System.out.println("- Inserta el ID del pedido: ");
        String id = input.next();

        try {
            String pedido = controlador.mostrarPedido(id);

            if (pedido != null) {
                String ped = pedido.toString();
                System.out.println(ped);
            }else {
                throw new ElementoNoExistente();
            }
        } catch (ElementoNoExistente e){
            System.out.println("Error: " + e.getMessage());
        } catch (DAOException | SQLException e) {
            System.out.println("El pedido no exite o ha habido un error mostrando Pedido por ID");
        }
    }

    /**
     * Muestra la información de los pedidos con estado "PENDIENTE".
     * Obtiene y muestra los detalles de los pedidos pendientes.
     */
    private void mostrarPedidoPen()  {
        String pedido = null;
        try {
            pedido = controlador.mostrarPedidoPend();
        } catch (DAOException | SQLException e) {
            System.out.println("Error mostrando Pedidos Pendientes");
        }

        if (pedido != null){
            String info = pedido.toString();
            System.out.println(info);
        }
    }

    /**
     * Muestra la información de los pedidos con estado "ENVIADO".
     * Obtiene y muestra los detalles de los pedidos enviados.
     */
    private void mostrarPedidoEnv(){
        String pedido = null;
        try {
            pedido = controlador.mostrarPedidoEnvi();
        } catch (DAOException | SQLException e) {
            System.out.println("Error mostrando Pedidos Enviados");
        }

        if (pedido != null){
            String info = pedido.toString();
            System.out.println(info);
        }
    }

}

