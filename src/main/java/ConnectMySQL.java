import java.lang.reflect.InvocationTargetException;
import java.sql.*;

public class ConnectMySQL {
    public static void execute() {
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test_demo?" +
                    "useUnicode=true&characterEncoding=UTF8", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from demo");
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String email = rs.getString(3);
                String contact = rs.getString(4);
                System.out.println("id: " + id + " name: " + name + " email: " + email + "contact: " + contact);
            }

            stmt.executeUpdate("insert into demo(name,email,contact) values('b','b','b')");
            stmt.executeUpdate("update demo set name='a1'where id=1");
            stmt.executeUpdate("delete from demo where id=3");
            stmt.close();
            conn.close();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  static void main(String[] args){
        ConnectMySQL.execute();
    }
}