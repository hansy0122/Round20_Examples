import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Ex03_sub extends Frame implements ActionListener{
	
	private Button bt=new Button("확대");
	private Button bt1=new Button("축소");
	private Panel p=new Panel();
	private BorderLayout bl=new BorderLayout();
	private FlowLayout fl=new FlowLayout(FlowLayout.RIGHT);
	private Image img;
	private int size=100;
	public Ex03_sub(String title){
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
	public void init(){
		Toolkit tk=Toolkit.getDefaultToolkit();
		img=tk.getImage("원본_한승엽님_명함사이즈.jpg");
		this.setLayout(bl);
		p.setLayout(fl);
		p.add(bt);
		p.add(bt1);
		this.add("North",p);
	}
	public void start(){
		bt1.addActionListener(this);
		bt.addActionListener(this);
	}
	public void paint(Graphics g){
		g.drawImage(img, 50, 50,size,size, this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== bt){
			size+=10;
			this.repaint();
		}else if(e.getSource()==bt1){
			size-=10;
			this.repaint();
		}
	}
}

public class Ex03 {
	public static void main(String ar[]){
		Ex03_sub ex=new Ex03_sub("제목");
	}

}