package include;

/**
 *
 * @author PacoDw
 */
public class GrupoEspecialista
{
    //--------------------------------------------------------------------------
    //ATRIBUTES
    private String id_grupo_especialista;
    private String nombre_grupo;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public GrupoEspecialista(){}
    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public GrupoEspecialista(String id_grupo_especialista, String nombre_grupo)
    {
        this.id_grupo_especialista = id_grupo_especialista;
        this.nombre_grupo = nombre_grupo;
    }
    
    //--------------------------------------------------------------------------
    //GET AND SETTERS
    /**
     * @return the id_grupo_especialista
     */
    public String getId_grupo_especialista()
    {
        return id_grupo_especialista;
    }

    /**
     * @param id_grupo_especialista the id_grupo_especialista to set
     */
    public void setId_grupo_especialista(String id_grupo_especialista)
    {
        this.id_grupo_especialista = id_grupo_especialista;
    }

    /**
     * @return the nombre_grupo
     */
    public String getNombre_grupo()
    {
        return nombre_grupo;
    }

    /**
     * @param nombre_grupo the nombre_grupo to set
     */
    public void setNombre_grupo(String nombre_grupo)
    {
        this.nombre_grupo = nombre_grupo;
    }
}
