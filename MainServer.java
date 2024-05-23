import com.chat.Server;
import com.designPatternBuilder.*;
import com.designPatternBridge.*;
import com.designPatternState.*;

import java.io.IOException;

public class MainServer {
    public static void main(String[] args) throws IOException {
        Server server = new Server();

        server.runConnection();
        server.openConnection();

        Director director = new Director();
        BikeBuilder builder = new BikeBuilder();
        director.buildBike(builder);

        String lectura;

        lectura = server.exchangeMessagesMod("Ingrese el tipo de bicicleta (Ruta, MTB, Gravel): ");
        builder.tipo(lectura);

        // Patrón Bridge (Estructural)
        String especial = null;

        if (lectura.equalsIgnoreCase("Ruta")) {
            String resultado = server.exchangeMessagesMod("Ingrese 1 para aero, 2 para escalada, 3 para crono: ");

            switch (resultado) {
                case "1" -> {
                    FabricaBicicletasRuta bicicletaEspecialidad = new BicicletasRutaEnsambladora(new BicicletaRutaAero());
                    especial = bicicletaEspecialidad.vender();
                }
                case "2" -> {
                    FabricaBicicletasRuta bicicletaEspecialidad = new BicicletasRutaEnsambladora(new BicicletaRutaEscalada());
                    especial = bicicletaEspecialidad.vender();
                }
                case "3" -> {
                    FabricaBicicletasRuta bicicletaEspecialidad = new BicicletasRutaEnsambladora(new BicicletaRutaCrono());
                    especial = bicicletaEspecialidad.vender();
                }
            }
        }
        builder.especialidad(especial);

        lectura = server.exchangeMessagesMod("Ingrese la marca de la bicicleta (Trek, Canyon, Giant, etc): ");
        builder.marca(lectura);

        lectura = server.exchangeMessagesMod("Ingrese el color de la bicicleta (Cualquiera): ");
        builder.color(lectura);

        // Patrón State (Comportamiento)
        Contexto contexto = new Contexto();
        EstadoPedidoRealizado estadoInicial = new EstadoPedidoRealizado();
        estadoInicial.cambiarEstado(contexto);

        // Mostrar Builder report 1
        builder.pedido(contexto.getEstado().toString());
        System.out.println();
        System.out.println(builder.build().toString().replace("¬", "\n"));

        String pedidoRealizado = server.exchangeMessagesMod(builder.build().toString());

        switch (pedidoRealizado) {
            case "1" -> {
                EstadoCompraRealizada estadoFinal = new EstadoCompraRealizada();
                estadoFinal.cambiarEstado(contexto);
                builder.pedido(contexto.getEstado().toString());
                builder.mensaje(contexto.getEstado().mensajePedido());
            }
            case "2" -> {
                EstadoPedidoRechazado estadoFinal = new EstadoPedidoRechazado();
                estadoFinal.cambiarEstado(contexto);
                builder.pedido(contexto.getEstado().toString());
                builder.mensaje(contexto.getEstado().mensajePedido());
            }
        }

        // Mostrar Builder report 2
        server.exchangeMessagesMod(builder.build().toString());
        //------------------------------------

        server.closeConnection();
    }
}
