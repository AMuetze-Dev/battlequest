package de.amit.battlequestOLD.model.modes.templates;

import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.IModeSender;
import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.ModeSender;

public interface IMode<T extends ModeSender> {

	Mode<T> createMode();

	IModeSender getIModeSender();

	void setIModeSender(IModeSender iModeSender);
}
