import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Delete extends Frame {
    Label lsrollno;
    TextField tfsrollno;
    Button submit;
    Statement statement;
    ResultSet resultSet;
    TextArea display_details;

    Delete() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproj", "root", "harshvar");
            statement = con.createStatement();
            Class.forName("com.mysql.cj.jdbc.Driver");

            this.setSize(400, 400);
            Label hs = new Label("DELETE STUDENT DETAILS");
            this.add(hs);

            lsrollno = new Label("Roll No: ");
            tfsrollno = new TextField();
            submit = new Button("Submit");
            display_details = new TextArea("", 2, 100, TextArea.SCROLLBARS_NONE);
            display_details.setEditable(false);

            hs.setBounds(150, 30, 200, 60);
            lsrollno.setBounds(110, 100, 50, 20);
            tfsrollno.setBounds(160, 100, 170, 20);

            submit.setBounds(10, 190, 440, 30);

            display_details.setBounds(10, 250, 440, 130);
            add(lsrollno);
            add(tfsrollno);
            add(submit);

            add(display_details);


            setTitle("Delete Details");
            setSize(460, 390);
            setLayout(null);
            setVisible(true);

            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    dispose();
                }
            });

            submit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    try {

                        String rollno = tfsrollno.getText();
                        statement.execute("DELETE FROM `studentproj`.`studentdetails`" +
                                "WHERE `studentdetails`.`studentID`=" + rollno + ";");

                        display_details.setText("STUDENT DETAILS DELETED");



                    } catch (SQLException throwables) {

                        display_details.setText("Enter Valid Roll Number!");
                    }
                }
            });


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }


}
