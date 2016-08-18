/**
 * Author: Dinesh Madhup
 * NPU ID: 10447
 * E-mail: dineshmadhup@gmail.com
 */

package dataaccess;

import business.Schedule;
import java.io.IOException;
import java.util.ArrayList;


public interface ScheduleWriter {
    void setSchedule(ArrayList<Schedule> theSchedule) throws IOException;
}
