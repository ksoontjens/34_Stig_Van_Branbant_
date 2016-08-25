package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.*;
import java.awt.event.*;

import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

public class HelloTVXlet implements Xlet {
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private MijnComponent mc;
    private Graphics g;

    public HelloTVXlet() {
        
    }
    public void initXlet(XletContext context) throws XletStateChangeException {
      
        if(debug)System.out.println("Xlet Initialiseren");
        this.actueleXletContext = context;
        
        //Template aanmaken
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION,
                new HScreenDimension(1.0f, 1.0f),   //Procentueel
                HSceneTemplate.REQUIRED);
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION,
                new HScreenPoint(0.0f, 0.0f),
                HSceneTemplate.REQUIRED);
        
        MijnComponent mc = new MijnComponent(150,50,200,300);
        scene.add(mc); 

        mc.paint(g);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);     
    }

    public void startXlet() {
    
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
     
    }
}
