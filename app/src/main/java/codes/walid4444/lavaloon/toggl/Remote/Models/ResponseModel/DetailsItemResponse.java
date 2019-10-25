package codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel;

import codes.walid4444.lavaloon.toggl.Remote.Models.TimeEntryModel;

public class DetailsItemResponse {

    private TimeEntryModel data;


    public void setData(TimeEntryModel data) {
        this.data = data;
    }

    public TimeEntryModel getData() {
        return data;
    }
}
