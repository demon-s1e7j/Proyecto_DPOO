package galeria.acciones;

import galeria.pieza.Pieza;
import galeria.sesion.ManejoSesion;
import galeria.usuarios.CompradorPropietario;

public class CompradorPropietarioAcciones {

    public static void viewMyPieces() {
        CompradorPropietario current = ManejoSesion.getCurrentCompradorPropietario();
        if (current != null) {
            System.out.println("Mostrando piezas de " + current.getNombre() + ":");
            current.mostrarPiezas();
        } else {
            System.out.println("No hay comprador/propietario logueado para mostrar piezas.");
        }
    }

    public static void purchasePiece(Pieza pieza) {
        CompradorPropietario current = ManejoSesion.getCurrentCompradorPropietario();
        if (current != null && pieza != null) {
            if (current.isEstaVerificado() && pieza.getValorFijo() <= current.getLimiteCompra()) {
                current.addPieza(pieza);
                System.out.println("Pieza comprada y añadida a la colección: " + pieza.getTitulo());
            } else {
                System.out.println("No se pudo completar la compra: verifica el límite de compra y tu estado de verificación.");
            }
        } else {
            System.out.println("Operación de compra no pudo ser completada.");
        }
    }

    public static void sellPiece(Pieza pieza) {
        CompradorPropietario current = ManejoSesion.getCurrentCompradorPropietario();
        if (current != null && pieza != null && current.getPiezas().contains(pieza)) {
     
            current.removePieza(pieza);
            System.out.println("Pieza vendida y removida de la colección: " + pieza.getTitulo());
        } else {
            System.out.println("No se pudo completar la venta: pieza no encontrada.");
        }
    }
}