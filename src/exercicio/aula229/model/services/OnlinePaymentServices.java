package exercicio.aula229.model.services;

public interface OnlinePaymentServices {

    double paymentFee(Double amount);
    double interst(Double amount,Integer months);
}
