package modelo;

import persistencia.Archivo;

import java.util.Random;
import java.util.Scanner;

public class Juego {

    private Scanner sc;
    public String id;
    public double valorApuesta;
    public  double ganancias;

    public Juego() {
        sc = new Scanner(System.in);
        String ruta = "./src/main/java/ArchivosDatos/DatosApuestas";
        System.out.println("Cuanto quieres apostar");
        valorApuesta = sc.nextDouble();
        String valor = String.valueOf(valorApuesta);

        System.out.println("Tus ganacias fueron de : ...");
        ganancias = 34000;

        double resultado = valorApuesta+ganancias;
        //String ganancias = String.valueOf(resultado);


        String RegistrarApuesta = ("Id: "+"," + "El Valor Apostado fue: "+ valorApuesta+"," + "Ganancias: "+ganancias+","+" Resultado de la Apuesta: "+resultado);
       // String reg2 = (""+ idAp+","+ ""+valor+","+""+ganancias+","+ ganancias+","+resultado );
        System.out.println(RegistrarApuesta);
        new Archivo().crearArchivoAgregarTexto(ruta,RegistrarApuesta);


    }

    public Object crearId(){
        Random r = new Random();
        int idApuesta = r.nextInt(5000)+1;
        String idAp = String.valueOf(idApuesta);

        return idAp;
    }

    public double calcularGananciasDosCoinc(double valorApuesta1){
        double valorGanancias =0;
        valorGanancias = valorApuesta1*0.10;
        double valorGananciaTotal = valorGanancias +valorApuesta1;

        return valorApuesta1;
    }

    public double calcularGananciasTresCoinc(double valorApuesta2){
        double valorGanancias =0;
        valorGanancias = valorApuesta2*0.25;
        double valorGananciaTotal = valorGanancias +valorApuesta2;
        return valorApuesta2;
    }

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getValorApuesta() {
        return valorApuesta;
    }

    public void setValorApuesta(double valorApuesta) {
        this.valorApuesta = valorApuesta;
    }

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }
}
