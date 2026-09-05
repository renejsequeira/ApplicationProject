/**
 * Rene Sequeira
 * Module 3 Assignment
 * User Interface with menu option
 */

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

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			MenuBar menu = new MenuBar();
			Menu menuName = new Menu("Options");	
			MenuItem date = new MenuItem("Date and Time");
			MenuItem content = new MenuItem("Text Content");
			MenuItem color = new MenuItem("Colors");
			MenuItem exit = new MenuItem("Exit");
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");
			String formatDate = currentDate.format(dateFormat);
			TextField dateText = new TextField();
			Random rand = new Random();
		
			date.setOnAction(e ->{
				dateText.appendText(formatDate);
			});
			
			content.setOnAction(e -> {JOptionPane.showMessageDialog(null, "Adding the following content to file:  ");
					try {
						
						PrintWriter file = new PrintWriter("C:\\Users\\renej\\eclipse-workspace\\ApplicationProject\\src\\application\\log.txt");
						file.println(dateText.getText());
						file.close();
					} catch (FileNotFoundException e1) {
					
						e1.printStackTrace();
					}
			
			});
			
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
			root.setBottom(dateText);
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
