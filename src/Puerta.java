/**
 * Created by adri on 8/02/17.
 */
public class Puerta  {
    public synchronized void entrar(Barcos b){
        for (int i = 0; i <3 ; i++) {
            System.out.println("El Barco "+ b.getId() + " esta entrando");
        }
    }
    public synchronized void salir(Barcos b){
        for (int i = 0; i <3 ; i++)
        System.out.println("El Barco "+ b.getId() + " esta saliendo");
    }
}
