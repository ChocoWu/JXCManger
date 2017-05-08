package internalFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import model.TbUserlist;

import com.lzw.dao.Dao;
import com.lzw.login.Login;
public class GengGaiMiMa extends JInternalFrame{
	private JLabel name;
	private JPasswordField oldPass;
	private JPasswordField newPass2;
	private JPasswordField newPass1;
	private JLabel userName;
	private TbUserlist user = Login.getUser();//得到用户的姓名
	public GengGaiMiMa() {
		super();
		addInternalFrameListener(new InternalFrameAdapter() {
			public void internalFrameActivated(final InternalFrameEvent e) {
				userName.setText("<html><b>" + user.getUsername()
						+ "</b></html>");
				name.setText("<html><b>" + user.getName()
						+ "</b></html>");
			}
		});//直接从数据库中获得
		setIconifiable(true);
		setTitle("更改密码");
		setClosable(true);
		getContentPane().setLayout(new GridBagLayout());
		setBounds(100, 100, 300, 228);
		final JLabel label_4 = new JLabel();
		label_4.setFont(new Font("", Font.PLAIN, 14));
		label_4.setForeground(Color.RED);
		label_4.setText("<html>注：每个<b>操作员</b>只能修改自己的密码。</html>");//嵌入网页
		final GridBagConstraints gridBagConstraints_10 = new GridBagConstraints();//外观管理器
		gridBagConstraints_10.weighty = 1.0;//weighty = 0.0; 当窗口放大时，高度不变,行的权重，通过这个属性来决定如何分配行的剩余空间
		gridBagConstraints_10.gridwidth = 4;//横占4个单元格,组件所占列数，也是组件的宽度
		gridBagConstraints_10.gridx = 0;//组件的横纵坐标
		gridBagConstraints_10.gridy = 0;//组件的纵坐标
		getContentPane().add(label_4, gridBagConstraints_10);
		
		final JLabel label = new JLabel();
		label.setFont(new Font("", Font.PLAIN, 14));//设置字体
		label.setText("用户姓名：");
		final GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridy = 1;//指定组件显示区域顶部的单元格，其中最上面的单元格的gridy = 0。
		gridBagConstraints.gridx = 0;//指定包含组件显示区域前缘的单元格，其中行中的第一个单元格具有gridx = 0。
		getContentPane().add(label, gridBagConstraints);
		
		userName = new JLabel();
		userName.setPreferredSize(new Dimension(80,21));//设置一个高度为80，宽度为21的label
		final GridBagConstraints gridBagConstraints_1 = new GridBagConstraints();
		gridBagConstraints_1.weighty = 1.0;
		gridBagConstraints_1.ipadx = 30;//组件内部填充空间，即给组件的最小宽度添加多大的空间,组件间的横向间距
		gridBagConstraints_1.insets = new Insets(0, 0, 0, 10);//
//用来定义组件容器周围的空间大小
//第一个参数代表距上面有几个点的空白，第二个参数代表距左边有几个点的空白，
//第三个参数代表距下边有几个点的空白区域，第	四个参数代表距右边留几个点的空白区域。
		gridBagConstraints_1.fill = GridBagConstraints.HORIZONTAL;//当组件在其格内而不能撑满其格时，通过 fill的值来设定填充方式，有四个值
		gridBagConstraints_1.gridy = 1;
		gridBagConstraints_1.gridx = 1;
		getContentPane().add(userName, gridBagConstraints_1);
		
		final JLabel label_5 = new JLabel();
		label_5.setFont(new Font("", Font.PLAIN, 14));
		label_5.setText("登  录  名：");
		final GridBagConstraints gridBagConstraints_11 = new GridBagConstraints();
		gridBagConstraints_11.gridy = 2;
		gridBagConstraints_11.gridx = 0;
		getContentPane().add(label_5, gridBagConstraints_11);

		name = new JLabel();
		final GridBagConstraints gridBagConstraints_12 = new GridBagConstraints();
		gridBagConstraints_12.gridy = 2;
		gridBagConstraints_12.gridx = 1;
		gridBagConstraints_12.fill = GridBagConstraints.HORIZONTAL;
		getContentPane().add(name, gridBagConstraints_12);

		final JLabel label_1 = new JLabel();
		label_1.setFont(new Font("", Font.PLAIN, 14));
		label_1.setText("旧  密  码：");
		final GridBagConstraints gridBagConstraints_2 = new GridBagConstraints();
		gridBagConstraints_2.gridy = 3;
		gridBagConstraints_2.gridx = 0;
		getContentPane().add(label_1, gridBagConstraints_2);

		oldPass = new JPasswordField();
		final GridBagConstraints gridBagConstraints_3 = new GridBagConstraints();
		gridBagConstraints_3.weighty = 1.0;
		gridBagConstraints_3.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_3.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_3.gridwidth = 3;
		gridBagConstraints_3.gridy = 3;
		gridBagConstraints_3.gridx = 1;
		getContentPane().add(oldPass, gridBagConstraints_3);

		final JLabel label_2 = new JLabel();
		label_2.setFont(new Font("", Font.PLAIN, 14));
		label_2.setText("新  密  码：");
		final GridBagConstraints gridBagConstraints_4 = new GridBagConstraints();
		gridBagConstraints_4.gridy = 4;
		gridBagConstraints_4.gridx = 0;
		getContentPane().add(label_2, gridBagConstraints_4);

		newPass1 = new JPasswordField();
		newPass1.setFont(new Font("", Font.PLAIN, 14));
		final GridBagConstraints gridBagConstraints_5 = new GridBagConstraints();
		gridBagConstraints_5.weighty = 1.0;
		gridBagConstraints_5.ipadx = 30;
		gridBagConstraints_5.insets = new Insets(0, 0, 0, 10);
		gridBagConstraints_5.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints_5.gridwidth = 3;
		gridBagConstraints_5.gridy = 4;
		gridBagConstraints_5.gridx = 1;
		getContentPane().add(newPass1, gridBagConstraints_5);

		final JLabel label_3 = new JLabel();
		label_3.setFont(new Font("", Font.PLAIN, 14));
		label_3.setText("确认新密码：");
		final GridBagConstraints gridBagConstraints_6 = new GridBagConstraints();
		gridBagConstraints_6.gridy = 5;
		gridBagConstraints_6.gridx = 0;
		getContentPane().add(label_3, gridBagConstraints_6);

		

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				if (oldPass.getText().equals(user.getPass())) {
					if (newPass1.getText().equals(newPass2.getText())) {
						user.setPass(newPass1.getText());
						Dao.updateUser(user);
						oldPass.setText(null);
						newPass1.setText(null);
						newPass2.setText(null);
						JOptionPane.showMessageDialog(getContentPane(), "密码修改成功。");
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "两次输入的密码不一致，请重新输入。");
					}
				}else {
					JOptionPane.showMessageDialog(getContentPane(), "旧密码输入错误，请确认密码。");
				}
			}
		});
		button.setText("确认");
		final GridBagConstraints gridBagConstraints_8 = new GridBagConstraints();
		gridBagConstraints_8.weighty = 1.0;
		gridBagConstraints_8.anchor = GridBagConstraints.EAST;
		gridBagConstraints_8.gridy = 6;
		gridBagConstraints_8.gridx = 1;
		getContentPane().add(button, gridBagConstraints_8);

		final JButton button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				oldPass.setText(null);
				newPass1.setText(null);
				newPass2.setText(null);
			}
		});
		button_1.setText("重写");
		final GridBagConstraints gridBagConstraints_9 = new GridBagConstraints();
		gridBagConstraints_9.gridwidth = 2;
		gridBagConstraints_9.weighty = 1.0;
		gridBagConstraints_9.gridy = 6;
		gridBagConstraints_9.gridx = 2;
		getContentPane().add(button_1, gridBagConstraints_9);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
				{
			         public void run()
			         {
			        	 JFrame frame = new JFrame();
			     		 frame.setBounds(100, 100, 800, 600); 
			     		 desktopPane = new JDesktopPane();
			    		 frame.getContentPane().add(desktopPane);
			    		 JInternalFrame internalFrame = new GengGaiMiMa();
			    		 desktopPane.add(internalFrame);
			    		 internalFrame.setVisible(true);
			        	 frame.setVisible(true);
			         }
		             JDesktopPane desktopPane;
				});
	}

}
