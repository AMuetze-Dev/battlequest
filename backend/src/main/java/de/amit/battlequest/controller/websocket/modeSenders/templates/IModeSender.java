package de.amit.battlequest.controller.websocket.modeSenders.templates;

import de.amit.battlequest.model.modes.templates.Mode;

public interface IModeSender {

	void registerAPI();

	void sendPossibleAnswers();

	void sendQuestion();

	void setSender(Mode<ModeSender> mode);

	void submitAnswer();

	void unregisterAPI();
}
