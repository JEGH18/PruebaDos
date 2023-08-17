package model;

import java.util.Calendar;
import java.util.Date;

public class Transaction {

	private Calendar date;
	private double purchaseValue;

	public Transaction(Date date2, double purchaseValue) {

		this.date = date;
		this.purchaseValue = purchaseValue;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(double purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

}
