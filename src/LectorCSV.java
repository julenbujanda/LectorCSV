import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class LectorCSV {

    private static String crearHTML(LinkedList<String[]> datos) {
        String html = "<html\n><head>\n</head>\n<body>\n<table>";
        for (String[] linea : datos) {
            html += "\n<tr>";
            for (int i = 0; i < linea.length - 1; i++) {
                switch (i) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 4:
                        break;
                    default:
                        if (!linea[i + 1].equalsIgnoreCase("n")&&!linea[i].equalsIgnoreCase("v")&&!linea[i].equalsIgnoreCase("n"))
                            html += "\n<td>" + linea[i] + "</td>";
                        break;
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
