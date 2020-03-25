package com.vk.superhellstrike.graphics;

import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public class BasicQuad implements GraphicalObject {
	private Rectangle r;
	
	public BasicQuad(int x, int y) {
		this.r = new Rectangle(x - 10, y - 10, 20, 20);
	}

	@Override
	public int getX() {
		return r.x;
	}

	@Override
	public int getY() {
		return r.y;
	}

	@Override
	public int getWidth() {
		return r.width;
	}

	@Override
	public int getHeight() {
		return r.height;
	}

	@Override
	public Rectangle getRectangle() {
		return r;
	}

	@Override
	public void setX(int x) {
		r.x = x;
	}

	@Override
	public void setY(int y) {
		r.y = y;	
	}

	@Override
	public void setWidth(int width) {
		r.width = width;
	}

	@Override
	public void setHeight(int height) {
		r.height = height;
		
	}

	@Override
	public void draw(GL2 gl) {
		gl.glRecti(r.x, r.y, r.x + r.width, r.y + r.height);
	}

	@Override
	public boolean collisionCheck(GraphicalObject go) {
		return r.contains(go.getRectangle());
	}

	@Override
	public boolean contains(int x, int y) {
		return r.contains(x, y);
	}
}
