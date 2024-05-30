import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    private static final Pattern ZIP_PATTERN = Pattern.compile("^.*\\.zip$");

    public static boolean isValidZipFile(String fileName) {
        if (fileName == null) {
            return false;
        }
        Matcher matcher = ZIP_PATTERN.matcher(fileName);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("example.zip" + " -> " + isValidZipFile("example.zip")); // true
        System.out.println("example.txt" + " -> " + isValidZipFile("example.txt")); // false
        System.out.println("example.zip.txt" + " -> " + isValidZipFile("example.zip.txt")); // false
        System.out.println("example.zip " + " -> " + isValidZipFile("example.zip ")); // false
        System.out.println("example" + " -> " + isValidZipFile("example")); // false
    }
}
