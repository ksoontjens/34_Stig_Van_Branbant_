/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

import java.lang.*;

public class Oef3
{
	public static void main(String args[])
		{

			double noemer = 1;
			double tel;
			double som = 0;
			for (tel=1; tel<10000;tel++)
			{
				som+=(1/noemer);
				noemer+=4;
			}
			noemer = 3;
			for(tel =1; tel < 10000; tel++)
			{
				som-=(1/noemer);
				noemer+=4;
			}
			double pi =som*4;
			System.out.println("pi = " +  pi);

		}
}






	
		
