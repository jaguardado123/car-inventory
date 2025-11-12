import java.sql.*;

public class CarDatabase {
	// Database Attributes
	private Connection connect = null;
	// Statement object to run my queries/commands
	private Statement statement = null;

	// Database Methods
	// Connect to my Database
	private void connectDatabase() {
		// In case connection can't be establish, we need to catch the Exc.(error)
		try {
			// Establish my connection to database.db
			connect = DriverManager.getConnection("jdbc:sqlite:database.db");
			statement = connect.createStatement();
		}
		catch(SQLException e) {
			System.out.println("Failed to connect to database.");
			System.out.println(e.toString());
		}
	}

	// Insert into my Table
	public void insertTable(String make, String model, int year) {
		if (connect == null)
			connectDatabase();
		// In case our query/command is incorrect, prevents code from crashing
		try {
			// Create our sql query/command.
			String query = "insert into Cars (make, model, year) values ('" + make + 
			"', '" + model + "', " + year + " )";
			statement.executeUpdate(query);
		}
		catch(SQLException e) {
			System.out.println("Failed to insert into table.");
			System.out.println(e.toString());
		}

	}

	// Let's make a method to retrieve data from my Car table.
	public Car[] selectTable() {
		if (connect == null)
			connectDatabase();
		
		// Store our data returned from our table
		Car[] cars = {};
		try {
			String query = "select count(*) from Cars";
			// ResultSet is used to read what is returned from our database.
			ResultSet result = statement.executeQuery(query);
			result.next(); // Begins reading our result.
			int size = result.getInt(1);

			// Allocate space in my array.
			cars = new Car[size];

			// Select and retrieve all the rows in my table.
			query = "select * from Cars";
			result = statement.executeQuery(query);
			int index = 0;
			// Reading through my rows and storing the values into my Car array.
			while( result.next() ) {
				cars[index] = new Car(
					result.getString("make"), 
					result.getString("model"), 
					Integer.parseInt( result.getString("year") )
				);
				index++;
			}
			// Once my array is filled, return it.
			return cars;
		}
		catch(SQLException e) {
			System.out.println("Failed to select from table.");
			System.out.println(e.toString());
		}

		return cars;
	}
}
