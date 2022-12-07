package exercicio.aula229.model.services;

import exercicio.aula229.model.entities.Contract;
import exercicio.aula229.model.entities.Installment;
import java.time.LocalDate;


public class ContractService {

    private OnlinePaymentServices onlinePaymentService;

    public ContractService(OnlinePaymentServices onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {
        double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i);
            double interest = onlinePaymentService.interst(basicQuota, i);
            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
            double quota = basicQuota + interest + fee;
            contract.getInstallments().add(new Installment(dueDate, quota));
        }
    }
}
