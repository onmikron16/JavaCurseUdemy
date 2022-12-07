package aulas.aula224.application;

import aulas.aula224.model.entities.CarRental;
import aulas.aula224.model.entities.Vehicle;
import aulas.aula224.model.services.BrazilTaxService;
import aulas.aula224.model.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


        System.out.println("Entre com os dados do aluguel");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();

        System.out.println("Retirada (dd/MM/yyyy hh:mm): ");
        LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);

        System.out.println("retorno (dd/MM/yyyy hh:mm): ");
        LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);


        CarRental cr = new CarRental(start,finish,new Vehicle(carModel));

        System.out.print("Enter com preço por hora: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter com preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay,pricePerHour,new BrazilTaxService());

        rentalService.processIvoice(cr);

        System.out.println("Fatura: ");
        System.out.println("Pagamento basico: " + String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: " + String.format("%.2f",cr.getInvoice().getTax()));
        System.out.println("Pagamento total: " + String.format("%.2f",cr.getInvoice().getTotalPayment()));





        BrazilTaxService taxService = new BrazilTaxService();

        sc.close();
    }
}
