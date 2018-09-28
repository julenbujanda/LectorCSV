import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class LectorCSV {

    private static String crearHTML(LinkedList<String[]> datos) {
        String html = "<html\n><head>\n</head>\n<body>\n<table>";
        for (int x = 0; x < datos.size(); x++) {
            html += "\n<tr>";
            for (int i = 0; i < datos.get(x).length - 1; i++) {
                if (!(datos.get(x)[i].charAt(0) == 'V') && !datos.get(x)[i].equalsIgnoreCase("n") &&
                        (i > 1) && (i != 4) && !((i >= 5) && (i <= 7)) && (i < 47))
                    html += "\n<td>" + datos.get(x)[i] + "</td>";
                else if (i == 5) {
                    if (x > 0) {
                        html += "<td>" + datos.get(x)[i + 2] + "/" + datos.get(x)[i + 1] + "/" + datos.get(x)[i] + "</td>";
                    } else {
                        html += "<td>FECHA</td>";
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
        LinkedList<String[]> tabla = new LinkedList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("horario.csv"));
            while ((strLinea = bufferedReader.readLine()) != null) {
                tabla.add(strLinea.split(";"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        generarFichero("./", crearHTML(tabla));
    }

}
