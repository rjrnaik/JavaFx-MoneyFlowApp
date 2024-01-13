package moneyFlow;

import java.util.ArrayList;

/**
 * Parent class for defining the characteristics of a Transaction
 *
 * @author Rajrishi Naik
 */
public class Transaction {

	private String txID;
	private String currency;
	private double amount;
	private String date;

	/**
	 * Param constructor
	 * 
	 * @param txID
	 * @param currency
	 * @param amount
	 * @param date
	 */
	public Transaction(String txID, String currency, double amount, String date) {
		this.txID = txID;
		this.currency = currency;
		this.amount = amount;
		this.date = date;
	}

	/**
	 * Default constructor
	 */
	public Transaction() {
		this("TID00000000", "CAD", 0.0, java.time.LocalDate.now() + "");
	}

	public void setTxID(String txID) {
		this.txID = txID;
	}

	public String getCurrency() {
		return this.currency;
	}

	public double getAmount() {
		return this.amount;
	}

	public String getDate() {
		return this.date;
	}

	public String getTxId() {
		return this.txID;
	}

	public void captureTransaction() { // method implemented in child classes
		// do nothing
	}

	public ArrayList<String> searchTransaction() {
		// do nothing
		ArrayList<String> txnList = new ArrayList<>();
		return txnList;
	}

}
