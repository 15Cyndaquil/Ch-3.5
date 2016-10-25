import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Switch extends Application{

	@Override
	public void start(Stage primaryStage){

	GridPane grid = new GridPane();
	ColumnConstraints column1 = new ColumnConstraints();
	ColumnConstraints column2 = new ColumnConstraints();
	ColumnConstraints column3 = new ColumnConstraints();
	ColumnConstraints column4 = new ColumnConstraints();
	ColumnConstraints column5 = new ColumnConstraints();
	
	column1.setPercentWidth(20);
	column2.setPercentWidth(20);
	column3.setPercentWidth(20);
	column4.setPercentWidth(20);
	column5.setPercentWidth(20);

	grid.getColumnConstraints().add(column1);
	grid.getColumnConstraints().add(column2);
	grid.getColumnConstraints().add(column3);
	grid.getColumnConstraints().add(column4);
	grid.getColumnConstraints().add(column5);


	RowConstraints row1 = new RowConstraints();
	RowConstraints row2 = new RowConstraints();

	row1.setPercentHeight(50);
	row2.setPercentHeight(50);

	grid.getRowConstraints().add(row1);
	grid.getRowConstraints().add(row2);
	
	grid.setVgap(5);
	grid.setHgap(5);

	Label output = new Label("How?!");
	output.setStyle("-fx-font-size: 15px;");
	GridPane.setColumnSpan(output, 3);

	List<String> role = new ArrayList<>();
	role.add("Administrator"); role.add("Faculty"); role.add("Staff");
	role.add("Student"); role.add("Guest");

	Button cancelb = new Button("Cancel");
	cancelb.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
	cancelb.setStyle("-fx-font-size: 20px;");
	grid.add(cancelb, 2, 1);

	Button againb = new Button("Again?");
	againb.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
	againb.setStyle("-fx-font-size: 20px;");

	ComboBox<String> roles = new ComboBox<>();
	roles.getItems().addAll(role);
	roles.setPromptText("Choose your role");
	roles.setStyle("-fx-font-size: 20px;");
	roles.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
	grid.add(roles, 1, 0);
	GridPane.setColumnSpan(roles, 3);

	ChangeListener<String> drops = (observable, oldValue, newValue) -> {
		String outrole = "How?!";
		outrole = roles.getValue();
		
		switch(outrole){
			case "Administrator":
				grid.getChildren().remove(roles);
				grid.getChildren().remove(cancelb);
				output.setText("You have all the power: " + outrole);
				grid.add(output, 1, 0);
				grid.add(againb, 1, 1);
				grid.add(cancelb, 3, 1);
				break;
			case "Faculty":
				grid.getChildren().remove(roles);
				grid.getChildren().remove(cancelb);
				output.setText("You do all the teaching: " + outrole);
				grid.add(output, 1, 0);
				grid.add(againb, 1, 1);
				grid.add(cancelb, 3, 1);
				break;
			case "Staff":
				grid.getChildren().remove(roles);
				grid.getChildren().remove(cancelb);
				output.setText("You do all the maintaining: " + outrole);
				grid.add(output, 1, 0);
				grid.add(againb, 1, 1);
				grid.add(cancelb, 3, 1);
				break;
			case "Student":
				grid.getChildren().remove(roles);
				grid.getChildren().remove(cancelb);
				output.setText("You do all the learning: " + outrole);
				grid.add(output, 1, 0);
				grid.add(againb, 1, 1);
				grid.add(cancelb, 3, 1);
				break;
			case "Guest":
				grid.getChildren().remove(roles);
				grid.getChildren().remove(cancelb);
				output.setText("You are a guest here: " + outrole);
				grid.add(output, 1, 0);
				grid.add(againb, 1, 1);
				grid.add(cancelb, 3, 1);
				break;
			case "How?!":
				System.out.println("How?!");
				break;
			}
	};
	againb.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent again){
			grid.getChildren().remove(output);
			grid.getChildren().remove(againb);
			grid.getChildren().remove(cancelb);
			grid.add(roles, 1, 0);
			grid.add(cancelb, 2, 1);
		}
	});
	cancelb.setOnAction(new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent cancel){
			System.exit(0);
		}
	});

	roles.valueProperty().addListener(drops);
	Scene scene = new Scene(grid, 500, 200);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}
