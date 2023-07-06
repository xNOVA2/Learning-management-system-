package AddQuestionScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainMenu.TeacherScreen;

public class AddQuestionScreen extends JFrame implements ActionListener {
    JLabel label, label2, label3,label4;
    JPanel panel, panel2;
    JTextField textField1, textField2, textField3, textField4, textField5;
    JCheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    ButtonGroup checkBoxGroup; // ButtonGroup to group the checkboxes
    JButton button,button2;
    ArrayList<Question> Questionss;


    // constructor starts here
    public AddQuestionScreen() {
        // button here
        button = new JButton();
        button2 = new JButton();
        button.addActionListener(this);
        button.setText("Add Question");
        button.setBounds(100, 300, 130, 30);
        button.setBackground(Color.black);
        button.setForeground(Color.white);
         button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.addActionListener(this);
        button2.setText("Main menu");
        button2.setBounds(100, 350, 130, 30);
        // Check Box
        checkBox1 = new JCheckBox();
        checkBox1.setBounds(70, 140, 20, 30);
        checkBox2 = new JCheckBox();
        checkBox2.setBounds(70, 180, 20, 30);
        checkBox3 = new JCheckBox();
        checkBox3.setBounds(70, 220, 20, 30);
        checkBox4 = new JCheckBox();
        checkBox4.setBounds(70, 260, 20, 30);

        // Group the checkboxes
        checkBoxGroup = new ButtonGroup();
        checkBoxGroup.add(checkBox1);
        checkBoxGroup.add(checkBox2);
        checkBoxGroup.add(checkBox3);
        checkBoxGroup.add(checkBox4);
        // label
        label = new JLabel("Add Question To Question Bank");
        label2 = new JLabel("Add Question");
        label3 = new JLabel("MCQ ");
        label4 = new JLabel("");

        label2.setBounds(100, 20, 100, 20);

        label3.setBounds(100, 105, 100, 30);
        label4.setBounds(100, 400, 250, 30);
        label4.setForeground(Color.RED);
        // text field start here
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();

        textField1.setBounds(100, 50, 200, 50);
        textField2.setBounds(100, 140, 130, 30);
        textField3.setBounds(100, 180, 130, 30);
        textField4.setBounds(100, 220, 130, 30);
        textField5.setBounds(100, 260, 130, 30);
        //
        panel = new JPanel();
        panel2 = new JPanel();
        panel2.add(textField1);
        panel2.add(textField2);
        panel2.add(textField3);
        panel2.add(textField4);
        panel2.add(textField5);
        panel2.add(label2);
        panel2.add(label3);
        panel2.add(label4);
        panel2.add(checkBox1);
        panel2.add(checkBox2);
        panel2.add(checkBox3);
        panel2.add(checkBox4);
        panel2.add(button);
  panel2.add(button2);
        panel2.setLayout(null);

        // panel start here
        panel.add(label);
        panel.setBackground(Color.LIGHT_GRAY);
        // Jframe
        this.setLayout(new BorderLayout());
        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.setSize(700, 800);
        this.setVisible(true);
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button) {

        if(textField1.getText().length() == 0){
            label4.setText("Question Cant be null");
            return;
        }
        if(!checkBox1.isSelected()&&!checkBox2.isSelected()&&!checkBox3.isSelected()&&!checkBox4.isSelected()){
            label4.setText("Please Select atleasst one Right answer");
            return;
        }
        if(textField2.getText().length()==0 || textField3.getText().length()==0 || textField4.getText().length()==0 || textField5.getText().length()==0){
            label4.setText("Fill All MCQ's");
            return;
        }

        int rightAnswer = 0;
        if (checkBox1.isSelected()) {
            rightAnswer = 0;
        } else if (checkBox2.isSelected()) {
            rightAnswer = 1;
        } else if (checkBox3.isSelected()) {
            rightAnswer = 2;
        } else if (checkBox4.isSelected()) {
            rightAnswer = 3;
        }
        
        String[] mcqs = new String[4];

        mcqs[0] = textField2.getText();
        mcqs[1] = textField3.getText();
        mcqs[2] = textField4.getText();
        mcqs[3] = textField5.getText();

        Question quesOBJ = new Question(textField1.getText(), mcqs, rightAnswer);
      Questionss = new ArrayList<>();
        
        Questionss.add(quesOBJ);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("QuestionList.txt",true))) {
            for(Question question : Questionss){
                writer.write(question.QuestionString() + "\n");
                writer.write(question.MCQS() + "\n");
                writer.write(question.Answer() + "\n");
            }
          
            writer.close();
        } catch (IOException e1) {
            System.out.println(e1);
            }
    }
        if(e.getSource() == button2){
            this.dispose();
            new TeacherScreen();
        }
    }
}
 