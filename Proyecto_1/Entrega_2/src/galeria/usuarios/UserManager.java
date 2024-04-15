package galeria.usuarios;

import java.util.HashMap;
import java.util.Map;
import galeria.pieza.Pieza;

public class UserManager {
    private static Map<String, Empleado> empleados = new HashMap<>();
    private static Map<String, CompradorPropietario> compradoresPropietarios = new HashMap<>();

    public static void registerUser(String username, Empleado empleado) {
        empleados.put(username, empleado);
        System.out.println("Empleado registrado: " + username);
    }

    public static void deleteUser(String username) {
        if (empleados.remove(username) != null || compradoresPropietarios.remove(username) != null) {
            System.out.println("Usuario eliminado: " + username);
        } else {
            System.out.println("No se pudo encontrar el usuario para eliminar: " + username);
        }
    }

    public static void updateUserRole(String username, String newRole) {
        Empleado empleado = empleados.get(username);
        if (empleado != null) {
            empleado.setRole(newRole);
            System.out.println("Rol actualizado para " + username + ": " + newRole);
        } else {
            System.out.println("Usuario no encontrado para actualizar rol: " + username);
        }
    }

    public static void registerCompradorPropietario(String username, CompradorPropietario compradorPropietario) {
        compradoresPropietarios.put(username, compradorPropietario);
    }

    public static CompradorPropietario getCompradorPropietario(String username) {
        CompradorPropietario compradorPropietario = compradoresPropietarios.get(username);
        if (compradorPropietario == null) {
            System.out.println("Comprador/Propietario no encontrado: " + username);
        } else {
            System.out.println("Comprador/Propietario encontrado: " + username);
        }
        return compradorPropietario;
    }

    public static Empleado getEmpleado(String username) {
        Empleado empleado = empleados.get(username);
        if (empleado == null) {
            System.out.println("Empleado no encontrado: " + username);
        } else {
            System.out.println("Empleado encontrado: " + username + " - Rol: " + empleado.getRole());
        }
        return empleado;
    }

    public static void registerEmpleado(String username, Empleado empleado) {
        empleados.put(username, empleado);
    }

    public static void addPieceToCompradorPropietario(String username, Pieza pieza) {
        CompradorPropietario compradorPropietario = getCompradorPropietario(username);
        if (compradorPropietario != null) {
            compradorPropietario.addPieza(pieza);
        }
    }

    public static boolean isEmpleado(String username) {
        return empleados.containsKey(username);
    }
}