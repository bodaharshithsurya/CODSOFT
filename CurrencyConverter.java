import java.util.Scanner;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Client client = ClientBuilder.newClient();

        System.out.print("Enter the base currency code (e.g., USD, EUR): ");
        String baseCurrency = scanner.nextLine();

        System.out.print("Enter the target currency code (e.g., USD, EUR): ");
        String targetCurrency = scanner.nextLine();

        System.out.print("Enter the amount to convert: ");
        double amount = scanner.nextDouble();

        String apiUrl = "https://api.exchangeratesapi.io/latest?base=" + baseCurrency;
        String response = client.target(apiUrl)
                .request(MediaType.APPLICATION_JSON)
                .get(String.class);

        // Parse the JSON response to extract the exchange rate
        // (You'll need a JSON parsing library like Gson or Jackson)
        // Assuming you have a method called parseExchangeRate() to extract the rate
        double exchangeRate = parseExchangeRate(response, targetCurrency);

        double convertedAmount = amount * exchangeRate;

        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
    }

    // Example using Gson to parse the JSON response
    private static double parseExchangeRate(String response, String targetCurrency) {
        // Assuming the response is in the following format:
        // {"base":"USD","date":"2023-11-10","rates":{"AED":3.6725,"AFN":83.1000,"ALL":136.6800,...}}
        com.google.gson.JsonObject jsonObject = com.google.gson.JsonParser.parseString(response).getAsJsonObject();
        com.google.gson.JsonObject rates = jsonObject.getAsJsonObject("rates");
        return rates.get(targetCurrency).getAsDouble();
    }
}