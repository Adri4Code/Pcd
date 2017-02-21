/**
 * Created by adri on 8/02/17.
 */
public class Puerta {
    public synchronized void entrar(Barcos b) {
        TorreDeControl t = new TorreDeControl();
        t.permisoEntrada();
        //for (int i = 0; i <3 ; i++)
        System.out.println("El Barco " + b.getId() + " esta entrando");

        t.permisoEntrada();
    }


    public synchronized void salir(Barcos b) {
        TorreDeControl t = new TorreDeControl();
        t.permisoEntrada();
        //for (int i = 0; i <3 ; i++)
        System.out.println("El Barco " + b.getId() + " esta saliendo");
        t.finSalida();
    }
}
