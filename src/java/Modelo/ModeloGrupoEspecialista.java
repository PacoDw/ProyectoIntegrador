package Modelo;

import include.GrupoEspecialista;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PacoDw
 */
public class ModeloGrupoEspecialista extends Conexion
{
    //--------------------------------------------------------------------------
    //METHOD GET ALL GROUPS
    public List<GrupoEspecialista> getALLGrupos()
    {
        List<GrupoEspecialista> grupos = new ArrayList<GrupoEspecialista>();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "call getALLGrupos()";
            pst = getConnection().prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                GrupoEspecialista ge = new GrupoEspecialista();
                ge.setId_grupo_especialista(rs.getString(1));
                ge.setNombre_grupo(rs.getString(2));
                grupos.add(ge);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (getConnection() != null)
                {
                    getConnection().close();
                }

                if (pst != null)
                {
                    pst.close();
                }
                if(rs != null)
                    rs.close();
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        return grupos;
    }
}
