/**
 * Author: Dinesh Madhup
 * NPU ID: 10447
 * E-mail: dineshmadhup@gmail.com
 */

package dataaccess;

import business.Schedule;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;


public interface ScheduleReader {
    ArrayList<Schedule> getSchedule() throws FileNotFoundException,IOException,ParseException;
}
