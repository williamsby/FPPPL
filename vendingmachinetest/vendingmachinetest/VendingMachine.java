import javax.swing.*;

public class VendingMachine { 
	public static void main(String args[]) {
		BuildMachine(); 
	} 

	public static void BuildMachine() {
		JFrame VendingMachine = new VendingMachineUI();
		VendingMachine.show(); 
	} 

} 