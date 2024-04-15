package galeria.acciones;

import galeria.sesion.ManejoSesion;
import galeria.usuarios.Cajero;
import galeria.usuarios.Empleado;

public class CajeroAcciones extends EmpleadoAcciones {

    public static void processPayments() {
        Empleado currentEmployee = ManejoSesion.getCurrentEmployee();
        if (currentEmployee instanceof Cajero) {
            System.out.println("Procesando pagos...");
   
            ((Cajero) currentEmployee).procesarTransacciones();
            System.out.println("Pagos procesados correctamente.");
        } else {
            System.out.println("Acceso denegado. Solo los cajeros pueden procesar pagos.");
        }
    }

    public static void issueReceipts() {
        Empleado currentEmployee = ManejoSesion.getCurrentEmployee();
        if (currentEmployee instanceof Cajero) {
            System.out.println("Emitiendo recibos...");
    
            ((Cajero) currentEmployee).emitirRecibos();
            System.out.println("Recibos emitidos correctamente.");
        } else {
            System.out.println("Acceso denegado. Solo los cajeros pueden emitir recibos.");
        }
    }
}