package StudentScreen;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainMenu.MyFrame;

public class StudentScreen extends JFrame implements ActionListener{
JPanel panel , panel2;
JLabel label;
JButton button,button2,button3;
    public StudentScreen(){
        button = new JButton("Select Course");
        button2 = new JButton("View Courses");
         button3 = new JButton("Logout");
        label = new JLabel("Student Console");
        panel = new JPanel();
        panel2 = new JPanel();
        this.setSize(800,800);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.setFocusable(false);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.BLACK);
        button2.setFocusable(false);
          button3.setForeground(Color.WHITE);
        button3.setBackground(Color.BLACK);
        button3.setFocusable(false);
        this.add(panel,BorderLayout.NORTH);
        this.add(panel2,BorderLayout.CENTER);
        button.addActionListener(this);
        panel.setBackground(Color.LIGHT_GRAY);
        panel2.setBackground(Color.LIGHT_GRAY);
        panel2.setLayout(null);
        button.setBounds(315,10,150,40);
        button2.setBounds(315,60,150,40);
           button2.addActionListener(this);
             button3.setBounds(315,110,150,40);
           button3.addActionListener(this);
        panel.add(label);
        panel2.add(button);
    
        panel2.add(button2);
         panel2.add(button3);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            this.dispose();
            new SelectCourseScreen();
        }
        else if(e.getSource() == button2){
            this.dispose();
            new ViewCourse();
        }
         else if(e.getSource() == button3){
            this.dispose();
            new MyFrame();
        }
    }
}
