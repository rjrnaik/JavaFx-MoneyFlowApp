package moneyFlow;

import java.util.ArrayList;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Statistics extends Application{
	public void start(Stage primaryStage) {

        BorderPane bPane = new BorderPane();
        HBox hBox = new HBox(15);
        hBox.setPadding(new Insets(10, 10, 10, 10));
        Label lblSearchTxn = new Label("Search Transactions");
        ComboBox<String> cmbByTxnType = new ComboBox<String>();
        cmbByTxnType.getItems().addAll("Expense", "Income");
        cmbByTxnType.setValue("---Select Type---");
        ComboBox<String> cmbByPeriod = new ComboBox<String>();
        cmbByPeriod.getItems().addAll("By Month", "By Year", "Last 10 transactions", "All transactions");
        cmbByPeriod.setValue("---Select Period---");
        TextField txtSearch = new TextField();

        hBox.getChildren().addAll(lblSearchTxn, cmbByTxnType, cmbByPeriod, txtSearch);

        bPane.setTop(hBox);

        Button btnSearch = new Button("Search");
        Button btnStats = new Button("Show Statistics");
        Button btnCancel = new Button("Cancel");
        Button btnClear = new Button("Clear");
        HBox hBox2 = new HBox(15);
        hBox2.setPadding(new Insets(10, 10, 10, 10));
        hBox2.getChildren().addAll(btnSearch, btnStats, btnCancel, btnClear);
        bPane.setCenter(hBox2);

        TextArea txtArea = new TextArea();
        txtArea.setMinHeight(720);
        txtArea.setMinWidth(720);
        bPane.setBottom(txtArea);

        Scene scene = new Scene(bPane);
        primaryStage.setTitle("TRANSACTION DETAILS");
        primaryStage.setScene(scene);
        primaryStage.setHeight(480);
        primaryStage.setWidth(720);
        primaryStage.show();

        btnSearch.setOnAction(new EventHandler<ActionEvent>() { // anonymous inner class for event handling
            public void handle(ActionEvent e) {

                ShowGraphs sg = new ShowGraphs();

                Expense exp = new Expense();
                Income inc = new Income();
                ArrayList<String> returnedList = new ArrayList<String>();
                ArrayList<String> returnedList2 = new ArrayList<String>();
                if (cmbByTxnType.getSelectionModel().getSelectedItem() == "Expense") { // Check for expense type
                	String expFilePath = "src/moneyFlow/resources/" + "ExpenseTrackerSheet.csv";
                    System.out.print("Expense");
                    if (cmbByPeriod.getSelectionModel().getSelectedItem() == "By Month") { // Check for By Month filter
                        System.out.println("-By Month");
                        try {
                            returnedList = exp.searchTransaction(expFilePath, txtSearch.getText());
                            for (String rec : returnedList) {
                                txtArea.appendText(rec + "\n");
                            }
                            sg.fetchRecords(returnedList, returnedList2);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }
                    } else if (cmbByPeriod.getSelectionModel().getSelectedItem() == "By Year") {
                        System.out.println("-By Year"); // Check for By Year filter
                        try {
                            returnedList = exp.searchTransaction(expFilePath, txtSearch.getText());
                            for (String rec : returnedList) {
                                txtArea.appendText(rec + "\n");
                            }
                            sg.fetchRecords(returnedList, returnedList2);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }
                    } else if (cmbByPeriod.getSelectionModel().getSelectedItem() == "Last 10 transactions") {
                        System.out.println("-Last 10 transactions"); // check for last 10 txns
                        try {
                            returnedList = exp.searchTransaction(expFilePath, "");
                            ArrayList<String> fetchData = new ArrayList<>();
                            for (int i = returnedList.size(); i > returnedList.size() - 10; i--) {
                                fetchData.add(returnedList.get(i - 1));
                                txtArea.appendText(returnedList.get(i - 1) + "\n");

                            }
                            sg.fetchRecords(fetchData, returnedList2);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }
                    } else {
                        System.out.println("All transactions");
                        try {
                            returnedList = exp.searchTransaction(expFilePath, "");
                            ArrayList<String> fetchData = new ArrayList<>();
                            for (int i = 0; i < returnedList.size(); i++) {
                                fetchData.add(returnedList.get(i));
                                txtArea.appendText(returnedList.get(i) + "\n");
                            }
                            sg.fetchRecords(fetchData, returnedList2);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }

                    }
                } else if (cmbByTxnType.getSelectionModel().getSelectedItem() == "Income") { // Check for income
                    System.out.print("Income");
                    String incFilePath = "src/moneyFlow/resources/" + "IncomeTrackerSheet.csv";
                    if (cmbByPeriod.getSelectionModel().getSelectedItem() == "By Month") { // Check for By Month filter
                        System.out.println("-By Month");
                        try {
                            returnedList = exp.searchTransaction(incFilePath, txtSearch.getText());
                            for (String rec : returnedList) {
                                txtArea.appendText(rec + "\n");
                            }
                            sg.fetchRecords(returnedList2, returnedList);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }
                    } else if (cmbByPeriod.getSelectionModel().getSelectedItem() == "By Year") {
                        System.out.println("-By Year"); // Check for By Year filter
                        try {
                            returnedList = exp.searchTransaction(incFilePath, txtSearch.getText());
                            for (String rec : returnedList) {
                                txtArea.appendText(rec + "\n");
                            }
                            sg.fetchRecords(returnedList2, returnedList);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }
                    } else if (cmbByPeriod.getSelectionModel().getSelectedItem() == "Last 10 transactions") {
                        System.out.println("-Last 10 transactions"); // check for last 10 txns
                        try {
                            returnedList = inc.searchTransaction(incFilePath, "");
                            ArrayList<String> fetchData = new ArrayList<>();
                            for (int i = returnedList.size(); i > returnedList.size() - 10; i--) {
                                txtArea.appendText(returnedList.get(i - 1) + "\n");
                            }
                            sg.fetchRecords(returnedList2, fetchData);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }
                    } else {
                        System.out.println("All transactions");
                        try {
                            returnedList = exp.searchTransaction(incFilePath, "");
                            ArrayList<String> fetchData = new ArrayList<>();
                            for (int i = 0; i < returnedList.size(); i++) {
                                fetchData.add(returnedList.get(i));
                                txtArea.appendText(returnedList.get(i) + "\n");
                            }
                            sg.fetchRecords(returnedList2, fetchData);
                        } catch (Exception ioe) {
                            ioe.getMessage();
                        }

                    }
                } else {
                    System.out.println("Transaction type not selected!!");
                }
            }
        });

        btnStats.setOnAction(new EventHandler<ActionEvent>() { // stats button handler

            public void handle(ActionEvent e) {
                ShowGraphs sg = new ShowGraphs();
                Stage newStage2 = new Stage();
                sg.start(newStage2);
                primaryStage.close();
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() { // Cancel button handler

            public void handle(ActionEvent e) {
                primaryStage.close();
            }
        });

        btnClear.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
                cmbByTxnType.setValue("---Select Type---");
                cmbByPeriod.setValue("---Select Period---");
                txtSearch.setText("");
                txtArea.setText("");

            }
        });
    }
}
