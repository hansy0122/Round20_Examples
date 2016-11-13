import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

class Draw implements Serializable{
	private int x,y,x1,y1;
	private int dist;
	
	public int getDist() {return dist;}

	public void setDist(int dist) {this.dist = dist;}

	public int getX() {return x;}

	public void setX(int x) {this.x = x;}

	public int getY() {return y;}

	public void setY(int y) {this.y = y;}

	public int getX1() {return x1;}

	public void setX1(int x1) {this.x1 = x1;}

	public int getY1() {return y1;}

	public void setY1(int y1) {this.y1 = y1;}
}
class Ex04_sub extends Frame implements MouseMotionListener,MouseListener,ItemListener{
	private MenuBar mb=new MenuBar();
	private Menu draw=new Menu("draw");
	private CheckboxMenuItem line=new CheckboxMenuItem("LINE");
	private CheckboxMenuItem pen=new CheckboxMenuItem("PEN",true);
	private CheckboxMenuItem oval=new CheckboxMenuItem("OVAL");
	private CheckboxMenuItem rect=new CheckboxMenuItem("RECT");
	
	
	private int x,y,x1,y1;
	
	private Vector vc=new Vector();
	
	public Ex04_sub(String title){
		super(title); // 객체는 어디에 ?
		super.setSize(400,400);
		
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
		this.setMenuBar(mb);
		mb.add(draw);
		draw.add(line);
		draw.add(oval);
		draw.add(pen);
		draw.add(rect);
	}
	public void start(){
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);}
		});
		
		pen.addItemListener(this);
		line.addItemListener(this);
		rect.addItemListener(this);
		oval.addItemListener(this);
		/*pen.setActionCommand("draw");
		line.setActionCommand("draw");
		oval.setActionCommand("draw");
		rect.setActionCommand("draw");*/
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		
	}
	public void update(Graphics g){
		paint(g);
	}
	public void paint(Graphics g){
		
		for(int i=0;i<vc.size();i++){
			Draw d=(Draw)vc.elementAt(i);
			if(d.getDist()==1){
				g.drawLine(d.getX(), d.getY(), d.getX1(), d.getY1());
			}
			else if(d.getDist()==2){
				
				g.drawOval(d.getX(),d.getY(), d.getX1()- d.getX(), d.getY1()-d.getY());
			}
			else if(d.getDist()==3){
				g.drawRect(d.getX(),d.getY(), d.getX1()- d.getX(), d.getY1()-d.getY());
			}
		}
		
		
		if(line.getState()==true){
			g.drawLine(x, y,x1, y1);
		}
		
		else if(oval.getState()==true){
			g.drawOval(x, y, x1-x, y1-y);
		}
		else if(rect.getState()==true){
			g.drawRect(x, y, x1-x, y1-y);
		}
	}

	/*public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("drwa")){
		pen.setState(false);
		line.setState(false);
		rect.setState(false);
		oval.setState(false);
		CheckboxMenuItem imsi=(CheckboxMenuItem)e.getSource();
		imsi.setState(true);
		}
	}*/
	
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		/*if(e.getActionCommand().equals("drwa")){*/
			pen.setState(false);
			line.setState(false);
			rect.setState(false);
			oval.setState(false);
			CheckboxMenuItem imsi=(CheckboxMenuItem)e.getSource();
			imsi.setState(true);
			}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x=e.getX();
		y=e.getY();
				
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
		this.repaint();
		
		
		
		if(pen.getState()!=true){
			Draw d=new Draw();
			int dist=0;
		if(line.getState()==true){dist=1;}
		else if(oval.getState()==true){dist=2;}
		else if(rect.getState()==true){dist=3;}
		d.setDist(dist);
		d.setX(x);
		d.setX1(x1);
		d.setY(y);
		d.setY1(y1);
		vc.add(d);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x1=e.getX();
		y1=e.getY();
		this.repaint();
		
		if(pen.getState()){
			Draw d=new Draw();
			d.setDist(1);
			d.setX(x);
			d.setY(y);
			d.setX1(x1);
			d.setY1(y1);
			vc.add(d);
			x=x1;
			y=y1;
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
		
	}

public class Ex04 {
	public static void main(String ar[]){
		Ex04_sub ex=new Ex04_sub("제목");
	}

}