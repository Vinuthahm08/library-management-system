import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class library{

    private JFrame frame;
    
    private JButton userButton;
    private JButton staffButton;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    library l = new library();
                    l.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public library() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("library");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        userButton = new JButton("USER");
        userButton.setBounds(130, 50, 200, 50);
        frame.getContentPane().add(userButton);

        staffButton = new JButton("STAFF");
        staffButton.setBounds(130, 150, 200, 50);
        frame.getContentPane().add(staffButton);

      
        Font font1 = new Font("Century Schoolbook", Font.BOLD, 20);
        userButton.setFont(font1);
        staffButton.setFont(font1);
        // Add ActionListener to the buttons
        userButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Your logic for user login here
                SignUpPage s = new SignUpPage();
                s.frame.setVisible(true); // show the login page
                frame.setVisible(false); 
            }
        });

        staffButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Your logic for staff login here
                signups s = new signups();
                s.frame.setVisible(true); // show the login page
                frame.setVisible(false); 
            }
        });
    }
}
