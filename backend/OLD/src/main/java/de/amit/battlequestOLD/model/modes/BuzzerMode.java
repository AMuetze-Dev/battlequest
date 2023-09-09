package de.amit.battlequestOLD.model.modes;

import de.amit.battlequestOLD.controller.websocket.modeSenders.BuzzerSender;
import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequestOLD.model.modes.templates.Mode;

class BuzzerMode extends Mode<BuzzerSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
