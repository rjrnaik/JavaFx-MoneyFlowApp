package moneyFlow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		System.out.println("*****************************************************************************************");
		System.out.println("*****************************************************************************************");
		System.out.println("*****************************************************************************************");
		System.out.println("*****MONEY FLOW APP STARTED**************************************************************");
		BorderPane bPane = new BorderPane(); // GUI 1 uses a borderPane withsections divided
		Label lblTitle = new Label("Expense / Income Entry");
		lblTitle.setAlignment(Pos.CENTER);
		bPane.setTop(lblTitle);

		GridPane gPane = new GridPane(); // Grid pane for form control elements
		gPane.setAlignment(Pos.CENTER);
		gPane.setPadding(new Insets(10, 10, 10, 10));
		gPane.setHgap(10);
		gPane.setVgap(10);

		Label lblEntryType = new Label("Entry Type");
		Label lblCurrency = new Label("Currency");
		Label lblAmount = new Label("Amount");
		Label lblCategory = new Label("Category");
		Label lblDate = new Label("Date");
		ComboBox<String> cmbEntryType = new ComboBox<String>();
		cmbEntryType.getItems().addAll("Expense", "Income");
		cmbEntryType.setValue("Expense");
		ComboBox<String> cmbCurrency = new ComboBox<String>();
		cmbCurrency.getItems().addAll("CAD", "EUR", "GBP", "INR", "USD");
		cmbCurrency.setValue("CAD");
		TextField txtAmount = new TextField();
		ComboBox<String> cmbCategory = new ComboBox<String>();
		cmbCategory.getItems().addAll("Bank Deposits / Transfers", "Bills", "Entertainment", "Food & Drinks",
				"Groceries", "Investment", "Misc", "Salary", "Shopping", "Travel");
		cmbCategory.setValue("---Choose category---");
		DatePicker dpDate = new DatePicker();
		dpDate.setValue(java.time.LocalDate.now());
		gPane.add(lblEntryType, 0, 0);
		gPane.add(cmbEntryType, 1, 0);
		gPane.add(lblCurrency, 0, 1);
		gPane.add(cmbCurrency, 1, 1);
		gPane.add(lblAmount, 0, 2);
		gPane.add(txtAmount, 1, 2);
		gPane.add(lblCategory, 0, 3);
		gPane.add(cmbCategory, 1, 3);
		gPane.add(lblDate, 0, 4);
		gPane.add(dpDate, 1, 4);

		bPane.setCenter(gPane);

		Button btnRecord = new Button("Record");
		Button btnStats = new Button("Search");
		Button btnCancel = new Button("Cancel");
		HBox hBox = new HBox(15); // HBOX for the buttons
		hBox.setPadding(new Insets(10, 10, 10, 10));
		hBox.getChildren().add(btnRecord);
		hBox.getChildren().add(btnStats);
		hBox.getChildren().add(btnCancel);
		hBox.setAlignment(Pos.CENTER);
		bPane.setBottom(hBox);

		Scene scene = new Scene(bPane);
		primaryStage.setTitle("MONEY FLOW");
		primaryStage.setScene(scene);
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.show();

		btnRecord.setOnAction(new EventHandler<ActionEvent>() { // use of anonymous innerclass for event handling
			public void handle(ActionEvent e) {
				try {
					if (txtAmount.getText().isEmpty()) {
						throw new Exception("Text field is empty");
					}
					if (cmbCategory.getSelectionModel().getSelectedItem().equalsIgnoreCase("---Choose category---")) {
						throw new Exception("Expense Category is not selected");
					}

					if (cmbEntryType.getValue().equals("Expense")) { // used Math.random * 1010000000 to generate a
																		// txnId
						Expense exp = new Expense("EXP" + ((long) (Math.random() * 10000000)), cmbCurrency.getValue(),
								Double.parseDouble(txtAmount.getText()), dpDate.getValue() + "",
								cmbCategory.getValue());
						String expFilePath = "MoneyFlow/src/resources/" + "ExpenseTrackerSheet.csv";
						exp.captureTransaction(exp, expFilePath);

					} else if (cmbEntryType.getValue().equals("Income")) {
						Income inc = new Income("INC" + ((long) (Math.random() * 10000000)), cmbCurrency.getValue(),
								Double.parseDouble(txtAmount.getText()), dpDate.getValue() + "",
								cmbCategory.getValue());
						String incFilePath = "MoneyFlow/src/resources/" + "IncomeTrackerSheet.csv";
						inc.captureTransaction(inc, incFilePath);
					}
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		});

		btnCancel.setOnAction(new EventHandler<ActionEvent>() { // cancelButton handler

			public void handle(ActionEvent e) {
				primaryStage.close(); // close the GUI 1
			}
		});

		btnStats.setOnAction(new EventHandler<ActionEvent>() { // stats button handler
			public void handle(ActionEvent e) {
				Statistics sc = new Statistics();
				Stage newStage = new Stage();
				sc.start(newStage); // open GUI 2 on click
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
