package gui;

import java.awt.event.*;
import java.beans.*;

import com.entity.Student;
import com.entity.Teacher;
import com.entity.User;
import com.util.Infortmation;
import com.util.InterfaceInformation;
import gui.photoCheck;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 24 15:59:44 CST 2022
 */



/**
 * @author horizon
 */
public class EditInformation extends JFrame {
    private User user;
    private InterfaceInformation ii;

    public EditInformation(User user,int role) {
        initComponents();
        this.user = user;
        ii = new Infortmation();

        // 学生禁止修改搬家
        if(user.getRole().equals("student") && role == 0) {
            classBox.setEnabled(false);
            collegeBox.setEnabled(false);
        }
        initInformation();
    }

    private void button1(ActionEvent e) {
        // TODO add your code here
        photoCheck photoCheck = new photoCheck(user);
        photoCheck.setVisible(true);
    }

    private void button2(ActionEvent e) {
        // TODO add your code here
        User temp;
        temp = user;
        temp.setName(nameText.getText());
        if(maleButton.isSelected())
            temp.setSex("男");
        if(femaleButton.isSelected())
            temp.setSex("女");
        temp.setAge(Integer.parseInt(ageText.getText()));
        temp.setIdCard(idCardText.getText());
        temp.setTelphone(telphoneText.getText());
        temp.setCollege(collegeBox.getSelectedItem().toString());
        temp.setsClass(classBox.getSelectedItem().toString());
        if(ii.upDateInformation(temp)){
            user = temp;
            JOptionPane.showMessageDialog(null,"资料更新成功","系统提醒",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"资料更新失败","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void collegeBoxItemStateChanged(ItemEvent e) {
        // TODO add your code here
        classBox.removeAllItems();
        for(String i:ii.getAllClass(collegeBox.getSelectedItem().toString()))
            classBox.addItem(i);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        nameLabel = new JLabel();
        sexLabel = new JLabel();
        ageLabel = new JLabel();
        idCardLabel = new JLabel();
        telphoneLabel = new JLabel();
        collegeLabel = new JLabel();
        classLabel = new JLabel();
        lastOnlineLabel = new JLabel();
        photo = new JLabel();
        nameText = new JTextField();
        maleButton = new JRadioButton();
        femaleButton = new JRadioButton();
        ageText = new JTextField();
        idCardText = new JTextField();
        telphoneText = new JTextField();
        collegeBox = new JComboBox();
        classBox = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- nameLabel ----
        nameLabel.setText("\u59d3\u540d:");
        contentPane.add(nameLabel);
        nameLabel.setBounds(120, 40, 50, nameLabel.getPreferredSize().height);

        //---- sexLabel ----
        sexLabel.setText("\u6027\u522b:");
        contentPane.add(sexLabel);
        sexLabel.setBounds(120, 75, 50, sexLabel.getPreferredSize().height);

        //---- ageLabel ----
        ageLabel.setText("\u5e74\u9f84:");
        contentPane.add(ageLabel);
        ageLabel.setBounds(120, 110, 50, ageLabel.getPreferredSize().height);

        //---- idCardLabel ----
        idCardLabel.setText("\u8eab\u4efd\u8bc1:");
        contentPane.add(idCardLabel);
        idCardLabel.setBounds(120, 145, 50, idCardLabel.getPreferredSize().height);

        //---- telphoneLabel ----
        telphoneLabel.setText("\u8054\u7cfb\u65b9\u5f0f:");
        contentPane.add(telphoneLabel);
        telphoneLabel.setBounds(120, 180, 70, telphoneLabel.getPreferredSize().height);

        //---- collegeLabel ----
        collegeLabel.setText("\u6240\u5c5e\u5b66\u9662:");
        contentPane.add(collegeLabel);
        collegeLabel.setBounds(120, 215, 70, collegeLabel.getPreferredSize().height);

        //---- classLabel ----
        classLabel.setText("\u6240\u5c5e\u73ed\u7ea7:");
        contentPane.add(classLabel);
        classLabel.setBounds(120, 250, 70, classLabel.getPreferredSize().height);

        //---- lastOnlineLabel ----
        lastOnlineLabel.setText("\u6700\u540e\u767b\u5f55\u65f6\u95f4:");
        contentPane.add(lastOnlineLabel);
        lastOnlineLabel.setBounds(120, 285, 250, lastOnlineLabel.getPreferredSize().height);
        contentPane.add(photo);
        photo.setBounds(15, 30, 90, 90);
        contentPane.add(nameText);
        nameText.setBounds(185, 30, 150, nameText.getPreferredSize().height);

        //---- maleButton ----
        maleButton.setText("\u7537");
        contentPane.add(maleButton);
        maleButton.setBounds(new Rectangle(new Point(190, 70), maleButton.getPreferredSize()));

        //---- femaleButton ----
        femaleButton.setText("\u5973");
        contentPane.add(femaleButton);
        femaleButton.setBounds(new Rectangle(new Point(255, 70), femaleButton.getPreferredSize()));
        contentPane.add(ageText);
        ageText.setBounds(185, 100, 150, ageText.getPreferredSize().height);
        contentPane.add(idCardText);
        idCardText.setBounds(185, 135, 150, idCardText.getPreferredSize().height);
        contentPane.add(telphoneText);
        telphoneText.setBounds(185, 170, 150, telphoneText.getPreferredSize().height);

        //---- collegeBox ----
        collegeBox.addItemListener(e -> collegeBoxItemStateChanged(e));
        contentPane.add(collegeBox);
        collegeBox.setBounds(185, 205, 150, collegeBox.getPreferredSize().height);
        contentPane.add(classBox);
        classBox.setBounds(185, 240, 150, classBox.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u4fee\u6539\u5934\u50cf");
        button1.addActionListener(e -> button1(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(15, 130), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u4fee\u6539");
        button2.addActionListener(e -> button2(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(245, 320), button2.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(maleButton);
        buttonGroup1.add(femaleButton);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void initInformation(){
        InterfaceInformation ii = new Infortmation();

        // 头像显示
        Thread photoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    ImageIcon image = new ImageIcon(getClass().getResource(user.getImage()));
                    image.setImage(image.getImage().getScaledInstance(90,90,Image.SCALE_DEFAULT));
                    photo.setIcon(image);
                }
            }
        });
        photoThread.start();

        nameText.setText(user.getName());
        if(user.getSex().equals("男"))
            maleButton.setSelected(true);
        else
            femaleButton.setSelected(true);
        ageText.setText(Integer.toString(user.getAge()));
        idCardText.setText(user.getIdCard());
        telphoneText.setText(user.getTelphone());
        // 获取所有学院
        for(String i:ii.getAllCollege())
            collegeBox.addItem(i);
        collegeBox.setSelectedItem(user.getCollege());
        // 获取所有班级
        for(String i:ii.getAllClass(user.getCollege()))
            classBox.addItem(i);
        classBox.setSelectedItem(user.getClass());
        lastOnlineLabel.setText(lastOnlineLabel.getText() + user.getLastOnline());
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JLabel nameLabel;
    private JLabel sexLabel;
    private JLabel ageLabel;
    private JLabel idCardLabel;
    private JLabel telphoneLabel;
    private JLabel collegeLabel;
    private JLabel classLabel;
    private JLabel lastOnlineLabel;
    private JLabel photo;
    private JTextField nameText;
    private JRadioButton maleButton;
    private JRadioButton femaleButton;
    private JTextField ageText;
    private JTextField idCardText;
    private JTextField telphoneText;
    private JComboBox collegeBox;
    private JComboBox classBox;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
