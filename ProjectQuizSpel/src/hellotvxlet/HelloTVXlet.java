package hellotvxlet;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.tv.xlet.*;
import org.davic.resources.*;
import org.dvb.ui.*;
import org.havi.ui.*;
import org.havi.ui.event.*;



public class HelloTVXlet implements Xlet, HBackgroundImageListener, 
        ResourceClient, HActionListener
       {
     Question[] questionArray = new Question[40];
    
    private XletContext actueleXletContext;
    private HScene scene;
    private HTextButton btn1;
    private HTextButton btn2;
    private HTextButton btn3;
    private HTextButton btn4;
    private HTextButton btn5;
    private HTextButton btn6;
    private HTextButton btn7;
    private HTextButton btn8;
    private HTextButton btn9;
    private HTextButton btnTrue;
    private HTextButton btnFalse;
    private HTextButton restart;
    private HStaticText vraaglabel;
    private HStaticText greenlabel;
    private HStaticText bluelabel;
    int scoreblauw = 0;
    int scorerood = 0;
    int drawScoreRood = 0;
    int drawScoreBlauw = 0;
    boolean Btn1Enable = true;
    boolean Btn2Enable = true;
    boolean Btn3Enable = true;
    boolean Btn4Enable = true;
    boolean Btn5Enable = true;
    boolean Btn6Enable = true;
    boolean Btn7Enable = true;
    boolean Btn8Enable = true;
    boolean Btn9Enable = true;
    boolean NoButtonLeft = false;
    String ButtonCol1 = "Zwart";
    String ButtonCol2 = "Zwart";
    String ButtonCol3 = "Zwart";
    String ButtonCol4 = "Zwart";
    String ButtonCol5 = "Zwart";
    String ButtonCol6 = "Zwart";
    String ButtonCol7 = "Zwart";
    String ButtonCol8 = "Zwart";
    String ButtonCol9 = "Zwart";
    boolean CanWin = false;
    boolean EnemyCanWin = false;
    int randomInt; 
    boolean Speler = true;
    int buttonKlik;
    
    private HBackgroundConfigTemplate bgTemplate; 
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("achtergrond.jpg");
    

    public void notifyRelease (ResourceProxy proxy){}
    public void release (ResourceProxy proxy){}
    public boolean requestRelease (ResourceProxy proxy, Object requestData){
        return false;  }
    
    public HelloTVXlet() {
        
    }

    public void initXlet(XletContext context) {

        this.actueleXletContext = context;
      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, 
              new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED); 
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, 
              new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED); 
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);

      
    //Background Image
      screen = HScreen.getDefaultHScreen();
    //HBackground device opvragen
      bgDevice = screen.getDefaultHBackgroundDevice();
    //HBackground device reserveren
      if (bgDevice.reserveDevice((ResourceClient) this)){
        System.out.println("BackgroundImage device has been reserved");
      } else{
        System.out.println("Background Image device cannot be reserved");
      }
      //Template maken
      bgTemplate = new HBackgroundConfigTemplate();
      
      bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, 
              HBackgroundConfigTemplate.REQUIRED);
      
      bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
      
      try{
        bgDevice.setBackgroundConfiguration(bgConfiguration);
      } 
      catch(java.lang.Exception e){
        System.out.println(e.toString());
      }
        
      
   //Buttons and Labels   
      btn1 = new HTextButton("1");
      btn2 = new HTextButton("2");
      btn3 = new HTextButton("3");
      btn4 = new HTextButton("4");
      btn5 = new HTextButton("5");
      btn6 = new HTextButton("6");
      btn7 = new HTextButton("7");
      btn8 = new HTextButton("8");
      btn9 = new HTextButton("9");
      btnTrue = new HTextButton("JA");
      btnFalse = new HTextButton("NEE");
      restart = new HTextButton("OPNIEUW?" + "\n" + "PRESS ENTER");
      
      vraaglabel = new HStaticText ("");
      greenlabel = new HStaticText ("--> Player 1" + "\n" + "Points: " + "\n" + scorerood );
      bluelabel = new HStaticText ("Player 2" +  "\n" + "Points: " + "\n" + scoreblauw);
      
     //Propterties Buttons and Labels 
      vraaglabel.setLocation(120, 400);
      vraaglabel.setSize(460, 85);
      vraaglabel.setBackground(new DVBColor(0,0,0,180));
      vraaglabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      vraaglabel.setFont(new Font("Tiresias",Font.PLAIN,17));
      
      
      greenlabel.setLocation(120, 50);
      greenlabel.setSize(220, 120);
      greenlabel.setForeground(new DVBColor(0,0,0,255));
      greenlabel.setBackground(new DVBColor(0,255,0,230));
      
      greenlabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      greenlabel.setBordersEnabled(Speler);
      
      
      bluelabel.setLocation(360, 50);
      bluelabel.setSize(220, 120);
      bluelabel.setForeground(new DVBColor(0,0,0,255));
      bluelabel.setBackground(new DVBColor(55,226,226,230));
      bluelabel.setBackgroundMode(HVisible.BACKGROUND_FILL);
      bluelabel.setBordersEnabled(!Speler);
      
      btn1.setLocation(120, 200);
      btn1.setSize(140, 50);
      btn1.setForeground(new DVBColor(0,0,0,255));
      btn1.setBackground(new DVBColor(255,255,255,220));
      btn1.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn2.setLocation(280, 200);
      btn2.setSize(140, 50);
      btn2.setForeground(new DVBColor(0,0,0,255));
      btn2.setBackground(new DVBColor(255,255,255,220));
      btn2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn3.setLocation(440, 200);
      btn3.setSize(140, 50);
      btn3.setForeground(new DVBColor(0,0,0,255));
      btn3.setBackground(new DVBColor(255,255,255,220));
      btn3.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn4.setLocation(120, 260);
      btn4.setSize(140, 50);
      btn4.setForeground(new DVBColor(0,0,0,255));
      btn4.setBackground(new DVBColor(255,255,255,220));
      btn4.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      btn5.setLocation(280, 260);
      btn5.setSize(140, 50);
      btn5.setForeground(new DVBColor(0,0,0,255));
      btn5.setBackground(new DVBColor(255,255,255,220));
      btn5.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn6.setLocation(440, 260);
      btn6.setSize(140, 50);
      btn6.setForeground(new DVBColor(0,0,0,255));
      btn6.setBackground(new DVBColor(255,255,255,220));
      btn6.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn7.setLocation(120, 320);
      btn7.setSize(140, 50);
      btn7.setForeground(new DVBColor(0,0,0,255));
      btn7.setBackground(new DVBColor(255,255,255,220));
      btn7.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      
      btn8.setLocation(280, 320);
      btn8.setSize(140, 50);
      btn8.setForeground(new DVBColor(0,0,0,255));
      btn8.setBackground(new DVBColor(255,255,255,220));
      btn8.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btn9.setLocation(440, 320);
      btn9.setSize(140, 50);
      btn9.setForeground(new DVBColor(0,0,0,255));
      btn9.setBackground(new DVBColor(255,255,255,220));
      btn9.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btnTrue.setLocation(120, 500);
      btnTrue.setSize(220, 50);
      btnTrue.setForeground(new DVBColor(0,0,0,255));
      btnTrue.setBackground(new DVBColor(255,255,255,220));
      btnTrue.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnTrue.setVisible(false);
      
      btnFalse.setLocation(360, 500);
      btnFalse.setSize(220, 50);
      btnFalse.setForeground(new DVBColor(0,0,0,255));
      btnFalse.setBackground(new DVBColor(255,255,255,220));
      btnFalse.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnFalse.setVisible(false);
      
      
      restart.setLocation(120, 500);
      restart.setSize(460, 50);
      restart.setForeground(new DVBColor(0,0,0,255));
      restart.setBackground(new DVBColor(255,255,255,255));
      restart.setBackgroundMode(HVisible.BACKGROUND_FILL);
      restart.setVisible(false);
      

      scene.add(btn1);
      scene.add(btn2);
      scene.add(btn3);
      scene.add(btn4);
      scene.add(btn5);
      scene.add(btn6);
      scene.add(btn7);
      scene.add(btn8);
      scene.add(btn9);
      scene.add(btnTrue);
      scene.add(btnFalse);
      scene.add(restart);
      scene.add(vraaglabel);
      scene.add(greenlabel);
      scene.add(bluelabel);
      
      btn1.setActionCommand("knop1");
      btn2.setActionCommand("knop2");
      btn3.setActionCommand("knop3");
      btn4.setActionCommand("knop4");
      btn5.setActionCommand("knop5");
      btn6.setActionCommand("knop6");
      btn7.setActionCommand("knop7");
      btn8.setActionCommand("knop8");
      btn9.setActionCommand("knop9");
      btnTrue.setActionCommand("True");
      btnFalse.setActionCommand("False");
      restart.setActionCommand("Revanche");
      
      btn1.setFocusTraversal(null, btn4, null, btn2);
      btn2.setFocusTraversal(null, btn5, btn1, btn3);
      btn3.setFocusTraversal(null, btn6, btn2, null);
      btn4.setFocusTraversal(btn1, btn7, null, btn5);
      btn5.setFocusTraversal(btn2, btn8, btn4, btn6);
      btn6.setFocusTraversal(btn3, btn9, btn5, null);
      btn7.setFocusTraversal(btn4, null, null, btn8);
      btn8.setFocusTraversal(btn5, null, btn7, btn9);
      btn9.setFocusTraversal(btn6, null, btn8, null);
      restart.setFocusTraversal(null, null, null, null);
      
      btn5.requestFocus();
      
      btn1.addHActionListener(this);
      btn2.addHActionListener(this);
      btn3.addHActionListener(this);
      btn4.addHActionListener(this);
      btn5.addHActionListener(this);
      btn6.addHActionListener(this);
      btn7.addHActionListener(this);
      btn8.addHActionListener(this);
      btn9.addHActionListener(this);
      btnTrue.addHActionListener(this);
      btnFalse.addHActionListener(this);
      restart.addHActionListener(this);
      
      arraylijst();
      
 
    }
    
     public void startXlet() {
       scene.validate();
       scene.setVisible(true);
       
       agrondimg.load(this);
        
    }

    public void pauseXlet() {
     
    }

    public void destroyXlet(boolean unconditional) {
      agrondimg.flush();
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try {
            bgConfiguration.displayImage(agrondimg);
        } catch (Exception s) {
            System.out.println(s.toString());
        } 
        
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        
    }

   
    public void actionPerformed(ActionEvent e) {
         if(e.getActionCommand() == "knop1"){
             if(Btn1Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 1;
            checkWin();
            btn1.setForeground(new DVBColor(255,255,255,220));
            btn1.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn1Enable = false;
            }
             
        }
        
        if(e.getActionCommand() == "knop2"){
            if(Btn2Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 2;
            checkWin();
            btn2.setForeground(new DVBColor(255,255,255,220));
            btn2.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn2Enable = false;
            }
        }
        
        if(e.getActionCommand() == "knop3"){
            if(Btn3Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 3;
            checkWin();
            btn3.setForeground(new DVBColor(255,255,255,220));
            btn3.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn3Enable = false;
            }
        }
        
        if(e.getActionCommand() == "knop4"){
            if(Btn4Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 4;
            checkWin();
            btn4.setForeground(new DVBColor(255,255,255,220));
            btn4.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn4Enable = false;
            }
            
        }
         
         if(e.getActionCommand() == "knop5"){
             if(Btn5Enable)
             {
             vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
             
             buttonKlik = 5;
             checkWin();
            btn5.setForeground(new DVBColor(255,255,255,220));
            btn5.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn5Enable = false;
            }
        }
        
        if(e.getActionCommand() == "knop6"){
            if(Btn6Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 6;
            checkWin();
            btn6.setForeground(new DVBColor(255,255,255,220));
            btn6.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn6Enable = false;
            }
        }
        
        if(e.getActionCommand() == "knop7"){
            if(Btn7Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 7;
            checkWin();
            btn7.setForeground(new DVBColor(255,255,255,220));
            btn7.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn7Enable = false;
            }
        }
        
        if(e.getActionCommand() == "knop8"){
            if(Btn8Enable)
             {
            vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
            
            buttonKlik = 8;
            checkWin();
            btn8.setForeground(new DVBColor(255,255,255,220));
            btn8.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn8Enable = false;
            }
        }
         
         if(e.getActionCommand() == "knop9"){
             if(Btn9Enable)
             {
             vraaglabel.setTextContent(vraagAanroeper(), 
                   HState.NORMAL_STATE);
             
            buttonKlik = 9;
            checkWin();
            btn9.setForeground(new DVBColor(255,255,255,220));
            btn9.setBackground(new DVBColor(0,0,0,220));
            btnTrue.setVisible(true);
            btnFalse.setVisible(true);
            btnTrue.requestFocus();
            btnTrue.setFocusTraversal(null, btnFalse, null, null);
            btnFalse.setFocusTraversal(btnTrue, null, null, null);
            Btn9Enable = false;
             }
        }
         
         if(e.getActionCommand() == "Revanche")
         {
            revange();
         }
         
         if(e.getActionCommand() == "True"){
        
             if(e.getActionCommand() == questionArray[randomInt].answer)
             {
                 if(!CanWin)
                 {
                    vraaglabel.setTextContent("Je antwoord is CORRECT", HState.NORMAL_STATE);
                if(Speler == true)
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                else
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                checkForDraw();
                spelerSwitch();
                 } 
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    greenlabel.setTextContent("--> Speler 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    else
                    {
                    buttonKleur("Blauw");
                    scoreblauw += 100;
                    bluelabel.setTextContent("--> Speler 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }   
                    
                 }
             }
             else  
             {  
                 if(!EnemyCanWin)
                 {
                vraaglabel.setTextContent("Je antwoord is NIET CORRECT", HState.NORMAL_STATE);
                
                if(Speler == true)
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                else
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                checkForDraw();
                spelerSwitch();
                 }
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Blauw");
                    scoreblauw += 100;
                    bluelabel.setTextContent("Speler 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    else
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    greenlabel.setTextContent("Speler 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    
                 
                 }
             }
             
            
         }
             
         if(e.getActionCommand() == "False"){
              
             if(e.getActionCommand() == questionArray[randomInt].answer)
             {
                 if(!CanWin)
                 {
                vraaglabel.setTextContent("JE ANTWOORD IS JUIST", HState.NORMAL_STATE);
                
                if(Speler == true)
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                else
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                checkForDraw();
                spelerSwitch();
                 }
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    greenlabel.setTextContent("--> Speler 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    else
                    {
                     buttonKleur("Blauw");
                     scoreblauw += 100;
                     bluelabel.setTextContent("--> Speler 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                     vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                     btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    
                 }
             }
             else
             {
                 if(!EnemyCanWin)
                 {
                vraaglabel.setTextContent("JE ANTWOORD IS FOUT", HState.NORMAL_STATE);
                
                if(Speler == true)
                {
                buttonKleur("Blauw");
                scoreblauw += 50;
                
                }
                else
                {
                buttonKleur("Rood");
                scorerood += 50;
                
                }
                btnTrue.setVisible(false);
                btnFalse.setVisible(false);
                btn5.requestFocus();
                checkForDraw();
                spelerSwitch();
                 }
                 else
                 {
                     if(Speler == true)
                    {
                    buttonKleur("Blauw");
                    scoreblauw += 100;
                    bluelabel.setTextContent("Speler 2" + "\n" + "€ " + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 2 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    else
                    {
                    buttonKleur("Rood");
                    scorerood += 100;
                    greenlabel.setTextContent("Speler 1" + "\n" + "€ " + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("SPELER 1 IS GEWONNEN", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
                    }
                    
                 }
             }
             
         
         }
    }
    
    public void checkWin()
    {
        if(Speler)
        {
            switch(buttonKlik)
            {
                case 1: if(ButtonCol2 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol7 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol7 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 2: if(ButtonCol1 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol8 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol8 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 3: if(ButtonCol1 == "Rood" && ButtonCol2 == "Rood" || ButtonCol6 == "Rood" && ButtonCol9 == "Rood" || ButtonCol5 == "Rood" && ButtonCol7 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol2 == "Blauw" || ButtonCol6 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol7 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 4: if(ButtonCol1 == "Rood" && ButtonCol7 == "Rood" || ButtonCol5 == "Rood" && ButtonCol6 == "Rood" )
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol6 == "Blauw" )
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 5: if(ButtonCol1 == "Rood" && ButtonCol9 == "Rood" || ButtonCol2 == "Rood" && ButtonCol8 == "Rood" || ButtonCol3 == "Rood" && ButtonCol7 == "Rood" || ButtonCol4 == "Rood" && ButtonCol6 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol2 == "Blauw" && ButtonCol8 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol6 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 6: if(ButtonCol3 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol5 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol3 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol5 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 7: if(ButtonCol1 == "Rood" && ButtonCol4 == "Rood" || ButtonCol8 == "Rood" && ButtonCol9 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol4 == "Blauw" || ButtonCol8 == "Blauw" && ButtonCol9 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 8: if(ButtonCol2 == "Rood" && ButtonCol5 == "Rood" || ButtonCol7 == "Rood" && ButtonCol9 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol9 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 9: if(ButtonCol1 == "Rood" && ButtonCol5 == "Rood" || ButtonCol3 == "Rood" && ButtonCol6 == "Rood" || ButtonCol7 == "Rood" && ButtonCol8 == "Rood")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol6 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol8 == "Blauw")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
            }
        }
        else
        {
            switch(buttonKlik)
            {
                case 1: if(ButtonCol2 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol7 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol7 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 2: if(ButtonCol1 == "Blauw" && ButtonCol3 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol8 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol3 == "Rood" || ButtonCol5 == "Rood" && ButtonCol8 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 3: if(ButtonCol1 == "Blauw" && ButtonCol2 == "Blauw" || ButtonCol6 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol7 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol2 == "Rood" || ButtonCol6 == "Rood" && ButtonCol9 == "Rood" || ButtonCol5 == "Rood" && ButtonCol7 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 4: if(ButtonCol1 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol5 == "Blauw" && ButtonCol6 == "Blauw" )
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol7 == "Rood" || ButtonCol5 == "Rood" && ButtonCol6 == "Rood" )
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 5: if(ButtonCol1 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol2 == "Blauw" && ButtonCol8 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol7 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol6 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol9 == "Rood" || ButtonCol2 == "Rood" && ButtonCol8 == "Rood" || ButtonCol3 == "Rood" && ButtonCol7 == "Rood" || ButtonCol4 == "Rood" && ButtonCol6 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 6: if(ButtonCol3 == "Blauw" && ButtonCol9 == "Blauw" || ButtonCol4 == "Blauw" && ButtonCol5 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol3 == "Rood" && ButtonCol9 == "Rood" || ButtonCol4 == "Rood" && ButtonCol5 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 7: if(ButtonCol1 == "Blauw" && ButtonCol4 == "Blauw" || ButtonCol8 == "Blauw" && ButtonCol9 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol4 == "Rood" || ButtonCol8 == "Rood" && ButtonCol9 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 8: if(ButtonCol2 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol9 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol2 == "Rood" && ButtonCol5 == "Rood" || ButtonCol7 == "Rood" && ButtonCol9 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
                case 9: if(ButtonCol1 == "Blauw" && ButtonCol5 == "Blauw" || ButtonCol3 == "Blauw" && ButtonCol6 == "Blauw" || ButtonCol7 == "Blauw" && ButtonCol8 == "Blauw")
                        { CanWin = true; } else { CanWin = false;}
                        if(ButtonCol1 == "Rood" && ButtonCol5 == "Rood" || ButtonCol3 == "Rood" && ButtonCol6 == "Rood" || ButtonCol7 == "Rood" && ButtonCol8 == "Rood")
                        { EnemyCanWin = true; } else { EnemyCanWin = false;}
                break;
            }
        
        }
    }
    
    public void buttonKleur(String kleur)
    {
        if(kleur == "Rood")
        {
           switch(buttonKlik)
            {
                case 1: btn1.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol1 = "Rood";
                        btn1.requestFocus();
                                                
                break;
                case 2: btn2.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol2 = "Rood";
                        btn2.requestFocus();
                break;
                case 3: btn3.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol3 = "Rood";
                        btn3.requestFocus();
                break;
                case 4: btn4.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol4 = "Rood";
                        btn4.requestFocus();
                break;
                case 5: btn5.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol5 = "Rood";
                        btn5.requestFocus();
                break;
                case 6: btn6.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol6 = "Rood";
                        btn6.requestFocus();
                break;
                case 7: btn7.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol7 = "Rood";
                        btn7.requestFocus();
                break;
                case 8: btn8.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol8 = "Rood";
                        btn8.requestFocus();
                break;
                case 9: btn9.setBackground(new DVBColor(0,255,0,230));
                        ButtonCol9 = "Rood";
                        btn9.requestFocus();
                break;
            }  
        }
        else
        {
            switch(buttonKlik)
            {
                case 1: btn1.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol1 = "Blauw";
                        btn1.requestFocus();
                        
                break;
                case 2: btn2.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol2 = "Blauw";
                        btn2.requestFocus();
                break;
                case 3: btn3.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol3 = "Blauw";
                        btn3.requestFocus();
                break;
                case 4: btn4.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol4 = "Blauw";
                        btn4.requestFocus();
                break;
                case 5: btn5.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol5 = "Blauw";
                        btn5.requestFocus();
                break;
                case 6: btn6.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol6 = "Blauw";
                        btn6.requestFocus();
                break;
                case 7: btn7.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol7 = "Blauw";
                        btn7.requestFocus();
                break;
                case 8: btn8.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol8 = "Blauw";
                        btn8.requestFocus();
                break;
                case 9: btn9.setBackground(new DVBColor(55,226,226,230));
                        ButtonCol9 = "Blauw";
                        btn9.requestFocus();
                break;
            } 
        }
        
              
    }
    
    public void spelerSwitch()
    {
        Speler = !Speler;
        
        if(Speler == true)
        {
          greenlabel.setTextContent("--> Player 1" + "\n" + "Points: " + "\n" + scorerood, HState.NORMAL_STATE);
          bluelabel.setTextContent("Player 2" +  "\n" + "Points: " + "\n" + scoreblauw, HState.NORMAL_STATE);

          greenlabel.setForeground(new DVBColor(255,255,255,255));
          bluelabel.setForeground(new DVBColor(0,0,0,255));
        }
        else
        {
          greenlabel.setTextContent("Player 1" + "\n" + "Points: " + "\n" + scorerood, HState.NORMAL_STATE);
          bluelabel.setTextContent("--> Player 2" +  "\n" + "Points: " + "\n" + scoreblauw, HState.NORMAL_STATE);
          bluelabel.setForeground(new DVBColor(255,255,255,255));
          greenlabel.setForeground(new DVBColor(0,0,0,255));
        }
    }
    
    public String vraagAanroeper()
    {
        boolean loopMayBeSkipped = false;

        Random randomCreator = new Random();
        String vraagReturn = "";
        randomInt = randomCreator.nextInt(40);
        
        for (int i = 0; i < questionArray.length; i++) 
        {
            if (!loopMayBeSkipped)
            {
                if (!questionArray[randomInt].used) 
                {
                    vraagReturn = questionArray[randomInt].question;
                    loopMayBeSkipped = true;
                } 
                else 
                {
                    randomInt = randomCreator.nextInt(40);
                }  
            }
        }
        
        questionArray[randomInt].used = true;
        
        System.out.println(randomInt);
        return vraagReturn;
    }

    public void arraylijst()
    {
        // Heel veel vragen

questionArray[0] = new Question("Is een krokodil groter dan een alligator?", "False", false);
questionArray[1] = new Question("Google is de meest bezochte webpagina ter wereld?", "True", false);
questionArray[2] = new Question("India is meer bevolkt dan Europa en Amerika?", "True", false);
questionArray[3] = new Question("FC Real Madrid werd verklaard als club van de eeuw?", "True", false);
questionArray[4] = new Question("Hoe hoger in de atmosfeer - hoe hoger de druk", "False", false);
questionArray[5] = new Question("Het Olympische vuur brandde voor het eerst in Amsterdam", "True", false);
questionArray[6] = new Question("Mozart heeft 'Fur Elise' gecomponeerd?	", "False", false);
questionArray[7] = new Question("Het Atlasgebergte ligt in Zuid-Amerika", "False", false);
questionArray[8] = new Question("Werd George van de Beatles ‘Ritchie’ als kind genoemd?", "False", false);
questionArray[9] = new Question("De luchtvochtigheid meet men met een barometer", "False", false);
questionArray[10] = new Question("Eminem heeft ooit een duet gezongen met Elton John", "True", false);
questionArray[11] = new Question("Socrates was een leerling van Plato", "False", false);
questionArray[12] = new Question("Stalin was de leider van de Bolsjewistische \n revolutie in Rusland in 1917", "False", false);
questionArray[13] = new Question("Koffie is de populairste niet alcoholistische \n drank ter wereld? ", "True", false);
questionArray[14] = new Question("Karl Marx is de schrijver van 'Das Kapital'", "True", false);
questionArray[15] = new Question("Leopold I was de eerste koning van België", "True", false);
questionArray[16] = new Question("Franklin Roosevelt is de enige Amerikaanse \n president die 4 keer verkozen is", "True", false);
questionArray[17] = new Question("Zwitserland werd niet bezet tijdens Wereldoorlog II", "True", false);
questionArray[18] = new Question("Hitler was getrouwd met Anna Braun", "False", false);
questionArray[19] = new Question("Neil Armstrong was de eerste man op de maan", "True", false);
questionArray[20] = new Question(" Heeft een sopraan een lage zangstem?", "True", false);
questionArray[21] = new Question("Voetbal is afkomstig uit Brazilië", "False", false);
questionArray[22] = new Question("Ping Pong is afkomstig uit China", "True", false);
questionArray[23] = new Question("Een Olympisch zwembad is 50 meter lang", "True", false);
questionArray[24] = new Question("Het WK voetbal werd in 2010 gehouden in Zuid-Afrika", "True", false);
questionArray[25] = new Question("Eddy Merckx won 4 maal de Ronde van Vlaanderen", "False", false);
questionArray[26] = new Question("Een volledige hockeywedstrijd duurt 70 minuten", "True", false);
questionArray[27] = new Question("De Olympische Winter Spelen van 1984 \n werden in Sarajevo gehouden?", "True", false);
questionArray[28] = new Question("De Champions League werd in 2014 \n gewonnen door Atlético Madrid", "False", false);
questionArray[29] = new Question("Het eerste WK in het voetbal werd \n gewonnen door Uruguay", "True", false);
questionArray[30] = new Question("Mozart had de Oostenrijkse nationaliteit", "True", false);
questionArray[31] = new Question("Elvis Presley stierf in 1977", "True", false);
questionArray[32] = new Question("Is San Marino een stad in de Verenigde Staten?	", "False", false);
questionArray[33] = new Question("John Lennon werd vermoord in Los Angeles", "False", false);
questionArray[34] = new Question("Een standaardpiano telt 52 witte toetsen", "True", false);
questionArray[35] = new Question("De eerste woorden van Bart Simpson in \n de serie 'The Simpsons' waren 'Ay carumba'", "True", false);
questionArray[36] = new Question("Al Pacino speelde de hoofdrol in Scarface", "True", false);
questionArray[37] = new Question("Angelina Jolie speelde de hoofdrol in de film 'Pretty Woman'", "False", false);
questionArray[38] = new Question("De achternaam van Rocky in de boksfilm 'Rocky' was 'Balboa'", "True", false);
questionArray[39] = new Question("Jennifer Aniston speelt de rol van 'Samantha' \n in de serie 'Sex and the City'", "False", false);
    }
       
    public void revange()
    {
        restart.setVisible(false);
        
        btn1.setBackground(new DVBColor(255,255,255,220));
        btn1.setForeground(new DVBColor(0,0,0,220));
        btn2.setBackground(new DVBColor(255,255,255,220));
        btn2.setForeground(new DVBColor(0,0,0,220));
        btn3.setBackground(new DVBColor(255,255,255,220));
        btn3.setForeground(new DVBColor(0,0,0,220));
        btn4.setBackground(new DVBColor(255,255,255,220));
        btn4.setForeground(new DVBColor(0,0,0,220));
        btn5.setBackground(new DVBColor(255,255,255,220));
        btn5.setForeground(new DVBColor(0,0,0,220));
        btn6.setBackground(new DVBColor(255,255,255,220));
        btn6.setForeground(new DVBColor(0,0,0,220));
        btn7.setBackground(new DVBColor(255,255,255,220));
        btn7.setForeground(new DVBColor(0,0,0,220));
        btn8.setBackground(new DVBColor(255,255,255,220));
        btn8.setForeground(new DVBColor(0,0,0,220));
        btn9.setBackground(new DVBColor(255,255,255,220));
        btn9.setForeground(new DVBColor(0,0,0,220));
        
        btn5.requestFocus();
        
        spelerSwitch();
        
        Btn1Enable = true;
        Btn2Enable = true;
        Btn3Enable = true;
        Btn4Enable = true;
        Btn5Enable = true;
        Btn6Enable = true;
        Btn7Enable = true;
        Btn8Enable = true;
        Btn9Enable = true;
        NoButtonLeft = false;
        vraaglabel.setTextContent("", HState.NORMAL_STATE);
        
        ButtonCol1 = "Zwart";
        ButtonCol2 = "Zwart";
        ButtonCol3 = "Zwart";
        ButtonCol4 = "Zwart";
        ButtonCol5 = "Zwart";
        ButtonCol6 = "Zwart";
        ButtonCol7 = "Zwart";
        ButtonCol8 = "Zwart";
        ButtonCol9 = "Zwart";
        CanWin = false;
        EnemyCanWin = false;
        drawScoreRood = 0;
        drawScoreBlauw = 0;
        
        for(int i=0;i < 40;i++)
        {
            questionArray[i].used = false;
        }
        
    }
    
    public void checkForDraw()
    {
        if(ButtonCol1 != "Zwart" && ButtonCol2 != "Zwart" && ButtonCol3 != "Zwart" && ButtonCol4 != "Zwart" && ButtonCol5 != "Zwart" && ButtonCol6 != "Zwart" && ButtonCol7 != "Zwart" && ButtonCol8 != "Zwart" && ButtonCol9 != "Zwart" )
        {
            //meeste knoppen
            if(ButtonCol1 == "Blauw")
            { drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol2 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol3 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol4 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol5 == "Blauw")
            {
            drawScoreBlauw ++;}
            else
            {drawScoreRood ++;
            }
            if(ButtonCol6 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol7 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol8 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            if(ButtonCol9 == "Blauw")
            {drawScoreBlauw ++;
            }
            else
            {drawScoreRood ++;
            }
            
            
            if(drawScoreBlauw > drawScoreRood)
            {
                    scoreblauw += 50;
                    bluelabel.setTextContent("PLAYER 2" + "\n" + "POINTS: " + "\n" + scoreblauw , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("PLAYER 2 HAS WON", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
            }
            else
            {
                    scorerood += 50;
                    greenlabel.setTextContent("PLAYER 1" + "\n" + "POINTS: " + "\n" + scorerood , HState.NORMAL_STATE);
                    vraaglabel.setTextContent("PLAYER 1 HAS WON", HState.NORMAL_STATE);
                    btnTrue.setVisible(false);
                    btnFalse.setVisible(false);
                    restart.setVisible(true);
                    restart.requestFocus();
            
            
            }
            
           
        }
    }
    
    
}


        
    
       
    

