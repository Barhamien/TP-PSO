/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package turtle;

import java.util.List;
import java.util.ArrayList;

public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
        //throw new RuntimeException("implement me!");
    	turtle.forward(sideLength);
    	turtle.turn( 270 );
    	turtle.forward(sideLength);
    	turtle.turn( 270 );
    	turtle.forward(sideLength);
    	turtle.turn( 270 ); 
    	turtle.forward(sideLength);
    	turtle.turn( 270 );
   
    }

    /**�
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
      // throw new RuntimeException("implement me!");
    	double angle;
    	angle = ((double)((sides - 2)*180))/sides;
    	return angle;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
    	int sides;
    	sides = (int)(360.0/(180.0 - angle) + 0.5);
    	return sides;
    	//throw new RuntimeException("implement me!");
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
    	double angle = calculateRegularPolygonAngle(sides);
    	turtle.forward(sideLength);
    	for(int i = 0;i < sides; i++)
    	{
    		turtle.turn(180 - angle);
    		turtle.forward(sideLength);
    	}
    	//throw new RuntimeException("implement me!");
    }

    /**
     * Given the current direction, current location, and a target location, calculate the heading
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentHeading. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentHeading current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to heading (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateHeadingToPoint(double currentHeading, int currentX, int currentY,
                                                 int targetX, int targetY) {
    	double tanvalue;
    	double arctanvalue;
    	double angle = 0;
    	if(currentY == targetY)
    	{
    		if(currentX > targetX)
    			angle = 300;
    		else angle = 90;
    		
    	}
    	else{
    		tanvalue = (double)(currentX - targetX)/(double)(currentY - targetY);
    		arctanvalue = Math.toDegrees(Math.atan(tanvalue));
    		if(currentX > targetX && currentY > targetY)
    		    angle = 180 + arctanvalue;
    		if(currentX <= targetX && currentY > targetY)
    			angle = 180 + arctanvalue;
    		if(currentX > targetX && currentY < targetY)
    			angle = 360 + arctanvalue;
    		if(currentX <= targetX && currentY < targetY)
    			angle = arctanvalue;
    	}
    	angle = angle - currentHeading;
    	return angle <0 ? angle+360 : angle;
    	//throw new RuntimeException("implement me!");
    }

    /**
     * Given a sequence of points, calculate the heading adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateHeadingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of heading adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateHeadings(List<Integer> xCoords, List<Integer> yCoords) {
    	int n = xCoords.size();
    	List<Double> Degrees=new ArrayList<>();
    	double angle = calculateHeadingToPoint(0, xCoords.get(0), yCoords.get(0), xCoords.get(1), yCoords.get(1));
    	Degrees.add(angle);
    	double adjustment = 0.0;
    	for(int i = 1; i < n-1; i++)
    	{
    		adjustment = calculateHeadingToPoint(angle, xCoords.get(i), yCoords.get(i), xCoords.get(i+1), yCoords.get(i+1));
    		angle = angle +adjustment;
    		angle = angle > 360 ? angle-360 : angle;
    		Degrees.add(adjustment);
    	}
    	return Degrees;
    	//throw new RuntimeException("implement me!");
    }

    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle,int sidelength) {
    	
    	PenColor k = null;
    	turtle.turn(180);
    	
    	turtle.color(k.RED); 
    	turtle.forward(sidelength);
    	for(int i = 1; i < 24; i++)
    	{
    		turtle.turn(-215);
            turtle.color(k.RED);                    
    		turtle.forward(sidelength);
    		
    	}
    	
        //throw new RuntimeException("implement me!");
    }
    	//throw new RuntimeException("implement me!");
   

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        //drawSquare(turtle, 40);
        //drawRegularPolygon(turtle,8, 70);
        drawPersonalArt(turtle, 220);
        // draw the window
        turtle.draw();
    }

}
