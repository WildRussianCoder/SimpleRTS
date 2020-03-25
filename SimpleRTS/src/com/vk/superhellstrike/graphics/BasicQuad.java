package com.vk.superhellstrike.graphics;

import java.awt.Rectangle;

public class BasicQuad extends GraphicalObject {
	public BasicQuad(int x, int y) {
		this.r = new Rectangle(x - 10, y - 10, 20, 20);
	}
}
