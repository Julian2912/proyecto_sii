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

public class AlumnoDAO {

    private ArrayList<AlumnoVO> arraAlumno;

    private DbConnection conex;
    private Statement st;
    private ResultSet rs;

    public AlumnoDAO() {
        this.arraAlumno = new ArrayList<AlumnoVO>();

        conex = new DbConnection();
        st = null;
        rs = null;
    }

//++++++++++++++++++++++++++++++++++++++++++CONSULTAR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public AlumnoVO consultarAlumnoXid(String codigo) {
        AlumnoVO alumno = new AlumnoVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("select * from sii.alumno where id_alumno = ****;".replace("****", codigo));
            while (rs.next()) {
                for (int i = 1; i <= alumno.nElementos; i++) {
                    alumno.ingresaDato(rs.getString(i), i);
                }
                //alumno.setNumTel(rs.getString("numtelemerg"));
            }
            conex.desconectar();
        } catch (Exception e) {
        }
        return alumno;
    }
//*******************************************************************************************************************

    public ArrayList<AlumnoVO> ListarAlumnoXgrupo(String id_grupo) {
        AlumnoVO alumno = new AlumnoVO();
        try {
            st = conex.getConnection().createStatement();
            rs = st.executeQuery("SELECT id_alumno, nombre, apellidop,apellidom,sexo,tiposangre,tutor,direccion,numtelemerg FROM sii.relacion_grupo_alumno natural join sii.alumno WHERE id_grupo =****;".replace("****", id_grupo));
            while (rs.next()) {
                AlumnoVO a = new AlumnoVO();
                for (int i = 1; i <= alumno.nElementos; i++) {
                    a.ingresaDato(rs.getString(i), i);
                }
                arraAlumno.add(a); //alumno.limpiarDatos();
            }
             conex.desconectar();
        } catch (Exception e) {
        }
        return arraAlumno;
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//++++++++++++++++++++++++++++++++++++++++++INSERCION++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void agrega_Nuevo_Alumno(AlumnoVO a) {
        String inserta = "insert into sii.alumno(id_alumno, nombre, apellidop,apellidom,sexo,tiposangre,tutor,direccion,numtelemerg) \n"
                + "values (****);".replace("****", a.tostring());
        try {
            st = conex.getConnection().createStatement();
            if (st.execute(inserta)) {
                System.out.println("se inserto de forma correcta");
            } else {
                System.out.println("no se  inserto de forma correcta");
            }
             conex.desconectar();

        } catch (Exception e) {  
        }

    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++ACTUALIZACIONES++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void actualizar_Alumno(AlumnoVO a){
        
        String []ara= a.tostring().split(",");
        String []atrib= a.getTitulos().split(",");
        String actualiza="update sii.alumno set %%%% = &&&& where id_alumno = **** order by id_alumno; ".replace("****", ara[0]);
      
        //int id_alumno= Integer.parseInt(ara[0]);
        try {
            for (int i = 1; i < ara.length; i++) {
                boolean b=conex.getConnection().createStatement().execute(actualiza.replace("%%%%", atrib[i]).replace("&&&&",ara[i]));
                }  
             conex.desconectar();
        } catch (Exception e) {
        }
    
    }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++++++++++++++++++++++++++++++++ELIMINAR++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
public void eliminar_AlumnoXId(String id_alumno){
    String elimina="DELETE FROM sii.alumno WHERE id_alumno = ****;".replace("****",id_alumno);
    System.out.println(elimina);
    try {
        conex.getConnection().createStatement().execute(elimina);
        conex.desconectar();
    } catch (Exception e) {
    }
}
    
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
}
