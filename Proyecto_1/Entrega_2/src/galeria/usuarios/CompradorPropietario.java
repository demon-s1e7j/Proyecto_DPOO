package galeria.usuarios;

import galeria.pieza.Pieza;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CompradorPropietario {
    protected String idUsuario;
    protected String nombre;
    protected String username;
    protected String informacionContacto;
    protected List<Pieza> piezas;
    protected Set<Pieza> piezasFavoritas;
    protected double limiteCompra;
    protected boolean estaVerificado;

    
    public CompradorPropietario(String idUsuario, String nombre, String username,
                                String informacionContacto, double limiteCompra,
                                boolean estaVerificado, List<Pieza> piezas, Set<Pieza> piezasFavoritas) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.username = username;
        this.informacionContacto = informacionContacto;
        this.limiteCompra = limiteCompra;
        this.estaVerificado = estaVerificado;
        this.piezas = piezas != null ? new ArrayList<>(piezas) : new ArrayList<>();
        this.piezasFavoritas = piezasFavoritas != null ? new HashSet<>(piezasFavoritas) : new HashSet<>();
    }


    public CompradorPropietario(String idUsuario, String nombre, String username,
                                String informacionContacto, double limiteCompra,
                                boolean estaVerificado) {
        this(idUsuario, nombre, username, informacionContacto, limiteCompra,
             estaVerificado, null, null);
    }


    public CompradorPropietario(String idUsuario) {
        this(idUsuario, "Default Name", "Default Username", "Default Contact", 0.0, false, new ArrayList<>(), new HashSet<>());
    }


    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsername() {
        return username;
    }

    public String getInformacionContacto() {
        return informacionContacto;
    }

    public double getLimiteCompra() {
        return limiteCompra;
    }

    public boolean isEstaVerificado() {
        return estaVerificado;
    }

    public List<Pieza> getPiezas() {
        return new ArrayList<>(piezas);
    }


    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setInformacionContacto(String informacionContacto) {
        this.informacionContacto = informacionContacto;
    }

    public void setLimiteCompra(double limiteCompra) {
        this.limiteCompra = limiteCompra;
    }

    public void setEstaVerificado(boolean estaVerificado) {
        this.estaVerificado = estaVerificado;
    }


    public void addPieza(Pieza pieza) {
        if (!estaVerificado) {
            System.out.println("Operación denegada: El usuario no está verificado.");
            return;
        }
        
        this.piezas.add(pieza);
        System.out.println("Pieza añadida: " + pieza.getTitulo());
    }

    public void removePieza(Pieza pieza) {
        if (piezas.remove(pieza)) {
            System.out.println("Pieza removida: " + pieza.getTitulo());
        } else {
            System.out.println("Pieza no encontrada en la colección.");
        }
    }

    public void toggleFavorite(Pieza pieza) {
        if (piezasFavoritas.contains(pieza)) {
            piezasFavoritas.remove(pieza);
            System.out.println("Pieza removida de favoritos: " + pieza.getTitulo());
        } else {
            piezasFavoritas.add(pieza);
            System.out.println("Pieza añadida a favoritos: " + pieza.getTitulo());
        }
    }


    public void mostrarPiezas() {
        if (piezas.isEmpty()) {
            System.out.println("No tienes ninguna pieza.");
        } else {
            System.out.println("Listado de piezas:");
            for (Pieza pieza : piezas) {
                System.out.println(pieza.getTitulo() + " - " + pieza.getDescripcion());
            }
        }
    }

    public void mostrarFavoritos() {
        if (piezasFavoritas.isEmpty()) {
            System.out.println("No tienes piezas favoritas.");
        } else {
            System.out.println("Piezas favoritas:");
            for (Pieza pieza : piezasFavoritas) {
                System.out.println(pieza.getTitulo() + " - " + pieza.getDescripcion());
            }
        }
    }
}