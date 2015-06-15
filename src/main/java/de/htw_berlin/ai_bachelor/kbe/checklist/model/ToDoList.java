package de.htw_berlin.ai_bachelor.kbe.checklist.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ToDoList implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private List<ToDo> toDos =  new ArrayList<ToDo>();
	
	
	public ToDoList() {
		super();
		this.setToDos();
	}
	
	
	public List<ToDo> getToDos() {
		return toDos;
	}

	private void setToDos() {
		toDos.add(new ToDo("KBE: Aufgabenzettel 2 bearbeiten"));
		toDos.add(new ToDo("KBE: Zweite Vorlesung nacharbeiten"));
		toDos.add(new ToDo("Lebensmittel einkaufen "));
		toDos.add(new ToDo("Leergut wegbringen"));
		toDos.add(new ToDo("Geburtstagsgeschenk besorgen"));
		toDos.add(new ToDo("Putzen"));
	}
	
	public int size() {
		return toDos.size();
	}
	
	public int sizeDone() {
		int done = 0;
		for (ToDo item : toDos) {
			if(item.isDone()) {
				++done;
			}
		}
		return done;
	}
}
