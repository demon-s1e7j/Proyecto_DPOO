package consolas;

import galeria.usuarios.*;
import galeria.pieza.Pieza;
import galeria.sesion.ManejoSesion;
import galeria.acciones.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class ConsolaUsuarios {

    public static void main(String[] args) {
        try {
          
            registerNewUsers();
          
            FileUtils.loadUserCredentials(); 

           
            ManejoSesion.loginEmpleado("adminUsername", "adminPassword");
            Empleado empleadoActual = ManejoSesion.getCurrentEmployee();
            if(empleadoActual instanceof Administrador) {
                Administrador admin = (Administrador) empleadoActual;
                admin.realizarAccionesEspecificas();
            }

    
            ManejoSesion.loginEmpleado("cashierUsername", "cashierPassword");
            empleadoActual = ManejoSesion.getCurrentEmployee();
            if(empleadoActual instanceof Cajero) {
                Cajero cajero = (Cajero) empleadoActual;
                cajero.realizarAccionesEspecificas();
            }

          
            ManejoSesion.loginCompradorPropietario("buyerOwnerUsername", "buyerOwnerPassword");
            CompradorPropietario compradorPropietarioActual = ManejoSesion.getCurrentCompradorPropietario();
            if(compradorPropietarioActual != null) {
                compradorPropietarioActual.mostrarPiezas();
                Pieza pieza = crearPiezaDemo();
                compradorPropietarioActual.addPieza(pieza);
                compradorPropietarioActual.removePieza(pieza);
            }

          
            empleadoActual = ManejoSesion.getCurrentEmployee();
            if(empleadoActual instanceof Operador) {
                Operador operador = (Operador) empleadoActual;
                operador.realizarAccionesEspecificas();
            }

        
            ManejoSesion.logout();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void registerNewUsers() throws IOException {
    
        FileUtils.registerUser("adminUsername", "adminPassword", "administrador");
        Empleado admin = new Administrador("1", "Admin User", "adminUsername", "adminPassword", "administrador");
        UserManager.registerUser("adminUsername", admin);

       
        FileUtils.registerUser("cashierUsername", "cashierPassword", "cajero");
        Empleado cashier = new Cajero("2", "Cashier User", "cashierUsername", "cashierPassword", "cajero");
        UserManager.registerUser("cashierUsername", cashier);


        FileUtils.registerUser("buyerOwnerUsername", "buyerOwnerPassword", "comprador");
        CompradorPropietario buyerOwner = new CompradorPropietario("3", "Buyer Owner", "buyerOwnerUsername", "buyerOwnerPassword", 50000000, true);
        UserManager.registerCompradorPropietario("buyerOwnerUsername", buyerOwner);
    }

    private static Pieza crearPiezaDemo() {
        return new Pieza("P001", "La Gioconda", 1503, "Italia", "Bueno", true, true, Arrays.asList("Leonardo da Vinci"),
                         8000000.0, 7500000, 7000000, new Date(), true, "Una de las pinturas más reconocidas del mundo.",
                         new Propietario("Owner001", new ArrayList<>()));
    }
}