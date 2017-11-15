package Modelo;

import java.sql.*;

/*
 * @author PacoDw
 */
public class Conexion
{
    //--------------------------------------------------------------------------
    //PROPERTIES
    private String username     = "root";
    private String pass         = "koko478569";
    private String url          = "jdbc:mysql://localhost:3306/proyecto_integrador";

    private Connection con;

    //--------------------------------------------------------------------------
    //CONSTRUCTOR
    public Conexion()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, pass);
        }
        catch (ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
        }
        catch (SQLException esql)
        {
            System.err.println(esql.getMessage());
        }
    }
    
    //--------------------------------------------------------------------------
    //GET CONNECTION
    public Connection getConnection()
    {
        return con;
    }
}