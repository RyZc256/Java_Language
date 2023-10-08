package gui;

import java.awt.event.*;
import com.entity.User;
import com.util.InterfaceLogin;
import com.util.opLogin;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 24 15:10:13 CST 2022
 * 找回密码/更改密码主界面
 * Unix Timestamp:1653378735
 */



/**
 * @author horizon
 */
public class ModifyPwd extends JFrame {
    private User user;

    private InterfaceLogin il;

    /**
     * 构造函数 (主界面)
     * @param user 用户类
     */
    public ModifyPwd(User user) {
        initComponents();
        this.user = user;
        tabbedPane1.remove(unKnown);
        il = new opLogin();
    }

    /**
     * 构造函数（登录界面）
     */
    public ModifyPwd(){
        initComponents();
        tabbedPane1.remove(known);
        il = new opLogin();
    }


    private void knowOk(ActionEvent e) {
        // TODO add your code here
        String[] password = new String[2];
        password[0] = knowNewpsdText.getText();
        password[1] = knowNewpsdCheckText.getText();

        // 判断两次密码是否一致
        if(!password[0].equals(password[1])){
            JOptionPane.showMessageDialog(null,"两次密码不一致","系统提示",JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{
            // 设置新密码
            user.setPassword(password[0]);
            if(il.reset(user)){
                JOptionPane.showMessageDialog(null,"密码更改成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            else
                JOptionPane.showMessageDialog(null,"密码更改失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void unKnowOk(ActionEvent e) {
        // TODO add your code here

        // 获取GUI控件的数据
        int account = Integer.parseInt(accountText.getText());
        String idCard = idCardText.getText();
        String[] password = new String[2];
        password[0] = unKnowNewpsdText.getText();
        password[1] = unKnowNewpsdCheckText.getText();

        // 查找数据库用户
        user = il.selectUser(accountText.getText());
        System.out.println(user.toString());
        // 判断用户名和密码是否匹配
        if(account == user.getAccount() && idCard.equals(user.getIdCard())){
            // 判断两次密码是否一致
            if(!password[0].equals(password[1])){
                JOptionPane.showMessageDialog(null,"两次密码不一致","系统提示",JOptionPane.INFORMATION_MESSAGE);
                return;
            }else{
                // 设置新密码
                user.setPassword(password[0]);
                if(il.reset(user))
                    JOptionPane.showMessageDialog(null,"密码更改成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null,"密码更改失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null,"用户名与身份证不匹配","系统提示",JOptionPane.INFORMATION_MESSAGE);
        }

    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        tabbedPane1 = new JTabbedPane();
        known = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        knowNewpsdText = new JPasswordField();
        knowNewpsdCheckText = new JPasswordField();
        knowOk = new JButton();
        unKnown = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        accountText = new JTextField();
        idCardText = new JTextField();
        unKnowNewpsdText = new JPasswordField();
        unKnowNewpsdCheckText = new JPasswordField();
        unKnowOk = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== known ========
            {
                known.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
                border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border.TitledBorder.CENTER
                ,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog",java.awt.Font
                .BOLD,12),java.awt.Color.red),known. getBorder()));known. addPropertyChangeListener(
                new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order"
                .equals(e.getPropertyName()))throw new RuntimeException();}});
                known.setLayout(null);

                //---- label1 ----
                label1.setText("\u65b0\u5bc6\u7801:");
                known.add(label1);
                label1.setBounds(new Rectangle(new Point(30, 25), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u518d\u6b21\u786e\u8ba4:");
                known.add(label2);
                label2.setBounds(new Rectangle(new Point(30, 70), label2.getPreferredSize()));
                known.add(knowNewpsdText);
                knowNewpsdText.setBounds(100, 15, 170, knowNewpsdText.getPreferredSize().height);
                known.add(knowNewpsdCheckText);
                knowNewpsdCheckText.setBounds(100, 60, 170, knowNewpsdCheckText.getPreferredSize().height);

                //---- knowOk ----
                knowOk.setText("\u66f4\u6539");
                knowOk.addActionListener(e -> knowOk(e));
                known.add(knowOk);
                knowOk.setBounds(new Rectangle(new Point(185, 115), knowOk.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < known.getComponentCount(); i++) {
                        Rectangle bounds = known.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = known.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    known.setMinimumSize(preferredSize);
                    known.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u627e\u56de\u5bc6\u7801", known);

            //======== unKnown ========
            {
                unKnown.setLayout(null);

                //---- label3 ----
                label3.setText("\u7528\u6237\u540d:");
                unKnown.add(label3);
                label3.setBounds(new Rectangle(new Point(30, 20), label3.getPreferredSize()));

                //---- label4 ----
                label4.setText("\u8eab\u4efd\u8bc1:");
                unKnown.add(label4);
                label4.setBounds(new Rectangle(new Point(30, 60), label4.getPreferredSize()));

                //---- label5 ----
                label5.setText("\u65b0\u5bc6\u7801:");
                unKnown.add(label5);
                label5.setBounds(new Rectangle(new Point(30, 100), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("\u518d\u6b21\u786e\u8ba4:");
                unKnown.add(label6);
                label6.setBounds(new Rectangle(new Point(30, 140), label6.getPreferredSize()));
                unKnown.add(accountText);
                accountText.setBounds(90, 15, 170, accountText.getPreferredSize().height);
                unKnown.add(idCardText);
                idCardText.setBounds(90, 55, 170, idCardText.getPreferredSize().height);
                unKnown.add(unKnowNewpsdText);
                unKnowNewpsdText.setBounds(90, 95, 170, unKnowNewpsdText.getPreferredSize().height);
                unKnown.add(unKnowNewpsdCheckText);
                unKnowNewpsdCheckText.setBounds(90, 135, 170, unKnowNewpsdCheckText.getPreferredSize().height);

                //---- unKnowOk ----
                unKnowOk.setText("\u66f4\u6539");
                unKnowOk.addActionListener(e -> unKnowOk(e));
                unKnown.add(unKnowOk);
                unKnowOk.setBounds(new Rectangle(new Point(175, 175), unKnowOk.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < unKnown.getComponentCount(); i++) {
                        Rectangle bounds = unKnown.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = unKnown.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    unKnown.setMinimumSize(preferredSize);
                    unKnown.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u627e\u56de\u5bc6\u7801", unKnown);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 305, 250);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JTabbedPane tabbedPane1;
    private JPanel known;
    private JLabel label1;
    private JLabel label2;
    private JPasswordField knowNewpsdText;
    private JPasswordField knowNewpsdCheckText;
    private JButton knowOk;
    private JPanel unKnown;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField accountText;
    private JTextField idCardText;
    private JPasswordField unKnowNewpsdText;
    private JPasswordField unKnowNewpsdCheckText;
    private JButton unKnowOk;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
