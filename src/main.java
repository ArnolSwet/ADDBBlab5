import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;


class Main {
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adbs","root","admin");
            //here sonoo is the database name, root is the username and root is the password
            Statement stmt=con.createStatement();

            ResultSet rs=stmt.executeQuery("select * from emp");

            while(rs.next())
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            con.close();

        } catch(Exception e) { 
            System.out.println(e);
        }
    }
}