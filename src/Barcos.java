/**
 * Created by adri on 8/02/17.
 */

public class Barcos implements Runnable {
    private int direccion;
    private int id;
    private Puerta puerta;

    public Barcos(Puerta _puerta, int _direccion, int _id) {
        this.puerta = _puerta;
        this.direccion = _direccion;
        this.id = _id;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id1) {
        this.id = id1;
    }

    public int getDireccion() {
        return this.direccion;
    }

    public void setDireccion(int direccion1) {
        this.direccion = direccion1;
    }

    public void run() {
        if (direccion == 0) {
            puerta.entrar(this);
        } else {
            puerta.salir(this);
        }
    }
}
