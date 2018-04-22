import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.io.*;
import java.awt.event.*;

public class Spot extends JPanel{
	
	public static String[] spotClrNames = {"white","yellow","blue","green","pink","red"};
	public static Color[] spotColors = {new Color(200,200,200),new Color(255, 240, 109),
										new Color(0,0,200),new Color(0,200,0),
										new Color(255, 163, 216),new Color(200,0,0)};
	
	private boolean isTarget;
	private boolean isRobot;	
    private int dieVal, clrNum, seqInd, graphIndex;
	private Color color;
	
	//0-5 for both
    public Spot(int valNum, int clrNum) {
		setPreferredSize(new Dimension(120,120));
		color = spotColors[clrNum];
		this.clrNum=clrNum;
        dieVal = valNum+1;
	}
	public void setIsRobot(boolean b){isRobot=b;}
	public void setIsTarget(boolean b){isTarget=b;}
	public void setSeqInd(int ind){seqInd=ind;}

	public int getGraphIndex() {
		return graphIndex;
	}

	public void setGraphIndex(int graphIndex) {
		this.graphIndex = graphIndex;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);     
		
		g.setColor(new Color(75,75,75));
		int w = this.getWidth();
		int h = this.getHeight();
		g.fillRect(0,0,w-1,h-1);
		
		int rectSz = this.getWidth();
		if(this.getHeight()<rectSz)rectSz = this.getHeight();
		rectSz/=7;
		int borderSz = rectSz/3;
		
		g.setColor(color);
		if(dieVal%2==1) g.fill3DRect(w/2-rectSz/2,h/2-rectSz/2,rectSz,rectSz,true);
		if(dieVal>1) {
			g.fill3DRect(w/4-rectSz/2,h/4-rectSz/2,rectSz,rectSz,true);
			g.fill3DRect(3*w/4-rectSz/2,3*h/4-rectSz/2,rectSz,rectSz,true);
		}
		if(dieVal>3) {
			g.fill3DRect(3*w/4-rectSz/2,h/4-rectSz/2,rectSz,rectSz,true);
			g.fill3DRect(w/4-rectSz/2,3*h/4-rectSz/2,rectSz,rectSz,true);
		}
		if(dieVal==6) {
			g.fill3DRect(w/4-rectSz/2,h/2-rectSz/2,rectSz,rectSz,true);
			g.fill3DRect(3*w/4-rectSz/2,h/2-rectSz/2,rectSz,rectSz,true);
		}
		
		for(int i=0; i<borderSz; i++)
			g.drawRect(i+5,i+5,this.getWidth()-(2*i+1)-10,this.getHeight()-(2*i+1)-10);
		

		g.setColor(new Color(255,255,255,120));
		if(isRobot){
			g.setFont(new Font ("Courier New", 1, 2*rectSz));
			for(int i=0; i<borderSz; i++){
				g.drawArc(w/6-i, h/6, 2*w/3, 2*h/3, -45, 90);
				g.drawArc(w/6+i, h/6-1, 2*w/3, 2*h/3, 135, 90);				
				g.drawArc(w/4, h/4-1+i, w/2, h/2, 45, 90);				
				g.drawArc(w/4, h/4-1-i, w/2, h/2, 225, 90);
			}
			g.drawString("Robo",w/6,h/2+rectSz/2);
		}
		if(seqInd!=0){
			g.setFont(new Font ("Courier New", 1, 4*rectSz));
			g.drawString(Integer.toString(seqInd),w/2-3*rectSz/2,h/2+3*rectSz/2);
		}
		if(isTarget){
			g.setColor(new Color(255,0,200,120));
			g.setFont(new Font ("Courier New", 1, 2*rectSz));
			for(int i=0; i<borderSz; i++){
				g.drawOval(w/6+i, h/6+i, 2*w/3-2*i, 2*h/3-2*i);
				g.drawOval(w/4+i, h/4+i, w/2-2*i, h/2-2*i);
			}
			g.drawString("G",w/2-rectSz/2,h/2+rectSz/2);
		}
	}
	
	@Override 
	public boolean equals(Object obj){
		if(obj instanceof Spot){
			Spot s = (Spot)obj;
			return s.dieVal==dieVal || s.clrNum==clrNum; // matches either or....
		}
		return false;
	}
	
	@Override 
	public String toString(){
		return spotClrNames[clrNum]+":"+dieVal;
	}
}