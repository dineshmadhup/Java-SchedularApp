/**
 * Author: Dinesh Madhup
 * NPU ID: 10447
 * E-mail: dineshmadhup@gmail.com
 */
package dataaccess;

import business.Schedule;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *Handles all I/O with the file
 */
public class ScheduleData implements ScheduleReader, ScheduleWriter, ScheduleConstants {

    // Path to the file
    private String filePath;

    

    /**
     * Initialize the scheduleData with a path to a file
     *
     * @param path valid file path either to read/write
     */
    public ScheduleData(String path) {
        filePath = path;
    }

    /**
     * Read a schedule from a file
     * @return all the schedule information from the file
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ParseException 
     */
    @Override
    public ArrayList<Schedule> getSchedule() throws FileNotFoundException,IOException,ParseException {
        File scheduleFile = new File(filePath);
        BufferedReader in = new BufferedReader(
                new FileReader(scheduleFile));

        ArrayList<Schedule> schedule = new ArrayList<Schedule>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String line = in.readLine();
            while(line != null)
            {
                String[] columns = line.split(FIELD_SEP);
                
                Schedule sch = new Schedule();
                //Parse the date from the string and save it to object
                Date theDate = sdf.parse(columns[0]);
                Calendar cal = Calendar.getInstance();
                cal.setTime(theDate);
                sch.setEvent(cal);
                //Get aditional data
                sch.setDescription(columns[1]);
                sch.setEnabled(false);
                if (columns[2].equals("true")){
                    sch.setEnabled(true);
                }
                
                schedule.add(sch);

                line = in.readLine();
            }
        
        return schedule;
    }

    /**
     * Writes the schedule to a file
     * @param theSchedule List of all events
     * @throws IOException 
     */
    @Override
    public void setSchedule(ArrayList<Schedule> theSchedule) throws IOException {
        //First create the new file.
        File scheduleFile = new File(filePath);
        if (!scheduleFile.exists()) {
            scheduleFile.createNewFile();
        }
        //Use printWriter since its just plain text
        PrintWriter out = null;
        out = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(scheduleFile)));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        
        for (Schedule sch : theSchedule) {
            out.print(sdf.format(sch.getEvent().getTime()) + FIELD_SEP);
            out.print(sch.getDescription() + FIELD_SEP);
            
            if (sch.isEnabled()) {
                out.println("true");

            } else {
                out.println("false");
            }
        }
        
        out.close();
    }

}
