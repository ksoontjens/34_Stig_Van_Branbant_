/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

package Oef3;
import java.lang.*;

public class PartTimeWerknemer extends Werknemer {
    
    public int urenGewerkt;
    
    public PartTimeWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGewerkt){
        
        super(voornaam, achternaam, wNummer, salaris);
        this.urenGewerkt = urenGewerkt;
    }
}
