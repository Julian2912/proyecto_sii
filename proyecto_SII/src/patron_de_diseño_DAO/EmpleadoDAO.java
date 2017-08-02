package patron_de_diseño_DAO;

import conexionBD.DbConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EmpleadoDAO {

    private ArrayList<EmpleadoVO> arraEmpleado;

    private DbConnection conex;
    private Statement st;
    private ResultSet rs;

    public EmpleadoDAO() {
        this.arraEmpleado = new ArrayList<EmpleadoVO>();

        conex = new DbConnection();
        st = null;
        rs = null;
    }

//++++++++++++++++++++++++++++++++++++++++++CONSULTAR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public EmpleadoVO consultarEmpleadoXid(String id_empleado) {
        EmpleadoVO empleado = new EmpleadoVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.empleado where id_empleado = ****;".replace("****", id_empleado));
            while (rs.next()) {
                for (int i = 1; i <= empleado.nElementos; i++) {
                    empleado.ingresaDato(rs.getString(i), i);
                }
                //empleado.setNumTel(rs.getString("numtelemerg"));
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return empleado;
    }
//*******************************************************************************************************************

    public ArrayList<EmpleadoVO> ListarEmpleadoXOcupacion(String ocupacion) {
        EmpleadoVO empleado = new EmpleadoVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.empleado where ocupacion ilike '%****%' order by id_empleado;".replace("****", ocupacion));
            while (rs.next()) {
                EmpleadoVO a = new EmpleadoVO();
                for (int i = 1; i <= empleado.nElementos; i++) {
                    a.ingresaDato(rs.getString(i), i);
                }
                arraEmpleado.add(a); //empleado.limpiarDatos();
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return arraEmpleado;
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++++++INSERCION++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void agrega_Nuevo_Empleado(EmpleadoVO a) {
        String t= a.getTitulos();
        String inserta = "insert into sii.empleado("+t+") \n"
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
    public void actualizar_Empleado(EmpleadoVO a) {

        String[] ara = a.tostring().split(",");
        String[] atrib = a.getTitulos().split(",");
        String actualiza = "update sii.empleado set %%%% = &&&& where id_empleado = ****; ".replace("****", ara[0]);

        //int id_empleado= Integer.parseInt(ara[0]);
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
    public void eliminar_EmpleadoXId(String id_empleado) {
        String elimina = "DELETE FROM sii.empleado WHERE id_empleado = ****;".replace("****", id_empleado);
        System.out.println(elimina);
        try {
            conex.getConnection().createStatement().execute(elimina);
            conex.desconectar();
        } catch (Exception e) {
        }
    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
