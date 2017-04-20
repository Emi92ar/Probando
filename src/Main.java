import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;
/**
 * Clase principal que se ejecutará
 * @author emibe
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Thread threads[] = new Thread[10];
		Thread.State status[] = new Thread.State[10];
		for (int i = 0; i <10 ; i++){
			threads[i] = new Thread(new Calculator(i));
			if((i%2) == 0){
				threads[i].setPriority(Thread.MAX_PRIORITY);
			}
			else{
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			threads[i].setName("Thread " +i);
		}
		try (FileWriter file = new FileWriter("D:\\BORRALO.txt");
				PrintWriter pw = new PrintWriter(file);){
			for(int i = 0; i < 10 ; i++){
				pw.println("Main : Status of Thread " +i+" : " + threads[i].getState());
				status[i] = threads[i].getState();			
				}
			for(int i = 0; i <10 ; i++){
				threads[i].start();
				pw.println("Main : Status of Thread " +i+" : " + threads[i].getState());
			}
			boolean finish = false;
			while(!finish){
				for(int i = 0; i<2.; i++){
					if(threads[i].getState() != status[i]){
						writeThreadInfo(pw, threads[i], status[i]);
						status[i] = threads[i].getState();
					}
				}
				finish = true;
				for(int i = 0; i < 10; i++){
					finish = finish &&(threads[i].getState() == State.TERMINATED);
				}
			}
		}
				
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state){
		pw.printf("\nMain : Id %d - %s", thread.getId(), thread.getName());
		pw.println("\n");
		pw.printf("\nMain : Priority %d", thread.getPriority());
		pw.println("\n");
		pw.printf("\nMain : Old State %s", state);
		pw.println("\n");
		pw.printf("\nMain : New State- %s", thread.getState());
		pw.println("\n");
		pw.printf("\nMain :**********************");
		pw.println("\n");
	}
}
