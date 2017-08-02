

package patron_de_diseño_DAO;

import javax.swing.JOptionPane;

public class MateriaVO {
    
    private String id_materia, grado,nombreMateria;

    public MateriaVO(String id_materia, String grado, String nombreMateria) {
        this.id_materia = id_materia;
        this.grado = grado;
        this.nombreMateria = nombreMateria;
    }

    public MateriaVO() {
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }


    public String getTitulos() {
        return  "id_materia" + ", grado" + ", nombreMateria" ;
    }

    @Override
    public String toString() {
        return id_materia + "," + grado + "," + nombreMateria ;
    }
    public String tostring() {
        return id_materia + ",'" + grado + "','" + nombreMateria+"'" ;
    }
    public void ingresaDato(String a,int op){
        switch(op){
            case 1:id_materia= a; break;
            case 2:grado=a; break;
            case 3:nombreMateria=a; break;    
             
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
    }
    public String getDato(int op){
        String a = null;
        switch(op){
            case 1:a=id_materia; break;
            case 2:a=grado=a; break;
            case 3:a=nombreMateria; break; 
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
        return a;
    }
    

}
