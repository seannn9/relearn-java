package io.github.seannn9;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import io.github.cdimascio.dotenv.Dotenv;

public class CurrencyConverter {
    public static void run(Scanner scanner) {
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("API_KEY");
        do {
            try {
                System.out.println("\nCurrency Converter:");
                System.out.println("See available currency code: https://www.exchangerate-api.com/docs/supported-currencies\n");

                System.out.print("What currency would you like to convert: ");
                String currToConvert = scanner.nextLine().toUpperCase();

                System.out.print("Amount: ");
                double amount = Double.parseDouble(scanner.nextLine());

                System.out.print("Convert to? ");
                String currConvertTo = scanner.nextLine().toUpperCase();

                String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey +"/latest/" + currToConvert;
        
                URI uri = URI.create(urlStr);
                URL url = uri.toURL();
                HttpURLConnection request = (HttpURLConnection) url.openConnection();
                
                JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) request.getContent()));
                JsonObject jsonObj = root.getAsJsonObject();
                JsonObject requestResult = jsonObj.get("conversion_rates").getAsJsonObject();

                double currencyResult = requestResult.get(currConvertTo).getAsDouble();
                double convertedAmount = currencyResult * amount;
                System.out.println(amount + " " + currToConvert + " -> " + (convertedAmount) + " "  + currConvertTo + "\n");
                break;
            } catch (IOException | NullPointerException | NumberFormatException err) {
                System.out.println("Invalid inputs. Try again");
            }
        } while(true);
    }
}
