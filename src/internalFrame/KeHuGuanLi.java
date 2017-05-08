package internalFrame;
import internalFrame.keHuGuanLi.KeHuTianJiaPanel;
import internalFrame.keHuGuanLi.KeHuXiuGaiPanel;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
public class KeHuGuanLi extends JInternalFrame {
	public KeHuGuanLi() {
		setIconifiable(true);
		setClosable(true);
		setTitle("客户信息管理");
		JTabbedPane tabPane = new JTabbedPane();
		final KeHuXiuGaiPanel khxgPanel = new KeHuXiuGaiPanel();
		final KeHuTianJiaPanel khtjPanel = new KeHuTianJiaPanel();
		tabPane.addTab("客户信息添加", null, khtjPanel, "客户添加");
		tabPane.addTab("客户信息修改与删除", null, khxgPanel, "修改与删除");
		getContentPane().add(tabPane);
		tabPane.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				khxgPanel.initComboBox();
			}
		});
		pack();
		setVisible(true);
	}
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			         public void run() {
			        	 JFrame frame = new JFrame();
			     		 frame.setBounds(100, 100, 800, 600); 
			     		 desktopPane = new JDesktopPane();
			    		 frame.getContentPane().add(desktopPane);
			    		 JInternalFrame internalFrame = new KeHuGuanLi();
			    		 desktopPane.add(internalFrame);
			    		 internalFrame.setVisible(true);
			        	 frame.setVisible(true);
			         }
		             JDesktopPane desktopPane;
				});
	}
}
