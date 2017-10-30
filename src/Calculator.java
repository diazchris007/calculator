import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {
	TextField txtnum1, txtnum2;
	Button btnadd, btnsub, btnclear;
	Label lblanswer;
	@Override
	public void start(Stage primaryStage) throws Exception {
		txtnum1 = new TextField();
		txtnum2 = new TextField();
		btnadd = new Button("+");
		btnsub = new Button("-");
		btnclear = new Button("Clear");
		lblanswer = new Label("?");
		lblanswer.setAlignment(Pos.CENTER);
		lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		 
		root.add(btnadd, 0, 0);
		root.add(btnsub, 1, 0);
		root.add(txtnum1, 0, 1);
		root.add(txtnum2, 1, 1);
		root.add(lblanswer, 0, 2, 2,1);
		root.add(btnclear, 0, 3, 2,1);
		
		setWidths();
		attachCode();
		Scene scene = new Scene(root, 400,400);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void setWidths(){
		txtnum1.setPrefWidth(70);
		txtnum2.setPrefWidth(70);
		btnadd.setPrefWidth(70);
		btnsub.setPrefWidth(70);
		btnclear.setPrefWidth(150);
		lblanswer.setPrefWidth(150);
		
	}
	public void attachCode(){
		btnadd.setOnAction(e -> btncode(e));
		btnsub.setOnAction(e -> btncode(e));
		btnclear.setOnAction(e -> btncode(e));
	}
	public void btncode(ActionEvent e){
		int num1, num2 = 0;
		float ans =0;
		String symbol = "?";
		OperationFactory oFact = new OperationFactory();
		if(e.getSource() ==btnclear){
			txtnum1.setText("");
			txtnum2.setText("");
			lblanswer.setText("");
			txtnum1.requestFocus();
			return;
		}

		Operation op = oFact.getOperation(((Button)e.getSource()).getText());
		num1=Integer.parseInt(txtnum1.getText());
		num2=Integer.parseInt(txtnum2.getText());
		ans = op.calculate(num1, num2);
		symbol = ((Button)e.getSource()).getText();
		lblanswer.setText("" + num1 + symbol + num2 + "="+ ans);
	}
    public static void main(String[] args) {
        launch(args);
    }
}
