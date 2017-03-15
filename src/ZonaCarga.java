/**
 * Created by adri on 8/03/17.
 */ public class ZonaCarga {
    private int controlCarga;
    private ContenedorAgua aguita;
    private ContenedorGas gasolina;
    private int capacidadAgua;
    private int capacidadGasolina;
    private ContenedorGas[] contenedorGasolina= new ContenedorGas[5];
    public ZonaCarga(){
        capacidadAgua=3000;
        capacidadGasolina=1000;
        for (int i = 0; i <contenedorGasolina.length ; i++) {
            //this.contenedorGasolina[i]=capacidadGasolina;
        }

    }
    public void controlEntrada(Barcos barcos){
        System.out.println("He llegado a la zona de carga de petroleros "+ barcos.getId());
        if(barcos.getPetrolero()==true ){
            controlCarga++;
            if(controlCarga==5){
                cargaPrivadaGas(barcos);
                cargaPublicaAgua(barcos);
            }

        }

    }
    public void restablecerControl(){
        this.controlCarga=0;
    }
     public void cargaPrivadaGas(Barcos barcos){
        int cargaAux=250;
        if(controlCarga==5){

        }
     }
     public void cargaPublicaAgua(Barcos barcos ){
         int cargaAux=500;
        if(controlCarga==5){

        }
     }
     public boolean gasesVacios(){
         boolean vacio= false;
         int aux=0;
         for (int i = 0; i <contenedorGasolina.length ; i++) {

         }
             /*if(contenedorGasolina[i]==0){
                 aux++;
             }
         }
         if(aux==5){
             vacio=true;
         }*/
         return vacio;
     }
     public void rellenarContenedoresGas(){
         if(gasesVacios()){
             for (int i = 0; i <contenedorGasolina.length ; i++) {
               //  this.contenedorGasolina[i]=capacidadGasolina;
             }

         }
     }
}
