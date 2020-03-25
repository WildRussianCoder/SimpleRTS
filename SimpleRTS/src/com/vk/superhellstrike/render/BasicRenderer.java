package com.vk.superhellstrike.render;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;


public class BasicRenderer implements GLEventListener, MouseListener, KeyListener {

	@Override
	public void init(GLAutoDrawable drawable) {}

	@Override
	public void dispose(GLAutoDrawable drawable) {}

	@Override
	public void display(GLAutoDrawable drawable) {
		GL2 gl = drawable.getGL().getGL2();
		
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT);
		
		
		gl.glFlush();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
