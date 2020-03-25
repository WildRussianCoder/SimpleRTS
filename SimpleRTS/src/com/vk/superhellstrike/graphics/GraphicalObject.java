package com.vk.superhellstrike.graphics;

import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public abstract class GraphicalObject {
	private Rectangle r;
	
	/*
	 * Constructors
	 */
	public GraphicalObject() {
		r = new Rectangle(0, 0, 1, 1);
	}
	
	public GraphicalObject(int width, int height) {
		r = new Rectangle(0, 0, width, height);
	}
	
	public GraphicalObject(int x, int y, int width, int height) {
		r = new Rectangle(x, y, width, height);
	}
	
	/*
	 * Getters
	 */
	public int getX() {
		return r.x;
	}
	
	public int getY() {
		return r.y;
	}
	
	public int getWidth() {
		return r.width;
	}
	
	public int getHeight() {
		return r.height;
	}
	
	public Rectangle getREctangle() {
		return r;
	}
	
	/*
	 * Setters
	 */
	public void setX(int x) {
		r.x = x;
	}
	
	public void setY(int y) {
		r.y = y;
	}
	
	public void setWidth(int width) {
		r.width = width;
	}
	
	public void setHeight(int height) {
		r.height = height;
	}
	
	/*
	 * Other methods
	 */
	public void draw(GL2 gl) {
		gl.glRecti(r.x, r.y, r.x + r.width, r.y + r.height);
	}
	
	public boolean collisionCheck(GraphicalObject o) {
		boolean collision = false;
		
		if(this.r.contains(o.r))
			collision = true;
		
		return collision;
	}
	
	public boolean contains(int x, int y) {
		return r.contains(x, y);
	}
}
