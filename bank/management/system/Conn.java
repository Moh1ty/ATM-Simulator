package bank.management.system;
import java.sql.*;  

public class Conn{
    //------------ Step1: REGISTER THE DRIVER (CREATE CONNECTION) ---------------//
    Connection c;  // CREATING CONNECTION
    Statement s; // CREATING STATEMENT
    public Conn(){  
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver); // ----->> No need for this line as the driver is automatically picked by java via classpath
            //c = DriverManager.getConnection("jdbc.mysql://localhost:3306");
            // By default sql is connected from local host with port number 3306 so we don't need to mention it
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","N@h1Bataunga");    
            s =c.createStatement(); 
            
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
