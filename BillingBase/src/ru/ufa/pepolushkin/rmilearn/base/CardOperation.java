package ru.ufa.pepolushkin.rmilearn.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel Polushkin on 08.10.14 0:17 UTC+6(MSK+2)
 * Created with IntelliJ IDEA 13
 */
public class CardOperation implements Serializable {

	private List<CardOperationCommand> commands = new ArrayList<>();

	public CardOperation(List<CardOperationCommand> commands) {
		this.commands = commands;
	}

	public List<CardOperationCommand> getCommands() {
		return commands;
	}
}
