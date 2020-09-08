package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;



public class processController {
	
	
	public processController() {
		super();
	}
	
	public String os() {
		String os = System.getProperty("os.name");
		return os;
	
	}
	
	public void processAtivo () {
		String listaProcessos = "";
		String os = os();
		
		if (os.contains("Windows")) {
			  listaProcessos = "TASKLIST /FO TABLE";
		  }
		  else if (os.contains("Linux")) {
			  listaProcessos = "ipconfig";
		  }
	    try {
			Process ip = Runtime.getRuntime().exec(listaProcessos);
			InputStream fluxo = ip.getInputStream();
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
		    String linha = buffer.readLine();
		    while (linha != null) {
		    	System.out.println(linha);
		    	linha = buffer.readLine();
		    }
		    buffer.close();
		    leitor.close();
		    fluxo.close();
		    
	    } catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void matarPID(String PID) {
		String ComandoPID = "";
		String os = os();
	    
		if (os.contains("Windows")) {
			ComandoPID = "TASKKILL /PID ";
		  }
		  else if (os.contains("Linux")) {
			  ComandoPID = "ipconfig";
		  } 
		ComandoPID+= PID;
	try {
		Runtime.getRuntime().exec(ComandoPID);
	} catch (IOException e) {
		
		System.out.println("PID invalido");
	}
		
	}
	
	public void matarNome(String Nome) {
		String ComandoNome = "";
		String os = os();
		if (os.contains("Windows")) {
			ComandoNome = "TASKKILL /PID";
		  }
		  else if (os.contains("Linux")) {
			  ComandoNome = "ipconfig";
		  }
		if (os.contains("Windows")) {
			ComandoNome = "TASKKILL /PID ";
		  }
		  else if (os.contains("Linux")) {
			  ComandoNome = "ipconfig";
		  } 
		ComandoNome+= Nome;
	try {
		Runtime.getRuntime().exec(ComandoNome);
	} catch (IOException e) {
		
		System.out.println("Nome invalido");
	}
	}
}
