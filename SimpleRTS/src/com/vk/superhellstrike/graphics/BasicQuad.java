package com.vk.superhellstrike.graphics;

import java.awt.Color;
import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public class BasicQuad implements GraphicalObject {
	private Rectangle r;
	private Color color;
	
	public BasicQuad(int x, int y, int width, int height, Color color) {
		this.r = new Rectangle(x, y, width, height);
		this.color = color;
	}
	
	public BasicQuad(Rectangle r, Color color) {
		this.color = color;
		this.r = r;
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
		gl.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
		gl.glBegin(GL2.GL_QUADS);
		gl.glVertex2i(r.x, r.y);
		gl.glVertex2i(r.x, r.y + r.height);
		gl.glVertex2i(r.x + r.width, r.y + r.height);
		gl.glVertex2i(r.x + r.width, r.y);
		gl.glEnd();
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
