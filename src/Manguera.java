/**
 * Created by adri on 24/03/17.
 */
public class Manguera extends Thread {
    private String tipo;
    public int carga;


    public Manguera() {
        this.tipo = "";
        this.carga = 0;
    }

    public Manguera(String tipo_, int carga) {
        this.tipo = tipo_;
        this.carga = carga;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo1) {
        this.tipo = tipo1;
    }

    public int getCarga() {
        return this.carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void run() {

        if (this.getTipo() == "Agua") {

            System.out.println("Cargando la manguera de Agua");
            setCarga(this.carga);
            carga += 1000;
            System.out.println(this.getCarga());
            System.out.println("Loading ... Water");

        } else {

            System.out.println("Cargando la manguera de Gas");
            setCarga(this.carga);
            carga += 1000;
            System.out.println(this.getCarga());
            System.out.println("Loading ... Gas ");


        }
    }
}
