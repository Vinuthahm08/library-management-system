import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;

public class loginpageuser{

    protected JFrame frame;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
     private JLabel usern;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginpageuser l = new loginpageuser();
                    l.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public loginpageuser() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("loginpageuser");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel usern = new JLabel("USER");
        usern.setBounds(193, 11, 57, 14);
        frame.getContentPane().add(usern);
        
        JLabel lblEmail = new JLabel("EMAIL");
        lblEmail.setBounds(83, 81, 46, 14);
        frame.getContentPane().add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(155, 78, 218, 30);
        frame.getContentPane().add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblPassword = new JLabel("PASSWORD");
        lblPassword.setBounds(83, 113, 68, 17);
        frame.getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(155, 110, 218, 30);
        frame.getContentPane().add(txtPassword);

        btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(155, 155, 100, 50);
        frame.getContentPane().add(btnLogin);
        // Define your font(s)
Font font1 = new Font("Century Schoolbook", Font.BOLD, 11);
Font font2 = new Font("Century Schoolbook", Font.BOLD, 17);
Font font3=new Font("Century Schoolbook" , Font.ITALIC,17);

// Apply the fonts to the respective components
lblEmail.setFont(font1);
lblPassword.setFont(font1);
btnLogin.setFont(font2);
usern.setFont(font3);


        // Handling login button action
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Your login logic here
                String url = "jdbc:mysql://localhost:3306/librarysys?useSSL=false";
        String mysqluser="root";
        String mysqlpwd="qwer@1234";
        String pswrd=new String(txtPassword.getPassword());
        String email=txtEmail.getText();
        String query=("select password from signup where email='"+email+"';");
        try{
            Connection conn = DriverManager.getConnection(url,mysqluser,mysqlpwd);
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            if(rs.next())
            {
                String realpswrd=rs.getString("password");
                if(realpswrd.equals(pswrd))
                {
                
        dashboardu obj=new dashboardu();
obj.frame.setVisible(true);
frame.dispose();
                }
            
                else
                {
                    JOptionPane.showMessageDialog(null," password entered is wrong");
                    
                }
            }
            else
                {
                      JOptionPane.showMessageDialog(null,"username is wrong");
                        
                        }
 rs.close();
            stm.close();
            conn.close();
        }
            
                catch(Exception e)
                        {
                          JOptionPane.showMessageDialog(null,"error occured from databse");
                        }
            
            }
        });
    }
}


