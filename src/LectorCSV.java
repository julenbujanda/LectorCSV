import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class LectorCSV {

    private static String crearHTML(LinkedList<String[]> datos) {
        String html = "<html><head></head><body><table>";
        for (String[] linea : datos) {
            html += "<tr>";
            for (String columna : linea) {
                html += "<td>" + columna + "</td>";
            }
            html += "</tr>";
        }
        html += "</table></body></html>";
        return html;
    }

    private static void generarFichero(String ruta, String html_pagina) {
        String nombre_fichero = "horario.html";
        try {
            FileWriter fw = new FileWriter(ruta + nombre_fichero, false);
            fw.write(html_pagina);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String strLinea;
        LinkedList<String[]> tabla = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("horario.csv"));
            while ((strLinea = bufferedReader.readLine()) != null) {
                tabla.add(strLinea.split(";"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        generarFichero("./",crearHTML(tabla));
    }

}
