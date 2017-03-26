import java.util.concurrent.Semaphore;

/**
 * Created by adri on 8/03/17.
 */
public class ZonaCarga {
    private int controlCarga;
    private ContenedorAgua agua;
    private ContenedorGas gasolina;
    private ContenedorGas[] contenedorGasolina = new ContenedorGas[5];
    Semaphore[] salida = new Semaphore[5];
    Semaphore[] entrada = new Semaphore[5];



    public int indice = 0;


    public ZonaCarga() {
        this.controlCarga = 0;
        for (int i = 0; i < 5; i++) {
            this.contenedorGasolina[i] = new ContenedorGas();
            this.entrada[i] = new Semaphore(0);
            this.salida[i] = new Semaphore(1);
        }
        this.agua = new ContenedorAgua();
        this.indice = -1;

    }

    public void controlEntrada(Barcos barcos) {
        if (controlCarga < 4) {

            controlCarga++;
            try {
                this.entrada[controlCarga].acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        for (int i = 0; i < 5; i++) {
            this.entrada[i].release();
        }

        this.llenarBarcos(barcos);

    }

    public void llenarBarcos(Barcos barcos) {

        while (barcos.getCargaGasolina() <= 3000) {
            System.out.println("Comprobando contenedores de gas vacios " + this.comprobarVacio());
            if (comprobarVacio() <= 4) {
                if (barcos.getId() == 10) {
                    this.contenedorGasolina[0].cogerGasManguera(barcos);
                }
                if (barcos.getId() == 12) {
                    this.contenedorGasolina[1].cogerGasManguera(barcos);
                }
                if (barcos.getId() == 14) {
                    this.contenedorGasolina[2].cogerGasManguera(barcos);
                }
                if (barcos.getId() == 16) {
                    this.contenedorGasolina[3].cogerGasManguera(barcos);
                }
                if (barcos.getId() == 18) {

                    this.contenedorGasolina[4].cogerGasManguera(barcos);
                }
            }/* else {
                this.desbloquearBloqueados();

            }*/


        }

        while (barcos.getCargaAgua() <= 5000) {

            this.agua.cogerAguaManguera(barcos);
            //this.agua.reponerAgua();

        }


    }


    public int comprobarVacio() {
        int comprobar = 0;
        for (int i = 0; i < this.contenedorGasolina.length; i++) {
            if (this.contenedorGasolina[i].getCapacidad() == 0) {
                comprobar++;
            }
        }
        return comprobar;
    }

    public void desbloquearBloqueados() {
        for (int i = 0; i < this.contenedorGasolina.length; i++) {
            this.contenedorGasolina[i].desbloquearBloqueados();
        }
    }


}
