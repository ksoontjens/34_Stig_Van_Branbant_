package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent{
    
    //Plaats en locatie instellen in de constructor
    public MijnComponent(int xPos, int yPos, int width, int height){
        
        this.setBounds(xPos,yPos,width,height);
        
    }
    
    //Paint methode overschrijven
    public void paint(Graphics g){
        
        g.setColor(new DVBColor(0,0,100,179));
        g.fillRect(100,100,100,100);
        g.setColor(Color.yellow);
        g.drawString("Tekst", 15,20);
        
    }
}
