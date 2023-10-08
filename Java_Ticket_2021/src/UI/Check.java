/*
 * Created by JFormDesigner on Wed Dec 15 20:03:37 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 荣榆 张
 */
public class Check extends JFrame {
    Ticket ticket;
    String[] data;
    public Check() {
        initComponents();
        ticket = new Ticket();
    }

    public static void main(String[] args){
        Check ck = new Check();
        ck.setVisible(true);
        ck.id_textField.setText("20211214200507275459");
        ck.sfz_textField.setText("350201199901011293");
    }

    private void button1MouseClicked(MouseEvent e) {
        // TODO add your code here
        ticket.setID(sfz_textField.getText());
        ticket.setSID(id_textField.getText());
        // 判断是否输入数据以及是否符合条件
        if(!id_textField.getText().equals("") && !sfz_textField.getText().equals("") && sfz_textField.getText().length() == 18){
            data = ticket.check();
            if(data[2].equals("1")){
                status_label.setText("此门票已使用");
            }else{
                status_label.setText("此门票未使用");
            }
            type_label.setText(data[0]);
        }
    }

    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!status_label.getText().equals("未查询") && !type_label.getText().equals("未查询")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String Today = sdf.format(cal.getTime());
            // 判断门票是否是今天的门票
            if(data[1].equals(Today)){
                // 判断门票是否使用
                if(data[2].equals("0")){
                    Object[] options = {"确认","取消"};
                    int Result = JOptionPane.showOptionDialog(null,"是否确认入场","检票系统",
                            JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(Result == 0){
                        // 入场成功，写入数据
                        if(ticket.enter()){
                            JOptionPane.showMessageDialog(null,"成功入场","检票系统",JOptionPane.INFORMATION_MESSAGE );
                            type_label.setText("未查询");
                            status_label.setText("未查询");
                        }else{
                            JOptionPane.showMessageDialog(null,"入场失败，请稍后再试","检票系统",JOptionPane.WARNING_MESSAGE );
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"此门票已使用,请重新购票","检票系统",JOptionPane.WARNING_MESSAGE );
                }
            }else{
                JOptionPane.showMessageDialog(null,"此门票使用日期为："+data[1],"检票系统",JOptionPane.INFORMATION_MESSAGE );
            }
        }else{
            JOptionPane.showMessageDialog(null,"请先检票再入场","检票系统",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        id_textField = new JTextField();
        sfz_textField = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        label5 = new JLabel();
        type_label = new JLabel();
        status_label = new JLabel();

        //======== this ========
        setTitle("\u5c55\u89c8\u9986\u8d2d\u7968\u7cfb\u7edf\u2014\u2014\u68c0\u7968\u7aef");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u8d2d\u7968\u7cfb\u7edf\u68c0\u7968\u7aef");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));

        //---- label2 ----
        label2.setText("\u8ba2\u5355\u7f16\u53f7\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- label3 ----
        label3.setText("\u8eab\u4efd\u8bc1\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

        //---- button1 ----
        button1.setText("\u68c0\u7968");
        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5165\u573a");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- label4 ----
        label4.setText("\u95e8\u7968\u7c7b\u578b\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- label5 ----
        label5.setText("\u95e8\u7968\u72b6\u6001\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

        //---- type_label ----
        type_label.setText("\u672a\u67e5\u8be2");
        type_label.setFont(type_label.getFont().deriveFont(type_label.getFont().getSize() + 2f));

        //---- status_label ----
        status_label.setText("\u672a\u67e5\u8be2");
        status_label.setFont(status_label.getFont().deriveFont(status_label.getFont().getSize() + 2f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label4)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                    .addComponent(label2)
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(label3)))
                                .addComponent(label5))
                            .addGap(18, 18, 18)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(sfz_textField, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(id_textField, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(type_label, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addComponent(status_label, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))))
                    .addContainerGap(39, Short.MAX_VALUE))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(button1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                    .addComponent(button2)
                    .addGap(81, 81, 81))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addGap(26, 26, 26)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(id_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(sfz_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(type_label))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(status_label))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(11, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField id_textField;
    private JTextField sfz_textField;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JLabel label5;
    private JLabel type_label;
    private JLabel status_label;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
