import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Submit extends JFrame {
    private JTextField nickname;
    private JPasswordField pass;
    private JButton submitButton;
    private JPanel submit;

    public Submit() {
    add(submit);
    setVisible(true);
    setSize(400,400);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = nickname.getText();
            String password = new String(pass.getPassword());
            if(SqlQuery.UpdateData("INSERT INTO players (username, password) VALUES ('"+ username + "', '" + password + "')"))
            {
                JOptionPane.showMessageDialog(null, "Kayıt başarılı, bu pencereyi kapatıp giriş yapabilirsiniz.");
            }
            else{
                JOptionPane.showMessageDialog(null,"Kayıt başarısız.");
            }
        }
    });
}
}
