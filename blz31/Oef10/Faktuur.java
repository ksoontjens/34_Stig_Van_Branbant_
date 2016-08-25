/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

package Oef10;
import java.lang.*;

public class Faktuur implements Betaalbaar{
    
    public int faktuurNr = 5;
    public int faktuurBedrag = 500;
    
    public Faktuur(){
        
    }
    
    @Override
    public void betaal(){
        System.out.println("Betaal het faktuur " + this.faktuurNr + " voor een bedrag van " + this.faktuurBedrag + ".");
    }
}