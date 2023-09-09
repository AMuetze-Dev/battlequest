package de.amit.battlequestOLD.model.modes;

import de.amit.battlequestOLD.controller.websocket.modeSenders.ScalaSender;
import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequestOLD.model.modes.templates.Mode;

class ScalaMode extends Mode<ScalaSender> {

	@Override
	public IModeSender getIModeSender() {
		return null;
	}

	@Override
	public void setIModeSender(IModeSender iModeSender) {

	}

}
