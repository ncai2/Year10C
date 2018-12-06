package game1;

import java.awt.Image;
import java.awt.Toolkit;

import javax.tools.Tool;

public class Badguy {

	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	private Image img;
	
	public Badguy() {
		
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("files/map.png");
		
	}
	
	private void setHeight(int i) {
		this.height = i;
	}


	private void setWidth(int i) {
		this.width = i;
	}


	public Badguy (int x, int y, int w, int h, String imgpath) {
		setxCoord(x);
		setyCoord(y);
		setWidth(w);
		setHeight(h);
		setImg(imgpath);
	}
	
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);	
	}
	 public Image getImg() {
		 return img;
	 }
	 
	 public int getxCoord() {
		 return this.xCoord;
	 }
	 
	 public int getyCoord() {
		 return this.yCoord;
		 
	 }
	 
	 public void setxCoord(int x) {
		 this.xCoord = x;
	 }
	 
	 public void setyCoord(int y) {
		 this.yCoord = y;
	 }


	public int getWidth() {
		// TODO Auto-generated method stub
		return this.width;
	}


	public int getHeight() {
		// TODO Auto-generated method stub
		return this.height;
	}

}
