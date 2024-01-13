package moneyFlow;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;


public class ShowGraphs extends Application {
	public static ArrayList<String> extractedData = new ArrayList<>();
	public static ArrayList<String> totalledData = new ArrayList<>();

	public void fetchRecords(ArrayList<String> expData, ArrayList<String> incData) {
		ArrayList<String> chartData = new ArrayList<>();

		if (expData.size() == 0) {
			chartData = incData;

		} else if (incData.size() == 0) {
			chartData = expData;

		}
		for (String data : chartData) {
			System.out.println("Data" + data);
			String[] extStr = data.split(",");
			extractedData.add(extStr[1]);
			extractedData.add(extStr[3]);
		}
		double totalBills = 0;
		double totalEntertainment = 0;
		double totalFood = 0;
		double totalGroceries = 0;
		double totalMisc = 0;
		double totalShopping = 0;
		double totalTravel = 0;
		double totalbankDepo = 0;
		double totalInvestment = 0;
		double totalSalary = 0;
		for (int i = 0; i < extractedData.size() - 1; i++) {
			System.out.println(extractedData.get(i) + "," + extractedData.get(i + 1));
			if (extractedData.get(i).equals("Bills")) {
				totalBills += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Entertainment")) {
				totalEntertainment += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Food & Drinks")) {
				totalFood += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Groceries")) {
				totalGroceries += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Misc")) {
				totalMisc += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Shopping")) {
				totalShopping += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Travel")) {
				totalTravel += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Bank Deposit / Transfers")) {
				totalbankDepo += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Investment")) {
				totalInvestment += Double.parseDouble(extractedData.get(i + 1));
			} else if (extractedData.get(i).equals("Salary")) {
				totalSalary += Double.parseDouble(extractedData.get(i + 1));
			}
		}
		totalledData.add("Bills");
		totalledData.add("" + totalBills);
		totalledData.add("Entertainment");
		totalledData.add("" + totalEntertainment);
		totalledData.add("Food & Drinks");
		totalledData.add(("" + totalFood));
		totalledData.add("Groceries");
		totalledData.add(("" + totalGroceries));
		totalledData.add("Misc");
		totalledData.add("" + totalMisc);
		totalledData.add("Shopping");
		totalledData.add(("" + totalShopping));
		totalledData.add("Travel");
		totalledData.add("" + totalTravel);
		totalledData.add("Bank Deposit / Transfers");
		totalledData.add(("" + totalbankDepo));
		totalledData.add("Investment");
		totalledData.add("" + totalInvestment);
		totalledData.add("Salary");
		totalledData.add("" + totalSalary);
		//System.out.println("totalledData.size()-" + totalledData.size());
		// return extractedData;
	}

	public void start(Stage primaryStage) {
		// BorderPane bPane = new BorderPane();

		/*
		 * PieChart.Data pied[] = new PieChart.Data[20]; String status[] = new
		 * String[totalledData.size()]; double values[] = new
		 * double[totalledData.size()]; for (int i = 0; i < totalledData.size() / 2;
		 * i++) { status[i] = totalledData.get(i * 2); // values[i] =
		 * Double.parseDouble(totalledData.get(i + 1)); } for (int i = 0; i <
		 * totalledData.size() / 2; i++) { values[i] =
		 * Double.parseDouble(totalledData.get(i * 2 + 1)); // j++; } /* for (int k = 0;
		 * k < totalledData.size() / 2; k++) { pied[k] = new PieChart.Data(status[k],
		 * values[k]); }
		 * 
		 * 
		 * pied[0] = new PieChart.Data(status[0], values[0]);
		 * System.out.println("status[0]" + status[0]); System.out.println("values[0]" +
		 * values[0]); /*
		 */
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
				new PieChart.Data(totalledData.get(0), Double.parseDouble(totalledData.get(1))),
				new PieChart.Data(totalledData.get(2), Double.parseDouble(totalledData.get(3))),
				new PieChart.Data(totalledData.get(4), Double.parseDouble(totalledData.get(5))),
				new PieChart.Data(totalledData.get(6), Double.parseDouble(totalledData.get(7))),
				new PieChart.Data(totalledData.get(8), Double.parseDouble(totalledData.get(9))),
				new PieChart.Data(totalledData.get(10), Double.parseDouble(totalledData.get(11))),
				new PieChart.Data(totalledData.get(12), Double.parseDouble(totalledData.get(13))),
				new PieChart.Data(totalledData.get(14), Double.parseDouble(totalledData.get(15))),
				new PieChart.Data(totalledData.get(16), Double.parseDouble(totalledData.get(17))),
				new PieChart.Data(totalledData.get(18), Double.parseDouble(totalledData.get(19))));

		PieChart pieChart = new PieChart(pieChartData);
		pieChart.setTitle("Categorical View");
		pieChart.setClockwise(true);
		pieChart.setLabelLineLength(50);
		pieChart.setLabelsVisible(true);
		pieChart.setStartAngle(180);

		Group root = new Group(pieChart);

		Scene scene = new Scene(root, 480, 480);
		primaryStage.setTitle("GRAPHICAL VIEW");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
}
