/**
 * UNIVERSIDAD DEL VALLE DE GUATEMALA
 * @author Eunice Mata - 21231
 * Object that simulates the patient for the list heap, it will be inserted as value for the node
 */

package project;

public class Patients implements Comparable<Patients>{
	protected String Name,reason,priority;

	public Patients(String name, String reason, String priority) {
		Name = name;
		this.reason = reason;
		this.priority = priority;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Patients o) {
		return priority.compareTo(o.getPriority());
	}
	
	@Override
	public String toString() {
		return "Paciente: " + this.Name + "\n\tRazon de ingreso: " + this.reason + "\n\tPrioridad: " + this.priority;
	}
	
}
