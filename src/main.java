import java.util.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

class Main {
    public static void main(String args[]){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","admin");
            //here adbs is the database name, root is the username and root is the password
            Statement stmt=con.createStatement();             
            // Check if database exists
            ResultSet rs=stmt.executeQuery("SHOW DATABASES LIKE 'adbs';");
            if(rs.next()) {
                //select the database            
                stmt.executeUpdate("USE adbs");
            } else {
                //create and select the database
                //System.out.println();
                //System.out.println("Creates database as it does not exist...");
                stmt.executeUpdate("CREATE DATABASE adbs");
                stmt.executeUpdate("USE adbs");
            }  
            stmt.close();  
            // Check if database exists
            Statement stmt1 =con.createStatement();  
            ResultSet rs1=stmt1.executeQuery("SHOW TABLES LIKE 'statistics'");
            if(rs1.next()) {
                // do nothing
            } else {
                //System.out.println("Creates table statistics...");
                //create statistics table
                stmt1.executeUpdate("CREATE TABLE statistics(id int not null auto_increment,coresCPU int not null,usedMemoryRAM double not null,availableDiskSpace double not null,primary key (id))");        
                // insert some rows
                System.out.println("Insert some rows...");
                stmt1.executeUpdate("INSERT INTO statistics (coresCPU, usedMemoryRAM, availableDiskSpace) VALUES (4, 3.4, 74.98)");        
                stmt1.executeUpdate("INSERT INTO statistics (coresCPU, usedMemoryRAM, availableDiskSpace) VALUES (8, 5.8, 127.98)");
            }     
            stmt1.close();
            //start menu
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("************************************************************************************************************************************************************************");
            System.out.println();
            System.out.println("Wellcome to the ADBS Lab 3!");
            System.out.println();
            System.out.println("Through this Menu you acccess and modify the local SQL Database.");
            System.out.println("You can perform SELECT, INSERT & DELETE operations");
            System.out.println();
            System.out.println("There is only one table created called STATISTICS. Here we store information that you introduce through this menu.");
            System.out.println();
            System.out.println("We store three fields:");
            System.out.println("1. The number of CPU Cores");
            System.out.println("2. Ocuppied RAM Memory (GB)");
            System.out.println("3. Disk Available Space (GB)");
            System.out.println();
            System.out.println("Let's start!");  
            int choice = 0;       
            while (choice != 5) {
                System.out.println();
                System.out.println("Type 1 for SELECT");
                System.out.println("Type 2 for INSERT");
                System.out.println("Type 3 for DELETE");
                System.out.println("Type 5 to EXIT");
                System.out.println();
                System.out.print("ANSWER: ");
                choice = scanner.nextInt();
                scanner.nextLine();                               
                switch (choice) {
                    case 1:  
                        System.out.println();                  
                        System.out.println("************************************************************************************************************************************************************************");
                        System.out.println();
                        System.out.print("SELECT QUERY: ");                                                  
                        String selectquery = scanner.nextLine();
                        System.out.println(selectquery);     
                        scanner.nextLine();                       
                        try {
                            Statement stmt2=con.createStatement();                              
                            ResultSet res2=stmt2.executeQuery(selectquery);                
                            System.out.println();  
                            System.out.println("id    coresCPU    usedMemoryRAM    availableDiskSpace");
                            System.out.println("--    --------    ---------    --------------");
                            while(res2.next()) {
                                System.out.println(res2.getInt(1)+"     "+res2.getInt(2)+"             "+res2.getDouble(3)+"                  "+res2.getDouble(4));    
                            }
                        } catch (Exception e) {
                            System.out.println("ERROR:"); 
                            System.out.println();  
                            System.out.print("Exception: "+e.toString());  
                        }         
                        System.out.println(); 
                        System.out.println("************************************************************************************************************************************************************************");
                        break;
                    case 2:
                        System.out.println();                  
                        System.out.println("************************************************************************************************************************************************************************");
                        System.out.println();
                        System.out.print("INSERT QUERY: ");                                                  
                        String insertquery = scanner.nextLine();  
                        System.out.println(insertquery); 
                        scanner.nextLine();                         
                        try {
                            Statement stmt2=con.createStatement();                              
                            stmt2.executeUpdate(insertquery);                         
                            System.out.println("ROW/S INSERTED CORRECTLY");          
                        } catch (Exception e) {
                            System.out.println("ERROR:"); 
                            System.out.println();  
                            System.out.print("Exception: "+e.toString());  
                        }         
                        System.out.println(); 
                        System.out.println("************************************************************************************************************************************************************************");
                        break;                        
                    case 3:
                        System.out.println();                  
                        System.out.println("************************************************************************************************************************************************************************");
                        System.out.println();
                        System.out.print("DELETE QUERY: ");                                                  
                        String deletequery = scanner.nextLine();                             
                        System.out.println(deletequery); 
                        try {
                            Statement stmt2=con.createStatement();                              
                            stmt2.executeUpdate(deletequery);                         
                            System.out.println("ROW/S DELETED CORRECTLY");          
                        } catch (Exception e) {
                            System.out.println("ERROR:"); 
                            System.out.println();  
                            System.out.print("Exception: "+e.toString());  
                        }         
                        System.out.println(); 
                        System.out.println("************************************************************************************************************************************************************************");                        
                        break;
                    case 5:
                        System.out.println(); 
                        System.out.println("************************************************************************************************************************************************************************");
                        System.out.println("BYE BYE");
                        System.out.println("************************************************************************************************************************************************************************");
                        break;
                    default:
                        break;
                }

            }
            scanner.close();
            con.close();

        } catch(Exception e) { 
            System.out.println(e);
        }
    }

    static void InsertMethod() {
        // code to be executed
    }

    static void DeleteMethod() {
        // code to be executed
    }

}