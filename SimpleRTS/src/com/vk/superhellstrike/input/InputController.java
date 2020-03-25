package com.vk.superhellstrike.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.vk.superhellstrike.graphics.BasicQuad;
import com.vk.superhellstrike.render.BasicRenderer;

public class InputController implements MouseListener, KeyListener {
	
	protected BasicRenderer renderer;

	public InputController(BasicRenderer renderer) {
		this.renderer = renderer;
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
		int button = e.getButton();
		
		if(button == MouseEvent.BUTTON1) {
			renderer.addGraphicalObject(new BasicQuad(x,y));
		}
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
