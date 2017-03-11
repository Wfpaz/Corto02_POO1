/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.controlador;

import com.sv.udb.modelo.SeresVivos;
import com.sv.udb.recursos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Walter
 */
public class SeresVivosCtrl {
    public boolean guardar(SeresVivos Obje) {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("INSERT INTO seresvivos VALUES (NULL, ?, ?, ?)");
            cmd.setString(1, Obje.getNombreSer());
            cmd.setString(2, Obje.getDescripcionSer());
            
            if (Obje.getCodigoReferSer() !=0) cmd.setString(3, String.valueOf(Obje.getCodigoReferSer())); 
            else cmd.setString(3, null);
//            cmd.setString(3, Obje.getCodigoReferSer() !=0 ? Obje.getCodigoReferSer(): null);
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
        }
        finally {
            try {
                if (cn!=null) {
                    if (!cn.isClosed()) {
                        cn.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
    
    public List<SeresVivos> consTodo(){ 
        List<SeresVivos> resp = new ArrayList();
       Connection cn = new Conexion().getConn();
        try
        {
            PreparedStatement cmd = cn.prepareStatement("SELECT * FROM seresvivos");
            ResultSet rs = cmd.executeQuery();
            resp.add(new SeresVivos(0,0,"N/D", "N/D"));
            while(rs.next())
            {
                resp.add(new SeresVivos(rs.getInt(1),rs.getInt(4),rs.getString(2),rs.getString(3)));
                            //SeresVivos(int codigoSer, int codigoReferSer, String nombreSer, String descripcionSer)
            }
        }
        catch(Exception err)
        {
            err.printStackTrace();
        }
        finally
        {
            try
            {
                if(cn!=null)
                {
                    if(!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            }
            catch(SQLException err)
            {
                err.printStackTrace();
            }
        }
        return resp;
    }
    
    public boolean eliminar(SeresVivos obje) {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("DELETE FROM seresvivos WHERE codi_sere = ?");
            cmd.setString(1, String.valueOf(obje.getCodigoSer()));
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.err.println("Error al eliminar los datos: " + e.getMessage());
        }
        finally {
            try {
                if (cn!=null) {
                    if (!cn.isClosed()) {
                        cn.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
    
    public boolean modificar(SeresVivos obje) {
        boolean resp = false;
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("UPDATE seresvivos SET nomb_sere=?, desc_sere=?, codi_refe_sere=? WHERE codi_sere=?");
            cmd.setString(1, obje.getNombreSer());
            cmd.setString(2, obje.getDescripcionSer());
            
            if (obje.getCodigoReferSer() !=0) cmd.setString(3, String.valueOf(obje.getCodigoReferSer())); 
            else cmd.setString(3, null);
            
            cmd.setString(4, String.valueOf(obje.getCodigoSer()));
            cmd.executeUpdate();
            resp = true;
        } catch (Exception e) {
            System.err.println("Error al actualizar los datos: " + e.getMessage());
        }
        finally {
            try {
                if (cn!=null) {
                    if (!cn.isClosed()) {
                        cn.close();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return resp;
    }
    
    public SeresVivos consUno(int id){
        SeresVivos resp = new SeresVivos();
        Connection cn = new Conexion().getConn();
        try {
            PreparedStatement cmd = cn.prepareStatement("Select * from seresvivos where codi_sere=?");
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();
            while (rs.next())
            {
                resp.setCodigoSer(rs.getInt(1));
                resp.setNombreSer(rs.getString(2));
                resp.setDescripcionSer(rs.getString(3));
                resp.setCodigoReferSer(rs.getInt(4));
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
        }
        finally 
        {
            try 
            {
                if (cn!=null)
                {
                    if (!cn.isClosed())
                    {
                        cn.close();
                    }
                }
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
        return resp;
    }
}
