/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

/**
 *
 * @author student
 */
public class MijnComponent extends HComponent{
    
    //Plaats en locatie instellen in de constructor
    public MijnComponent(int width, int height){
        this.setBounds(0,0,width,height);
        
    }
    
    //Paint methode overschrijven
    public void paint(Graphics g){
        g.setColor(new DVBColor(0,0,100,179));
        g.fillRect(0,0,100,100);
        g.setColor(Color.yellow);
        g.drawString("Tekst", 15,20);
        
    }
}
