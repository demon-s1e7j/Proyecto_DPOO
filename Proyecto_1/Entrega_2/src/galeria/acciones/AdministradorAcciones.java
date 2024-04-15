package galeria.acciones;

import galeria.sesion.ManejoSesion;
import galeria.usuarios.Administrador;
import galeria.usuarios.UserManager;
import galeria.usuarios.Empleado;

public class AdministradorAcciones extends EmpleadoAcciones {

    public static void manageUsers() {
        Empleado currentEmployee = ManejoSesion.getCurrentEmployee();
        if (currentEmployee instanceof Administrador) {
            System.out.println("Administrando usuarios...");
       
            try {
         
                String username = "newAdmin";
                String password = "newPassword";
                String role = "Administrador"; 

             
                Administrador newAdmin = new Administrador(username, "Nuevo Admin", username, password, role);
                UserManager.registerUser(username, newAdmin);
                UserManager.deleteUser("oldUser");
                UserManager.updateUserRole("existingUser", "Administrador");

                System.out.println("Operaciones de usuario completadas.");
            } catch (Exception e) {
                System.out.println("Error al gestionar usuarios: " + e.getMessage());
            }
        } else {
            System.out.println("Acceso denegado. Solo los administradores pueden gestionar usuarios.");
        }
    }

    public static void adjustSystemSettings() {
        Empleado currentEmployee = ManejoSesion.getCurrentEmployee();
        if (currentEmployee instanceof Administrador) {
            System.out.println("Ajustando configuraciones del sistema...");
     
        } else {
            System.out.println("Acceso denegado. Solo los administradores pueden ajustar configuraciones.");
        }
    }
}