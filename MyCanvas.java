package game1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;

import sun.audio.*;

import sun.audio.*;

public class MyCanvas extends Canvas implements KeyListener {

	
	LinkedList badguys = new LinkedList();
	String msg = new String();
	LinkedList provinces = new LinkedList();
	Goodguy good = new Goodguy (350, 150, 10, 10,"files/hostreal2.png");
	Image start = Toolkit.getDefaultToolkit().createImage("files/menu.png");
	boolean menu = true;
	
	Rectangle sask = new Rectangle(122,240,45,102);
	Rectangle alber = new Rectangle(98,230,48,120);
	Rectangle bc = new Rectangle(164,240,50,108); 
	Rectangle man = new Rectangle (26,230,50,110); 
	Rectangle ontario = new Rectangle (206,270,80,70);
	Rectangle quebec = new Rectangle (300,210,70,130);
	Rectangle brunswick = new Rectangle (362,294,24,36);
	Rectangle scotia = new Rectangle (320,192,104,66); //356,270,36,36
	Rectangle pei = new Rectangle(353,288,33,42); 
	Rectangle labrador = new Rectangle(356,270,36,36); //320,192,104,66
	Rectangle yukon = new Rectangle (38,120,54,96);
	Rectangle northwest = new Rectangle (98,138,102,96);
	Rectangle nunavut = new Rectangle (182,0,186,234);
	
	
	
	
	Font myFont = new Font("Comic Sans", 1, 11);
	
	int c;
	
	
	boolean correct = false;
	
	int score;
	
	
	public MyCanvas() {
		this.setSize(443,390);
		this.addKeyListener(this);
		playIt("files/WiiMusic.wav");
		
		provinces.add(sask);
		provinces.add(alber);
		//provinces.set(1, alber);
		provinces.add(bc);
		//provinces.set(2, bc);
		provinces.add(man);
		//provinces.set(3, man);
		provinces.add(ontario);
		//provinces.set(4, ontario);
		provinces.add(quebec);
		//provinces.set(5, quebec);
		provinces.add(scotia);
		//provinces.set(6, scotia);
		provinces.add(brunswick);
		//provinces.set(7, brunswick);
		provinces.add(pei);
		//provinces.set(8, pei);
		provinces.add(labrador);
	//	provinces.set(9, labrador);
		provinces.add(yukon);
		//provinces.set(10, yukon);
		provinces.add(northwest);
	//	provinces.set(11, northwest);
		provinces.add(nunavut);
	//	provinces.set(12, nunavut);
		
		Random rand = new Random();
		c = rand.nextInt(13);
		
	}	

	public void playIt(String filename) {
		
		try {
			InputStream in = new FileInputStream(filename); 
			AudioStream as = new AudioStream(in);
			AudioPlayer.player.start(as);
		}   catch (IOException e) {
				System.out.println(e);
		}
	
	}

	public void paint(Graphics g) {
		Random rand = new Random();
		Font myFont = new Font("Comic Sans", 1, 11);
		this.setFont(myFont);
		if (menu) {
			g.drawImage(start, 10, 10, 453, 400, this);
			g.drawString("Welcome to YouCan(ada)Geo!", 152, 24);
			g.drawString("Press the spacebar to begin!", 152, 38);
		} else {
		
		this.setFont(myFont);
		String str = String.valueOf(good.getxCoord()) + " , " + String.valueOf(good.getyCoord());
		
		
		
		Background back = new Background(0, 0, 453, 400, "files/mapgood2.png");
		
		
	//	g.drawRect((int) scotia.getX(), (int) scotia.getY(), (int) scotia.getWidth(), (int) scotia.getHeight());
	//	g.drawRect((int) bc.getX(), (int) bc.getY(), (int) bc.getWidth(), (int) bc.getHeight()); 
	//	g.drawRect((int) ontario.getX(), (int) ontario.getY(), (int) ontario.getWidth(), (int) ontario.getHeight()); 
	//	g.drawRect((int) labrador.getX(), (int) labrador.getY(), (int) labrador.getWidth(), (int) labrador.getHeight()); 
	//	g.drawRect((int) sask.getX(), (int) sask.getY(), (int) sask.getWidth(), (int) sask.getHeight()); 
	//	g.drawRect((int) brunswick.getX(), (int) brunswick.getY(), (int) brunswick.getWidth(), (int) brunswick.getHeight()); 
	//	g.drawRect((int) man.getX(), (int) man.getY(), (int) man.getWidth(), (int) man.getHeight()); 
	//	g.drawRect((int) pei.getX(), (int) pei.getY(), (int) pei.getWidth(), (int) pei.getHeight()); 

		g.drawImage(back.getImg(), back.getxCoord(), back.getyCoord(), back.getWidth(), back.getHeight(), this);
		g.drawString(str, 20, 20);
		
		if (correct) {
			g.drawString("Correct", 20, 50);
		}else {
			g.drawString("Incorrect", 20, 50);
		}
		
		//g.drawRect((int) alber.getX(), (int) alber.getY(), (int) alber.getWidth(), (int) alber.getHeight(), this);
		
		
		
		g.drawImage(good.getImg(), good.getxCoord(), good.getyCoord(), good.getWidth(), good.getHeight(), this);
		
		//Badguy bad = new Badguy (100, 100, 500, 100, "files/questionnumber1.png");
		//g.drawImage(bad.getImg(), bad.getxCoord(), bad.getyCoord(), bad.getWidth(), bad.getHeight(), this);		
				
		g.drawString("Welcome to the Canadian Geo Game!", 213, 100);
		g.drawString("Move the red dot from right to left", 225, 115);
		g.drawString("To the corresponding province in the bottom left", 266, 130);
		g.drawString("in the bottom left", 289, 145);
		
		//g.drawRect((int) brunswick.getX(), (int) brunswick.getY(), (int) brunswick.getWidth(), (int) brunswick.getHeight());
		//g.drawRect((int) scotia.getX(), (int) scotia.getY(), (int) scotia.getWidth(), (int) scotia.getHeight());
		//g.drawRect((int) labrador.getX(), (int) labrador.getY(), (int) labrador.getWidth(), (int) labrador.getHeight());
		//g.drawRect(338,205,108,54);
		//g.drawRect((int) pei.getX(), (int) pei.getY(), (int) pei.getWidth(), (int) pei.getHeight()); 

		if (c==0) {
			g.drawString("Saskatchewan", 0, 350);
			//g.drawString
		} else if (c==1) {
			g.drawString("Alberta", 0, 350);
		} else if (c==2) {
			g.drawString("Manitoba", 0, 350);
		} else if (c==3) {
			g.drawString("B.C.", 0, 350);
		} else if (c==4) {
			g.drawString("Ontario", 0, 350);
		} else if (c==5) {
			g.drawString("Quebec",0,350);
		} else if (c==6) {
			g.drawString("Newfoundland and Labrador",0,350);
		} else if (c==7) {
			g.drawString("Nova Scotia",0,350);
		} else if (c==8) {
			g.drawString("New Brunswick",0,350);
		} else if (c==9) {
			g.drawString("Prince Edward Island",0,350);
		} else if (c==10) {
			g.drawString("Yukon",0,350);
		} else if (c==11) {
			g.drawString("Northwest Territories",0,350);
		} else if (c==12) {
			g.drawString("Nunavut",0,350); 
		} else if (c==13) {
			c = rand.nextInt(13);
		}	
		
		g.drawString("Score: "+String.valueOf(score), 350, 350);
		
		//for(int i = 0; i < badguys.size(); i++) {
		//	Badguy bg  = (Badguy) badguys.get(i);
		//	g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);	
		//}
		}
		
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);	
		
		//for(int i = 0; i < badguys.size(); i++) {
		//	Badguy bg = (Badguy) badguys.get(i);
		//	Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());	
		//}
		
		good.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());
		
		if (e.getKeyCode() == 32) {
			menu = false;
		}
		
		
			if (key == 10) {
			Rectangle gr = new Rectangle(good.getxCoord(), good.getyCoord(), good.getWidth(), good.getHeight());
			Rectangle r = (Rectangle) provinces.get(c);
			
			System.out.println(provinces.get(c).toString());
			
			if (gr.intersects(r)) {
				
				System.out.println("found it");
				correct = true;
				score++;
				Random rand = new Random();
				c = rand.nextInt(13);
				playIt("files/correct.wav");
				if (score % 5 == 0) {
					playIt("files/goodjob.wav");
				}
			
			} 
			else {
				
				System.out.println("missed it");
				correct = false;
				score --;
				Random rand = new Random();
				c = rand.nextInt(13);
				playIt("files/incorrect.wav");
				
				
			}
			
		}
		
		repaint();
		
		
	}

	
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
		
	}


