package principal;

import com.google.gson.*;
import operations.CurrencyConverter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientApi  {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Declaration of Variables
        Scanner read = new Scanner(System.in);
        String targetCurrency;
        String baseCurrency;
        double amount;
        List <CurrencyConverter> currency =  new ArrayList<>();
        CurrencyConverter currencyConverter = new CurrencyConverter();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Escriba la moneda a convertir con sus respectivas siglas:\n" +
                    "1. USD\n" + "2. COP\n" + "3. ARS\n"+ "4. DOP\n"+ "5. CAD\n"+"6. AUD\n"
                    + "Salir\n");
            baseCurrency = read.next().toUpperCase();

            if (baseCurrency.equalsIgnoreCase("salir")) {
                break;
            }

            System.out.println("Ingrese la moneda a la que desea convertir (ej. USD, COP, ARS, DOP, CAD, AUD):");
            targetCurrency = read.next().toUpperCase();

            System.out.println("Ingrese el valor a convertir: ");
            amount = read.nextDouble();

            try {
                double convertedAmount = currencyConverter.convert(amount, baseCurrency, targetCurrency);
                System.out.println(amount + " " + baseCurrency + " son " + convertedAmount + " " + targetCurrency);

            } catch (IOException | InterruptedException e) {
                System.out.println("Error al obtener la moneda de cambio.");
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                read.nextLine();
            }
            System.out.println("------------------------------------------------------------");
            System.out.println("¿Desea realizar otra conversión? (si/no)");
            String continuar = read.next().toLowerCase();
            if (!continuar.equals("si")) {
                break;
            }
        }

        read.close();
        System.out.println(currency);
        FileWriter myDocument = new FileWriter("myDoc.json");
        myDocument.write(gson.toJson(currency));
        myDocument.close();
        System.out.println("Hasta pronto.");

    }

}

