import java.sql.*; // SQL
import java.util.logging.Level; // For errors.
import java.util.logging.Logger; // For errors.

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Java & mySql");

        Statement sqlStatement; // runs SQL.

        String output;
        ResultSet result; // holds the result from the SQL.
        String selectAll = "select * from Student";

        try {
            // load the Jar:
            Class.forName("com.mysql.jdbc.Driver");

            // URL for database:
            String dbURL = "jdbc:mysql://localhost:3306/colegiu";

            // make Connection:
            Connection dbConnection = DriverManager.getConnection(dbURL, "root", "");

            // allow SQL to execute using "sqlStatemnt" and "dbConnection":
            sqlStatement = dbConnection.createStatement();
            result = sqlStatement.executeQuery(selectAll); // holds the output from the SQL.

            // Output the result:
            while (result.next() != false) {
                output = result.getInt(1) + " " + result.getString("nume_student") + " "
                        + result.getString("pren_student") + " " +
                        result.getString("data_nasterii") + " " +
                        result.getString("telefon");
                System.out.println(output);
            }

            sqlStatement.close();
        }

        catch (ClassNotFoundException exception) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("Class not FOUND. Check the Jar.");
        }

        catch (SQLException exception) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("SQL error:" + exception.getMessage());
        }
    }
}
