package persistencia;
import modelo.Apuestas;
import java.util.ArrayList;

public class DAOApuestas {

    public ArrayList<Apuestas>ApuestasJuego(){
        String ruta  = "./src/main/java/ArchivosDatos/DatosApuestas";
        ArrayList<String>Datos = new Archivo().ContenidoArchivo(ruta);
        ArrayList<Apuestas> ApuestasTragamonedas = new ArrayList<>();
        for (int i = 0; i<Datos.size(); i++) {
            Apuestas a = new Apuestas();
            String fila[] = Datos.get(i).split(",");
            a.setId(fila[0]);
            a.setValorApuesta(fila[1]);
            a.setGanancias(fila[2]);
            a.setResultadoApuesta(fila[3]);

        }
        return ApuestasTragamonedas;
    }

    public ArrayList<Apuestas>ApuestasJuego2(){
        String ruta  = "./src/main/java/ArchivosDatos/DatosApuestasTempo";
        ArrayList<String>Datos = new Archivo().ContenidoArchivo(ruta);
        ArrayList<Apuestas> ApuestasTragamonedas = new ArrayList<>();
        for (int i = 0; i<Datos.size(); i++) {
            Apuestas a = new Apuestas();
            String fila[] = Datos.get(i).split(",");
            a.setId(fila[0]);
            a.setValorApuesta(fila[1]);
            a.setGanancias(fila[2]);
            a.setResultadoApuesta(fila[3]);
            a.getId().toString();
            a.getValorApuesta().toString();
            a.getGanancias().toString();
            a.getResultadoApuesta().toString();

        }


        return ApuestasTragamonedas;
    }
}
