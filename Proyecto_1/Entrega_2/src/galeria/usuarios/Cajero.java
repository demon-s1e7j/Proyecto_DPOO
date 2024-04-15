package galeria.usuarios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cajero extends Empleado {
    private List<String> transacciones = new ArrayList<>();

    public Cajero(String idEmpleado, String nombre, String username, String passwordHash, String role) {
        super(idEmpleado, nombre, username, passwordHash, role);
    }

    @Override
    public void realizarAccionesEspecificas() {
        System.out.println(this.nombre + " está procesando pagos y gestionando transacciones financieras.");
        procesarTransacciones();
        emitirRecibos();
    }

    public void procesarTransacciones() {
     
        transacciones.add("Transacción " + System.currentTimeMillis());
        System.out.println("Procesamiento de pagos y emisión de facturas en curso.");
        System.out.println("Transacciones completadas exitosamente.");
    }

    public void emitirRecibos() {
        System.out.println("Emitiendo recibos para las transacciones...");
        
        transacciones.forEach(transaccion -> {
            try (FileWriter writer = new FileWriter("Recibo_" + transaccion.hashCode() + ".txt")) {
                writer.write("Recibo de la " + transaccion);
                System.out.println("Recibo emitido para: " + transaccion);
            } catch (IOException e) {
                System.out.println("Error al emitir recibo para: " + transaccion);
            }
        });
      
        transacciones.clear();
    }
}