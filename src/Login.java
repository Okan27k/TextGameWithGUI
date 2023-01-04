import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame {
    private JPanel login;
    private JButton LoginButton;
    private JLabel LoginText;
    private JTextField usernameText;
    private JPasswordField pass;
    private JButton createAccount;
    private JLabel loginImage;

    public Login(){
        add(login);
        setVisible(true);
        setSize(400,400);
        LoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameText.getText();
                String password = new String(pass.getPassword());
                ResultSet checkRs = SqlQuery.getResult(("SELECT password FROM players WHERE username='" + username + "'"));

                if(checkRs != null){
                    if(password.equals(SqlQuery.getValeusFromSQL("SELECT password FROM players WHERE username='"+
                            username + "'","password"))){
                        new GameFirstPage();
                        JComponent comp = (JComponent) e.getSource();
                        Window win = SwingUtilities.getWindowAncestor(comp);
                        win.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre hatalı!");
                    }
                }
            }
        });
        createAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Submit();

            }
        });
    }

    private void createUIComponents() {
        loginImage = new JLabel(new ImageIcon("login.png"));
    }
}
