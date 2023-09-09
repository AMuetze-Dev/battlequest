package de.amit.battlequestOLD.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Response {
	private boolean isSuccess;
	private String message;
}
