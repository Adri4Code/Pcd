
public class Main {

    public static void main(String[] args) {
        //vector de hilos y luego de vectores entre 0 y 1
        Puerta p = new Puerta();
        TorreDeControl t = new TorreDeControl();
        ZonaCarga z= new ZonaCarga();
        Thread[] threads = new Thread[20];
        Barcos[] barquitos = new Barcos[20];
        for (int i = 0; i < barquitos.length; i++) {

            if (i%2==0 && i<10) {
                barquitos[i] = new Barcos(p, 0, i, t, false,z);
            } else if(i>=10 && i%2==0){
                barquitos[i] = new Barcos(p, 0, i, t, true,z);
            }else {
                barquitos[i]=new Barcos(p,1,i,t,false,z);
            }


            threads[i] = new Thread(barquitos[i]);
        }



      for (int i = 0; i < threads.length; i++) {
            Thread t1 = threads[i];
            t1.start();
        }


    }

}
