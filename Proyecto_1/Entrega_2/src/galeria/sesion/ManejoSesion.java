package galeria.sesion;

import galeria.usuarios.Empleado;
import galeria.usuarios.FileUtils;
import galeria.usuarios.CompradorPropietario;
import galeria.usuarios.UserManager;

public class ManejoSesion {
    private static Empleado currentEmployee;
    private static CompradorPropietario currentCompradorPropietario;

    public static void loginEmpleado(String username, String password) {
        if (FileUtils.verifyUser(username, password)) {
            currentEmployee = UserManager.getEmpleado(username);
            if (currentEmployee != null) {
                System.out.println("Empleado " + username + " ha iniciado sesión exitosamente.");
            } else {
                System.out.println("Error: No se encontró el empleado.");
            }
        } else {
            System.out.println("Error de autenticación.");
        }
    }

    public static void loginCompradorPropietario(String username, String password) {
        if (FileUtils.verifyUser(username, password)) {
            currentCompradorPropietario = UserManager.getCompradorPropietario(username);
            if (currentCompradorPropietario != null) {
                System.out.println("Comprador/Propietario " + username + " ha iniciado sesión exitosamente.");
            } else {
                System.out.println("Error: No se encontró el comprador/propietario.");
            }
        } else {
            System.out.println("Error de autenticación.");
        }
    }

    public static Empleado getCurrentEmployee() {
        return currentEmployee;
    }

    public static CompradorPropietario getCurrentCompradorPropietario() {
        return currentCompradorPropietario;
    }

    public static void logout() {
        if (currentEmployee != null) {
            System.out.println("Empleado " + currentEmployee.getUsername() + " ha cerrado sesión.");
            currentEmployee = null;
        } else if (currentCompradorPropietario != null) {
            System.out.println("Comprador/Propietario " + currentCompradorPropietario.getUsername() + " ha cerrado sesión.");
            currentCompradorPropietario = null;
        } else {
            System.out.println("No hay ningún usuario logueado actualmente.");
        }
    }
}
