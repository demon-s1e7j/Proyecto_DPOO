package galeria.acciones;

import galeria.sesion.ManejoSesion;
import galeria.usuarios.Operador;
import galeria.usuarios.Empleado;

public class OperadorAcciones extends EmpleadoAcciones {

    public static void manageOperations() {
        Empleado currentEmployee = ManejoSesion.getCurrentEmployee();
        if (currentEmployee instanceof Operador) {
            System.out.println("Gestionando operaciones diarias...");
            ((Operador)currentEmployee).coordinarEventos();  
            System.out.println("Operaciones diarias gestionadas correctamente.");
        } else {
            System.out.println("Acceso denegado. Solo los operadores pueden gestionar operaciones.");
        }
    }

    public static void manageEventScheduling() {
        Empleado currentEmployee = ManejoSesion.getCurrentEmployee();
        if (currentEmployee instanceof Operador) {
            System.out.println("Programando eventos...");
            ((Operador)currentEmployee).programarEventos();
            System.out.println("Eventos programados correctamente.");
        } else {
            System.out.println("Acceso denegado. Solo los operadores pueden programar eventos.");
        }
    }
}