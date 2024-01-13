package moneyFlow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Income extends Transaction {
	private String incCategory;

	ArrayList<Income> incomeList = new ArrayList<Income>();

	/**
	 * Param Constructor
	 * 
	 * @param txID
	 * @param currency
	 * @param amount
	 * @param date
	 * @param incCategory
	 */
	public Income(String txID, String currency, double amount, String date, String incCategory) {
		super(txID, currency, amount, date);
		this.incCategory = incCategory;
	}

	/**
	 * Default Constructor
	 */
	public Income() {

	}

	public String getIncCategory() {
		return this.incCategory;
	}

	/**
	 * captureTransaction method inherited from parent, records the data from the
	 * GUI and stores in a delimited file - IncomeTrackerSheet.csv
	 * 
	 * @param inc
	 * @param filePath
	 * @throws IOException
	 */
	public void captureTransaction(Income inc, String filePath) {
		File fileObj = new File(filePath);
		incomeList.add(inc);
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileObj, true)))) {
			for (int j = 0; j < incomeList.size(); j++) {
				Income i = incomeList.get(j);
				pw.print(i.getTxId() + "," + i.getIncCategory() + "," + i.getCurrency() + "," + i.getAmount() + ","
						+ i.getDate() + "\n");
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		System.out.println("Write Successful");
	}

	/**
	 * searchTransaction method is used to search for an income transaction from the
	 * file created based on a search criteria
	 * 
	 * @param filePath
	 * @param searchTerm
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> searchTransaction(String filePath, String searchTerm) {
		ArrayList<String> incList = new ArrayList<String>();
		File fileObj = new File(filePath);
		// int count = 0;
		if (fileObj.exists()) {
			try (Scanner sc = new Scanner(fileObj)) {
				while (sc.hasNextLine()) {
					String incRecord = sc.nextLine();
					String[] incRecArr = incRecord.split(",");
					String[] incRecDate = incRecArr[4].split("-"); // extract the date by split()
					if (!searchTerm.isEmpty()) {
						if (searchTerm.matches("[0-9]+")) { // match the year if searchTerm is numeric
							if (incRecDate[0].equals(searchTerm)) {
								incList.add(incRecord);
							}
						} else {
							switch (searchTerm.toLowerCase()) { // match the month number if the searchTerm is Month
							case "january":

								if (incRecDate[1].equals("01")) {
									incList.add(incRecord);
								}
								break;
							case "february":
								if (incRecDate[1].equals("02")) {
									incList.add(incRecord);
								}
								break;
							case "march":
								if (incRecDate[1].equals("03")) {
									incList.add(incRecord);
								}
								break;
							case "april":
								if (incRecDate[1].equals("04")) {
									incList.add(incRecord);
								}
								break;
							case "may":
								if (incRecDate[1].equals("05")) {
									incList.add(incRecord);
								}
								break;
							case "june":
								if (incRecDate[1].equals("06")) {
									incList.add(incRecord);
								}
								break;
							case "july":
								if (incRecDate[1].equals("07")) {
									incList.add(incRecord);
								}
								break;
							case "august":
								if (incRecDate[1].equals("08")) {
									incList.add(incRecord);
								}
								break;
							case "september":
								if (incRecDate[1].equals("09")) {
									incList.add(incRecord);
								}
								break;
							case "october":
								if (incRecDate[1].equals("10")) {
									incList.add(incRecord);
								}
								break;
							case "november":
								if (incRecDate[1].equals("11")) {
									incList.add(incRecord);
								}
								break;
							case "december":
								if (incRecDate[1].equals("12")) {
									incList.add(incRecord);
								}
								break;
							default:
								incList.add("Invalid Month Value");
								break;

							}
						}
					} else {
						incList.add(incRecord);
						// count++;
					}
				}
				sc.close();
				// System.out.println(count);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.getMessage();
			}
		}
		return incList;
	}

}
