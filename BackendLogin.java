import java.sql.*;
import java.awt.*;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

public class BackendLogin {
    public static String back(String query,String userName) throws Exception {// TODO Auto-generated method stub
        String url = "jdbc:mysql://localhost:3306/student management system";
        String user = "admin";
        String uname = "root";
//		String query = "select pass from login where username='"+user+"'";
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,"harshvar");

        PreparedStatement ps = con.prepareStatement(query);
        ResultSet results = ps.executeQuery();

        	     while(results.next()){
//                    return results.getString(1);
                    if(results.getString("teacherName")==userName){
                        return results.getString("teacherName");
                    }else
                        return "The Name not found";
        	     }
//        	     Statement st = con.createStatement();
//        	     ResultSet rs = st.executeQuery(query);
//        	     rs.next();
//        	     String name = rs.getString("sname");
//        	     System.out.print(name);
        return "No record to be searched";
    }

}
