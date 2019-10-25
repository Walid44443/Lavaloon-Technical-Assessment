package codes.walid4444.lavaloon.toggl.Remote.Models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class TimeEntryModel implements Comparable<TimeEntryModel>{

    /**
     * id : 1341958724
     * guid : d56537ae363371f958ba847f5cb1ca41
     * wid : 3750995
     * billable : false
     * start : 2019-10-24T23:18:45+00:00
     * stop : 2019-10-24T23:18:48+00:00
     * duration : 3
     * duronly : false
     * at : 2019-10-24T23:18:48+00:00
     * uid : 5181178
     */


    private int id;
    private String guid;
    private int wid;
    private boolean billable;
    private String start;
    private String stop;
    private int duration;
    private boolean duronly;
    private String at;
    private int uid;
    private String description;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isDuronly() {
        return duronly;
    }

    public void setDuronly(boolean duronly) {
        this.duronly = duronly;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(TimeEntryModel otherObject) {
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
                try {
                    return f.parse(at).compareTo(f.parse(otherObject.at));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
    }
}
