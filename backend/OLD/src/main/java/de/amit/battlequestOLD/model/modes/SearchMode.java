package de.amit.battlequestOLD.model.modes;

import de.amit.battlequestOLD.controller.websocket.modeSenders.SearchSender;
import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequestOLD.model.modes.templates.Mode;

class SearchMode extends Mode<SearchSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
