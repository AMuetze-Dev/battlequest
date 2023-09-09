package de.amit.battlequestOLD.model.modes;

import de.amit.battlequestOLD.controller.websocket.modeSenders.templates.ModeSender;
import de.amit.battlequestOLD.model.modes.templates.Mode;

public enum Modie {

	BUZZER(BuzzerMode.class), MULTIPLE_CHOICE(MultipleChoiceMode.class), SCALA(ScalaMode.class),
	SEARCH(SearchMode.class), SORT(SortMode.class), TEXT(TextMode.class);

	Class<? extends Mode<? extends ModeSender>> mode;

	Modie(Class<? extends Mode<? extends ModeSender>> mode) {
		this.mode = mode;
	}

	public Class<? extends Mode<? extends ModeSender>> getMode() {
		return mode;
	}
}
