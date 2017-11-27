package Modelo;

import include.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PacoDw
 */
public class ModeloTicket extends Conexion
{   
    //--------------------------------------------------------------------------
    //METHOD CREATE TICKET
    public boolean crearTicket(Ticket t)
    {                  
        boolean flat = false;
        PreparedStatement pst = null;

        try
        {
            String sql = "call nuevoTicket(?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);

            pst.setString(1, t.getNombre_ticket());
            pst.setString(2, t.getDescripcion());
            pst.setString(3, t.getEstado());
            pst.setString(4, t.getSolucion());
            pst.setString(5, t.getFecha_inicio());
            pst.setString(6, t.getFecha_aprox());
            pst.setString(7, t.getFecha_cierre());
            pst.setString(8, t.getComentarios());
            pst.setInt(9, Integer.parseInt(t.getGrupo_especialista()));
            pst.setInt(10, Integer.parseInt(t.getUsuario()));
            
            
            
            if (pst.executeUpdate() == 1)
            {
                if(pst.executeUpdate("call updateTicketsUsuario()") > 0)
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
    //METHOD GET TICKETS
    public List<Ticket> getAllTickets()
    {
        List<Ticket> tickets = new ArrayList<Ticket>();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "call getAllTickets()";
            pst = getConnection().prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setId_ticket(rs.getString(1));
                t.setNombre_ticket(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setEstado(rs.getString(4));
                t.setSolucion(rs.getString(5));
                t.setFecha_inicio(rs.getString(6));
                t.setFecha_aprox(rs.getString(7));
                t.setFecha_cierre(rs.getString(8));
                t.setComentarios(rs.getString(9));
                t.setGrupo_especialista(rs.getString(10));
                t.setUsuario(rs.getString(11));
                tickets.add(t);
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
        return tickets;
    }
    
    //--------------------------------------------------------------------------
    //METHOD GET USER TICKETS
    public List<Ticket> getTicketsUsuario(String username)
    {
        List<Ticket> tickets = new ArrayList<Ticket>();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "call getTicketsUsuario(?)";
            pst = getConnection().prepareStatement(sql);
            
            pst.setString(1, username);
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                Ticket t = new Ticket();
                t.setId_ticket(rs.getString(1));
                t.setNombre_ticket(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setEstado(rs.getString(4));
                t.setSolucion(rs.getString(5));
                t.setFecha_inicio(rs.getString(6));
                t.setFecha_aprox(rs.getString(7));
                t.setFecha_cierre(rs.getString(8));
                t.setComentarios(rs.getString(9));
                tickets.add(t);
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
        return tickets;
    }
    
    //--------------------------------------------------------------------------
    //METHOD DELETE TICKETS
    public boolean deleteTickets(int id)
    {        
        boolean flat =  false;
        PreparedStatement pst = null;
        
        try
        {
            String sql = "call deleteTicket(?)";
            pst = getConnection().prepareStatement(sql);
            
            pst.setInt(1, id);
                        
            if (pst.executeUpdate() == 1)
            {
                if(pst.executeUpdate("call updateTicketsUsuario()") > 0)
                    flat = true;    
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
                    getConnection().close();

                if (pst != null)
                    pst.close();
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        return flat;
    }
    
    //--------------------------------------------------------------------------
    //METHOD UPDATE TICKETS
    public boolean updateTickets(Ticket t)
    {        
        PreparedStatement pst = null;
        boolean flat = false;
        
        try
        {
            String sql = "call updateTicket(?,?,?,?,?,?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            
            pst.setInt(1, Integer.parseInt(t.getId_ticket()));
            pst.setString(2, t.getNombre_ticket());
            pst.setString(3, t.getDescripcion());
            pst.setString(4, t.getEstado());
            pst.setString(5, t.getSolucion());
            pst.setString(6, t.getFecha_inicio());
            pst.setString(7, t.getFecha_aprox());
            pst.setString(8, t.getFecha_cierre());
            pst.setString(9, t.getComentarios());
            pst.setInt(10, Integer.parseInt(t.getGrupo_especialista()));
            pst.setInt(11, Integer.parseInt(t.getUsuario()));
                        
            if(pst.executeUpdate() == 1)
                flat = true;
            
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
                    getConnection().close();

                if (pst != null)
                    pst.close();
            }
            catch (Exception e)
            {
                System.err.println(e.getMessage());
            }
        }
        return flat;
    }
    
    //--------------------------------------------------------------------------
    //FIND TO LAST TICKET
    public Ticket getLastTicket()
    {   
        PreparedStatement pst = null;
        ResultSet rs = null;
        Ticket t = new Ticket();

        try
        {
            String sql = "call getLastTicket()";
            pst = getConnection().prepareStatement(sql);
                        
            rs = pst.executeQuery();
            
            while (rs.next())
            {
                t.setId_ticket(rs.getString(1));
                t.setNombre_ticket(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setEstado(rs.getString(4));
                t.setSolucion(rs.getString(5));
                t.setFecha_inicio(rs.getString(6));
                t.setFecha_aprox(rs.getString(7));
                t.setFecha_cierre(rs.getString(8));
                t.setComentarios(rs.getString(9));
                t.setGrupo_especialista(rs.getString(10));
                t.setUsuario(rs.getString(11));
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
        return t;
    }
    
    //--------------------------------------------------------------------------
    //GET A TICKET
    public Ticket getATicket(int id)
    {
        PreparedStatement pst = null;
        ResultSet rs = null;
        Ticket t = new Ticket();

        try
        {
            String sql = "call getATicket(?)";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, id);
                        
            rs = pst.executeQuery();
            
            while (rs.next())
            {
                t.setId_ticket(rs.getString(1));
                t.setNombre_ticket(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setEstado(rs.getString(4));
                t.setSolucion(rs.getString(5));
                t.setFecha_inicio(rs.getString(6));
                t.setFecha_aprox(rs.getString(7));
                t.setFecha_cierre(rs.getString(8));
                t.setComentarios(rs.getString(9));
                t.setGrupo_especialista(rs.getString(10));
                t.setUsuario(rs.getString(11));
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
        return t;
    }
    
    //TO MAKE TESTS WITH THIS FILE
    public static void main(String[] args)
    {
        System.out.println("Ejecutanto proyecto");
        
        ModeloTicket mt = new ModeloTicket();
        
        System.out.println(mt.getLastTicket());
////////        
////////        for(Ticket i : mt.getTicketsUsuario("PacoDw"))
////////        {
////////            System.out.println(i.getId_ticket());
////////            System.out.println(i.getNombre_ticket());
////////            System.out.println(i.getFecha_inicio());
////////            System.out.println(i.getFecha_aprox());
////////            System.out.println(i.getGrupo_especialista());
////////            System.out.println(i.getUsuario());
////////        }
////
////////
////////        include.Ticket t = new include.Ticket("6", "Prueba 6 CERRADO", "Esta es la prueba 6 CERRADO",
////////        "CERRADO", "Solucion CERRADO", "2017-11-17 16:54:59", "2017-11-19 12:00:00",
////////        "2017-11-19 11:59:59", "CERRADO", "1", "1");
////////
////////        if (mt.updateTickets(t))
////////        {
////////            System.out.println("Se elimino el ticket");
////////        }
////////        else
////////        {
////////            System.out.println("No se elimino el ticket");
////////        }
    } //int main
}
