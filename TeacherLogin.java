import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class TeacherLogin extends Frame {
    TextField name, pass;
    Button b_submit, b_cancel;
    String userName;
    String studententered;

    TeacherLogin() {
        try {


            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproj", "root", "harshvar");
            Statement statement = con.createStatement();

            Class.forName("com.mysql.cj.jdbc.Driver");


            setLayout(new FlowLayout());
            this.setLayout(null);
            this.setVisible(true);

            // to close the windows using close button (x) on right corner
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    Frame frame = (Frame) e.getSource();
                    frame.dispose();
                }
            });

            this.setTitle("Teacher Login");
            this.setSize(400, 400);
            Label l = new Label("Teacher Login");
            final Label message = new Label("");
            Label n = new Label("Username:", Label.CENTER);
            Label p = new Label("password:", Label.CENTER);
            name = new TextField(20);
            pass = new TextField(20);
            pass.setEchoChar('*');
            b_submit = new Button("submit");
            b_cancel = new Button("cancel");

            this.add(n);
            this.add(name);
            this.add(p);
            this.add(pass);
            this.add(b_submit);
            this.add(b_cancel);
            this.add(l);
            this.add(message);
            n.setBounds(70, 90, 90, 60);
            p.setBounds(70, 130, 90, 60);
            l.setBounds(115, 30, 200, 60);
            name.setBounds(200, 100, 90, 20);
            pass.setBounds(200, 140, 90, 20);
            b_submit.setBounds(100, 260, 70, 40);
            b_cancel.setBounds(180, 260, 70, 40);

            b_cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menu menu =new menu();
                    setVisible(false);
                }
            });
            // event for showing message of user logged in app
            b_submit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        ResultSet resultSet = statement.executeQuery("SELECT `teacherdetails`.`teacherID`,\n" +
                                "    `teacherdetails`.`teacherCode`\n" +
                                "FROM `studentproj`.`teacherdetails`;\n");
                        resultSet.next();

                        System.out.println("hey");

                        SelectOp selectOp = new SelectOp();
                        setVisible(false);

                    } catch (SQLException throwables) {
                        System.out.println("this");
                        throwables.printStackTrace();
                    }
                }

                ;


            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
