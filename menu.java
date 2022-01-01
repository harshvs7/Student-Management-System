import java.awt.*;
import java.awt.event.*;

class menu extends Frame {
    Button teacher, student;

    menu() {

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

        this.setTitle("Student Record Management System");
        this.setSize(400, 400);
        Label l = new Label("STUDENT MANAGEMENT SYSTEM");
        Label l2 = new Label("Select Login Type: ");
        final Label message = new Label("");
        teacher = new Button("Teacher");
        student = new Button("Student");

        this.add(teacher);
        this.add(student);
        this.add(l);
        this.add(l2);
        this.add(message);

        l.setBounds(95, 80, 200, 60);
        l2.setBounds(140, 140, 200, 60);

        teacher.setBounds(100, 200, 70, 40);
        student.setBounds(210, 200, 70, 40);


        // event for showing message of user logged in app
        teacher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Teacher");
                TeacherLogin teacherLogin = new TeacherLogin();
                setVisible(false);
            }
        });
        student.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Student");
                MyLoginWindow myLoginWindow = new MyLoginWindow();
                setVisible(false);
            }
        });
    }


    public static void main(String args[]) {
        menu m = new menu();


    }


}
