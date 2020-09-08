package view;

import javax.swing.JOptionPane;

import controller.processController;

public class principal {

	public static void main(String[] args) {
		processController process = new processController();
		String nomeprocess = "";
		String PID = "";
		int op=0;
		while(op!=99){
			op=Integer.parseInt(JOptionPane.showInputDialog("Cadastro\n1 - listar os processos ativos" + "\n2 - Matar processo por PID"  + "\n3 - Matar processo por Nome"  + "\n99 - Sair"));

			switch(op){
			case 1:
				process.processAtivo();
				break;
			case 2:
				PID =(JOptionPane.showInputDialog("Informe o PID do processo a ser finalizado"));
				process.matarPID(PID);
				break;
			case 3:
				nomeprocess =(JOptionPane.showInputDialog("Informe o Nome do processo a ser finalizado"));
				process.matarNome(nomeprocess);
				break;
			case 99:
				JOptionPane.showMessageDialog(null,"Saindo");
				break;	
			default:
				JOptionPane.showMessageDialog(null,"Opção inválida");
			}
		}
	}

}
