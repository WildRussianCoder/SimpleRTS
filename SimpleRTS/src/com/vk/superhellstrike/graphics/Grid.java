package com.vk.superhellstrike.graphics;

import java.awt.Color;
import java.awt.Rectangle;

import com.jogamp.opengl.GL2;

public class Grid implements GraphicalObject {
	
	private Color color;
	private Rectangle area;
	private int cellSize;
	
	public Grid(int x, int y, int cellsInGrid, int cellSize, Color color) {
		this.cellSize = cellSize;
		this.color = color;
		this.area = new Rectangle(x, y, 
				cellSize*cellsInGrid,
				cellSize*cellsInGrid);
	}

	@Override
	public int getX() {
		return area.x;
	}

	@Override
	public int getY() {
		return area.y;
	}

	@Override
	public int getWidth() {
		return area.width;
	}

	@Override
	public int getHeight() {
		return area.height;
	}

	@Override
	public Rectangle getRectangle() {
		return area;
	}

	@Override
	public void setX(int x) {
		this.area.x = x;
	}

	@Override
	public void setY(int y) {
		this.area.y = y;
	}

	@Override
	public void setWidth(int width) {
		this.area.width = width;
	}

	@Override
	public void setHeight(int height) {
		this.area.height = height;
	}

	@Override
	public void draw(GL2 gl) {
		gl.glColor4f(color.getRed()/255.0f,color.getGreen()/255.0f,color.getBlue()/255.0f,color.getAlpha()/255.0f);
		gl.glBegin(GL2.GL_LINES);
		for(int x = area.x; x <= area.x + area.width; x += cellSize) {
			gl.glVertex2i(x, area.y);
			gl.glVertex2i(x, area.y + area.height);
		}
		
		for(int y = area.y; y <= area.y + area.height; y += cellSize) {
			gl.glVertex2i(area.x, y);
			gl.glVertex2i(area.x + area.width, y);
		}
		gl.glEnd();
	}

	@Override
	public boolean collisionCheck(GraphicalObject o) {
		return area.contains(o.getRectangle());
	}

	@Override
	public boolean contains(int x, int y) {
		return area.contains(x, y);
	}

}
