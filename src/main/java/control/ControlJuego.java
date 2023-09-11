package control;

import modelo.Apuestas;
import persistencia.DAOApuestas;

import java.util.ArrayList;
import java.util.Random;

public class ControlJuego {


    private ArrayList<Apuestas>datosApuestas;
    public ControlJuego() {
        datosApuestas = new DAOApuestas().ApuestasJuego2();

    }
    public String crearId(){
        Random r = new Random();
        int idApuesta = r.nextInt(5000)+1;
        String idAp = String.valueOf(idApuesta);

        return idAp;
    }
    private double calcularPorcentaje1(double valorApostado){
        double calcularGanancia = valorApostado*0.25;
        return calcularGanancia;
    }

    private double calcularPorcentaje2(double valorApostado2){
        double calcularGanancia2 = valorApostado2*0.10;
        return calcularGanancia2;
    }

    public  String mostrarDatosArchivo(){
     /*   String ruta=  "./src/main/java/ArchivoDatos/DatosApuestasTempo";

        System.out.println(new Archivo().ContenidoArchivo(ruta));*/



        for (int i = 0; i<datosApuestas.size(); i++){

           Apuestas a = datosApuestas.get(i);
           String d = datosApuestas.get(i).getId();
            System.out.println(d);
            System.out.println(datosApuestas.get(i).getValorApuesta().toString());

            System.out.println(datosApuestas.get(i).getGanancias().toString());

            System.out.println(datosApuestas.get(i).getResultadoApuesta().toString());

        }
        //System.out.println(pro.ApuestasJuego().size());
        return datosApuestas.toString();


    }



}
