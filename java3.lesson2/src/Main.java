import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement statement;

    public static void main(String[] args){
        try {
            connect();
            create();
            insertData();
            getData();
            deleteData();
            deleteTable();
            disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private static void deleteTable() throws SQLException {
        statement.executeUpdate("DROP TABLE 'datatable'");
        System.out.println("'datatable' are deleted");
    }
    private static void deleteData() throws SQLException {
        statement.executeUpdate("DELETE FROM 'datatable' WHERE NAME = 'Arturs'");
        System.out.println("Data from 'datatable' are deleted");
    }
    private static void getData() throws SQLException {
        ResultSet result = statement.executeQuery("SELECT * FROM 'datatable'");
        while (result.next()){
            System.out.println(result.getInt("ID"));
            System.out.println(result.getString("NAME"));
            System.out.println(result.getString("SURNAME"));
        }
    }
    private static void insertData() throws SQLException {
        connection.setAutoCommit(false);
            statement.executeUpdate("INSERT INTO 'datatable'  ('NAME', 'SURNAME') VALUES ('Arturs', 'Suhomiro');");
            statement.executeUpdate("INSERT INTO 'datatable' ('NAME', 'SURNAME') VALUES ('Ivan', 'Petrov');");
            statement.executeUpdate("INSERT INTO 'datatable' ('NAME', 'SURNAME') VALUES ('Igor', 'Ivanov');");
            statement.executeUpdate("INSERT INTO 'datatable' ('NAME', 'SURNAME') VALUES ('Bob', 'Clay');");
            statement.executeUpdate("INSERT INTO 'datatable' ('NAME', 'SURNAME') VALUES ('Gleb', 'Petrov');");
            connection.setAutoCommit(true);
        System.out.println("Insertion data in 'datatable'");
    }

    private static void create() throws SQLException {
        statement = connection.createStatement();
        statement.execute("CREATE TABLE if not exists 'datatable' ('ID' INTEGER PRIMARY KEY AUTOINCREMENT, 'NAME' text, 'SURNAME' text);");
        System.out.println("Table 'datatable' are created");
    }


    private static void connect() throws Exception {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:java3.lesson2.db");
        statement = connection.createStatement();
        System.out.println("Connection to java3.lesson2.db");
    }
    private static void disconnect() throws SQLException {
        connection.close();
        System.out.println("Disconnect from java3.lesson2.db");
    }

}
