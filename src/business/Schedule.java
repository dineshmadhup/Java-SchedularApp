/**
 * Author: Dinesh Madhup
 * NPU ID: 10447
 * E-mail: dineshmadhup@gmail.com
 */
package business;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * Schedule Class represents a schedule event.
 * @dinesh
 */
public class Schedule {
   private  Calendar event;
   private String description;
   private boolean enabled;

   
   public Schedule(){
       event = GregorianCalendar.getInstance();
       description = "";
       enabled = true;
   }
   
    /**
     * @return the event
     */
    public Calendar getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Calendar event) {
        this.event = event;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
