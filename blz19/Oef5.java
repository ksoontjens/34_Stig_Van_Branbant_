/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

import java.lang.*;

public class Oef5
{
	public static void main(String args[])
	{
		int i;
		for (i=3; i < 99; i++ ){
			int j;
			for (j=2; j<i; j++){
				int n = i%j;
				if (n==0){
					break;
				}
			}
			if(i == j){
				System.out.println("Priem: "+i);
			}
		}
	}
}