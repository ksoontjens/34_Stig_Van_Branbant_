/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

import java.lang.*;

public class Oef1{
	public static void main(String args[])
		{
			int x;
			int y;
			for (x=1; x<=9 ; x++)
			{
				for(y=1; y<=9 ; y++)
				{
					System.out.println( x + " x " + y + "  = " + x*y);
				}
			}
		}
}