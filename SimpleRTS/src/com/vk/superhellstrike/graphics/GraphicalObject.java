package com.vk.superhellstrike.graphics;

import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public interface GraphicalObject {	
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
	public Rectangle getRectangle();
	public void setX(int x);
	public void setY(int y);
	public void setWidth(int width);
	public void setHeight(int height);
	public void draw(GL2 gl);
	public boolean collisionCheck(GraphicalObject o);
	public boolean contains(int x, int y);
}
