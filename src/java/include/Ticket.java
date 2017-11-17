package include;

/**
 *
 * @author PacoDw
 */
public class Ticket
{
    //--------------------------------------------------------------------------
    //ATRIBUTES
    private String id_ticket;
    private String nombre_ticket;
    private String descripcion;
    private String estado;
    private String solucion;
    private String fecha_inicio;
    private String fecha_aprox;
    private String fecha_cierre;
    private String comentarios;
    private String grupo_especialista;
    private String usuario;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Ticket(){}
    public Ticket(  String nombre_ticket, String descripcion, String estado, 
                    String solucion, String fecha_inicio, String fecha_aprox,
                    String fecha_cierre, String comentarios, String grupo_especialista,
                    String usuario
                 )
    {
        this.id_ticket = "";
        this.nombre_ticket = nombre_ticket; 
        this.descripcion = descripcion; 
        this.estado = estado; 
        this.solucion = solucion; 
        this.fecha_inicio = fecha_inicio; 
        this.fecha_aprox = fecha_aprox; 
        this.fecha_cierre = fecha_cierre; 
        this.comentarios = comentarios; 
        this.grupo_especialista = grupo_especialista; 
        this.usuario = usuario; 
    }
    
    //--------------------------------------------------------------------------
    //METHOD GET AND SET
    
     /**
     * @return the id_ticket
     */
    public String getId_ticket()
    {
        return id_ticket;
    }

    /**
     * @param id_ticket the id_ticket to set
     */
    public void setId_ticket(String id_ticket)
    {
        this.id_ticket = id_ticket;
    }
    
    /**
     * @return the nombre_ticket
     */
    public String getNombre_ticket()
    {
        return nombre_ticket;
    }

    /**
     * @param nombre_ticket the nombre_ticket to set
     */
    public void setNombre_ticket(String nombre_ticket)
    {
        this.nombre_ticket = nombre_ticket;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * @return the estado
     */
    public String getEstado()
    {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado)
    {
        this.estado = estado;
    }

    /**
     * @return the solucion
     */
    public String getSolucion()
    {
        return solucion;
    }

    /**
     * @param solucion the solucion to set
     */
    public void setSolucion(String solucion)
    {
        this.solucion = solucion;
    }

    /**
     * @return the fecha_inicio
     */
    public String getFecha_inicio()
    {
        return fecha_inicio;
    }

    /**
     * @param fecha_inicio the fecha_inicio to set
     */
    public void setFecha_inicio(String fecha_inicio)
    {
        this.fecha_inicio = fecha_inicio;
    }

    /**
     * @return the fecha_aprox
     */
    public String getFecha_aprox()
    {
        return fecha_aprox;
    }

    /**
     * @param fecha_aprox the fecha_aprox to set
     */
    public void setFecha_aprox(String fecha_aprox)
    {
        this.fecha_aprox = fecha_aprox;
    }

    /**
     * @return the fecha_cierre
     */
    public String getFecha_cierre()
    {
        return fecha_cierre;
    }

    /**
     * @param fecha_cierre the fecha_cierre to set
     */
    public void setFecha_cierre(String fecha_cierre)
    {
        this.fecha_cierre = fecha_cierre;
    }

    /**
     * @return the comentarios
     */
    public String getComentarios()
    {
        return comentarios;
    }

    /**
     * @param comentarios the comentarios to set
     */
    public void setComentarios(String comentarios)
    {
        this.comentarios = comentarios;
    }

    /**
     * @return the grupo_especialista
     */
    public String getGrupo_especialista()
    {
        return grupo_especialista;
    }

    /**
     * @param grupo_especialista the grupo_especialista to set
     */
    public void setGrupo_especialista(String grupo_especialista)
    {
        this.grupo_especialista = grupo_especialista;
    }

    /**
     * @return the usuario
     */
    public String getUsuario()
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
}
