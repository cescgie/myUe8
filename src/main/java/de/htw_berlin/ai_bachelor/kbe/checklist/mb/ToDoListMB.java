package de.htw_berlin.ai_bachelor.kbe.checklist.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDo;
import de.htw_berlin.ai_bachelor.kbe.checklist.model.ToDoList;

@ManagedBean(name = "todoList", eager = true)
public class ToDoListMB implements PhaseListener, Serializable {

	private static final long serialVersionUID = 1L;

    private ToDoList toDoList;
    
    FacesContext context = null;
    String name;
    
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
    
    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public void afterPhase(PhaseEvent event) {
    	System.out.println("After : - "+event.getPhaseId()+ "\n");
    		if (event.getPhaseId() == PhaseId.RESTORE_VIEW) 
    		{	
    			if (FacesContext.getCurrentInstance().isPostback())
    			{
    				System.out.println("- is PostbackRequest");
    			}
    			System.out.println("- Die ID der Wurzel des Komponentenbaums: "+event.getPhaseId());
    			System.out.println("- Die Anzahl der Elemente im zum View gehörenden Komponentenbaum: " + getComponent(event)+"\n");
    		}
    		
    		if (event.getPhaseId() == PhaseId.RENDER_RESPONSE)
    		{
    			System.out.println("- is RenderResponse");
    			System.out.println("- Die ID der Wurzel des Komponentenbaums: "+event.getPhaseId());
    			System.out.println("- Die Anzahl der Elemente im zum View gehörenden Komponentenbaum: " + getComponent(event)+"\n");
    		}
    } 


    public void beforePhase(PhaseEvent event) {
    	System.out.println("Before : - " + event.getPhaseId()); 
    }

    
    public PhaseId getPhaseId() {
    	return PhaseId.ANY_PHASE;
    }
    
    /*
     * Quelle :
     * http://www.jroller.com/cschalk/entry/getting_familiar_with_the_jsf 
     * http://stackoverflow.com/questions/8388854/how-to-implement-a-phaselistener-which-runs-at-end-of-lifecycle
     * http://www.devmanuals.com/tutorials/java/jsf/jsf2TagLibrary/core/phaseListener.html
     */
    
    private int getComponent(PhaseEvent event) {
		int count = 1;
		count += event.getFacesContext().getViewRoot().getChildCount();
		return count;
	}
    
    /*
     * Quelle:
     * https://community.oracle.com/thread/1729930
     * https://community.oracle.com/thread/1732507
     * https://goo.gl/4muZdq
     */

}
