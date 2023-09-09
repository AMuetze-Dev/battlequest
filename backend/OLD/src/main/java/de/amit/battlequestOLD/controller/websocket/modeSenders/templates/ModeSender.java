package de.amit.battlequestOLD.controller.websocket.modeSenders.templates;

import de.amit.battlequestOLD.model.modes.templates.Mode;

public abstract class ModeSender implements IModeSender {

	private Mode<ModeSender> mode;

	public ModeSender() {
		mode = null;
	}

	protected Mode<ModeSender> getSender() {
		return mode;
	}

	@Override
	public void setSender(Mode<ModeSender> mode) {
		this.mode = mode;
	}
}
