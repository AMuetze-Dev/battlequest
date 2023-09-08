package de.amit.battlequest.model.modes;

import de.amit.battlequest.controller.websocket.modeSenders.SearchSender;
import de.amit.battlequest.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequest.model.modes.templates.Mode;

class SearchMode extends Mode<SearchSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
