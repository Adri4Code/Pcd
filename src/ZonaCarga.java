/**
 * Created by adri on 8/03/17.
 *
 */
public class ZonaCarga {
    private int controlCarga;
    private ContenedorAgua aguita;
    private ContenedorGas gasolina;
    private ContenedorGas[] contenedorGasolina= new ContenedorGas[5];
    public ZonaCarga(){

        for (int i = 0; i <contenedorGasolina.length ; i++) {
            this.contenedorGasolina[i]=new ContenedorGas();
        }

    }
    public void controlEntrada(Barcos barcos){
        System.out.println("He llegado a la zona de carga de petroleros "+ barcos.getId());
        if(barcos.getPetrolero()==true ){
            controlCarga++;
            if(controlCarga==5){
                //cargarAgua
                //cargarGas

            }

        }

    }

}
