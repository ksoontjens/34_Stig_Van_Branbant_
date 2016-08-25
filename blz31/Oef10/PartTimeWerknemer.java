/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

package Oef10;
import java.lang.*;

public class PartTimeWerknemer extends Werknemer {
    
    public int urenGewerkt;
    
    public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGewerkt){
        
        super(voornaam, achternaam, wNummer, salaris);
        this.urenGewerkt = urenGewerkt;
    }

    public float getWeekLoon(){
        return this.salaris + this.urenGewerkt;
    }
   
    @Override
    public void salarisVerhogen(int percentage){
        if(percentage > 5){
            percentage = 5;
        }
        float verhogingsfactor = (float) percentage/100;
        salaris += salaris * verhogingsfactor;
    }
}
