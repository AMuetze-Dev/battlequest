package de.amit.battlequest.model.modes.templates;

import de.amit.battlequest.controller.websocket.modeSenders.templates.ModeSender;

public abstract class Mode<T extends ModeSender> implements IMode<T> {

	@Override
	public Mode<T> createMode() {
		return this;
	}
}
