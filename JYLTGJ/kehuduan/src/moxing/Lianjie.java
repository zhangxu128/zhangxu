package moxing;
import java.util.*;
import java.net.*;
import java.io.*;
import gonggong.*;
import gongju.*;

public class Lianjie 
{
	public Socket s;
	public Lianjie()
	{
		
	}
	public boolean fasong(Object o)
	{
		boolean b=false;
		try {
			s=new Socket("127.0.0.1",9999);		
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());			
			Message ms=(Message)ois.readObject();
			if(ms.getMesType().equals("1"))
			{	
				Ljfwqxc ljxc=new Ljfwqxc(s);
				ljxc.start();
				Glxc.addLjfwqxc(((User)o).getUserId(),ljxc);
				b=true;
			}			
		} catch (Exception e) {}
		return b;
	}
}