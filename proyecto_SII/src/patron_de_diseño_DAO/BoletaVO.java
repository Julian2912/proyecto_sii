

package patron_de_diseño_DAO;

import javax.swing.JOptionPane;


public class BoletaVO {
    private String  id_boleta;
    private float bimestre_1,
            bimestre_2,
            bimestre_3,
            bimestre_4,
            bimestre_5;
    public final int nElementos=6;
    public BoletaVO() {
    }

    public String getId_boleta() {
        return id_boleta;
    }

    

    public void setId_boleta(String id_boleta) {
        this.id_boleta = id_boleta;
    }

    public float getBimestre_1() {
        return bimestre_1;
    }

    public void setBimestre_1(float bimestre_1) {
        this.bimestre_1 = bimestre_1;
    }

    public float getBimestre_2() {
        return bimestre_2;
    }

    public void setBimestre_2(float bimestre_2) {
        this.bimestre_2 = bimestre_2;
    }

    public float getBimestre_3() {
        return bimestre_3;
    }

    public void setBimestre_3(float bimestre_3) {
        this.bimestre_3 = bimestre_3;
    }

    public float getBimestre_4() {
        return bimestre_4;
    }

    public void setBimestre_4(float bimestre_4) {
        this.bimestre_4 = bimestre_4;
    }

    public float getBimestre_5() {
        return bimestre_5;
    }
    public void ingresaDato(String a,int op){
        switch(op){
            case 1:id_boleta= a; break;
            case 2:bimestre_1=Integer.parseInt(a); break;            
            case 3:bimestre_2=Integer.parseInt(a); break; 
            case 4:bimestre_3=Integer.parseInt(a); break; 
            case 5:bimestre_4=Integer.parseInt(a); break; 
            case 6:bimestre_5=Integer.parseInt(a); break; 
            
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
    }
    public String  getDato(int op){
        String a=null;
        switch(op){
            case 1:a+=id_boleta ; break;
            case 2:a+=bimestre_1; break;            
            case 3:a+=bimestre_2; break; 
            case 4:a+=bimestre_3; break; 
            case 5:a+=bimestre_4; break; 
            case 6:a+=bimestre_5; break; 
            
            default: JOptionPane.showMessageDialog(null,a,"no se puede insertar este dato", op);
        }
        return a;
    }

    public void setBimestre_5(float bimestre_5) {
        this.bimestre_5 = bimestre_5;
    }

    public BoletaVO(String id_boleta, float bimestre_1, float bimestre_2, float bimestre_3, float bimestre_4, float bimestre_5) {
        this.id_boleta = id_boleta;
        this.bimestre_1 = bimestre_1;
        this.bimestre_2 = bimestre_2;
        this.bimestre_3 = bimestre_3;
        this.bimestre_4 = bimestre_4;
        this.bimestre_5 = bimestre_5;
    }
    public String getTitulos() {
        return  "id_boleta" + ", bimestre_1" + ", bimestre_2"  + ", bimestre_3" + ", bimestre_4" + ", bimestre_5" ;
    }

    
    public String tostring() {
        return id_boleta + "','" + bimestre_1 + "', '" + bimestre_2 + "','" + bimestre_3 + "','" + bimestre_4 + "','" + bimestre_5 + "', '" + nElementos +"'";
    }

    @Override
    public String toString() { 
        return  id_boleta + "," + bimestre_1 + "," + bimestre_2 + "," + bimestre_3 + "," + bimestre_4 + "," + bimestre_5;
    }
 
 
}
