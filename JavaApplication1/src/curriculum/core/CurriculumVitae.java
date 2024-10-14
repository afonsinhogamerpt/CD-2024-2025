/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curriculum.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author afonsorgcosta
 */
public class CurriculumVitae {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int curriculumId;
    private int eventId;
    private int personId;
    private Event[] evento;
    
    public CurriculumVitae() {
        
    }
    
    public CurriculumVitae(int curriculumId, int eventId, int personId, Event[] evento){
        this.curriculumId = curriculumId;
        this.eventId = eventId;
        this.personId = personId;
        this.evento = evento;
    }

    public int getCurriculumId() {
        return curriculumId;
    }

    public void setCurriculumId(int curriculumId) {
        this.curriculumId = curriculumId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Event[] getEvento() {
        return evento;
    }

    public void setEvento(Event[] evento) {
        this.evento = evento;
    }
    
    public Event groupEvents(){
        Event ev1 = new Event();
        return ev1;
    }
    
    
}
