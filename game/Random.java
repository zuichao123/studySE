import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Random{
	public static void main(String[] args){
		System.out.print("******************");
		System.out.print("\n************   $$ "+(int)((Math.random()*10)/2));
		System.out.println(":"+(int)((Math.random()*10)/2)+" $$"+"\n******************");
	}
}