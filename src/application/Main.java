package application;
import javax.swing.JOptionPane;
	
import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.time.format.DateTimeFormatter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.*;


public class Main extends Application {
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
			MenuItem colors = new MenuItem("Colors");
			MenuItem exit = new MenuItem("Exit");
			LocalDateTime currentDate = LocalDateTime.now();
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm a");
			String formatDate = currentDate.format(dateFormat);
			
			date.setOnAction(d -> JOptionPane.showMessageDialog(null, formatDate));
			content.setOnAction(c -> {JOptionPane.showMessageDialog(null, "Adding the following content to file:  "+ textBox.getText());
					try {
						//String textContent = "";
						PrintWriter file = new PrintWriter("C:\\Users\\renej\\eclipse-workspace\\UserInterface\\src\\log.txt");
						file.println(textBox.getText());
						file.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
			});
			colors.setOnAction(c ->JOptionPane.showMessageDialog(null, "Testing Colors"));
			exit.setOnAction(e -> System.exit(0));
			menuName.getItems().addAll(date,content,colors,exit);
			menu.getMenus().add(menuName);
			
			root.setTop(menu);
			root.getChildren().add(textBox);
			primaryStage.setScene(new Scene(root,200,50));
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
