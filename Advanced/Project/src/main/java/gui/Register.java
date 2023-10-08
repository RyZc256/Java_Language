package gui;

import javax.swing.event.*;

import com.entity.Teacher;
import com.util.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun May 22 22:52:52 CST 2022
 * 注册账号主界面
 * Unix Timestamp:1653378696
 */



/**
 * @author horizon
 */
public class Register extends JFrame {
    private InterfaceRegister ir;

    private InterfaceRegular interfaceRegular;

    private ArrayList<String> colleges;
    public static void main(String[] args) {
        Register r = new Register();
        r.setVisible(true);
    }

    public Register() {
        initComponents();
        ir = new opRegister();
        interfaceRegular = new Regular();
        colleges = ir.SelectCollege();
        for(String i:colleges)
            collegeBox.addItem(i);
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
    }

    private void reset(ActionEvent e) {
        // TODO add your code here
        accountText.setText("");
        passwordText.setText("");
        nameText.setText("");
        famaleRb.setSelected(false);
        maleRb.setSelected(false);
        ageText.setText("");
        idCardText.setText("");
        telphoneText.setText("");
        teacherRb.setSelected(false);
        studentRb.setSelected(false);
        collegeBox.setSelectedIndex(0);
    }

    private void idCardTextCaretUpdate(CaretEvent e) {
        // TODO add your code here
        if(interfaceRegular.idCard(idCardText.getText()))
            tipIdCard.setVisible(false);
        else
            tipIdCard.setVisible(true);
    }

    private void telphoneTextCaretUpdate(CaretEvent e) {
        // TODO add your code here
        if(interfaceRegular.telphon(telphoneText.getText()))
            tipTelphone.setVisible(false);
        else
            tipTelphone.setVisible(true);
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        int account = Integer.parseInt(accountText.getText()); // 获取密码
        String password = passwordText.getText(); // 获取密码
        String name = nameText.getText(); // 获取姓名
        String sex = ""; // 获取性别
        if(famaleRb.isSelected())
            sex = "女";
        if(maleRb.isSelected())
            sex = "男";
        int age = Integer.parseInt(ageText.getText()); // 获取年龄
        String idCard = idCardText.getText(); // 获取身份证号
        String college = collegeBox.getSelectedItem().toString();
        String telphone = telphoneText.getText(); // 获取联系方式
        // 构造教师类型
        Teacher teacher = new Teacher(account,password,name,sex,age,idCard,telphone,null,college,new Datetime().now(),"teacher","未选择");
        if(!tipAccount.isVisible() && !tipTelphone.isVisible() && !tipIdCard.isVisible()) {
            String status = ir.Register(teacher);
            // 弹窗提示
            JOptionPane.showMessageDialog(null,status,"系统提示",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"信息不符合要求,请重新尝试","系统提示",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void accountTextCaretUpdate(CaretEvent e) {
        // TODO add your code here
        if(interfaceRegular.teacherAccount(accountText.getText()))
            tipAccount.setVisible(false);
        else
            tipAccount.setVisible(true);
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        passwordText = new JPasswordField();
        nameText = new JTextField();
        famaleRb = new JRadioButton();
        maleRb = new JRadioButton();
        ageText = new JTextField();
        idCardText = new JTextField();
        collegeBox = new JComboBox();
        telphoneText = new JTextField();
        teacherRb = new JRadioButton();
        studentRb = new JRadioButton();
        tipIdCard = new JLabel();
        tipTelphone = new JLabel();
        label1 = new JLabel();
        accountText = new JTextField();
        tipAccount = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        resetButton = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf\u2014\u2014\u6ce8\u518c");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
            awt.Font.BOLD,12),java.awt.Color.red),dialogPane. getBorder()))
            ;dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label2 ----
                label2.setText("\u5bc6\u7801:");
                contentPanel.add(label2);
                label2.setBounds(new Rectangle(new Point(20, 90), label2.getPreferredSize()));

                //---- label3 ----
                label3.setText("\u59d3\u540d:");
                contentPanel.add(label3);
                label3.setBounds(new Rectangle(new Point(20, 55), label3.getPreferredSize()));

                //---- label4 ----
                label4.setText("\u6027\u522b:");
                contentPanel.add(label4);
                label4.setBounds(new Rectangle(new Point(20, 125), label4.getPreferredSize()));

                //---- label5 ----
                label5.setText("\u5e74\u9f84:");
                contentPanel.add(label5);
                label5.setBounds(new Rectangle(new Point(20, 160), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("\u8eab\u4efd\u8bc1:");
                contentPanel.add(label6);
                label6.setBounds(new Rectangle(new Point(20, 200), label6.getPreferredSize()));

                //---- label7 ----
                label7.setText("\u8054\u7cfb\u7535\u8bdd:");
                contentPanel.add(label7);
                label7.setBounds(new Rectangle(new Point(20, 280), label7.getPreferredSize()));

                //---- label8 ----
                label8.setText("\u6240\u5c5e\u5b66\u9662:");
                contentPanel.add(label8);
                label8.setBounds(new Rectangle(new Point(20, 240), label8.getPreferredSize()));

                //---- label9 ----
                label9.setText("\u89d2\u8272:");
                contentPanel.add(label9);
                label9.setBounds(new Rectangle(new Point(20, 320), label9.getPreferredSize()));
                contentPanel.add(passwordText);
                passwordText.setBounds(115, 85, 170, passwordText.getPreferredSize().height);
                contentPanel.add(nameText);
                nameText.setBounds(115, 50, 170, nameText.getPreferredSize().height);

                //---- famaleRb ----
                famaleRb.setText("\u5973");
                contentPanel.add(famaleRb);
                famaleRb.setBounds(new Rectangle(new Point(210, 125), famaleRb.getPreferredSize()));

                //---- maleRb ----
                maleRb.setText("\u7537");
                contentPanel.add(maleRb);
                maleRb.setBounds(new Rectangle(new Point(120, 125), maleRb.getPreferredSize()));
                contentPanel.add(ageText);
                ageText.setBounds(115, 155, 170, ageText.getPreferredSize().height);

                //---- idCardText ----
                idCardText.addCaretListener(e -> idCardTextCaretUpdate(e));
                contentPanel.add(idCardText);
                idCardText.setBounds(115, 195, 170, idCardText.getPreferredSize().height);
                contentPanel.add(collegeBox);
                collegeBox.setBounds(115, 235, 170, collegeBox.getPreferredSize().height);

                //---- telphoneText ----
                telphoneText.addCaretListener(e -> telphoneTextCaretUpdate(e));
                contentPanel.add(telphoneText);
                telphoneText.setBounds(115, 275, 170, telphoneText.getPreferredSize().height);

                //---- teacherRb ----
                teacherRb.setText("\u6559\u5e08");
                contentPanel.add(teacherRb);
                teacherRb.setBounds(new Rectangle(new Point(120, 320), teacherRb.getPreferredSize()));

                //---- studentRb ----
                studentRb.setText("\u5b66\u751f");
                studentRb.setRolloverEnabled(true);
                studentRb.setEnabled(false);
                contentPanel.add(studentRb);
                studentRb.setBounds(new Rectangle(new Point(205, 320), studentRb.getPreferredSize()));

                //---- tipIdCard ----
                tipIdCard.setText("\u4fe1\u606f\u4e0d\u7b26\u5408\u8981\u6c42");
                tipIdCard.setVisible(false);
                contentPanel.add(tipIdCard);
                tipIdCard.setBounds(new Rectangle(new Point(300, 195), tipIdCard.getPreferredSize()));

                //---- tipTelphone ----
                tipTelphone.setText("\u4fe1\u606f\u4e0d\u7b26\u5408\u8981\u6c42");
                tipTelphone.setVisible(false);
                contentPanel.add(tipTelphone);
                tipTelphone.setBounds(new Rectangle(new Point(300, 275), tipTelphone.getPreferredSize()));

                //---- label1 ----
                label1.setText("\u7528\u6237\u540d:");
                contentPanel.add(label1);
                label1.setBounds(new Rectangle(new Point(20, 25), label1.getPreferredSize()));

                //---- accountText ----
                accountText.addCaretListener(e -> accountTextCaretUpdate(e));
                contentPanel.add(accountText);
                accountText.setBounds(115, 15, 170, accountText.getPreferredSize().height);

                //---- tipAccount ----
                tipAccount.setText("\u4fe1\u606f\u4e0d\u7b26\u5408\u8981\u6c42 \u4f8b\uff1a1000000");
                tipAccount.setVisible(false);
                contentPanel.add(tipAccount);
                tipAccount.setBounds(new Rectangle(new Point(295, 20), tipAccount.getPreferredSize()));

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

                //---- okButton ----
                okButton.setText("\u6ce8\u518c");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- resetButton ----
                resetButton.setText("\u91cd\u7f6e");
                resetButton.addActionListener(e -> {
			cancel(e);
			reset(e);
		});
                buttonBar.add(resetButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
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
        buttonGroup1.add(famaleRb);
        buttonGroup1.add(maleRb);

        //---- buttonGroup2 ----
        var buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(teacherRb);
        buttonGroup2.add(studentRb);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JPasswordField passwordText;
    private JTextField nameText;
    private JRadioButton famaleRb;
    private JRadioButton maleRb;
    private JTextField ageText;
    private JTextField idCardText;
    private JComboBox collegeBox;
    private JTextField telphoneText;
    private JRadioButton teacherRb;
    private JRadioButton studentRb;
    private JLabel tipIdCard;
    private JLabel tipTelphone;
    private JLabel label1;
    private JTextField accountText;
    private JLabel tipAccount;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton resetButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
