package de.amit.battlequestOLD.model.modes;

import de.amit.battlequestOLD.controller.websocket.modeSenders.SortSender;
import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequestOLD.model.modes.templates.Mode;

class SortMode extends Mode<SortSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
