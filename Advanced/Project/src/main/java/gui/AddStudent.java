package gui;

import com.entity.Student;
import com.entity.User;
import com.util.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
 * Created by JFormDesigner on Sat May 28 14:46:41 CST 2022
 */



/**
 * @author horizon
 */
public class AddStudent extends JFrame {
    private int infoFlag;
    private InterfaceInformation interfaceInformation;
    private Regular regular;

    public static void main(String[] args) {
        AddStudent as=  new AddStudent();
        as.setVisible(true);
    }

    public AddStudent() {
        initComponents();
        init();
    }

    private void collegeBoxItemStateChanged(ItemEvent e) {
        // TODO add your code here
        ArrayList<String> colleges = interfaceInformation.getAllClass(collegeBox.getSelectedItem().toString());
        classBox.removeAllItems();
        for(String i:colleges)
            classBox.addItem(i);
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        if(regular.idCard(idCardText.getText()) && regular.telphon(telphoneText.getText())){
            User user = new Student();
            user.setName(nameText.getText());
            user.setPassword(passwordField1.getText());
            user.setAge(Integer.parseInt(ageText.getText()));
            if(femaleButton.isValid())
                user.setSex("女");
            if(maleButton.isValid())
                user.setSex("男");
            user.setIdCard(idCardText.getText());
            user.setTelphone(telphoneText.getText());
            user.setCollege(collegeBox.getSelectedItem().toString());
            user.setsClass(classBox.getSelectedItem().toString());
            interfaceInformation.singleAddStu(user);
            AddInfo(String.format("新增学生:%s,学号:%s",user.getName(),user.getAccount()));
        }else
            //，实在是不想拆分了,就这样吧，
            JOptionPane.showMessageDialog(null,"身份证或者手机号好有误","系统提醒",JOptionPane.INFORMATION_MESSAGE);
    }


    public void AddInfo(String info){
        if(infoFlag<5) {
            InfoLabel.setText(InfoLabel.getText().substring(0, InfoLabel.getText().length() - 7) + info + "<br></html>");
        } else{
            infoFlag = 1;
            InfoLabel.setText("<html>消息:<br>"+info+"<br></html>");
        }
        infoFlag++;
    }


    public void init(){
        interfaceInformation = new Infortmation();
        regular = new Regular();
        infoFlag = 0;
        String Info = "<html>消息:<br></html>";
        InfoLabel.setText(Info);
        ArrayList<String> colleges = interfaceInformation.getAllCollege();
        for(String i:colleges)
            collegeBox.addItem(i);
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        ArrayList<User> students = new ArrayList<>();
        ArrayList<String> datas = new ArrayList<>(); // List初始化
        // ftp内文件名称
        try{
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file", "txt");
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            chooser.setFileFilter(filter);
            chooser.setAcceptAllFileFilterUsed(false);
            int returnVal = chooser.showDialog(this, "确定");
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getName();
                if(filename.endsWith("txt")) {
                    String path = chooser.getSelectedFile().toString();
                    InputStreamReader reader = new InputStreamReader(new FileInputStream(chooser.getSelectedFile()));
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String line = "";
                    line = bufferedReader.readLine();
                    // 逐行读取
                    line = bufferedReader.readLine();
                    do {
                        System.out.println(line);
                        User user = new Student();
                        String[] info = line.split(" ");
                        user.setName(info[0]);
                        user.setPassword(info[1]);
                        user.setAge(Integer.parseInt(info[2]));
                        user.setSex(info[3]);
                        user.setIdCard(info[4]);
                        user.setTelphone(info[5]);
                        user.setCollege(info[6]);
                        user.setsClass(info[7]);
                        interfaceInformation.singleAddStu(user);
                        students.add(user);
                        line = bufferedReader.readLine();
                    }while(line != null);
                }
                else
                    JOptionPane.showMessageDialog(null,"文件类型不支持","系统提醒",JOptionPane.INFORMATION_MESSAGE);
            }
            String writeInfo = "";
            for (User i:students){
                writeInfo += String.format("学号:%s,密码:%s,姓名:%s,年龄:%s,性别:%s,身份证:%s,联系电话:%s,学院:%s,班级:%s\n",
                        i.getAccount(),
                        i.getPassword(),
                        i.getName(),
                        i.getAge(),
                        i.getSex(),
                        i.getIdCard(),
                        i.getTelphone(),
                        i.getCollege(),
                        i.getsClass());
            }

            // 写文件
            File write = new File(String.format("target/Info/%s-StudentList.txt",new Datetime().now()));
            write.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(write));
            out.write(writeInfo);
            out.flush();
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        passwordField1 = new JPasswordField();
        nameLabel = new JLabel();
        nameText = new JTextField();
        sexLabel = new JLabel();
        maleButton = new JRadioButton();
        femaleButton = new JRadioButton();
        ageText = new JTextField();
        ageLabel = new JLabel();
        idCardLabel = new JLabel();
        idCardText = new JTextField();
        telphoneText = new JTextField();
        telphoneLabel = new JLabel();
        collegeLabel = new JLabel();
        collegeBox = new JComboBox();
        classLabel = new JLabel();
        classBox = new JComboBox();
        InfoLabel = new JLabel();
        buttonBar = new JPanel();
        button1 = new JButton();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,dialogPane. getBorder () ) )
            ; dialogPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u5bc6\u7801:");
                contentPanel.add(label1);
                label1.setBounds(new Rectangle(new Point(15, 15), label1.getPreferredSize()));
                contentPanel.add(passwordField1);
                passwordField1.setBounds(80, 5, 250, passwordField1.getPreferredSize().height);

                //---- nameLabel ----
                nameLabel.setText("\u59d3\u540d:");
                contentPanel.add(nameLabel);
                nameLabel.setBounds(15, 55, 50, nameLabel.getPreferredSize().height);
                contentPanel.add(nameText);
                nameText.setBounds(80, 45, 250, nameText.getPreferredSize().height);

                //---- sexLabel ----
                sexLabel.setText("\u6027\u522b:");
                contentPanel.add(sexLabel);
                sexLabel.setBounds(15, 90, 50, sexLabel.getPreferredSize().height);

                //---- maleButton ----
                maleButton.setText("\u7537");
                contentPanel.add(maleButton);
                maleButton.setBounds(new Rectangle(new Point(85, 85), maleButton.getPreferredSize()));

                //---- femaleButton ----
                femaleButton.setText("\u5973");
                contentPanel.add(femaleButton);
                femaleButton.setBounds(new Rectangle(new Point(150, 85), femaleButton.getPreferredSize()));
                contentPanel.add(ageText);
                ageText.setBounds(80, 115, 250, ageText.getPreferredSize().height);

                //---- ageLabel ----
                ageLabel.setText("\u5e74\u9f84:");
                contentPanel.add(ageLabel);
                ageLabel.setBounds(15, 125, 50, ageLabel.getPreferredSize().height);

                //---- idCardLabel ----
                idCardLabel.setText("\u8eab\u4efd\u8bc1:");
                contentPanel.add(idCardLabel);
                idCardLabel.setBounds(15, 160, 50, idCardLabel.getPreferredSize().height);
                contentPanel.add(idCardText);
                idCardText.setBounds(80, 150, 250, idCardText.getPreferredSize().height);
                contentPanel.add(telphoneText);
                telphoneText.setBounds(80, 185, 250, telphoneText.getPreferredSize().height);

                //---- telphoneLabel ----
                telphoneLabel.setText("\u8054\u7cfb\u65b9\u5f0f:");
                contentPanel.add(telphoneLabel);
                telphoneLabel.setBounds(15, 195, 70, telphoneLabel.getPreferredSize().height);

                //---- collegeLabel ----
                collegeLabel.setText("\u6240\u5c5e\u5b66\u9662:");
                contentPanel.add(collegeLabel);
                collegeLabel.setBounds(15, 230, 70, collegeLabel.getPreferredSize().height);

                //---- collegeBox ----
                collegeBox.addItemListener(e -> collegeBoxItemStateChanged(e));
                contentPanel.add(collegeBox);
                collegeBox.setBounds(80, 220, 250, collegeBox.getPreferredSize().height);

                //---- classLabel ----
                classLabel.setText("\u6240\u5c5e\u73ed\u7ea7:");
                contentPanel.add(classLabel);
                classLabel.setBounds(15, 265, 70, classLabel.getPreferredSize().height);
                contentPanel.add(classBox);
                classBox.setBounds(80, 255, 250, classBox.getPreferredSize().height);

                //---- InfoLabel ----
                InfoLabel.setText("text");
                InfoLabel.setVerticalAlignment(SwingConstants.TOP);
                contentPanel.add(InfoLabel);
                InfoLabel.setBounds(15, 300, 310, 105);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- button1 ----
                button1.setText("\u6279\u91cf\u6dfb\u52a0");
                button1.addActionListener(e -> button1(e));
                buttonBar.add(button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("\u6dfb\u52a0");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
                cancelButton.addActionListener(e -> cancel(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(maleButton);
        buttonGroup1.add(femaleButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JPasswordField passwordField1;
    private JLabel nameLabel;
    private JTextField nameText;
    private JLabel sexLabel;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JTextField ageText;
    private JLabel ageLabel;
    private JLabel idCardLabel;
    private JTextField idCardText;
    private JTextField telphoneText;
    private JLabel telphoneLabel;
    private JLabel collegeLabel;
    private JComboBox collegeBox;
    private JLabel classLabel;
    private JComboBox classBox;
    private JLabel InfoLabel;
    private JPanel buttonBar;
    private JButton button1;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
