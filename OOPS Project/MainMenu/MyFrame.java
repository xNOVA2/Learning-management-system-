package MainMenu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import StudentScreen.StudentScreen;

public class MyFrame extends JFrame implements ActionListener{
    Teacher teacher;
    Student student;
    JPanel panel1,panel2;
    JLabel label,label2,label3,label4;
    TextField textField1;
    JPasswordField textField2;
    
    JButton button = new JButton("Login");
  public  MyFrame() {
        this.setSize(800, 800);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        Font font = new Font("", Font.PLAIN, 20);

        textField1 = new TextField();
        textField1.setBounds(310, 100,160,30);
        textField2 = new JPasswordField(); // setBounds will change the position in GUI
        textField2.setBounds(310, 150,160,30);

        label = new JLabel();
        label.setBounds(310, 20, 250, 20);
        label.setText("DHA SUFFA LMS");
        label.setFont(font);

        // label of textField start here; 
        label2 = new JLabel();
        label2.setBounds(310, 70,160,30);
        label2.setText("Username");

        label3 = new JLabel();
        label3.setBounds(310, 125,110,30);
        label3.setText("Password");

        label4 = new JLabel("");
        label4.setBounds(310, 250,200,30);

        panel2 = new JPanel();
        panel2.setBackground(Color.LIGHT_GRAY);

        // panel1 start here 
        panel1 = new JPanel();
        panel1.setBackground(Color.LIGHT_GRAY);
        panel1.setPreferredSize(new Dimension(500, 700));       
        panel1.setLayout(null);

        // button 
        button.setBounds(310, 200,160,30);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFocusable(false);
        button.setBorderPainted(false);
        // adding componets to the JFRAME 
        this.add(label);

        this.add(panel2, BorderLayout.NORTH);
        this.add(panel1, BorderLayout.CENTER);

        // panel adding components 
        panel1.add(textField1);
        panel1.add(textField2);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(button);
        panel1.add(label4);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {


        try {
            ObjectInputStream ObjectReader = new ObjectInputStream(new FileInputStream("Teacher.txt"));
            teacher = (Teacher) ObjectReader.readObject();
            ObjectReader.close();
        } catch (Exception error) {
            System.out.println(error);
        }

        try {
            ObjectInputStream ObjecrReader = new ObjectInputStream(new FileInputStream("Student.txt"));
            student = (Student) ObjecrReader.readObject();
           ObjecrReader.close();
        } catch (Exception err) {
            System.out.println(err);
        }
        char[] PF = textField2.getPassword();
        String password = new String(PF);
        if (textField1.getText().equals(teacher.Username) && password.equals(teacher.Password)) {
            this.dispose();
            new TeacherScreen();
        } else if (textField1.getText().equals(student.Username) && password.equals(student.Password)) {
            new StudentScreen();
        } else {
           label4.setText("Invalid Username Or Password");
           label4.setForeground(Color.RED);
        }
    
    }
}



   
}
