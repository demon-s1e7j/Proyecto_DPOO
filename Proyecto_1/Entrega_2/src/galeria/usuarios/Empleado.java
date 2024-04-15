package galeria.usuarios;

public abstract class Empleado {
    protected String idEmpleado;
    protected String nombre;
    protected String username;
    protected String passwordHash;
    protected String role;  

    public Empleado(String idEmpleado, String nombre, String username, String passwordHash, String role) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.username = username;
        this.passwordHash = passwordHash;
        this.role = role;  
    }

   
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

   
    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
public abstract void realizarAccionesEspecificas();
    
    public void realizarTareaGeneral() {
        System.out.println(this.nombre + " está realizando una tarea general.");
    }

  
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
