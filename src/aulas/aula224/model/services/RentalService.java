package aulas.aula224.model.services;

import aulas.aula224.model.entities.CarRental;
import aulas.aula224.model.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private TaxService taxService;
    public RentalService(Double pricePerDay, Double pricePerHour,TaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    }
    public void processIvoice(CarRental carRental){

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60d;

        double basicPayment;
        if(hours <= 12d){
            basicPayment = pricePerHour * Math.ceil(hours);
        }else {
            hours = hours / 24;
            basicPayment = pricePerDay * Math.ceil(hours);
        }
        System.out.println(pricePerHour);
        double tax = taxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment,tax));
    }







}
