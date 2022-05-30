import java.io.IOException;
import java.sql.*;

public class Connection {
    public static void main(String[] args) throws IOException, SQLException {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String user = "user";
        String password = "password";

        System.out.println("MySQL");

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
            Statement stmt = connection.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM tablename;");

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");

                System.out.println(id + " " + name + " " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("PostgreSQL");

        url = "jdbc:postgresql://localhost:5432/dbname";
        user = "user";
        password = "password";

        try (java.sql.Connection connection = DriverManager.getConnection(url, user, password)) {
             Statement st = connection.createStatement();
             ResultSet res = st.executeQuery("SELECT * FROM tablename;");

            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("name");
                int age = res.getInt("age");

                System.out.println(id + " " + name + " " + age);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
