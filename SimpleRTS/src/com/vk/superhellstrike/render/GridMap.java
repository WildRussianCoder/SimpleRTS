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
	
	public GridMap(int mapSize, int cellSize, boolean gridIsVisible) {
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
		
		for(int i = 0; i < mapSize; i++) {
			for(int j = 0; j < mapSize; j++) {
				map[i][j].draw(gl);
			}
		}
		
		if(gridIsVisible)
			grid.draw(gl);
		gl.glFlush();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = e.getY() / cellSize;
		int column = e.getX() / cellSize;
		int button = e.getButton();
		
		if(button == MouseEvent.BUTTON1 && row < mapSize && column < mapSize) {
			map[row][column].setSprite(new BasicQuad(column*cellSize, row*cellSize, cellSize, cellSize, new Color(255, 0, 255)));
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		int row = e.getY() / cellSize;
		int column = e.getX() / cellSize;
		
		if(row < mapSize && column < mapSize) {
			if(previousHighlighted != null)
				previousHighlighted.setHighlight(false);
			map[row][column].setHighlight(true);
			previousHighlighted = map[row][column];
			
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
