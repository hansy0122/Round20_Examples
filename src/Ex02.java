import java.awt.*;
import java.awt.event.*;

class Ex02_sub extends Frame{
	
	public Ex02_sub(String title){
		super(title); // ��ü�� ��� ?
		super.setSize(300,200);
		
		this.init();
		this.start();

		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frm=super.getSize();
		
		
		int xpos=(int)(screen.getWidth()/2-frm.getWidth()/2);
		int ypos=(int)(screen.getHeight()/2-frm.getHeight()/2);
		super.setLocation(xpos,ypos);
		super.setResizable(false);
		super.setVisible(true);
		
	}
	
	public void init()
	{
		
	}
	
	public void start(){
		
	}
	public void update(Graphics g){
		paint(g);
	}
	
	public void paint(Graphics g){
		g.drawLine(10, 10, 100, 100);
		g.setColor(Color.red);
		g.drawRect(10, 10, 50, 50);
		g.setColor(Color.BLUE);
		g.fillRect(150, 10,	50, 50);
		g.setColor(Color.green);
		int x[]={100,200,200}; int y[]={30,30,80};
		g.drawPolygon(x, y, 3);
		g.setColor(Color.cyan);
		g.setFont(new Font("����ü",Font.BOLD,20));
		g.drawString("�ݰ��ݰ�",200,100); //label�� �������� ������ �����µ� ���� �̴� �׸����μ� �׷���
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("����_�ѽ¿���_���Ի�����.jpg");
		g.drawImage(img,50,50,100,100,this);
		
		
	}
	
}

public class Ex02 {
	public static void main(String ar[]){
		Ex02_sub ex=new Ex02_sub("����");
	}

}