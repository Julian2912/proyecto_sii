/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patron_de_diseño_DAO;

import javax.swing.JOptionPane;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GrupoVO {
    private String id_grupo,nombre;
    public final int  nElementos=2;
    public GrupoVO(String id_grupo, String nombre) {
        this.id_grupo = id_grupo;
        this.nombre = nombre;
    }

    public GrupoVO() {
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getTitulos() {
        return "id_grupo" + ", nombre" ;
    }
@Override
    public String toString() {
        return  id_grupo + ", " + nombre ;
    }
    public String tostring() {
        return  id_grupo + ",'" + nombre+"'" ;
    }
     public void ingresaDato(String a,int op){
        switch(op){
            case 1:id_grupo= a; break;
            case 2:nombre=a; break;            
             
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
    }
    public String getDato(int op){
        String a = null;
        switch(op){
            case 1:a=id_grupo; break;
            case 2:a=nombre; break;
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
        return a;
    }
    
}
