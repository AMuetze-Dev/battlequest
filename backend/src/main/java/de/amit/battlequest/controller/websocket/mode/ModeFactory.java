package de.amit.battlequest.controller.websocket.mode;

import java.lang.reflect.InvocationTargetException;

import de.amit.battlequest.controller.websocket.modeSenders.templates.ModeSender;
import de.amit.battlequest.model.modes.Modie;
import de.amit.battlequest.model.modes.templates.Mode;

public class ModeFactory {

	public static Mode<? extends ModeSender> createMode(Modie modie) {
		try {
			return modie.getMode().getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}

	private ModeFactory() {
	}
}
