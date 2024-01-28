
## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies


## What do you need to make the connection between Java and mySQL:

- `Java Development Kit (JDK)` 
- `Integrated Development Environment (IDE)` - [Visual Studio Code](https://code.visualstudio.com)
- `mySQL Database` - [mySQL](https://www.mysql.com/downloads/)
- `mySQL Connector/J` - [Connector](https://dev.mysql.com/downloads/connector/j/)
> If you have all this things , you are good to go !


## Let's actually make the things work !

Open vscode and do the following things:

- Create the Java project - type `Command` + `Shift` + `P` , after type Create Java Project and `Enter`.
- Add the Connector jar to the Referenced Libraries of the project - in the left bottom press on **Java Project** -> **Referenced Libraries** -> **+** -> add your **Connector jar**
- Write the code below :


#### Import the necessary libraries:

```Java
import java.sql.*; // SQL
import java.util.logging.Level; // For errors.
import java.util.logging.Logger; // For errors.
```

#### Create your necessary variables:

```Java
        Statement sqlStatement; // runs SQL.

        String output;
        ResultSet result; // holds the result from the SQL.
        String selectAll = "select * from Student";
```

#### Make the try and catch blocks:
> We make this because databases can give us a lot of errors , exceptions , etc.

```Java
try {

}

catch {

}

```

#### Make the catch exceptions:

```Java
        catch (ClassNotFoundException exception) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("Class not FOUND. Check the Jar.");
        }

        catch (SQLException exception) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, exception);
            System.out.println("SQL error:" + exception.getMessage());
        }
```

#### Finally the try block:

```Java
 try {
            // load the Jar:
            Class.forName("com.mysql.jdbc.Driver");

            // URL for database:
            String dbURL = "jdbc:mysql://localhost:3306/name_of_your_database";

            // make Connection:
            Connection dbConnection = DriverManager.getConnection(dbURL, "root", ""); // By default when you install mySQL your name will be root and you will have no password, in the future consider to add a password and a name for more security.

            // allow SQL to execute using "sqlStatemnt" and "dbConnection":
            sqlStatement = dbConnection.createStatement();
            result = sqlStatement.executeQuery(selectAll); // holds the output from the SQL.

            // Output the result:
            while (result.next() != false) {
                output = result.getInt(1) + " " + result.getString("Name");
                System.out.println(output);
            }

            sqlStatement.close();
        }
```



[To See All the Code](https://github.com/Gheruha/JavaToMySQL/blob/main/src/App.java)