package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.ContractTerm;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date(dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract Value: ");
		double totalValue = sc.nextDouble();

		Contract ct = new Contract(number, date, totalValue);

		System.out.println("Enter number of installments");
		int n = sc.nextInt();

		ContractService cService = new ContractService(new PaypalService());

		cService.processContract(ct, n);
		
		System.out.println("Installments: ");
		for (ContractTerm x : ct.getCTerm()) {
			System.out.println(x);
		}

		sc.close();
	}
}
