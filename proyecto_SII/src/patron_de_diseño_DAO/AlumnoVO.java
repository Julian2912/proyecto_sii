/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patron_de_diseño_DAO;

import javax.swing.JOptionPane;


public class AlumnoVO {
    private String id_alumno,
            nombre,
            apellidop,
            apellidom,
            sexo,
            tiposangre,
            tutor,
            direccion,
            numTel;
     final int nElementos =9;
    public AlumnoVO() {
    }
 @Override
    public String toString() {
        return id_alumno + "," + nombre + "," + apellidop + "," + apellidom + "," + sexo +","+tiposangre+ "," + tutor + "," + direccion + "," + numTel ;
    }
    public String tostring() {
        return id_alumno + ",'" + nombre + "','" + apellidop + "','" + apellidom + "','" + sexo +"','"+tiposangre+ "','" + tutor + "','" + direccion + "','" + numTel+"'" ;
    }
   
    public String getTitulos() {
        return  "id_alumno"  + ", nombre" + ", apellidop"+ ", apellidom" + ", sexo"  + ", tiposangre"  + ", tutor"+ ", direccion"  + ", numtelemerg"  ;
    }

   

    public AlumnoVO(String id_alumno, String nombre, String apellidop, String apellidom, String sexo, String tiposangre, String tutor, String direccion, String numTel) {
        this.id_alumno = id_alumno;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.sexo = sexo;
        this.tiposangre = tiposangre;
        this.tutor = tutor;
        this.direccion = direccion;
        this.numTel = numTel;
    }

   

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getTiposangre() {
        return tiposangre;
    }

    public void setTiposangre(String tiposangre) {
        this.tiposangre = tiposangre;
    }
    public void ingresaDato(String a,int op){
        switch(op){
            case 1:id_alumno= a; break;
            case 2:nombre=a; break;
            case 3:apellidop=a; break; 
            case 4:apellidom=a; break; 
            case 5:sexo=a; break; 
            case 6:tiposangre=a; break; 
            case 7:tutor=a; break;
            case 8:direccion=a; break; 
            case 9:numTel=a; break; 
            default: JOptionPane.showMessageDialog(null,0,"no se puede insertar este dato", op);
            
        }
    }
    public String getDato(int op){
        String a="";
        switch(op){
            case 1:a+=id_alumno; break;
            case 2:a+=nombre; break;
            case 3:a+=apellidop; break; 
            case 4:a+=apellidom; break; 
            case 5:a+=sexo; break; 
            case 6:a+=tiposangre; break; 
            case 7:a+=tutor; break;
            case 8:a+=direccion; break; 
            case 9:a+=numTel; break; 
            default: JOptionPane.showMessageDialog(null,0,"no se puede insertar este dato", op);
            
        }
        return a;
    }
    public void limpiarDatos(){
        id_alumno=
            nombre=
            apellidop=
            apellidom=
            sexo=
            tiposangre=
            tutor=
            direccion=
            numTel="";
    }
    
}
