import java.awt.*;
import java.awt.event.*;
//class A extends Canvas{} //������ Ŭ���� ����ؼ� ���� �׷��Ƚ� ����ϴ� ���� ������
class Ex01_sub extends Frame implements ActionListener{
	Button bt=new Button("ok");
	BorderLayout bl=new BorderLayout();
	public Ex01_sub(String title){
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
	public void init(){
		this.setLayout(bl);
		this.add("North",bt);
	}
	public void start(){
		bt.addActionListener(this); 
	}
	public void update(Graphics g){ // �����ִ��� ������ �ϴ°��� �ڵ�ȣ��� //������ �ٸ����� �ۼ��ؾ��� ������Ʈ�� �浿�� ���Ͼ.     // ������Ʈ�� ���� ������ ���ص���.
		g.clearRect(0,0, 300, 200); // �ʱ�ȭ���ѹ����°� 
		paint(g); 
	}
	public void paint(Graphics g){
		System.out.println("dd");
		int x=(int)(Math.random()*200);
		int y=(int)(Math.random()*300); // �ù� ÷�� ��ȣ ��������� Math.random�� ��Ʈ�κ�ȭ���Ѽ� 0���� ȯ��ǰ����� �ȳ�Ÿ�� �Ѥ�
		
		g.drawLine(x, x, y, y);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==bt){
		this.repaint(); //update���� repaint
		};
		
		
	}
	
}

public class Ex01 {
	public static void main(String ar[]){
		Ex01_sub ex=new Ex01_sub("����");
	}

}
