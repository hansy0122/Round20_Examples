import java.awt.*;
import java.awt.event.*;

class Ex02_sub extends Frame{
	
	public Ex02_sub(String title){
		super(title); // 객체는 어디에 ?
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
		g.setFont(new Font("굴림체",Font.BOLD,20));
		g.drawString("반가반가",200,100); //label은 독립적인 영역을 가지는데 반해 이는 그림으로서 그려짐
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image img=tk.getImage("원본_한승엽님_명함사이즈.jpg");
		g.drawImage(img,50,50,100,100,this);
		
		
	}
	
}

public class Ex02 {
	public static void main(String ar[]){
		Ex02_sub ex=new Ex02_sub("제목");
	}

}