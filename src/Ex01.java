import java.awt.*;
import java.awt.event.*;
//class A extends Canvas{} //독립적 클래스 사용해서 원래 그래픽스 사용하는 것이 보통임
class Ex01_sub extends Frame implements ActionListener{
	Button bt=new Button("ok");
	BorderLayout bl=new BorderLayout();
	public Ex01_sub(String title){
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
		this.setLayout(bl);
		this.add("North",bt);
	}
	public void start(){
		bt.addActionListener(this); 
	}
	public void update(Graphics g){ // 원래있던거 재정의 하는거임 자동호출됨 //원래는 다른곳에 작성해야지 콤포넌트랑 충동일 안일어남.     // 업데이트는 구지 재정의 안해도댐.
		g.clearRect(0,0, 300, 200); // 초기화시켜버리는거 
		paint(g); 
	}
	public void paint(Graphics g){
		System.out.println("dd");
		int x=(int)(Math.random()*200);
		int y=(int)(Math.random()*300); // 시밤 첨에 괄호 안해줬더니 Math.random만 인트로변화시켜서 0으로 환산되가지고 안나타남 ㅡㅡ
		
		g.drawLine(x, x, y, y);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==bt){
		this.repaint(); //update이후 repaint
		};
		
		
	}
	
}

public class Ex01 {
	public static void main(String ar[]){
		Ex01_sub ex=new Ex01_sub("제목");
	}

}
