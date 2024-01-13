module MoneyFlow {
	requires javafx.controls;
	
	opens moneyFlow to javafx.graphics, javafx.fxml;
}
