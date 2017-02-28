/**
 * Created by adri on 8/02/17.
 */

public class Barcos implements Runnable {
    private int direccion;
    private int id;
    private Puerta puerta;
    private TorreDeControl torreDeControl;

    public Barcos(Puerta _puerta, int _direccion, int _id, TorreDeControl torreDeControl) {
        this.puerta = _puerta;
        this.direccion = _direccion;
        this.id = _id;
        this.torreDeControl = torreDeControl;
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
            torreDeControl.permisoEntrada();
            puerta.entrar(this);
            torreDeControl.finEntrada();

        } else {

            torreDeControl.permisoSalida();
            puerta.salir(this);
            torreDeControl.finSalida();

        }
    }
}
