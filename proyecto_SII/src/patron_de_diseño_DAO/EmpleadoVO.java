

package patron_de_diseño_DAO;

import javax.swing.JOptionPane;


public class EmpleadoVO {
    private String  id_empleado,
                    ocupacion,
                    nombre,
                     apellidop,
                    apellidom,
                    sexo,
                    correo,            
                    numtel;
     final int nElementos =8;
    public EmpleadoVO() {
        
    }

    public EmpleadoVO(String id_empleado, String ocupacion, String nombre, String apellidop, String apellidom, String sexo, String correo, String numtel) {
        this.id_empleado = id_empleado;
        this.ocupacion = ocupacion;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.sexo = sexo;
        this.correo = correo;
        this.numtel = numtel;
    }

    

    public String getOcupacion() {
        return ocupacion;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

 
    public String getTitulos() {
        return "id_empleado"+ ", ocupacion"  + ", nombre" + ", apellidop"  + ", apellidom" + ", sexo" + ", correo"  + ", numtel" ;
    }

   
    public String tostring() {
        return  id_empleado + ",'" + ocupacion + "','" + nombre + "','" + apellidop + "','" + apellidom + "','" + sexo + "','" + correo + "','" + numtel+"'";
    }
       @Override
    public String toString() {
        return id_empleado+","+ocupacion + "," + nombre + "," + apellidop + "," + apellidom + "," + sexo + "," + correo + "," + numtel;
    }
    
 
    public void ingresaDato(String a,int op){
        switch(op){
            case 1:id_empleado= a; break;
            case 2:ocupacion=a; break;            
            case 3:nombre=a; break; 
            case 4:apellidop=a; break; 
            case 5:apellidom=a; break; 
            case 6:sexo=a; break; 
            case 7:correo=a; break;
            case 8:numtel=a; break; 
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
    }
    public String getDato(int op){
        String a="";
        switch(op){
            case 1:a=id_empleado; break;
            case 2:a=ocupacion; break;            
            case 3:a=nombre; break; 
            case 4:a=apellidop; break; 
            case 5:a=apellidom; break; 
            case 6:a=sexo; break; 
            case 7:a=correo; break;
            case 8:a=numtel; break; 
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
        return a;
    }
}
