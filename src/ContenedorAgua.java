/**
 * Created by adri on 15/03/17.
 */
import java.util.concurrent.Semaphore;
public class ContenedorAgua {
    Semaphore mutex = new Semaphore(1);

    public ContenedorAgua(){}
    public void  cogiendoAgua(Barcos barcos){

        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(barcos + "El barco" + barcos.getId() + "esta cogiendo agua");
        mutex.release();

    }
}
