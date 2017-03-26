/**
 * Created by adri on 15/03/17.
 */

import java.util.concurrent.Semaphore;

public class ContenedorAgua {
    Semaphore mutex = new Semaphore(1);
    Semaphore mutexAgua = new Semaphore(1);
    private int cargaAgua = 1000;
    Manguera Agua = new Manguera("Agua", 0);

    public ContenedorAgua() {
        this.cargaAgua = 1000;
    }

    public int getCargaAgua() {
        return this.cargaAgua;
    }

    public void setCargaAgua(int cargaAgua) {
        this.cargaAgua = cargaAgua;
    }

    public synchronized void  cogerAguaManguera(Barcos barcos) {
        this.Agua.start();

        while(this.Agua.getCarga()!=5000){
            barcos.setCargaAgua(this.Agua.getCarga());
            this.Agua.setCarga(0);
        }
        try {
            this.Agua.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //TODO:Simplemente hay que modificar el llenado de los barcos el resto es igual, en vez de hacerlo por
        //los atributos se hacen por threads y fuera

    }

    public void cogiendoAgua(Barcos barcos) {
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El barco" + barcos.getId() + "esta cogiendo agua");

        barcos.setCargaAgua(this.getCargaAgua());
        this.setCargaAgua(0);

        mutex.release();

    }

    public void reponerAgua() {

        this.cargaAgua = 1000;
    }
}
