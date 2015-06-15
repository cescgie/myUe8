package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

@ManagedBean(name = "todoList", eager = true)
public class ToDoListMB implements Serializable {

	private static final long serialVersionUID = 1L;

    private ToDoList toDoList;
    
	public ToDoListMB() {
		super();
		toDoList = new ToDoList();
	}    

	public List<ToDo> getToDos() {
		return toDoList.getToDos();
	}
	
	public int getSize() {
		return toDoList.size();
	}
	
	public int getSizeDone() {
		return toDoList.sizeDone();
	}

	//Should be called if the Button "Speichern" is pushed.
	//Needs configuration in the faces-config.xml.
    public String save() {
    	return "save";
    }
}
