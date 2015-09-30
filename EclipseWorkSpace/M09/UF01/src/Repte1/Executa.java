package Repte1;


import java.io.IOException;
import java.lang.Runtime;


public class Executa {

	private String cmd;
	private int opt;
	private Process proc;
	
	public Executa (String cmd, int opt) throws IOException, InterruptedException{
		this.cmd = cmd;
		this.opt = opt;
		run();
	}	
	
	// Se inicia el programa llamado
	public void run() throws IOException, InterruptedException{
		Runtime rt = Runtime.getRuntime();
		try{			//Creamos 2 opciones para realizar pruebas de opciones
			if (opt == 1){
				System.out.println("Ejecutando "+ cmd);
				proc = rt.exec(cmd);	
				System.out.println("El proceso se abre ahora");					
				proc.waitFor();
				System.out.println("El proceso se cierra ahora ");
							
			}else if(opt == 2){
				Runtime.getRuntime().exec(cmd);	
			}
			
		}catch (IOException exRun){
			exRun.printStackTrace();
		}
	}

}