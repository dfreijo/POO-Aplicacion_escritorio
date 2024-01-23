package modelo;
/*
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ListaPedidoTest {

    TipoCliente premium = TipoCliente.PREMIUM;
    EstadoPedido enviado = EstadoPedido.ENVIADO;
    Premium clientePremium = new Premium("Andrés Romero", "Zaragoza 1", "2222", "andres@mail.com", premium, 0.4f, 10.99f);
    Articulo articulo = new Articulo("1", "Sistema refrigeración", 89.50f, 7.99f, 24);
    ListaPedido listaPedido = new ListaPedido();

    @Test
    void getPedidos() {
        listaPedido.agregarPedido(1, 3,clientePremium, articulo, "28/10/2023 06:05:15", enviado);
        String resultado = listaPedido.getPedidos(1);
        String esperado = "Pedido{\n" +
                "id= " + "1" +
                ", fecha= " + "28/10/2023 06:05:15" + "\n" +
                ", cliente= " + "Andrés Romero" + ", nif: " + "2222" + "\n" +
                ", articulo= id: " + "1" + " descripción: " + "Sistema refrigeración" + " precio unidad: " + "89.5" + " €\n" +
                ", cantidad= " + "3" +
                ", coste envío= " + "4.7939997" + " €\n" +
                ", precio total= " + "273.294" + " €\n" +
                ", estado= "  + "ENVIADO" +
                " }\n" + "======================================================================================================================\n";
        Assertions.assertEquals(esperado,resultado);
    }

    @Test
    void compruebaExistenciaPedido() {
        listaPedido.agregarPedido(1, 3,clientePremium, articulo, "28/10/2023 06:05:15", enviado);
        boolean resultado = listaPedido.compruebaExistenciaPedido(1);
        boolean esperado = true;
        Assertions.assertEquals(esperado,resultado);
    }
}*/