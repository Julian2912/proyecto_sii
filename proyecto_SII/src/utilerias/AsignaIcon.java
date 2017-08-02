/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Julian
 */
public class AsignaIcon {
    
     public Icon crearIcono(String url,JLabel atiname){
        ImageIcon imagen = new ImageIcon(url);
        Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(atiname.getWidth(), atiname.getHeight(), Image.SCALE_DEFAULT));
        return icon;
    }
    
}
