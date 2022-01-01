import java.awt.*;
import java.awt.event.*;
public class SelectOp extends Frame {
    TextField name, pass;
    Button b_add, b_search, b_delete, b_cancel;
    String userName;
    String studententered;

    SelectOp() {
        try {


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

            this.setTitle("Student Managment System");
            this.setSize(400, 400);
            Label l = new Label("Menu Option", Label.CENTER);
            final Label message = new Label("");

            b_add = new Button("Add");
            b_cancel = new Button("Cancel");
            b_delete = new Button("Delete");
            b_search = new Button("Search");


            this.add(b_add);
            this.add(b_cancel);
            this.add(b_delete);
            this.add(b_search);
            this.add(l);
            this.add(message);

            l.setBounds(95, 30, 200, 60);

            b_add.setBounds(100, 260, 70, 40);
            b_cancel.setBounds(180, 260, 70, 40);
            b_delete.setBounds(100, 160, 70, 40);
            b_search.setBounds(180, 160, 70, 40);


            // event for showing message of user logged in app
            b_add.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent actionEvent) {
                    add addnew = new add();

                }

                ;

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        b_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                menu menu = new menu();

            }
        });

        b_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {
                search search = new search();

            }
        });

        b_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent action) {

                Delete delete = new Delete();

            }
        });


    }


}
