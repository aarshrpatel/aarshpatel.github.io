/*
 * Aarsh Patel
 */

//Packages
import java.awt.*;
import javax.swing.*;
import java.util.*;

public class TriangleFractals extends Canvas {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Triangle Fractals");
		frame.setSize(900, 900);
		TriangleFractals sp = new TriangleFractals();
		frame.add(sp);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void paint(Graphics g)
	{
		int width = this.getWidth();
		int height = this.getHeight();
		
		drawFractals(width/2, 0, 0, height, width, height, g, 4);
	}
	
	public void drawFractals(int x1, int y1, int x2, int y2, int x3, int y3, Graphics g, int pixels)
	{
		//if pixel != 0 then draw three smaller triangles
		if(pixels > 0)
		{
			//dimensions for middle triangle
			int xLeft = (x1 + x2)/2;//left top
			int xRight = (x1 + x3)/2;//right top
			int xMiddle = (x2 + x3)/2;//middle bottom
			int yLeft = (y1 + y2)/2;//left top
			int yRight = (y1 + y3)/2;//right top
			int yMiddle = (y2 + y3)/2;//middle bottom
			
			//draw the black triangles around the white
			drawFractals(xLeft, yLeft, x2, y2, xMiddle, yMiddle, g, pixels - 1);//bottom left triangle
			drawFractals(xRight, yRight, xMiddle, yMiddle, x3, y3, g, pixels - 1);//bottom right triangle
			drawFractals(x1, y1, xLeft, yLeft, xRight, yRight, g, pixels - 1);//top triangle
		}
		
		else if(pixels == 0)//if the pixels are zero than just draw a black triangle
		{
			g.setColor(new Color(0, 0, 0));
			int[] xValues = {x1, x2, x3};//top, bottom-left, bottom-right
			int[] yValues = {y1, y2, y3};//top, bottom-left, bottom-right
		
			g.fillPolygon(xValues, yValues, 3);
		}
		else
			return;
	}
}
