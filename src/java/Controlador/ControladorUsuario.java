package Controlador;
import Modelo.ModeloUsuario;
import include.Usuario;
import java.util.List;

/*
 * @author PacoDw
 */
public class ControladorUsuario
{
    //--------------------------------------------------------------------------
    //METHOD CREAR USUARIO
    public boolean nuevoUsuario(Usuario u)
    {
        ModeloUsuario mu = new ModeloUsuario();
        
         return mu.crearUsuario(u);
    }
    
    //--------------------------------------------------------------------------
    //METHOD AUTENTICAR USUARIO POR LOGIN
    public boolean autenticarLogin(Usuario u)
    {
        ModeloUsuario mu = new ModeloUsuario();

        return mu.autenticarLogin(u);
    }
    
    //--------------------------------------------------------------------------
    //METHOD GET USUARIOS GRUPOS
    public List<Usuario> getUsuariosGrupos(int id)
    {
        ModeloUsuario mu = new ModeloUsuario();

        return mu.getUsuariosGrupos(id);
    }
}
