package gui;

import java.awt.event.*;

import com.entity.User;
import com.util.InterfaceLogin;
import com.util.opLogin;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
/*
 * Created by JFormDesigner on Sun May 22 22:54:38 CST 2022
 */



/**
 * @author horizon
 */
public class Login extends JFrame {

    private InterfaceLogin il;
    private User user;

    public static void main(String[] args) {
        Login login = new Login();
        login.setVisible(true);
    }

    public Login() {
        initComponents();
        il = new opLogin();
    }

    // 账号发生改变
    private void accountTextCaretUpdate(CaretEvent e) {
        // TODO add your code here
        user = il.selectUser(accountText.getText());
        ImageIcon image = new ImageIcon(getClass().getResource(user.getImage()));
        image.setImage(image.getImage().getScaledInstance(60,60,Image.SCALE_DEFAULT));
        label3.setIcon(image);
//        System.out.println(user.getAccount());
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        user = null;
        // 查询用户
        user = il.selectUser(accountText.getText());
        String password = passwordText.getText();
        if (user.getEnable() == 1 && user.getRole().equals("teacher") || user.getRole().equals("student")){
            user.toString();
            if (password.equals(user.getPassword())) {
                JOptionPane.showMessageDialog(null, String.format("%s欢迎回来,上次登录时间:%s", user.getName(), user.getLastOnline()), "系统提醒", JOptionPane.INFORMATION_MESSAGE);
                // 更新时间
                if(!il.upDateLastOnline(user))
                    JOptionPane.showMessageDialog(null,"最后登录时间更新失误","系统提醒",JOptionPane.INFORMATION_MESSAGE);
                // 判断新建什么窗口
                if(user.getRole().equals("student")){
                    StudentHome st = new StudentHome(user);
                    st.setVisible(true);
                }else{
                    TeacherHome tt = new TeacherHome(user);
                    tt.setVisible(true);
                }
                // 关闭窗口
                dispose();
            }else{
                JOptionPane.showMessageDialog(null,String.format("%s密码错误，请重试", user.getName()),"系统提醒",JOptionPane.INFORMATION_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(null,"账号未启用,请联系管理员","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
        ModifyPwd modifyPwd = new ModifyPwd();
        modifyPwd.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        accountText = new JTextField();
        passwordText = new JPasswordField();
        label3 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax
            .swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing
            .border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.
            Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.red
            ),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override
            public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName(
            )))throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u7528\u6237\u540d:");
                contentPanel.add(label1);
                label1.setBounds(new Rectangle(new Point(95, 30), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u5bc6\u7801:");
                contentPanel.add(label2);
                label2.setBounds(new Rectangle(new Point(95, 70), label2.getPreferredSize()));

                //---- accountText ----
                accountText.addCaretListener(e -> accountTextCaretUpdate(e));
                contentPanel.add(accountText);
                accountText.setBounds(170, 25, 180, accountText.getPreferredSize().height);
                contentPanel.add(passwordText);
                passwordText.setBounds(170, 65, 180, passwordText.getPreferredSize().height);
                contentPanel.add(label3);
                label3.setBounds(20, 30, 60, 60);

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
                okButton.setText("\u767b\u5f55");
                okButton.addActionListener(e -> ok(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u5fd8\u8bb0\u5bc6\u7801");
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JTextField accountText;
    private JPasswordField passwordText;
    private JLabel label3;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
