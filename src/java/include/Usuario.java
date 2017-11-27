package include;

/**
 * @author PacoDw
 */
public class Usuario
{
    //--------------------------------------------------------------------------
    //ATRIBUTES
    private String id_usuario;
    private String nombres;
    private String apellidos;
    private String username;
    private String password;
    private String email;
    private String telefono;
    private String domicilio;
    private String ultimaSesion;
    private String rol;
    private String grupoEspecialidad;
    private String especialidad;
    private String num_tickets;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Usuario(String nombres, String apellidos,String username, 
    String password, String email, String telefono, String domicilio, 
    String ultimaSesion, String rol, String grupoEspecialidad, 
    String especialidad)
    {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.ultimaSesion = ultimaSesion;
        this.rol = rol;
        this.grupoEspecialidad = grupoEspecialidad;
        this.especialidad = especialidad;   
    }
    
    //--------------------------------------------------------------------------
    //CONSTRUCTOR PARA EL LOGIN
    public Usuario(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public Usuario(){
    }

    //--------------------------------------------------------------------------
    //METHOD GET AND SET
    
    /**
     * @return the id_usuario
     */
    public String getId_usuario()
    {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario)
    {
        this.id_usuario = id_usuario;
    }
    
    /**
     * @return the nombres
     */
    public String getNombres()
    {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres)
    {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos()
    {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the telefono
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @return the domicilio
     */
    public String getDomicilio()
    {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio)
    {
        this.domicilio = domicilio;
    }

    /**
     * @return the ultimaSesion
     */
    public String getUltimaSesion()
    {
        return ultimaSesion;
    }

    /**
     * @param ultimaSesion the ultimaSesion to set
     */
    public void setUltimaSesion(String ultimaSesion)
    {
        this.ultimaSesion = ultimaSesion;
    }

    /**
     * @return the rol
     */
    public String getRol()
    {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol)
    {
        this.rol = rol;
    }

    /**
     * @return the grupoEspecialidad
     */
    public String getGrupoEspecialidad()
    {
        return grupoEspecialidad;
    }

    /**
     * @param grupoEspecialidad the grupoEspecialidad to set
     */
    public void setGrupoEspecialidad(String grupoEspecialidad)
    {
        this.grupoEspecialidad = grupoEspecialidad;
    }

    /**
     * @return the especialidad
     */
    public String getEspecialidad()
    {
        return especialidad;
    }

    /**
     * @param especialidad the especialidad to set
     */
    public void setEspecialidad(String especialidad)
    {
        this.especialidad = especialidad;
    }
    
     /**
     * @return the num_tickets
     */
    public String getNum_tickets()
    {
        return num_tickets;
    }

    /**
     * @param num_tickets the num_tickets to set
     */
    public void setNum_tickets(String num_tickets)
    {
        this.num_tickets = num_tickets;
    }
}
