package project;
import java.io.*;
import java.util.*; //priorityqueque incluidoo

public class main {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		System.out.println("+--------------------------+");
		System.out.println("| Bienvenido a mi Hospital |");
		System.out.println("+--------------------------+");
		System.out.println();
		Heap<Patients> Tree = new Heap();
		
		try {
			File myFile = new File("datos.txt");
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
		        String[] data = myReader.nextLine().split(",");
		        for(int i = 0; i > 3; i++) {
		        	data[i] = data[i].trim();
		        }
		        
		        Patients newPatient = new Patients(data[0],data[1],data[2]);
		        Tree.insert(newPatient);
		        System.out.println(newPatient.toString());
		      }
			myReader.close();			
		} catch (FileNotFoundException  e) {
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
	}

}
