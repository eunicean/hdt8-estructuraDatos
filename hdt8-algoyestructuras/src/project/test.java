package project;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class test {
	private Heap<Patients> listado;
	
	Patients patient1 = new Patients("Eunice", "No pudo dormir", "A");
	Patients patient2 = new Patients("Cristian", "Tiene que aguantar a Eunice", "C");
	Patients patient3 = new Patients("Emilio", "Quemadura de agua", "C");
	Patients patient4 = new Patients("Chuy", "Vio mario movie", "B");
	
	public static Heap customHeap() {
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
		
		return Tree;
	}
	
	public static PriorityQueue JavaFrameworksHeap() {
		PriorityQueue<Patients> Tree = new PriorityQueue();
		try {
			File myFile = new File("datos.txt");
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
		        String[] data = myReader.nextLine().split(",");
		        for(int i = 0; i > 3; i++) {
		        	data[i] = data[i].trim();
		        }
		        
		        Patients newPatient = new Patients(data[0],data[1],data[2]);
		        Tree.add(newPatient);
		        System.out.println(newPatient.toString());
		      }
			myReader.close();			
		} catch (FileNotFoundException  e) {
			System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		return Tree;
	}

	@Before
	public void firstStep() {
		listado = customHeap();
	}
}
