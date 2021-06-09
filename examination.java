package grade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class examination {
    private JPanel read;
    private JButton saveButton;
    private JButton readButton;
    private JTextField student;
    private JTextField unit;
    private JTextField gred;
    private JTextField grade;

    public static void main(String[] args) {
        JFrame frame = new JFrame("examination");
        frame.setContentPane(new examination().read);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public examination() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myname = student.getText();
                String mycourse = unit.getText();
                String mygrade = grade.getText();

                Connection connection = null;
                String host="localhost";
                String port="5432";
                String db_name="postgres";
                String username="postgres";
                String password="bengrace8";
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+db_name+"", ""+username+"", ""+password+"");
                    if (connection != null) {
                        String querry="insert into examination1 values ('"+myname+"','"+mycourse+"''"+mygrade+"')";
                        Statement statement=connection.createStatement();
                        int x =statement.executeUpdate(querry);
                        if (x == 0) {
                            JOptionPane.showMessageDialog(saveButton,"record exists");
                        }
                        else{
                            JOptionPane.showMessageDialog(saveButton,"added sucessfully");
                        }
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
                    }
        });
        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }
}
