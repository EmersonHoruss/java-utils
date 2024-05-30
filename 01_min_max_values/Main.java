import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] annotations = {
            "@Size(min = 3, max = 4)",
            "@Size( min = 3, max = 4)",
            "@Size( min = 3, max = 4 )",
            "@Size(max = 4)",
            "@Size(min = 3)"
        };

        // Expresión regular para capturar los números junto con 'min' y 'max'
        Pattern pattern = Pattern.compile("\\b(min|max)\\s*=\\s*(\\d+)");

        // Lista para almacenar los resultados
        List<String> results = new ArrayList<>();

        // Procesar cada anotación
        for (String annotation : annotations) {
            Matcher matcher = pattern.matcher(annotation);
            while (matcher.find()) {
                // Añadir 'min' o 'max' y el número encontrado a la lista de resultados
                String type = matcher.group(1); // 'min' o 'max'
                String number = matcher.group(2); // El número
                results.add(type + ": " + number);
            }
        }

        // Mostrar los resultados
        for (String result : results) {
            System.out.println(result);
        }
    }
}
