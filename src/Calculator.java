import java.util.Random;
/**
 * Esta clase implementa la interface Runnable que va a ser instanciada cuando 
 * sea ejecutada por un hilo
 * @author emibe
 * @version 20/04/2017
 */

public class Calculator implements Runnable {
	//campos de la clase
	private int number;
	/**
	 * Constructor de la clase para calcular valores
	 * @param number Recibe el numero con el cual cada hilo realizara la cuenta
	 */
	public Calculator(int number){
		this.number = number;
	}
	/**
     * Método que genera la serie de números aleatorios
     */
	public void generarSerieDeAleatorios () {
        Random numAleatorio;
        numAleatorio = new Random ();
    } //Cierre del método
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++){
			System.out.printf("blabla%s_ %d * %d = %d \n", Thread.currentThread().getName(), number, i, i*number);
		}
	}
	/**
     * Método que genera devuelve el valor de number
     * @return number 
     */
	public int getNumer(){
		return number;
	}
}
