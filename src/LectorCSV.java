import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

public class LectorCSV {

    private static String crearHTML(LinkedList<String[]> datos, HashMap<Integer, String> magnitudes) {
        String html = "<html\n><head>\n<meta charset='UTF-8'></head>\n<body>\n<table>";
        for (int x = 0; x < datos.size(); x++) {
            html += "\n<tr>";
            for (int i = 0; i < datos.get(x).length - 1; i++) {
                if (!(datos.get(x)[i].charAt(0) == 'V') && !datos.get(x)[i].equalsIgnoreCase("n") &&
                        (i > 1) && (i != 4) && (i != 3) && !((i >= 5) && (i <= 7)) && (i < 47))
                    html += "\n<td>" + datos.get(x)[i] + "</td>";
                else if (i == 5) {
                    if (x > 0) {
                        html += "<td>" + datos.get(x)[i + 2] + "/" + datos.get(x)[i + 1] + "/" + datos.get(x)[i] + "</td>";
                    } else {
                        html += "<td>FECHA</td>";
                    }
                } else if (i == 3) {
                        try{
                            html += "<td>" + magnitudes.get(Integer.parseInt(datos.get(x)[i])) + "</td>";
                        } catch (NumberFormatException e){
                            html += "\n<td>" + datos.get(x)[i] + "</td>";
                        }

                }

            }
            html += "\n</tr>";
        }
        html += "\n</table>\n</body>\n</html>\n";
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
        LinkedList<String[]> tablaDatos = new LinkedList<>();
        HashMap<Integer, String> tablaMagnitudes = new HashMap<>();
        try {
            BufferedReader bufferDatos = new BufferedReader(new FileReader("horario.csv"));
            BufferedReader bufferMagnitudes = new BufferedReader(new FileReader("magnitudes.csv"));
            while ((strLinea = bufferDatos.readLine()) != null) {
                tablaDatos.add(strLinea.split(";"));
            }
            while ((strLinea = bufferMagnitudes.readLine()) != null) {
                String[] magnitud = strLinea.split(";");
                tablaMagnitudes.put(Integer.parseInt(magnitud[0]), magnitud[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        generarFichero("./", crearHTML(tablaDatos, tablaMagnitudes));
    }

}
