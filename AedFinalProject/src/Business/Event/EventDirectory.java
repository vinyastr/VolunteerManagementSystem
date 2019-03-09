/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Event;

import java.util.ArrayList;

/**
 *
 * @author prashantreddy
 */
public class EventDirectory {
    ArrayList<Event> eventDirectory;
    
    public EventDirectory(){
        eventDirectory= new ArrayList<Event>();
    }

    public ArrayList<Event> getEventDirectory() {
        return eventDirectory;
    }

    public void setEventDirectory(ArrayList<Event> eventDirectory) {
        this.eventDirectory = eventDirectory;
    }
    public Event createEvent()
    {
        Event event = new Event();
        eventDirectory.add(event);
        return event;
    }
}
