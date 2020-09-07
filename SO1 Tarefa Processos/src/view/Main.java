package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {
	
	public static void main(String[] args) {
		RedesController redController = new RedesController();
		
		String os = redController.os();
		int opc = 0;
		while (opc!=9){
			opc=Integer.parseInt(JOptionPane.showInputDialog("insira comando\n 1-ipconfig\n 2-ping test	\n 9-finalizar\n "));
			switch (opc) {
			
			case 1:
				redController.ipConfig(os);
				break;
			case 2:
				redController.pingTest(os);
				break;
			default: System.out.println("opc invalida");
				break;
			case 9:System.out.println("operação finalizada");
				break;
			}
	
		}
	}
}