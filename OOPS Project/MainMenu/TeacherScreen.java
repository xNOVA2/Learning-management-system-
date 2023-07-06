package MainMenu;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import AddQuestionScreen.AddQuestionScreen;
import CheckMarksScreen.MarksScreen;
import QuestionBankScreen.QuestionBankScreen;

public class TeacherScreen extends JFrame implements ActionListener {
    
    JPanel panel, panel2;
    JLabel label;
    JButton button1, button2, button3,button4;

    // Constructor starts here
    public TeacherScreen() {
        // Create panels, labels, and buttons
        panel = new JPanel();
        label = new JLabel("Teacher Console ");
        button1 = new JButton("Question Bank");
        button2 = new JButton("Add Question");
        button3 = new JButton("Check Marks");
        button4 = new JButton("Logout");
        panel2 = new JPanel();


        button1.setBackground(Color.black);
                button2.setBackground(Color.black);
        button3.setBackground(Color.black);
           button4.setBackground(Color.black);
        button1.setForeground(Color.white);
        button2.setForeground(Color.white);
        button3.setForeground(Color.white);
         button4.setForeground(Color.white);
        // Add buttons to panel2
        panel2.add(button1);
        panel2.add(button2);
        panel2.add(button3);
        panel2.add(button4);
        // Add label to panel
        panel.add(label);

        // Set size for panel2
        panel2.setPreferredSize(new Dimension(500, 500));

        // Set background color for panel
        panel.setBackground(Color.LIGHT_GRAY);

        // Set layout for panel2
        panel2.setLayout(null);

        // Set bounds and action listeners for buttons
        button1.addActionListener(this);
        button1.setFocusable(false);
        button1.setBounds(320, 50, 150, 50);
        button2.addActionListener(this);
        button2.setFocusable(false);
        button2.setBounds(320, 120, 150, 50);
        button3.addActionListener(this);
        button3.setFocusable(false);
        button3.setBounds(320, 190, 150, 50);
        button4.setFocusable(false);
        button4.setBounds(320, 260, 150, 50);
button4.addActionListener(this);
        // Set bounds for label
        label.setBounds(400, 60, 200, 20);

        // Set JFrame properties
        this.setSize(800, 800);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
                 this.dispose();
            new QuestionBankScreen();
        } else if (e.getSource() == button2) {
            this.dispose();
            new AddQuestionScreen();
        }
        else if(e.getSource()==button3){
                 this.dispose();
            new MarksScreen();
        }
        else if(e.getSource()==button4){
                 this.dispose();
            new MyFrame();
        }
    }
}
