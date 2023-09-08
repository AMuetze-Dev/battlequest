package de.amit.battlequest.model.modes;

import de.amit.battlequest.controller.websocket.modeSenders.TextSender;
import de.amit.battlequest.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequest.model.modes.templates.Mode;

class TextMode extends Mode<TextSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
