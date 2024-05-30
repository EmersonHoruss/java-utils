import java.io.*;
import java.util.zip.*;

public class Main {

    public static void main(String[] args) {
        String sourceFolder = "file_to_zip"; // Cambia esto a la ruta de tu carpeta
        String zipFileName = "archivo.zip"; // Nombre del archivo ZIP a crear

        try {
            // Crear el flujo de salida para el archivo ZIP
            FileOutputStream fos = new FileOutputStream(zipFileName);
            ZipOutputStream zos = new ZipOutputStream(fos);

            // Obtener la carpeta a comprimir
            File folderToZip = new File(sourceFolder);

            // Comenzar a comprimir la carpeta
            zipFolder(folderToZip, folderToZip.getName(), zos);

            // Cerrar los flujos
            zos.close();
            fos.close();
            System.out.println("La carpeta ha sido empaquetada en un archivo ZIP.");
        } catch (IOException e) {
            System.err.println("Error al empaquetar la carpeta: " + e.getMessage());
        }
    }

    private static void zipFolder(File folder, String parentFolder, ZipOutputStream zos) throws IOException {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                // Llamada recursiva para manejar subdirectorios
                zipFolder(file, parentFolder + "/" + file.getName(), zos);
            } else {
                // Crear una nueva entrada ZIP para cada archivo
                String entryName = parentFolder + "/" + file.getName();
                ZipEntry zipEntry = new ZipEntry(entryName);
                zos.putNextEntry(zipEntry);

                // Leer el archivo y escribirlo en la entrada ZIP
                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }
                }

                // Cerrar la entrada ZIP actual
                zos.closeEntry();
            }
        }
    }
}
