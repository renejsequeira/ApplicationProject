package application;
import javax.swing.JOptionPane;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.*;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;


public class Main extends Application {
	//private CornerRadii CornerRaddi;

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			TextField textBox = new TextField(" Module three Assignment.\n"
					+ " Creating a user interface with an option menu.");
			MenuBar menu = new MenuBar();
			Menu menuName = new Menu("Options");
			
			MenuItem date = new MenuItem("Date and Time");
			MenuItem content = new MenuItem("Text Content");
			MenuItem color = new MenuItem("Colors");
			MenuItem exit = new MenuItem("Exit");
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");
			String formatDate = currentDate.format(dateFormat);
			Random rand = new Random();
			//double randGreen = 90 + rand.nextInt(61);
			date.setOnAction(e -> JOptionPane.showMessageDialog(null, formatDate));
			content.setOnAction(e -> {JOptionPane.showMessageDialog(null, "Adding the following content to file:  "+ textBox.getText());
					try {
						//String textContent = "";
						PrintWriter file = new PrintWriter("C:\\Users\\renej\\eclipse-workspace\\UserInterface\\src\\log.txt");
						file.println(textBox.getText());
						file.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			});
			//Color hueGreen = Color.hsb(randGreen, .9, .9);
			color.setOnAction(e ->{
				double randGreen = 90 + rand.nextInt(61);
				Color hueGreen = Color.hsb(randGreen, .5, 1.0);
				BackgroundFill fill = new BackgroundFill(hueGreen, CornerRadii.EMPTY, Insets.EMPTY);
				Background bckgrnd = new Background(fill);
				root.setBackground(bckgrnd);
			});
			exit.setOnAction(e -> System.exit(0));
			menuName.getItems().addAll(date,content,color,exit);
			menu.getMenus().add(menuName);
			
			root.setTop(menu);
			root.getChildren().add(textBox);
			primaryStage.setScene(new Scene(root,200,200));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
		JOptionPane.showMessageDialog(null,"Menu Selection Exit Not Selected \n"
				+ "Good Bye");
	}
}
