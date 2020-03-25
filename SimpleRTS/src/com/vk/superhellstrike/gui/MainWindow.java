package com.vk.superhellstrike.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.util.FPSAnimator;
import com.vk.superhellstrike.input.InputController;
import com.vk.superhellstrike.render.BasicRenderer;

public class MainWindow {

	private final String TITLE = "Simple RTS";
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	private final int FPS = 120;
	
	private JFrame frame;
	private GLJPanel panel;
	private GLCapabilities caps;
	private BasicRenderer renderer;
	private FPSAnimator animator;
	private InputController inputController;
	
	public MainWindow() {	
		frame = new JFrame(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		frame.setResizable(true);
		
		
		caps = new GLCapabilities(GLProfile.get(GLProfile.GL2));
		renderer = new BasicRenderer();
		inputController = new InputController(renderer);
		
		panel = new GLJPanel(caps);
		panel.addGLEventListener(renderer);
		panel.addMouseListener(inputController);
		panel.addKeyListener(inputController);
		frame.getContentPane().add(panel);
		
		animator = new FPSAnimator(panel, FPS, true);
		animator.start();
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainWindow();
	}
}
