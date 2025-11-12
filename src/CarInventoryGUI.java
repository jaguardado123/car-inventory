import javax.swing.*; // Importinga all class in javax.swing package.
import java.awt.event.*;
import javax.swing.table.*;

// This class will build our Graphical User Interface (GUI)
public class CarInventoryGUI extends CarDatabase {
	// GUI Attributes
	private JFrame frame = null;
	private JPanel panel = null;
	private JTextField make_input = null;
	private JTextField model_input = null;
	private JTextField year_input = null;
	private JButton button = null;
	private DefaultTableModel default_table = null;

	// Create my Constructor
	public CarInventoryGUI() {
		// Create our GUI window.
		frame = new JFrame("Car Inventory");
		// Let's resize our window
		frame.setSize(600, 600); // pixels x pixels
		// Make sure the x button ends our program.
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		// Let's create our panel
		panel = new JPanel();
		// Let's create our text fields.
		loadInputFields();
		loadButton();
		loadTable();


		// Add our panel to our frame.
		frame.add(panel);

		// Let's make our frame visible
		frame.setVisible(true);
	}

	private void loadInputFields() {
		// Creating our text fields.
		make_input = new JTextField(10); // 10 : size of our text field.
		model_input = new JTextField(10);
		year_input = new JTextField(10);

		// Let's create some labels for our text fields.
		JLabel make_label = new JLabel("Make:");
		JLabel model_label = new JLabel("Model:");
		JLabel year_label = new JLabel("Year:");

		// Add them to our panel
		panel.add(make_label);
		panel.add(make_input);

		panel.add(model_label);
		panel.add(model_input);

		panel.add(year_label);
		panel.add(year_input);
	}

	private void loadButton() {
		// Creating our button.
		button = new JButton("Add");

		// We have to add an event listener.
		// Does something when the button is pressed.
		button.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Code in here is executed.
				// Let's get the text from out textfields
				String make = make_input.getText();
				String model = model_input.getText();
				int year = Integer.parseInt( year_input.getText() );

				// Now we have to store into our database
				insertTable(make, model, year);
				default_table.addRow(new Object[] {make, model, year});
			}
		});

		// Let's add the button to our panel
		panel.add(button);
	}

	private void loadTable() {
		// Creating our Default Table Model
		String[] headers = {"Make", "Model", "Year"};
		default_table = new DefaultTableModel(null, headers);

		// Let's add values from our Database.
		Car[] cars = selectTable();
		for(int i = 0; i < cars.length; i++) {
			default_table.addRow(new Object[] {
				cars[i].make,
				cars[i].model,
				cars[i].year
			});
		}

		// Next we're going to create a JTable
		JTable table = new JTable(default_table);
		table.setSize(500, 300); // pixels x pixels

		// ScrollPane
		JScrollPane scrollPane = new JScrollPane(table);

		// Let's add our table to our panel
		panel.add(scrollPane);
	}
}
