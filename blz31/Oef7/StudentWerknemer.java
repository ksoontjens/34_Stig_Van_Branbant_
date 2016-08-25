/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

package Oef7;
import java.lang.*;

public class StudentWerknemer extends PartTimeWerknemer {
       
    public StudentWerknemer(String voornaam, String achternaam, int wNummer, float salaris, int urenGewerkt){
        
        super(voornaam, achternaam, wNummer, salaris, urenGewerkt);
        this.setRSZ(5);
    }    
}