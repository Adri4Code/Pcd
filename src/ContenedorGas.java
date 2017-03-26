import java.util.concurrent.Semaphore;

/**
 * Created by adri on 15/03/17.
 */
public class ContenedorGas {
    private int capacidad = 1000;
    Semaphore mutex = new Semaphore(1);
    Semaphore bloqueo = new Semaphore(0);
    Manguera mangueraGas = new Manguera("Gas",0);

    public ContenedorGas() {
        this.capacidad = 1000;

    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public void setCapacidad(int capacidad1) {
        this.capacidad = capacidad1;
    }

    public synchronized void cogerGasManguera(Barcos barcos) {
        this.mangueraGas.start();
        if(this.mangueraGas.getCarga()==3000){
            barcos.setCargaGasolina(this.mangueraGas.getCarga());
            this.mangueraGas.setCarga(0);
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    //Coger gas con semaforos
    public void cogerGas(Barcos barcos) {
        if (barcos.getPetrolero()) {

            try {
                mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("El barco " + barcos.getId() + " esta cogiendo gas");
            barcos.setCargaGasolina(getCapacidad());
            this.capacidad = 0;
            mutex.release();
            try {
                this.mutex.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void desbloquearBloqueados() {
        this.reponerGas();
        this.mutex.release();

    }


    public void reponerGas() {
        this.capacidad = 1000;
    }

}
