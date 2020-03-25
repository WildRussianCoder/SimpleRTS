package com.vk.superhellstrike.render;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.vk.superhellstrike.graphics.GraphicalObject;


public class BasicRenderer implements GLEventListener {
	
	protected ArrayList<GraphicalObject> listOfObjects;
	protected GLU glu;

	@Override
	public void init(GLAutoDrawable drawable) {
		listOfObjects = new ArrayList<GraphicalObject>();
		glu = new GLU();
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		for(GraphicalObject o : listOfObjects) {
			o.draw(gl);
		}
		
		gl.glFlush();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(0, drawable.getSurfaceWidth() - 1, drawable.getSurfaceHeight() - 1, 0);
		
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}
	
	public void addGraphicalObject(GraphicalObject o) {
		listOfObjects.add(o);
	}
}
