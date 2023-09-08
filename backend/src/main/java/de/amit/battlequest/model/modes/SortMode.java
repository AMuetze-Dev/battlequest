package de.amit.battlequest.model.modes;

import de.amit.battlequest.controller.websocket.modeSenders.SortSender;
import de.amit.battlequest.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequest.model.modes.templates.Mode;

class SortMode extends Mode<SortSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
