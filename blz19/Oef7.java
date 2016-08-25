/**
* deze klasse is een java programma
* @author Marijn Brosens
* @version 1.0
*/

import java.lang.*;

public class Oef7{

	public static void main(String arg[]){

		int a[] = {12,34,56,78,123,234,99,88};

		int b[];
		b = new int[a.length];

		for(int i = 0; i < a.length; i++){

			int x = a[0];

			for(int j = 0; j < a.length; j++){
				if(a[j] > x){
					x = a[j];
				}
			}

			b[i] = x;

			for (int j = 0; j < a.length; j++){
				if(a[j] == x){
					a[j] = 0;
				}
			}
		}

		for(int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}
	}
}