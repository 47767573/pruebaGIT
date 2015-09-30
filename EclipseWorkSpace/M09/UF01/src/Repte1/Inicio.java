package Repte1;

public class Inicio {
	
	static String prg = "notepad.exe";
	//String prg = "suma.ccp";
	static int opt  = 1;	//variable que define como ejecutar el programa que pedimos
	static int son = 1;		//hijos de hijos que crearemos antes de ejecutar el programa
	
	
	public static void main(String[] args) {	
	}
	
	/**
	 * El constructor crea tantos procesos hijos de hijos como definamos y el ultimo proceso hijo ejecuta el programa
	 * @param programa el programa que se ejecutará
	 * @param option opciones de como ejecutar el programa
	 * @param hijos numero de procesos hijos de hijos 
	 */
	public Inicio (String programa, int option, int hijos){
		
		this.prg = programa;
		this.opt = option;
		this.son = hijos-1;		
		
		try{		
			if (hijos > 0){
				Inicio hijo = new Inicio (prg, opt, son);			
			
			}else if (hijos <= 0){
				Executa Exe = new Executa(prg, opt);				
			}
		}catch (Exception e){
			e.printStackTrace();
		}		
	}		
}