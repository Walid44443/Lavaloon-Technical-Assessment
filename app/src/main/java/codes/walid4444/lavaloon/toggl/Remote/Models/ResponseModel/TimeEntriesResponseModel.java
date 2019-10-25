package codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel;

public class TimeEntriesResponseModel {

    /**
     * id : 1341745349
     * guid : 69a1128c5efbacd76163cb80e8270cd4
     * wid : 3750995
     * pid : 154912222
     * billable : false
     * start : 2019-10-24T18:34:50+00:00
     * stop : 2019-10-24T18:44:32+00:00
     * duration : 582
     * description : Lavaloon Task
     * duronly : false
     * at : 2019-10-24T18:44:32+00:00
     * uid : 5181178
     */

    private int id;
    private String guid;
    private int wid;
    private int pid;
    private boolean billable;
    private String start;
    private String stop;
    private int duration;
    private String description;
    private boolean duronly;
    private String at;
    private int uid;

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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
