package de.amit.battlequestOLD.controller.websocket.mode;

import java.lang.reflect.InvocationTargetException;

import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.ModeSender;
import de.amit.battlequestOLD.model.modes.Modie;
import de.amit.battlequestOLD.model.modes.templates.Mode;

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
