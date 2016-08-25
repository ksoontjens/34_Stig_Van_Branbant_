/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

package Oef5;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        
        Werknemer w1 = new Werknemer("Voornaam1", "Achternaam1", 1, 1000.0f);//f van gedwongen float
        Werknemer w2 = new Werknemer("Voornaam2", "Achternaam2", 2, 2000.0f);
        Werknemer w3 = new Werknemer("Voornaam3", "Achternaam3", 3, 3000.0f);
        Werknemer w4 = new Werknemer("voornaam4", "Achternaam4", 4, 4000.0f);

        //Oef3
        PartTimeWerknemer pw1 = new PartTimeWerknemer("voornaam5", "Achternaam5", 5, 5000.0f,20);
        PartTimeWerknemer pw2 = new PartTimeWerknemer("voornaam6", "Achternaam6", 6, 6000.0f,20);

        //Oef2
        w1.salarisVerhogen(10); // 10 percent.0f
        w2.salarisVerhogen(10);

        //Oef4
        pw1.salarisVerhogen(10);
        pw1.salarisVerhogen(10);

        System.out.println(w1.voornaam + " verdiend "  + w1.getSalaris());
        System.out.println(w2.voornaam + " verdiend "  + w2.getSalaris());
        System.out.println(w3.voornaam + " verdiend "  + w3.getSalaris());
        System.out.println(w4.voornaam + " verdiend "  + w4.getSalaris());

        System.out.println(pw1.voornaam + " verdiend "  + pw1.getSalaris());
        System.out.println(pw2.voornaam + " verdiend "  + pw2.getSalaris());

    }
}