package Modelo;

import include.Encriptar;
import include.GrupoEspecialista;
import include.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PacoDw
 */
public class ModeloUsuario extends Conexion
{

    //--------------------------------------------------------------------------
    //METHOD CREAR USUARIO
    public boolean crearUsuario(Usuario u)
    {
        boolean flat = false;
        PreparedStatement pst = null;

        try
        {
            String sql = "call nuevoUsuario(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);

            pst.setString(1, u.getNombres());
            pst.setString(2, u.getApellidos());
            pst.setString(3, u.getUsername());
            pst.setString(4, Encriptar.sha1(u.getPassword()));
            pst.setString(5, u.getEmail());
            pst.setString(6, u.getTelefono());
            pst.setString(7, u.getDomicilio());
            pst.setString(8, u.getUltimaSesion());
            pst.setString(9, u.getRol());
            pst.setString(10, u.getGrupoEspecialidad());
            pst.setString(11, u.getEspecialidad());

            if (pst.executeUpdate() == 1)
            {
                flat = true;
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
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
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        return flat;
    }

    //--------------------------------------------------------------------------
    //METHOD AUTENTICAR USUARIO POR LOGIN
    public boolean autenticarLogin(Usuario u)
    {
        boolean flag = false;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try
        {
            String sql = "call autenticarLogin(?,?)";
            pst = getConnection().prepareStatement(sql);

            pst.setString(1, u.getUsername());
            pst.setString(2, u.getPassword()); //Falta encryptar

            rs = pst.executeQuery();

            if (rs.absolute(1))
            {
                flag = true;
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                if (pst != null)
                {
                    pst.close();
                }

                if (getConnection() != null)
                {
                    getConnection().close();
                }

                if (rs != null)
                {
                    rs.close();
                }
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        return flag;
    }
    
    //--------------------------------------------------------------------------
    //METHOD GET USUARIOS GRUPOS
    public List<Usuario> getUsuariosGrupos(int id)
    {
       List<Usuario> usuarios = new ArrayList<Usuario>();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "call getUsuariosGrupos(?)";
            pst = getConnection().prepareStatement(sql);
            
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId_usuario(rs.getString(1));
                u.setNombres(rs.getString(2));
                u.setGrupoEspecialidad(rs.getString(3));
                usuarios.add(u);
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
        return usuarios;
    }

//    public static void main(String[] args)
//    {
//
//        System.out.println("Ejecutanto proyecto");
//
//        Usuario user = new Usuario("PacoDw", "koo");
//        ModeloUsuario mu = new ModeloUsuario();
//
//        if (mu.autenticarLogin(user))
//        {
//            System.out.println("Es correcto el login");
//        }
//        else
//        {
//            System.out.println("Es incorrecto el login");
//        }
//
//    }
}
