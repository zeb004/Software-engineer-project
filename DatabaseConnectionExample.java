import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 Here is an example of connecting to the online database.
 You must have the JDBC MySQL driver, and put in the project build path.
 
 Port: 				rseddon.heliohost.org
 Database Name:		rseddon_lfg
 Username:			rseddon_general
 Password:			tpNo7Q54,6Q+
 
 Note: Most of the actual code should be the same, but sqlite and MySQl are different in subtly annoying ways. 
 
 
 */
public class DatabaseConnectionExample {

	public static void main(String[] args) {
		
		//url to connect to in the form driver:database://host/databaseName
		String url = "jdbc:mysql://rseddon.heliohost.org/rseddon_lfg";
		
		//create null connection
		Connection conn = null;
		
		try {
			//create the connection, input paramters are (URL, username, password)
			conn = DriverManager.getConnection(url, "rseddon_general", "tpNo7Q54,6Q+");
			
			//an insert statement for the groups table
			//Note: This won't work because I already put this one in the database, change the groupid and it should work
			String sql = "Insert into Groups (groupid, name, category, date, city, zipcode, description, maxmembers) VALUES ('2', 'Ultimate Frisbee Game', 'Sports', "
					+ "'Wednesday, August 27th, 2:00 pm', 'Huntsville', '77340', 'Lets play frisbee', '10');";
			
			//prepare and execute the sql statement
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			
			//close the connection
			conn.close();
		}//end try
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}//end catch
		System.out.println("Done");

	}

}
