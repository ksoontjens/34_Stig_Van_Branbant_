/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

import java.lang.*;

public class Oef2
{
	public static void main(String args[])
		{
		int weekdag = 1;
		int dag;
			for (dag=1; dag<28;dag++)
			{
	
				if(weekdag==1){System.out.println("zondag");}
				if(weekdag==2){System.out.println("maandag");}
				if(weekdag==3){System.out.println("dinsdag");}
				if(weekdag==4){System.out.println("woensdag");}
				if(weekdag==5){System.out.println("donderdag");}
				if(weekdag==6){System.out.println("vrijdag");}
				if(weekdag==7){System.out.println("zaterdag");}

				weekdag++;
				if(weekdag>7) {weekdag = 1;}
			

				System.out.println( " " + dag + "februari 2009");
			}

		}
}