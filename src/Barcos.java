/**
 * Created by adri on 8/02/17.
 */

public class Barcos implements Runnable {
    private int direccion;
    private int id;
    private Puerta puerta;
    private TorreDeControl torreDeControl;
    private ZonaCarga zonaDeCarga;
    private boolean petrolero;
    private int cargaAgua;
    private int cargaGasolina;
    public Barcos(){
        this.direccion=-1;
        this.id=-1;
        this.puerta=null;
        this.torreDeControl=null;
        this.petrolero=false;
    }

    public Barcos(Puerta _puerta, int _direccion, int _id, TorreDeControl torreDeControl, boolean _petrolero,ZonaCarga _zonaDeCarga) {
        this.puerta = _puerta;
        this.direccion = _direccion;
        this.id = _id;
        this.torreDeControl = torreDeControl;
        this.petrolero = _petrolero;
        this.zonaDeCarga=_zonaDeCarga;

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

    public boolean getPetrolero() {
        return this.petrolero;
    }

    public void setPetrolero(boolean _petrolero) {
        this.petrolero = _petrolero;
    }
    public int getCargaAgua(){
        return this.cargaAgua;
    }
    public void setCargaAgua(int _cargaAgua){
        if(this.cargaAgua<=5000) {
            this.cargaAgua = _cargaAgua;
        }else{
            System.out.println("La capacidad de agua esta llena");
        }
    }
    public int getCargaGasolina(){
        return this.cargaGasolina;
    }
    public void setCargaGasolina(int _cargaGasolina){
        if(this.cargaGasolina<=3000) {
            this.cargaGasolina = _cargaGasolina;
        }
        else {
            System.out.println("La capacidad de gasoleo esta llena");
        }
    }

    public void run() {
        if (direccion == 0) {
            torreDeControl.permisoEntrada(this);
            puerta.entrar(this);
            torreDeControl.finEntrada(this);
            if(getPetrolero()){
                zonaDeCarga.controlEntrada(this);
            }

        } else {

            torreDeControl.permisoSalida(this);
            puerta.salir(this);
            torreDeControl.finSalida(this);

        }
    }
}
