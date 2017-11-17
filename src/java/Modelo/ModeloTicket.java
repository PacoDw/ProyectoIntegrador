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
    //METHOD CREAR TICKET
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
    public List<Ticket> getTickets()
    {
        List<Ticket> tickets = new ArrayList<Ticket>();
        
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            String sql = "call getTickets()";
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
        return tickets;
    }
    
     
//    public static void main(String[] args)
//    {
//        System.out.println("Ejecutanto proyecto");
//        
//        ModeloTicket mt = new ModeloTicket();
//        
////        List<Ticket> ti = mt.getTickets();
////        
////        for(Ticket i : mt.getTickets())
////        {
////            System.out.println(i.getId_ticket());
////            System.out.println(i.getNombre_ticket());
////            System.out.println(i.getFecha_inicio());
////            System.out.println(i.getFecha_aprox());
////            System.out.println(i.getGrupo_especialista());
////            System.out.println(i.getUsuario());
////        }
//        
//            
//        
////        
////
////        include.Ticket t = new include.Ticket("Prueba 1", "Esta es una prueba",
////        "Abierto", "Sin solucion todavia", "2017-11-16 16:54:59", "2017-11-18 12:00:00",
////        null, "Aun no se a ido a recoger", "1", "1");
////        
////        
////
////        if (mt.crearTicket(t))
////        {
////            System.out.println("Se creo el ticket");
////        }
////        else
////        {
////            System.out.println("No se creo el ticket");
////        }
//    }
}
