package com.vk.superhellstrike.render;

import java.awt.Color;
import java.awt.event.MouseEvent;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.vk.superhellstrike.graphics.BasicQuad;
import com.vk.superhellstrike.graphics.Grid;
import com.vk.superhellstrike.objects.GridCell;

public class GridMap extends BasicRenderer {
	
	private Grid grid;
	private boolean gridIsVisible;
	private GridCell[][] map;
	private int mapSize;
	private int cellSize;
	private GL2 gl;
	private GridCell previousHighlighted;
	
	private boolean isDragged;
	private int startX;
	private int startY;
	private int dX;
	private int dY;
	private int currentX;
	private int currentY;
	
	public GridMap(int mapSize, int cellSize, boolean gridIsVisible) {
		this.isDragged = false;
		this.dX = 0;
		this.dY = 0;
		this.startX = 0;
		this.startY = 0;
		this.currentX = 0;
		this.currentY = 0;
		this.grid = new Grid(0, 0, mapSize, cellSize, Color.white);
		this.gridIsVisible = gridIsVisible;
		this.mapSize = mapSize;
		this.cellSize = cellSize;
		this.previousHighlighted = null;
		this.map = new GridCell[mapSize][mapSize];
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				map[i][j] = new GridCell(i, j, cellSize);
			}
		}
	}
	
	@Override
	public void display(GLAutoDrawable drawable) {
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		gl.glPushMatrix();
		gl.glTranslatef(currentX, currentY, 0);
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				map[i][j].draw(gl);
			}
		}
		
		if(gridIsVisible)
			grid.draw(gl);
		
		gl.glPopMatrix();
		gl.glFlush();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int button = e.getButton();
		
		if(button == MouseEvent.BUTTON1 && 
				x < currentX + cellSize*mapSize && x >= currentX &&
				y < currentY + cellSize*mapSize && y >= currentY) {
			int column = (x - currentX)/cellSize;
			int row = (y - currentY)/cellSize;
			map[row][column].setSprite(new BasicQuad(column*cellSize, row*cellSize, cellSize, cellSize, new Color(255, 0, 255)));
		}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int button = e.getButton();
		int x = e.getX();
		int y = e.getY();
		
		if(button == MouseEvent.BUTTON2) {
			startX = x;
			startY = y;
			isDragged = true;
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		int button = e.getButton();
		if(button == MouseEvent.BUTTON2)
			isDragged = false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(x < currentX + mapSize*cellSize && x >= currentX && y >= currentY && y < currentY + mapSize*cellSize) {
			int column = (x - currentX)/cellSize;
			int row = (y - currentY)/cellSize;
			if(previousHighlighted != null)
				previousHighlighted.setHighlight(false);
			map[row][column].setHighlight(true);
			previousHighlighted = map[row][column];
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(isDragged) {
			dX = x - startX;
			dY = y - startY;
			
			if(Math.abs(dX) > cellSize) {
				startX += dX;
				currentX += dX > 10 ? cellSize : -cellSize;
			}
			
			if(Math.abs(dY) > cellSize) {
				startY += dY;
				currentY += dY > 10 ? cellSize : -cellSize;
			}
		}
			
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		gl.glClearColor(0.2f, 0.2f, 0.2f, 1.0f);
		gl.glEnable(GL2.GL_BLEND);
		gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
	}
	
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GLU glu = new GLU();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(0, drawable.getSurfaceWidth() - 1, drawable.getSurfaceHeight() - 1, 0);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
}
