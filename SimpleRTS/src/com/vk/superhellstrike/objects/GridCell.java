package com.vk.superhellstrike.objects;

import java.awt.Color;

import com.jogamp.opengl.GL2;
import com.vk.superhellstrike.graphics.BasicQuad;
import com.vk.superhellstrike.graphics.GraphicalObject;

public class GridCell {
	private GraphicalObject sprite;
	
	private GraphicalObject highlighter;
	private boolean highlight;
	
	private int row;
	private int column;
	private int size;
	
	public GridCell(int row, int column, int size) {
		this.row = row;
		this.column = column;
		this.size = size;
		this.highlight = false;
		this.sprite = new BasicQuad(column*size, row*size, size, size, Color.black);
		this.highlighter = new BasicQuad(column*size, row*size, size, size, new Color(0,255,0,128));
	}
	
	public void draw(GL2 gl) {
		sprite.draw(gl);
		if(highlight)
			highlighter.draw(gl);
	}
	
	public void setHighlight(boolean highlight) {
		this.highlight = highlight;
	}
	
	public boolean getHighlight() {
		return this.highlight;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public int getColumn() {
		return this.column;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void setSprite(GraphicalObject sprite) {
		this.sprite = sprite;
	}
	
	public GraphicalObject getSprite() {
		return this.sprite;
	}
	
	public void setHighlighter(GraphicalObject highlighter) {
		this.highlighter = highlighter;
	}
	
	public GraphicalObject getHighlighter() {
		return this.highlighter;
	}
}
