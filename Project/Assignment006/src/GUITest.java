import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUITest {

    // initiate variables in Frame
    public JFrame frame;
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    public void initiateWindow() {
        //Creating the Frame
        frame = new JFrame("Weighted Grade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);


        //Creating the panel of Total Assignment
        JLabel label = new JLabel("Total Assignment Points:");
        JTextField tf = new JTextField(10); // accepts up to 10 characters
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 70,40));

        //Create the panel of Earned Assignment
        JLabel label2 = new JLabel("Earned Assignment Points:");
        JTextField tf2 = new JTextField(10); // accepts upto 10 characters
        panel2.add(label2); // Components Added using Flow Layout
        panel2.add(tf2);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT, 70, 40));

        //Create the panel of Percentage
        JLabel label3 = new JLabel("Percentage of class:");
        JTextField tf3 = new JTextField(10); // accepts upto 10 characters
        panel3.add(label3); // Components Added using Flow Layout
        panel3.add(tf3);
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT, 70, 40));

        // create submit button
        JButton button = new JButton("Click to calculate score");
        panel4.add(button);
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 40));

        button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.println(tf.getText());
                try {
                    double pointTotal = Double.parseDouble(tf.getText());
                    double earnedPoints = Double.parseDouble(tf2.getText());
                    double assignmentPercentage = Double.parseDouble(tf3.getText());
                    // check if the input is valid
                    if (pointTotal <= 0 || earnedPoints <= 0 || earnedPoints > pointTotal || assignmentPercentage <= 0 || assignmentPercentage >100) {
                        showResult("Invalid input!");
                    } else {
                        Grades grade = new Grades(pointTotal, earnedPoints, assignmentPercentage);
                        showResult("Weighted Score:" + grade.getWeightedGrade());
                    }
                } catch(Exception exception) {
                    showResult("Invalid input!");
                }
            }
        });

        frame.setBounds(100,100,500,500);
        frame.setLayout(new GridLayout(5,1));
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);

        frame.setVisible(true);
    }

    public void showResult(String content){
        panel5.removeAll();
        panel5.setVisible(false);
        panel5.setVisible(true);
        JLabel label5 = new JLabel(content);
        panel5.add(label5);
        panel5.setLayout(new FlowLayout(FlowLayout.CENTER, 70, 40));
        frame.add(panel5);
        frame.setVisible(true);
    }


}
