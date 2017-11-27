/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloTicket;
import include.Ticket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PacoD
 */
public class ControladorTicket
{
    //--------------------------------------------------------------------------
    //METHOD CREAR TICKET
    public boolean crearTicket(Ticket t)
    {
        ModeloTicket mt = new ModeloTicket();
        
         return mt.crearTicket(t);
    }
    
    //--------------------------------------------------------------------------
    //METHOD GET TICKETS
    public List<Ticket> getAllTickets()
    {
        ModeloTicket mt = new ModeloTicket();
        
        return mt.getAllTickets();
    }
    
    //--------------------------------------------------------------------------
    //METHOD GET USER TICKETS
    public List<Ticket> getTicketsUsuario(String username)
    {
        ModeloTicket mt = new ModeloTicket();
        
        return mt.getTicketsUsuario(username);
    }
    
    //--------------------------------------------------------------------------
    //METHOD DELETE TICKETS
    public boolean deleteTicket(int id)
    {
        ModeloTicket mt = new ModeloTicket();
        
        return mt.deleteTickets(id);
    }
    
    //--------------------------------------------------------------------------
    //METHOD UPDATE TICKETS
     public boolean updateTicket(Ticket t)
    {
        ModeloTicket mt = new ModeloTicket();
        
        return mt.updateTickets(t);
    }
     
     //--------------------------------------------------------------------------
    //FIND TO LAS TICKET
    public Ticket getLastTicket()
    {
        ModeloTicket mt = new ModeloTicket();

        return mt.getLastTicket();
    }
    
    //--------------------------------------------------------------------------
    //GET A TICKET
    public Ticket getATicket(int id)
    {
        ModeloTicket mt = new ModeloTicket();

        return mt.getATicket(id);
    }
}
