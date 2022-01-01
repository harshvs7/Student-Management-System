import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class add extends Frame implements ActionListener {
    Label lsname, lsrollno, lsbranch, lsyear, lsbg, lscgpa, lspass;
    Choice csclass;
    Choice year;
    TextField tfsname, tfsrollno, tfscgpa, tfspass;
    Button submit;
    Connection connection;
    Statement statement;
    TextArea display_details;
    String query;

    add() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentproj", "root", "harshvar");
            statement = connection.createStatement();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Label hs = new Label("ADD STUDENT DETAILS");
        this.add(hs);

        lsname = new Label("Name: ");
        lsrollno = new Label("Roll No: ");
        lsbranch = new Label("Branch: ");
        lsyear = new Label("Year: ");

        lscgpa = new Label("CGPA: ");
        lspass = new Label("Student Password: ");

        year = new Choice();
        year.add("1");
        year.add("2");
        year.add("3");
        year.add("4");

        csclass = new Choice();
        csclass.add("CSE");
        csclass.add("ECE");
        csclass.add("Civil");
        csclass.add("IT");
        csclass.add("MAE");


        tfsname = new TextField();
        tfsrollno = new TextField();
        tfscgpa = new TextField();
        tfspass = new TextField();

        submit = new Button("Submit");

        display_details = new TextArea("", 2, 100, TextArea.SCROLLBARS_NONE);
        display_details.setEditable(false);

        hs.setBounds(150, 30, 200, 60);

        lsname.setBounds(10, 90, 50, 20);
        tfsname.setBounds(70, 90, 150, 20);

        lsrollno.setBounds(240, 90, 50, 20);
        tfsrollno.setBounds(300, 90, 150, 20);

        lsbranch.setBounds(10, 120, 50, 20);
        csclass.setBounds(70, 120, 150, 20);

        lsyear.setBounds(240, 120, 50, 20);
        year.setBounds(300, 120, 150, 20);


        lscgpa.setBounds(10, 150, 50, 20);
        tfscgpa.setBounds(70, 150, 150, 20);

        lspass.setBounds(10, 180, 100, 20);
        tfspass.setBounds(120, 180, 180, 20);

        submit.setBounds(10, 210, 440, 30);

        display_details.setBounds(10, 250, 440, 130);

        add(lsname);
        add(lsrollno);
        add(lsbranch);
        add(lsyear);
        add(lspass);
        add(lscgpa);


        add(csclass);
        add(year);
        add(tfsname);
        add(tfsrollno);
        add(tfspass);
        add(tfscgpa);

        add(submit);

        add(display_details);

        submit.addActionListener(this);

        setTitle("Students Details");
        setSize(460, 390);
        setLayout(null);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            try {
                query = "Insert into studentdetails values('" + tfsrollno.getText() + "','" + tfsname.getText()
                        + "','" + tfspass.getText() + "','" + csclass.getSelectedItem()
                        + "'," + Integer.parseInt(year.getSelectedItem()) + ",'" + tfscgpa.getText() + "')";
                statement.execute(query);
                String sdetails = "STUDENT DETAILS ADDED\n\n Name : " + tfsname.getText() + "\n Roll No. :"
                        + tfsrollno.getText() + "\n Branch: " + csclass.getSelectedItem() + "\n Year: "
                        + year.getSelectedItem() + "\n CGPA: " + tfscgpa.getText();

                display_details.setText(sdetails);

            } catch (Exception ae) {
                ae.printStackTrace();
            }
        }
    }


}