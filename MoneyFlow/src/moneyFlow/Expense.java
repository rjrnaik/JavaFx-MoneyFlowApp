package moneyFlow;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Expense extends Transaction {
	private String expCategory;

    ArrayList<Expense> expenseList = new ArrayList<Expense>();

    /**
     * Param constructor
     * 
     * @param txID
     * @param currency
     * @param amount
     * @param date
     * @param expCategory
     */
    public Expense(String txID, String currency, double amount, String date, String expCategory) {
        super(txID, currency, amount, date);
        this.expCategory = expCategory;
    }

    /**
     * Default Constructor
     */
    public Expense() {

    }

    public String getExpCategory() {
        return this.expCategory;
    }

    public void addExpense(Expense exp) {
        expenseList.add(exp);
    }

    /**
     * captureTransaction records the data from the GUI and stores it in a delimited
     * file - ExpenseTrackerSheet.csv
     * 
     * @param exp
     * @param filePath
     * @throws IOException
     */
    public void captureTransaction(Expense exp, String filePath) {
        File fileObj = new File(filePath);
        expenseList.add(exp);

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileObj, true)))) {
            for (int i = 0; i < expenseList.size(); i++) {
                Expense e = expenseList.get(i);
                pw.print(e.getTxId() + "," + e.getExpCategory() + "," + e.getCurrency() + ","
                        + e.getAmount() + "," + e.getDate() + "\n");
            }
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        System.out.println("Write Successful");
    }

    /**
     * searchTransaction method searches for expenses in the delimited file created
     * based on a search filter
     * 
     * @param filePath
     * @param searchTerm
     * @return
     * @throws IOException
     */
    public ArrayList<String> searchTransaction(String filePath, String searchTerm) {
        ArrayList<String> expList = new ArrayList<String>();
        File fileObj = new File(filePath);

        // int count = 0;
        if (fileObj.exists()) {
            try (Scanner sc = new Scanner(fileObj)) {
                while (sc.hasNextLine()) {
                    String expRecord = sc.nextLine();
                    String[] expRecArr = expRecord.split(",");
                    String[] expRecDate = expRecArr[4].split("-"); // extract the date
                    if (!searchTerm.isEmpty()) { // if seachTerm is numeric, match it with the year
                        if (searchTerm.matches("[0-9]+")) {
                            if (expRecDate[0].equals(searchTerm)) {
                                expList.add(expRecord); // add matching records to expList
                            }
                        } else { // if SerchTerm is non numeric, check the month value
                            switch (searchTerm.toLowerCase()) {
                                case "january":

                                    if (expRecDate[1].equals("01")) { // extract month bit
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "february":
                                    if (expRecDate[1].equals("02")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "march":
                                    if (expRecDate[1].equals("03")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "april":
                                    if (expRecDate[1].equals("04")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "may":
                                    if (expRecDate[1].equals("05")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "june":
                                    if (expRecDate[1].equals("06")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "july":
                                    if (expRecDate[1].equals("07")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "august":
                                    if (expRecDate[1].equals("08")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "september":
                                    if (expRecDate[1].equals("09")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "october":
                                    if (expRecDate[1].equals("10")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "november":
                                    if (expRecDate[1].equals("11")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                case "december":
                                    if (expRecDate[1].equals("12")) {
                                        expList.add(expRecord);
                                    }
                                    break;
                                default:
                                    expList.add("Invalid Month Value");
                                    break;
                            }
                        }

                    } else {
                        expList.add(expRecord);
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
        return expList;
    }

}
