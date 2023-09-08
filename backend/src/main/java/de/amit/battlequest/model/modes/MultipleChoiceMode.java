package de.amit.battlequest.model.modes;

import de.amit.battlequest.controller.websocket.modeSenders.MultipleChoiceSender;
import de.amit.battlequest.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequest.model.modes.templates.Mode;

class MultipleChoiceMode extends Mode<MultipleChoiceSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
