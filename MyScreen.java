package game1;

import javax.swing.JFrame; //Inheritance of Swing, a Tool Kit that contains JFrame, what you're copying to make you "MyScreen"
public class MyScreen extends JFrame { 

	public MyScreen() { //Constructor, contains a set of instructions of the screen.
		this.setSize(453,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		MyScreen screen = new MyScreen(); 
		MyCanvas canvas = new MyCanvas();
		screen.getContentPane().add(canvas);
	}

}
