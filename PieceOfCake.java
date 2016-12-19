
import java.math.*;
import java.io.*;
import java.util.Scanner;
public class PieceOfCake {

	public static void main(String[] args) {


		    int a;
		    
		    int i;
		    int z;
		    int n = 0;
		  
		    Scanner in = new Scanner (System.in);
		    System.out.println("Enter no of cakes: ");
		    a = in.nextInt();
		    int [] arr = new int[a];
		
		 
		    	for(i = 0; i < a; i++)
		    	{
		    		System.out.println("Enter cake area ");
		    		  	arr[i] = in.nextInt();
		    	}
		    	
		    	for( i = 0; i < a; i++){
		    		double sqrtN = Math.sqrt(arr[i]);
		    		int b = (int)sqrtN;
		    
		    		for (z = b; z >= 1; z--){
		    			if (arr[i] % z == 0){
			            break;
		    			}
		    		}
		    		int j =((z + arr[i] / z) * 2);
		    		System.out.println("Perimeter of cake is " + j);
		    		
		    	}
		    		
		    		 
		    		  	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
		    	
/*		    	System.out.println(n);

			    	
		  }*/
		    
	}
}

		
		
		




