import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FlatFileGraphic {

    //initiate veriables
    public JFrame frame;
    JPanel panelLeft = new JPanel();
    JPanel panelRight = new JPanel();

    JPanel panelLeftTop = new JPanel();
    JPanel panelLeftBottom = new JPanel();

    JPanel panelRightTop = new JPanel();
    JPanel panelRightBottom = new JPanel();

    JPanel panelLeftTop1 = new JPanel();
    JPanel panelLeftTop2 = new JPanel();
    JPanel panelLeftTop3 = new JPanel();
    JPanel panelLeftTop4 = new JPanel();
    JPanel panelRightTop1 = new JPanel();
    JPanel panelRightTop2 = new JPanel();
    JPanel panelRightTop3 = new JPanel();
    JPanel panelRightTop4 = new JPanel();

    JTextArea ta1 = new JTextArea(10, 30);
    JTextArea ta2 = new JTextArea(10, 30);

    String[] res;

    public void initiateWindow() {

        //Creating the Frame
        frame = new JFrame("Weighted Grade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        panelLeft.setSize(300, 600);
        panelRight.setSize(300, 600);

        // read part
        JLabel label1 = new JLabel("Reading File Name:");
        JTextField tf1 = new JTextField("annual.csv", 30);  // accepts up to 30 characters
        JButton button1 = new JButton("Click to read from file");
        JLabel label3 = new JLabel("First five lines of file:");
        // button action
        button1.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String fileName = FlatFileGraphic.class.getResource("") + tf1.getText();
                fileName = fileName.split(":")[1];
                BufferedReader br = null;
                String line = "";
                String csvSplit = ",";
                res = new String[5];
                try {
                    br = new BufferedReader(new FileReader(fileName));
                    int i = 0;
                    while((line = br.readLine()) != null && i < 5){
                        res[i] = "";
                        String toAppend = "";
                        String[] temp = line.split(csvSplit);
                        for (int j = 0; j < temp.length && j < 3; j++) {
                            if (j==0) {
                                res[i] += temp[j];
                                toAppend += temp[j];
                            } else {
                                res[i] += "," + temp[j];
                                toAppend += "," + temp[j];
                            }
                        }

                        ta1.append(line+"\r\n");
                        ta2.append(res[i]+"\r\n");
                        i++;
                    }
                    // ta1.setLineWrap(true);
                    ta1.setWrapStyleWord(true);
                    frame.setVisible(true);

                } catch(Exception exception) {
                    System.out.println(exception);
                }
            }
        });

        // write part
        JLabel label2 = new JLabel("File Name to write:");
        JTextField tf2 = new JTextField(30);  // accepts up to 30 characters
        JButton button2 = new JButton("Click to write to file");
        JLabel label4 = new JLabel("First five lines of new file:");

        button2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                    String fileName = tf2.getText();
                    File fout = new File(fileName);
                    FileOutputStream fos = new FileOutputStream(fout);

                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

                    for (int i = 0; i < res.length; i++) {
                        bw.write(res[i]);
                        bw.newLine();
                    }

                    bw.close();
                    System.out.println("Output Success!");

                } catch(Exception exception) {
                    System.out.println(exception);
                }
            }
        });

        // add items to frame
        panelLeftTop1.add(label1);
        panelLeftTop1.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
        panelLeftTop2.add(tf1);
        panelLeftTop2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        panelLeftTop3.add(button1);
        panelLeftTop3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        panelLeftTop4.add(label3);
        panelLeftTop4.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
        panelLeftTop.setLayout(new GridLayout(4,1, 10, 10));
        panelLeftTop.add(panelLeftTop1);
        panelLeftTop.add(panelLeftTop2);
        panelLeftTop.add(panelLeftTop3);
        panelLeftTop.add(panelLeftTop4);
        panelLeft.add(panelLeftTop, BorderLayout.NORTH);
        panelLeft.add(panelLeftBottom, BorderLayout.SOUTH);

        panelRightTop1.add(label2);
        panelRightTop1.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
        panelRightTop2.add(tf2);
        panelRightTop2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        panelRightTop3.add(button2);
        panelRightTop3.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        panelRightTop4.add(label4);
        panelRightTop4.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 15));
        panelRightTop.setLayout(new GridLayout(4,1, 10, 10));
        panelRightTop.add(panelRightTop1);
        panelRightTop.add(panelRightTop2);
        panelRightTop.add(panelRightTop3);
        panelRightTop.add(panelRightTop4);

        ta1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        ta2.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 15));
        panelLeftBottom.add(ta1);
        panelRightBottom.add(ta2);

        panelRight.add(panelRightTop, BorderLayout.NORTH);
        panelRight.add(panelRightBottom, BorderLayout.SOUTH);

        frame.setLayout(new GridLayout(1,2, 10, 10));
        frame.add(panelLeft);
        frame.add(panelRight);
        frame.setVisible(true);
    }

}
