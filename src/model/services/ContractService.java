package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.ContractTerm;

public class ContractService {

	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService ops) {
		this.onlinePaymentService = ops;
	}

	public void processContract(Contract ct, int months) {

		double basicQuota = ct.getTotalValue() / months;

		for (int i = 1; i <= months; i++) {
			Date date = addMonths(ct.getDate(), i);
			double updatedQuota = basicQuota + onlinePaymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + onlinePaymentService.paymentFee(updatedQuota);
			ct.addContractTerm(new ContractTerm(date, fullQuota));

		}

	}

	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();

	}
}
