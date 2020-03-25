package com.vk.superhellstrike.render;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;
import com.vk.superhellstrike.graphics.BasicQuad;
import com.vk.superhellstrike.graphics.GraphicalObject;

public class BasicRenderer implements GLEventListener, MouseListener, KeyListener {
	
	protected File texFile;
	protected Texture t;
	protected int texture;
	protected LinkedList<GraphicalObject> listOfObjects;
	protected GLU glu;

	@Override
	public void init(GLAutoDrawable drawable) {
		listOfObjects = new LinkedList<GraphicalObject>();
		glu = new GLU();
		GL2 gl = drawable.getGL().getGL2();
		gl.glEnable(GL2.GL_TEXTURE_2D);
		
		try{
			texFile = new File("textures", "20x20.png");
	        Texture t = TextureIO.newTexture(texFile, true);
	        texture = t.getTextureObject(gl);
	          
	     }catch(IOException e){
	        e.printStackTrace();
	     }
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
	

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		listOfObjects.add(new BasicQuad(x, y, texture));
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
