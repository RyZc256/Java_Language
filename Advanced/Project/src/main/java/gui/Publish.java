package gui;

import com.entity.Student;
import com.entity.Task;
import com.entity.User;
import com.util.Datetime;
import com.util.InterfaceHome;
import com.util.opHome;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Thu May 26 20:52:11 CST 2022
 */



/**
 * @author horizon
 */
public class Publish extends JFrame {
    private InterfaceHome interfaceHome;
    private ArrayList<Student> students;
    private User user;

    public Publish(User user, ArrayList<Student> students) {
        interfaceHome = new opHome();
        this.user = user;
        this.students = students;
        initComponents();
        deadlineText.setText(new Datetime().now());
    }

    private void cancel(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void ok(ActionEvent e) {
        // TODO add your code here
        Task task = new Task(
                titleText.getText(),
                contentText.getText(),
                new Datetime().now(),
                deadlineText.getText(),
                user.getAccount()
        );
        if(interfaceHome.teaPublishTask(task,students)){
            JOptionPane.showMessageDialog(null,"任务发布成功","系统提醒",JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null,"任务发布失败","系统提醒",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        titleText = new JTextField();
        contentText = new JTextField();
        label3 = new JLabel();
        deadlineText = new JTextField();
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
            dialogPane.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder (
            0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border .TitledBorder
            . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt. Color .
            red ) ,dialogPane. getBorder () ) ); dialogPane. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java .
            beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u4efb\u52a1\u6807\u9898\uff1a");
                contentPanel.add(label1);
                label1.setBounds(new Rectangle(new Point(15, 15), label1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u4efb\u52a1\u5185\u5bb9:");
                contentPanel.add(label2);
                label2.setBounds(new Rectangle(new Point(15, 55), label2.getPreferredSize()));
                contentPanel.add(titleText);
                titleText.setBounds(85, 10, 300, titleText.getPreferredSize().height);
                contentPanel.add(contentText);
                contentText.setBounds(85, 50, 300, 225);

                //---- label3 ----
                label3.setText("\u622a\u6b62\u65e5\u671f:");
                contentPanel.add(label3);
                label3.setBounds(new Rectangle(new Point(15, 285), label3.getPreferredSize()));
                contentPanel.add(deadlineText);
                deadlineText.setBounds(85, 280, 300, deadlineText.getPreferredSize().height);

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
                okButton.setText("\u53d1\u5e03");
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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - 张荣榆
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label1;
    private JLabel label2;
    private JTextField titleText;
    private JTextField contentText;
    private JLabel label3;
    private JTextField deadlineText;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
