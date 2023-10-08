/*
 * Created by JFormDesigner on Sun Dec 12 21:41:12 CST 2021
 */

package UI;

import SQL.sqloperation;
import jdk.nashorn.internal.scripts.JO;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import java.sql.Array;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author 荣榆 张
 */
public class Visitors extends JFrame {
    // 创建一个用户对象
    User person;
    Date date;
    ArrayList Ticket_Price;
    ArrayList Ticket_Type;


    public Visitors() {
        initComponents();
        person = new User();
        date = new Date();
        // 选择框初始化
        comboBoxinit();
    }

    public static void main(String[] args){
        Visitors vi = new Visitors();
        vi.setVisible(true);
    }

    /**
     * 下拉选择框初始化
     * @param
     */
    public void comboBoxinit(){
        SQL.sqloperation db = new sqloperation();
        String sql = "select * from Ticket";
        Ticket_Type = db.GetType(sql,1);
        Ticket_Price = db.GetType(sql,2);
        for(int i=0;i<Ticket_Type.size();i++){
            type_comboBox.addItem(Ticket_Type.get(i));
        }
        // 获取今日日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        // 写入用户对象今日时间
        person.setOrder_CDate(sdf.format(cal.getTime()));
        // 只允许购买7日内的门票
        cal.add(Calendar.DATE,+0);
        date_comboBox.addItem(sdf.format(cal.getTime()));
        for (int i=0;i<6;i++){
            cal.add(Calendar.DATE,+1);
            date_comboBox.addItem(sdf.format(cal.getTime()));
        }
    }

    /**
     * 下单按钮监听
     * @param e
     */
    private void checkMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(check.getText().equals("下单")){
            if(!id_textField.getText().equals("") && id_textField.getText().length()==18 ){
                // 改变按钮性质
                check.setText("修改");
                // 日期
                insertdate(1);
                person.Order();
            }else{
                JOptionPane.showMessageDialog(null,"身份证有误","购票系统",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            if(!id_textField.getText().equals("") && id_textField.getText().length()==18){
                insertdate(0);
                person.Update();
            }else{
                JOptionPane.showMessageDialog(null,"身份证有误","购票系统",JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    /**
     * 插入数据
     * @param flag 1位首次创建，0为修改数据
     */
    public void insertdate(int flag){
        if(flag == 1){
            // 订单编号前缀
            person.setOrder_ID(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(date));
            // 订单编号后缀随机数,防止同时订单重复
            Random r = new Random();
            // 订单编号
            person.setOrder_ID(person.getOrder_ID() + r.nextInt(1000));
        }
        // 订单创建时间
        person.setOrder_CDate(new SimpleDateFormat("yyyy-MM-dd").format(date));
        // 身份证
        person.setSFZ(id_textField.getText());
        // 门票使用日期
        person.setOrder_JDate(date_comboBox.getSelectedItem().toString());
        // 客户端显示订单编号
        number_label.setText(person.getOrder_ID());
    }

    /**
     * 界面组件数据初始化
     */
    public void init(){
        number_label.setText("未生成");
        check.setText("下单");
        id_textField.setText("");
        type_comboBox.setSelectedIndex(0);
        date_comboBox.setSelectedIndex(0);
    }

    /**
     * 删除按钮监听
     * @param e
     */
    private void button2MouseClicked(MouseEvent e) {
        // TODO add your code here
        // 初始化界面
        init();
    }

    /**
     * 门票类型下拉选择框监听
     * @param e
     */
    private void type_comboBoxItemStateChanged(ItemEvent e) {
        // TODO add your code here
        String T_Type = type_comboBox.getSelectedItem().toString();
        person.setOrder_Type(T_Type);
        int index = type_comboBox.getSelectedIndex();
        try{
            price_label.setText("售价：" + Ticket_Price.get(index).toString());
            // 写入对象数据
            person.setOrder_Price(Double.parseDouble(Ticket_Price.get(index).toString()));
        }catch (Exception r){
            r.printStackTrace();
        }

    }

    /**
     * 付款按钮监听
     * @param e
     */
    private void pay_buttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(check.getText().equals("下单")){
            JOptionPane.showMessageDialog(null,"请先下单","购票系统",JOptionPane.WARNING_MESSAGE);
        }else{
            Object[] options = {"付款","取消"};
            int Result = JOptionPane.showOptionDialog(null,"信息检查无误是否付款","购票系统",
                    JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(Result == 0){
                if(person.Purchase()){
                    JOptionPane.showMessageDialog(null,"支付成功","购票系统",JOptionPane.INFORMATION_MESSAGE);
                    init();
                }else{
                    JOptionPane.showMessageDialog(null,"支付失败","购票系统",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private void his_buttonMouseClicked(MouseEvent e) {
        // TODO add your code here
        if(!id_textField.getText().equals("") && id_textField.getText().length() == 18){
            person.setSFZ(id_textField.getText());
            History history = new History(person);
            history.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"输入身份证信息再查询历史记录","购票系统",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    /**
     * 界面初始化
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        type_comboBox = new JComboBox();
        date_comboBox = new JComboBox();
        label4 = new JLabel();
        id_textField = new JTextField();
        check = new JButton();
        pay_button = new JButton();
        button2 = new JButton();
        his_button = new JButton();
        label5 = new JLabel();
        price_label = new JLabel();
        number_label = new JLabel();

        //======== this ========
        setTitle("\u5c55\u89c8\u9986\u8d2d\u7968\u7cfb\u7edf\u2014\u2014\u8bbf\u5ba2\u7aef");
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("\u5c55\u89c8\u9986\u8d2d\u7968\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 3f));

        //---- label2 ----
        label2.setText("\u95e8\u7968\u7c7b\u578b\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));

        //---- label3 ----
        label3.setText("\u95e8\u7968\u65e5\u671f\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));

        //---- type_comboBox ----
        type_comboBox.addItemListener(e -> type_comboBoxItemStateChanged(e));

        //---- label4 ----
        label4.setText("\u8eab\u4efd\u8bc1\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));

        //---- check ----
        check.setText("\u4e0b\u5355");
        check.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkMouseClicked(e);
            }
        });

        //---- pay_button ----
        pay_button.setText("\u4ed8\u6b3e");
        pay_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pay_buttonMouseClicked(e);
            }
        });

        //---- button2 ----
        button2.setText("\u5220\u9664");
        button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button2MouseClicked(e);
            }
        });

        //---- his_button ----
        his_button.setText("\u5386\u53f2");
        his_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                his_buttonMouseClicked(e);
            }
        });

        //---- label5 ----
        label5.setText("\u8ba2\u5355\u7f16\u53f7\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));

        //---- price_label ----
        price_label.setText("\u552e\u4ef7\uff1a0.00");
        price_label.setFont(price_label.getFont().deriveFont(price_label.getFont().getSize() + 2f));

        //---- number_label ----
        number_label.setText("\u672a\u751f\u6210");
        number_label.setFont(number_label.getFont().deriveFont(number_label.getFont().getSize() + 2f));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(0, 41, Short.MAX_VALUE)
                    .addComponent(check)
                    .addGap(18, 18, 18)
                    .addComponent(pay_button)
                    .addGap(18, 18, 18)
                    .addComponent(button2)
                    .addGap(18, 18, 18)
                    .addComponent(his_button)
                    .addGap(36, 36, 36))
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label3)
                                        .addComponent(label4)
                                        .addComponent(label5))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(date_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(id_textField, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(number_label)))
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(type_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                    .addComponent(price_label, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label1)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(type_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(price_label))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(date_comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(id_textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label5)
                        .addComponent(number_label))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(check)
                        .addComponent(pay_button)
                        .addComponent(button2)
                        .addComponent(his_button))
                    .addGap(26, 26, 26))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JComboBox type_comboBox;
    private JComboBox date_comboBox;
    private JLabel label4;
    private JTextField id_textField;
    private JButton check;
    private JButton pay_button;
    private JButton button2;
    private JButton his_button;
    private JLabel label5;
    private JLabel price_label;
    private JLabel number_label;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
