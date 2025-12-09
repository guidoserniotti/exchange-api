import com.google.gson.Gson;
import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Conversor {
    public String convertir(String firstPair, String secondPair){
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        String url = "https://v6.exchangerate-api.com/v6/"+apiKey+"/pair/"+firstPair+"/"+secondPair;
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ExchangeRateResponse exchangeRate = gson.fromJson(response.body(), ExchangeRateResponse.class);

            if (!exchangeRate.getResult().equals("success")) {
                return "Error en la consulta de la API";
            }

            System.out.print("Ingrese la cantidad de " + firstPair.toUpperCase() + " a convertir: ");
            Scanner scanner = new Scanner(System.in);
            double cantidad = Integer.valueOf(scanner.nextLine());
            double resultado = cantidad * exchangeRate.getConversionRate();

            return "El valor " + cantidad + " " + firstPair.toUpperCase() + " equivale a " + resultado + secondPair.toUpperCase();

        } catch(Exception err){
            return err.getMessage();
        }
    }
}
