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

public class BoletaDAO {

    private ArrayList<BoletaVO> arraBoleta;

    private DbConnection conex;
    private Statement st;
    private ResultSet rs;

    public BoletaDAO() {
        this.arraBoleta = new ArrayList<BoletaVO>();

        conex = new DbConnection();
        st = null;
        rs = null;
    }

//++++++++++++++++++++++++++++++++++++++++++CONSULTAR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public BoletaVO consultarBoletaXid(String id_boleta) {
        BoletaVO boleta = new BoletaVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.boleta where id_boleta = ****;".replace("****", id_boleta));
            while (rs.next()) {
                for (int i = 1; i <= boleta.nElementos; i++) {
                    boleta.ingresaDato(rs.getString(i), i);
                }
                //boleta.setNumTel(rs.getString("numtelemerg"));
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return boleta;
    }
//*******************************************************************************************************************

    public ArrayList<BoletaVO> ListarBoletaXOcupacion(String ocupacion) {
        BoletaVO boleta = new BoletaVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.boleta where ocupacion ilike '%****%' order by id_boleta;".replace("****", ocupacion));
            while (rs.next()) {
                BoletaVO a = new BoletaVO();
                for (int i = 1; i <= boleta.nElementos; i++) {
                    a.ingresaDato(rs.getString(i), i);
                }
                arraBoleta.add(a); //boleta.limpiarDatos();
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return arraBoleta;
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++++++INSERCION++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void agrega_Nuevo_Boleta(BoletaVO a) {
        String t= a.getTitulos();
        String inserta = "insert into sii.boleta("+t+") \n"
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
    public void actualizar_Boleta(BoletaVO a) {

        String[] ara = a.tostring().split(",");
        String[] atrib = a.getTitulos().split(",");
        String actualiza = "update sii.boleta set %%%% = &&&& where id_boleta = ****; ".replace("****", ara[0]);

        //int id_boleta= Integer.parseInt(ara[0]);
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
    public void eliminar_BoletaXId(String id_boleta) {
        String elimina = "DELETE FROM sii.boleta WHERE id_boleta = ****;".replace("****", id_boleta);
        System.out.println(elimina);
        try {
            conex.getConnection().createStatement().execute(elimina);
            conex.desconectar();
        } catch (Exception e) {
        }
    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
