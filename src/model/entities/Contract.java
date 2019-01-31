package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	
	private Integer number;
	private Date date;
	private Double totalValue;

	private List<ContractTerm> cTerm = new ArrayList<>();

	
	public Contract() {
	}

	public Contract(Integer number, Date date, Double totalValue) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public List<ContractTerm> getCTerm(){
		return cTerm;
	}
	
	public void addContractTerm(ContractTerm contractTerm) {
		cTerm.add(contractTerm);
	}
	public void removeContractTerm(ContractTerm contractTerm) {
		cTerm.remove(contractTerm);
	}
}