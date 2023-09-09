package de.amit.battlequestOLD.model.modes.templates;

import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.ModeSender;

public abstract class Mode<T extends ModeSender> implements IMode<T> {

	@Override
	public Mode<T> createMode() {
		return this;
	}
}
