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
		int op1 = 0;
		
		System.out.println("Elija una implementacion de Heap: \n 1. Custom Heap (mio :D) \n 2. Priority Queue JavaFramework\n");
		op1 = tec.nextInt();
		
		String menu = "Elija una accion: \n 1. Ver listado \n 2. Ingresar Paciente \n 3. Atender Paciente con mayor prioridad \n 4. Salir\n";
		boolean stillMenu = true;

		String name = "";
		String reason = "";
		String priority = "";
		if(op1 == 1) {
			Heap<Patients> listado = customHeap();
			while(stillMenu) {
				System.out.println(menu);
				int op2 = tec.nextInt();
				switch (op2) {
				case 1:
					listado.printTree();
					break;
				case 2:

					System.out.println("Ingrese el nombre\n");
					name = tec.nextLine();
					System.out.println("Ingrese la rason de hospitaliazcion\n");
					reason = tec.nextLine();
					System.out.println("Ingrese la prioridad de atencion\n");
					priority = tec.nextLine();
					
					listado.insert(new Patients(name, reason, priority));

					listado.printTree();
					break;
				case 3:
					listado.printTree();
					listado.remove();
					listado.printTree();
					break;
				case 4:
					stillMenu = false;
					break;

				default:
					System.out.println("Elija una de las opciones disponibles");
					break;
				}
			}
		}
		else if(op1 == 2) {
			PriorityQueue<Patients> listado = JavaFrameworksHeap();
			while(stillMenu) {
				System.out.println(menu);
				int op2 = tec.nextInt();
				switch (op2) {
				case 1:
					System.out.println("Priority queue: ");
					
					Iterator iterador = listado.iterator();
					 
			        while (iterador.hasNext()) {
			            System.out.println(iterador.next());
			        }
				
					break;
				case 2:
					System.out.println("Ingrese el nombre\n");
					name = tec.nextLine();
					System.out.println("Ingrese la rason de hospitaliazcion\n");
					reason = tec.nextLine();
					System.out.println("Ingrese la prioridad de atencion\n");
					priority = tec.nextLine();
					
					listado.add(new Patients(name, reason, priority));

					break;
				case 3:
					System.out.println("------ Paciente atendido ------ \n" + listado.peek().toString());
					listado.poll();
					Iterator meh = listado.iterator();
			        while (meh.hasNext()) {
			            System.out.println(meh.next());
			        }
					break;
				case 4:
					stillMenu = false;
					break;

				default:
					System.out.println("Elija una de las opciones disponibles");
					break;
				}
			}
		}
		else {
			System.out.println("No selecciono una de las opciones disponibles");
		}
		
	}
	
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

}
