
package Controlador;

import Modelo.ModeloGrupoEspecialista;
import include.GrupoEspecialista;
import java.util.List;

/**
 *
 * @author PacoDw
 */
public class ControladorGrupoEspecialista
{
    //--------------------------------------------------------------------------
    //METHOD GET ALL GROUPS
    public List<GrupoEspecialista> getALLGrupos()
    {
        ModeloGrupoEspecialista mge = new ModeloGrupoEspecialista();
        
        return mge.getALLGrupos();
    }
}
