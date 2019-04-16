import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Sites[] sites = null;

        try {
            String sitesData = readUrl("https://api.mercadolibre.com/sites");
            sites = new Gson().fromJson(sitesData, Sites[].class);

            for (Sites site : sites){
                System.out.println(site.getName());
            }

        } catch (IOException e) {
            System.out.println("Ocurrio un error al traer las categorias.");
            e.printStackTrace();
        }

        boolean bandera = true;
        String id = "";

        while (bandera){

            System.out.println("\nSeleccione un sitio: ");

            Scanner scanner = new Scanner(System.in);
            String categoria = scanner.nextLine();

            for (Sites site : sites){
                if (site.getName().equals(categoria)){
                    bandera = false;
                    id = site.getId();
                }
            }

        }

        try {
            String data = readUrl("https://api.mercadolibre.com/sites/" + id + "/categories");
            Category[] categories = new Gson().fromJson(data, Category[].class);
            for (Category category : categories){
                System.out.println("\n" + category.getName());
            }
        } catch (IOException e) {
            System.out.println("Ocurrio un error al traer las categorias.");
            e.printStackTrace();
        }
    }

    private static String readUrl(String urlString) throws IOException {

        BufferedReader reader = null;

        try {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            int read = 0;
            StringBuffer buffer = new StringBuffer();
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1){
                buffer.append(chars, 0, read);
            }
            return buffer.toString();

        } finally {
            if (reader != null){
                reader.close();
            }
        }
    }
}
