package principal;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        //declaration of variables
        Scanner read = new Scanner(System.in);
        int option = 0;
        int main=0;

        //while loop for client view
        while(option!= 7){
            System.out.println("____________________________________________________");
            System.out.println("Elije la moneda que deseas convertir");
            System.out.println("1. USD");
            System.out.println("2. COP");
            System.out.println("3. ARS");
            System.out.println("4. CAD");
            System.out.println("5. AUD");
            System.out.println("6. DOP");
            System.out.println("Salir");
            System.out.println("____________________________________________________");


            if (read.hasNextInt()){
                option = read.nextInt();
            }else {
                System.out.println("Numero invalido");
                read.next();
                continue;
            }

            switch (option){
                case 1:
                    System.out.println("____________________________________________________");
                    System.out.println("Ingresa el valor a convertir de Dolar a Peso Colombiano");
                    if (read.hasNextDouble()){
                        double dollar= read.nextDouble();
                    }
            }
        }
    }
}