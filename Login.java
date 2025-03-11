package LoginPage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    
    JLabel Header = new JLabel("Halo, Login dulu yaa !");
    JLabel LabelUsername = new JLabel("Username:");
    JLabel LabelPassword = new JLabel("Password:");
    
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    
    JButton tombolLogin = new JButton("Login");
    JButton tombolReset = new JButton("Reset");

    private static final String USERNAME_VALID = "Zaqi Fattah";
    private static final String PASSWORD_VALID = "123230199";
    
    public Source Login() {
        setVisible(true);
        setSize(400, 350);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        getContentPane().setBackground(new Color(219,112,147));
        
        add(Header);
        Header.setBounds(30, 20, 440, 24);
        Header.setFont(new Font("Arial", Font.BOLD, 22));
        add(LabelUsername);
        LabelUsername.setBounds(30, 80, 400, 24);
        add(LabelPassword);
        LabelPassword.setBounds(30, 140, 400, 24);
        
        add(inputUsername);
        inputUsername.setBounds(150, 80, 200, 24);
        add(inputPassword);
        inputPassword.setBounds(150, 140, 200, 24);
        
        add(tombolLogin);
        tombolLogin.setBounds(30, 200, 320, 32);
        tombolLogin.addActionListener(this);
        tombolLogin.setBackground(new Color(255,192,203));
        
        add(tombolReset);
        tombolReset.setBounds(30, 250, 320, 32);
        tombolReset.addActionListener(this);
        tombolReset.setBackground(new Color(255,192,203));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolReset) {
            inputUsername.setText("");
            inputPassword.setText("");
        } else if (e.getSource() == tombolLogin) {
            try {
                String username = inputUsername.getText();
                String password = new String(inputPassword.getPassword());

                if (username.isEmpty() && password.isEmpty()) {
                    throw new Exception("Username dan Password Belum Diisi");
                } else if (username.isEmpty()) {
                    throw new Exception("Username belum diisi");
                } else if (password.isEmpty()) {
                    throw new Exception("Password belum diisi");
                }

                if (username.equals(USERNAME_VALID) && password.equals(PASSWORD_VALID)) {
                    Session.setUsername(username);
                    new Login();
                    this.dispose();
                } else {
                    throw new Exception("Username atau Password salah");
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}
