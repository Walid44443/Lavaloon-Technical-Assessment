package codes.walid4444.lavaloon.toggl.Remote.Models.ResponseModel;

import java.util.List;

import codes.walid4444.lavaloon.toggl.Remote.Models.UserInfoModel;

public class LoginResponseModel {

    /**
     * since : 1571952607
     * data : {"id":5181178,"api_token":"871e465bc6bee6bc3b284c3f0aff16a2","default_wid":3750995,"email":"walid44443@gmail.com","fullname":"Walid44443","jquery_timeofday_format":"h:i A","jquery_date_format":"m/d/Y","timeofday_format":"h:mm A","date_format":"MM/DD/YYYY","store_start_and_stop_time":true,"beginning_of_week":1,"language":"en_US","image_url":"https://assets.toggl.com/images/profile.png","sidebar_piechart":true,"at":"2019-10-24T18:27:10+00:00","created_at":"2019-10-24T18:27:10+00:00","retention":9,"record_timeline":false,"render_timeline":false,"timeline_enabled":false,"timeline_experiment":false,"new_blog_post":{"title":"Information About Desktop App Syncing Issues on October 1st","url":"https://blog.toggl.com/toggl-desktop-issue-october-2019/","category":"Announcement","pub_date":"2019-10-03T12:22:18Z"},"should_upgrade":true,"achievements_enabled":true,"timezone":"Africa/Cairo","openid_enabled":false,"send_product_emails":true,"send_weekly_report":true,"send_timer_notifications":true,"last_blog_entry":"","invitation":{},"workspaces":[{"id":3750995,"name":"Walid44443's workspace","profile":0,"premium":false,"admin":true,"default_hourly_rate":0,"default_currency":"USD","only_admins_may_create_projects":false,"only_admins_see_billable_rates":false,"only_admins_see_team_dashboard":false,"projects_billable_by_default":true,"rounding":1,"rounding_minutes":0,"api_token":"a66174f0e0909c733fa8f850ffa4358b","at":"2019-10-24T18:27:10+00:00","ical_enabled":true}],"duration_format":"improved","obm":{"included":false,"nr":0,"actions":"tree"}}
     */

    private int since;
    private UserInfoModel data;

    public int getSince() {
        return since;
    }

    public void setSince(int since) {
        this.since = since;
    }

    public UserInfoModel getData() {
        return data;
    }

    public void setData(UserInfoModel data) {
        this.data = data;
    }
}
