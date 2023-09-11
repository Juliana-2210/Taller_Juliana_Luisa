package persistencia;

import modelo.Apuestas;

import java.util.ArrayList;

public class DAOValorApostado {
    String ruta =  "./src/main/java/ArchivosDatos/DatosApuestas";
    public ArrayList<Apuestas>mostrarDatosApuesta (){
        ArrayList<String>datos = new Archivo().ContenidoArchivo(ruta);
        ArrayList<Apuestas>datosApuesta = new ArrayList<Apuestas>();

        for (int i = 0; i<datos.size(); i++){
           Apuestas a = new Apuestas();
            String linea[] = datos.get(i).split(",");

            a.setId(linea[0]);

          /* Double g = Double.parseDouble(linea[2]);
            a.setGanancias(g);
            Double r = Double.parseDouble(linea[3]);
            a.setResultadoApuesta(r);*/

            datosApuesta.add(a);
        }
        return datosApuesta;
    }
}
