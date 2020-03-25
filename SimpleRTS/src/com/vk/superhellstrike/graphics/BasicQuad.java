package com.vk.superhellstrike.graphics;

import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public class BasicQuad implements GraphicalObject {
	private Rectangle r;
	
	private int textureObject;
	
	public BasicQuad(int x, int y, int textureObj) {
		this.r = new Rectangle(x - 10, y - 10, 20, 20);
		this.textureObject = textureObj;
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
		gl.glBindTexture(GL2.GL_TEXTURE_2D, textureObject);
		gl.glBegin(GL2.GL_QUADS);
		
		gl.glTexCoord2i(0, 1);
		gl.glVertex2i(r.x, r.y);
		
		gl.glTexCoord2i(0, 0);
		gl.glVertex2i(r.x, r.y + r.height);
		
		gl.glTexCoord2i(1, 0);
		gl.glVertex2i(r.x + r.width, r.y + r.height);
		
		gl.glTexCoord2i(1, 1);
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
