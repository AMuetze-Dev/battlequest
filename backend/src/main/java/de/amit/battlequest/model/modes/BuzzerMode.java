package de.amit.battlequest.model.modes;

import de.amit.battlequest.controller.websocket.modeSenders.BuzzerSender;
import de.amit.battlequest.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequest.model.modes.templates.Mode;

class BuzzerMode extends Mode<BuzzerSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
