package gui;

import java.awt.event.*;
import com.entity.User;
import com.util.Infortmation;
import com.util.InterfaceInformation;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/*
 * Created by JFormDesigner on Tue May 24 17:14:06 CST 2022
 */



/**
 * @author horizon
 */
public class photoCheck extends JFrame {
    private User user;
    private InterfaceInformation ii;
    public photoCheck(User user) {
        initComponents();
        this.user = user;
        ii = new Infortmation();
        initPhoto();
    }

    private void initPhoto(){
        ArrayList<ImageIcon> imageIcons = new ArrayList<>();
        for(int i=1;i<13;i++){
            String path = String.format("images/user/%s.png",i);
            System.out.println(path);
            ImageIcon image = new ImageIcon(getClass().getResource(path));
            image.setImage(image.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
            imageIcons.add(image);
        }
        photo1.setIcon(imageIcons.get(0));
        photo2.setIcon(imageIcons.get(1));
        photo3.setIcon(imageIcons.get(2));
        photo4.setIcon(imageIcons.get(3));
        photo5.setIcon(imageIcons.get(4));
        photo6.setIcon(imageIcons.get(5));
        photo7.setIcon(imageIcons.get(6));
        photo8.setIcon(imageIcons.get(7));
        photo9.setIcon(imageIcons.get(8));
        photo10.setIcon(imageIcons.get(9));
        photo11.setIcon(imageIcons.get(10));
        photo12.setIcon(imageIcons.get(11));
    }

    private void photo1MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/1.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo2MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/2.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo3MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/3.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo4MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/4.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo5MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/5.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo6MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/6.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo7MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/7.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo8MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/8.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo9MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/9.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo10MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/10.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo11MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/11.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void photo12MouseClicked(MouseEvent e) {
        // TODO add your code here
        user.setImage("images/user/12.png");
        if(ii.upDatePhoto(user))
            JOptionPane.showMessageDialog(null,"头像更新成功","系统提示",JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"头像更新失败","系统提示",JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - 张荣榆
        photo1 = new JLabel();
        photo2 = new JLabel();
        photo3 = new JLabel();
        photo4 = new JLabel();
        photo5 = new JLabel();
        photo6 = new JLabel();
        photo7 = new JLabel();
        photo8 = new JLabel();
        photo9 = new JLabel();
        photo10 = new JLabel();
        photo11 = new JLabel();
        photo12 = new JLabel();

        //======== this ========
        setTitle("\u5b66\u751f\u5b9e\u4e60\u7ba1\u7406\u7cfb\u7edf");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- photo1 ----
        photo1.setText("text");
        photo1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo1MouseClicked(e);
            }
        });
        contentPane.add(photo1);
        photo1.setBounds(10, 10, 80, 80);

        //---- photo2 ----
        photo2.setText("text");
        photo2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo2MouseClicked(e);
            }
        });
        contentPane.add(photo2);
        photo2.setBounds(90, 10, 80, 80);

        //---- photo3 ----
        photo3.setText("text");
        photo3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo3MouseClicked(e);
            }
        });
        contentPane.add(photo3);
        photo3.setBounds(170, 10, 80, 80);

        //---- photo4 ----
        photo4.setText("text");
        photo4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo4MouseClicked(e);
            }
        });
        contentPane.add(photo4);
        photo4.setBounds(250, 10, 80, 80);

        //---- photo5 ----
        photo5.setText("text");
        photo5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo5MouseClicked(e);
            }
        });
        contentPane.add(photo5);
        photo5.setBounds(330, 10, 80, 80);

        //---- photo6 ----
        photo6.setText("text");
        photo6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo6MouseClicked(e);
            }
        });
        contentPane.add(photo6);
        photo6.setBounds(410, 10, 80, 80);

        //---- photo7 ----
        photo7.setText("text");
        photo7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo7MouseClicked(e);
            }
        });
        contentPane.add(photo7);
        photo7.setBounds(10, 95, 80, 80);

        //---- photo8 ----
        photo8.setText("text");
        photo8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo8MouseClicked(e);
            }
        });
        contentPane.add(photo8);
        photo8.setBounds(90, 95, 80, 80);

        //---- photo9 ----
        photo9.setText("text");
        photo9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo9MouseClicked(e);
            }
        });
        contentPane.add(photo9);
        photo9.setBounds(170, 95, 80, 80);

        //---- photo10 ----
        photo10.setText("text");
        photo10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo10MouseClicked(e);
            }
        });
        contentPane.add(photo10);
        photo10.setBounds(250, 95, 80, 80);

        //---- photo11 ----
        photo11.setText("text");
        photo11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo11MouseClicked(e);
            }
        });
        contentPane.add(photo11);
        photo11.setBounds(330, 95, 80, 80);

        //---- photo12 ----
        photo12.setText("text");
        photo12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                photo12MouseClicked(e);
            }
        });
        contentPane.add(photo12);
        photo12.setBounds(410, 95, 80, 80);

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
    private JLabel photo1;
    private JLabel photo2;
    private JLabel photo3;
    private JLabel photo4;
    private JLabel photo5;
    private JLabel photo6;
    private JLabel photo7;
    private JLabel photo8;
    private JLabel photo9;
    private JLabel photo10;
    private JLabel photo11;
    private JLabel photo12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
