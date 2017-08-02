/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patron_de_diseño_DAO;

import conexionBD.DbConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GrupoDAO {
    
    
    private ArrayList<GrupoVO> arraGrupo;

    private DbConnection conex;
    private Statement st;
    private ResultSet rs;
    
    public GrupoDAO() {
     this.arraGrupo = new ArrayList<GrupoVO>();
        
        conex = new DbConnection();
        st = null;
        rs = null;        
    }
    //++++++++++++++++++++++++++++++++++++++++++CONSULTAR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public GrupoVO consultarGrupoXid(String id_grupo) {
        GrupoVO grupo = new GrupoVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.grupo where id_grupo = ****;".replace("****", id_grupo));
            while (rs.next()) {
                for (int i = 1; i <= grupo.nElementos; i++) {
                    grupo.ingresaDato(rs.getString(i), i);
                }
                //grupo.setNumTel(rs.getString("numtelemerg"));
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return grupo;
    }
//*******************************************************************************************************************

    public ArrayList<GrupoVO> ListarGrupos() {
        GrupoVO grupo = new GrupoVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.grupo  order by id_grupo;");
            while (rs.next()) {
                GrupoVO a = new GrupoVO();
                for (int i = 1; i <= grupo.nElementos; i++) {
                    a.ingresaDato(rs.getString(i), i);
                }
                arraGrupo.add(a); //grupo.limpiarDatos();
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return arraGrupo;
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++++++INSERCION++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void agrega_Nuevo_Grupo(GrupoVO a) {
        String t= a.getTitulos();
        String inserta = "insert into sii.grupo("+t+") \n"
                + "values (****);".replace("****", a.tostring());
        System.out.println(inserta);
        try {
            st = conex.getConnection().createStatement();
            st.execute(inserta);               
            conex.desconectar();
        } catch (Exception e) {
        }

    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++ACTUALIZACIONES++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void actualizar_Grupo(GrupoVO a) {

        String[] ara = a.tostring().split(",");
        String[] atrib = a.getTitulos().split(",");
        String actualiza = "update sii.grupo set %%%% = &&&& where id_grupo = ****; ".replace("****", ara[0]);

        //int id_grupo= Integer.parseInt(ara[0]);
        try {
            for (int i = 1; i < ara.length; i++) {
                conex.getConnection().createStatement().execute(actualiza.replace("%%%%", atrib[i]).replace("&&&&", ara[i]));
            }
            conex.desconectar();
        } catch (Exception e) {
        }

    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++ELIMINAR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    public void eliminar_GrupoXId(String id_grupo) {
        String elimina = "DELETE FROM sii.grupo WHERE id_grupo = ****;".replace("****", id_grupo);
        System.out.println(elimina);
        try {
            conex.getConnection().createStatement().execute(elimina);
            conex.desconectar();
        } catch (Exception e) {
        }
    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    

}
