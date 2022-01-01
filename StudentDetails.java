
import java.awt.*;
import java.awt.event.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDetails extends Frame {
    TextArea display_details;

    StudentDetails(String studententered, String passwordentered) {

        display_details = new TextArea("", 5, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        display_details.setEditable(false);
        this.setSize(400, 400);

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproj", "root", "harshvar");
            Statement statement = con.createStatement();

            Class.forName("com.mysql.cj.jdbc.Driver");

            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Frame frame = (Frame) e.getSource();
                    frame.dispose();
                }
            });


            Label hs = new Label("STUDENT DETAILS");
            hs.setBounds(150, 30, 50, 60);
            this.add(hs);
            display_details.setBounds(10, 250, 440, 200);
            add(display_details);


            setLayout(new FlowLayout());
            setVisible(true);

            ResultSet resultSet = statement.executeQuery("SELECT `studentdetails`.`studentID`,\n" +
                    "    `studentdetails`.`studentName`,\n" +
                    "    `studentdetails`.`studentCode`,\n" +
                    "    `studentdetails`.`studentBranch`,\n" +
                    "    `studentdetails`.`studentYear`,\n" +
                    "    `studentdetails`.`CGPA`\n" +
                    "FROM `studentproj`.`studentdetails`\n where studentdetails.studentID= '" + studententered + "' and studentdetails.studentCode= '" + passwordentered + "';");
            resultSet.next();
            String sdetails = "Name: " + resultSet.getString("studentName") +
                    "\nYear: " + resultSet.getString("studentYear")
                    + "\nBranch: " + resultSet.getString("studentBranch")
                    + "\nCGPA: " + resultSet.getString("CGPA");
            display_details.setText(sdetails);
            setVisible(false);


        } catch (Exception e) {
            display_details.setText("Enter valid credentials!");

        }
    }

}
