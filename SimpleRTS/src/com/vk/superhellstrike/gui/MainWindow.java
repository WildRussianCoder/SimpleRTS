package com.vk.superhellstrike.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;
import com.vk.superhellstrike.render.BasicRenderer;

public class MainWindow {

	private final String TITLE = "Hello OpenGL and Java";
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	private final int FPS = 120;
	
	private JFrame frame;
	private GLJPanel panel;
	private GLCapabilities caps;
	private BasicRenderer renderer;
	private FPSAnimator animator;
	
	public MainWindow() {	
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		frame.setResizable(true);
		
		
		caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
		panel = new GLJPanel(caps);
		renderer = new BasicRenderer();
		panel.addGLEventListener(renderer);
		panel.addMouseListener(renderer);
		panel.addKeyListener(renderer);
		frame.getContentPane().add(panel);
		
		animator = new FPSAnimator(panel, FPS, true);
		animator.start();
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
}
