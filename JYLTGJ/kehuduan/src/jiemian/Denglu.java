package jiemian;
import java.io.*;
import moxing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gonggong.*;
import gongju.*;

public class Denglu extends JFrame implements ActionListener
{
	JLabel jbl1;
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JButton jp2_jb1;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args)
	{
		Denglu dl=new Denglu();
	}
	public Denglu()
	{
		jbl1=new JLabel(new ImageIcon("image/tou.gif"));
		jp2=new JPanel(new GridLayout(3,3));
		jp2_jbl1=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl2=new JLabel("QQ����",JLabel.CENTER);
		jp2_jbl3=new JLabel("��������",JLabel.CENTER);
		jp2_jbl3.setForeground(Color.blue);
		jp2_jbl4=new JLabel("�������뱣��",JLabel.CENTER);
		jp2_jb1=new JButton(new ImageIcon("image/clear.gif"));
		jp2_jtf=new JTextField();
		jp2_jpf=new JPasswordField();
		jp2_jcb1=new JCheckBox("������¼");
		jp2_jcb2=new JCheckBox("��ס����");
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jb1);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		jtp=new JTabbedPane();
		jtp.add("QQ����",jp2);
		jp3= new JPanel();
		jtp.add("�ֻ�����",jp3);
		jp4=new JPanel();
		jtp.add("�����ʼ�",jp4);
		jp1=new JPanel();
		jp1_jb1=new JButton(new ImageIcon("image/denglu.gif"));
		jp1_jb1.addActionListener(this);
		jp1_jb2=new JButton(new ImageIcon("image/quxiao.gif"));
		jp1_jb3=new JButton(new ImageIcon("image/xiangdao.gif"));
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		this.add(jbl1,"North");
		this.add(jtp,"Center");
		this.add(jp1,"South");
		ImageIcon tp1=new ImageIcon("image/qq.gif");
		this.setIconImage(tp1.getImage());
		this.setTitle("�û���¼");
		this.setSize(351,240);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jp1_jb1)
		{
			Yanzheng yz=new Yanzheng();
			User u=new User();
			u.setUserId(jp2_jtf.getText().trim());
			u.setPasswd(new String(jp2_jpf.getPassword()));
			if(yz.checkUser(u))
			{
				try {
					liebiao lb=new liebiao(u.getUserId());
					Glhylb.addliebiao(u.getUserId(),lb);
					ObjectOutputStream oos=new ObjectOutputStream
					(Glxc.getLjfwqxc(u.getUserId()).getS().getOutputStream());
					Message m=new Message();
					m.setMesType(MessageType.message_get_onLineFriend);
					m.setSender(u.getUserId());
					oos.writeObject(m);					
				} catch (Exception e3){}
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(this,"�û������������");
			}
		}
	}
}