package codes.walid4444.lavaloon.toggl.Remote.Models;

import java.util.List;

public class UserInfoModel {
    /**
     * id : 5181178
     * api_token : 871e465bc6bee6bc3b284c3f0aff16a2
     * default_wid : 3750995
     * email : walid44443@gmail.com
     * fullname : Walid44443
     * jquery_timeofday_format : h:i A
     * jquery_date_format : m/d/Y
     * timeofday_format : h:mm A
     * date_format : MM/DD/YYYY
     * store_start_and_stop_time : true
     * beginning_of_week : 1
     * language : en_US
     * image_url : https://assets.toggl.com/images/profile.png
     * sidebar_piechart : true
     * at : 2019-10-24T18:27:10+00:00
     * created_at : 2019-10-24T18:27:10+00:00
     * retention : 9
     * record_timeline : false
     * render_timeline : false
     * timeline_enabled : false
     * timeline_experiment : false
     * new_blog_post : {"title":"Information About Desktop App Syncing Issues on October 1st","url":"https://blog.toggl.com/toggl-desktop-issue-october-2019/","category":"Announcement","pub_date":"2019-10-03T12:22:18Z"}
     * should_upgrade : true
     * achievements_enabled : true
     * timezone : Africa/Cairo
     * openid_enabled : false
     * send_product_emails : true
     * send_weekly_report : true
     * send_timer_notifications : true
     * last_blog_entry :
     * invitation : {}
     * workspaces : [{"id":3750995,"name":"Walid44443's workspace","profile":0,"premium":false,"admin":true,"default_hourly_rate":0,"default_currency":"USD","only_admins_may_create_projects":false,"only_admins_see_billable_rates":false,"only_admins_see_team_dashboard":false,"projects_billable_by_default":true,"rounding":1,"rounding_minutes":0,"api_token":"a66174f0e0909c733fa8f850ffa4358b","at":"2019-10-24T18:27:10+00:00","ical_enabled":true}]
     * duration_format : improved
     * obm : {"included":false,"nr":0,"actions":"tree"}
     */

    private int id;
    private String api_token;
    private int default_wid;
    private String email;
    private String fullname;
    private String jquery_timeofday_format;
    private String jquery_date_format;
    private String timeofday_format;
    private String date_format;
    private boolean store_start_and_stop_time;
    private int beginning_of_week;
    private String language;
    private String image_url;
    private boolean sidebar_piechart;
    private String at;
    private String created_at;
    private int retention;
    private boolean record_timeline;
    private boolean render_timeline;
    private boolean timeline_enabled;
    private boolean timeline_experiment;
    private NewBlogPostBean new_blog_post;
    private boolean should_upgrade;
    private boolean achievements_enabled;
    private String timezone;
    private boolean openid_enabled;
    private boolean send_product_emails;
    private boolean send_weekly_report;
    private boolean send_timer_notifications;
    private String last_blog_entry;
    private InvitationBean invitation;
    private String duration_format;
    private ObmBean obm;
    private List<WorkspacesBean> workspaces;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public int getDefault_wid() {
        return default_wid;
    }

    public void setDefault_wid(int default_wid) {
        this.default_wid = default_wid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getJquery_timeofday_format() {
        return jquery_timeofday_format;
    }

    public void setJquery_timeofday_format(String jquery_timeofday_format) {
        this.jquery_timeofday_format = jquery_timeofday_format;
    }

    public String getJquery_date_format() {
        return jquery_date_format;
    }

    public void setJquery_date_format(String jquery_date_format) {
        this.jquery_date_format = jquery_date_format;
    }

    public String getTimeofday_format() {
        return timeofday_format;
    }

    public void setTimeofday_format(String timeofday_format) {
        this.timeofday_format = timeofday_format;
    }

    public String getDate_format() {
        return date_format;
    }

    public void setDate_format(String date_format) {
        this.date_format = date_format;
    }

    public boolean isStore_start_and_stop_time() {
        return store_start_and_stop_time;
    }

    public void setStore_start_and_stop_time(boolean store_start_and_stop_time) {
        this.store_start_and_stop_time = store_start_and_stop_time;
    }

    public int getBeginning_of_week() {
        return beginning_of_week;
    }

    public void setBeginning_of_week(int beginning_of_week) {
        this.beginning_of_week = beginning_of_week;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public boolean isSidebar_piechart() {
        return sidebar_piechart;
    }

    public void setSidebar_piechart(boolean sidebar_piechart) {
        this.sidebar_piechart = sidebar_piechart;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getRetention() {
        return retention;
    }

    public void setRetention(int retention) {
        this.retention = retention;
    }

    public boolean isRecord_timeline() {
        return record_timeline;
    }

    public void setRecord_timeline(boolean record_timeline) {
        this.record_timeline = record_timeline;
    }

    public boolean isRender_timeline() {
        return render_timeline;
    }

    public void setRender_timeline(boolean render_timeline) {
        this.render_timeline = render_timeline;
    }

    public boolean isTimeline_enabled() {
        return timeline_enabled;
    }

    public void setTimeline_enabled(boolean timeline_enabled) {
        this.timeline_enabled = timeline_enabled;
    }

    public boolean isTimeline_experiment() {
        return timeline_experiment;
    }

    public void setTimeline_experiment(boolean timeline_experiment) {
        this.timeline_experiment = timeline_experiment;
    }

    public NewBlogPostBean getNew_blog_post() {
        return new_blog_post;
    }

    public void setNew_blog_post(NewBlogPostBean new_blog_post) {
        this.new_blog_post = new_blog_post;
    }

    public boolean isShould_upgrade() {
        return should_upgrade;
    }

    public void setShould_upgrade(boolean should_upgrade) {
        this.should_upgrade = should_upgrade;
    }

    public boolean isAchievements_enabled() {
        return achievements_enabled;
    }

    public void setAchievements_enabled(boolean achievements_enabled) {
        this.achievements_enabled = achievements_enabled;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public boolean isOpenid_enabled() {
        return openid_enabled;
    }

    public void setOpenid_enabled(boolean openid_enabled) {
        this.openid_enabled = openid_enabled;
    }

    public boolean isSend_product_emails() {
        return send_product_emails;
    }

    public void setSend_product_emails(boolean send_product_emails) {
        this.send_product_emails = send_product_emails;
    }

    public boolean isSend_weekly_report() {
        return send_weekly_report;
    }

    public void setSend_weekly_report(boolean send_weekly_report) {
        this.send_weekly_report = send_weekly_report;
    }

    public boolean isSend_timer_notifications() {
        return send_timer_notifications;
    }

    public void setSend_timer_notifications(boolean send_timer_notifications) {
        this.send_timer_notifications = send_timer_notifications;
    }

    public String getLast_blog_entry() {
        return last_blog_entry;
    }

    public void setLast_blog_entry(String last_blog_entry) {
        this.last_blog_entry = last_blog_entry;
    }

    public InvitationBean getInvitation() {
        return invitation;
    }

    public void setInvitation(InvitationBean invitation) {
        this.invitation = invitation;
    }

    public String getDuration_format() {
        return duration_format;
    }

    public void setDuration_format(String duration_format) {
        this.duration_format = duration_format;
    }

    public ObmBean getObm() {
        return obm;
    }

    public void setObm(ObmBean obm) {
        this.obm = obm;
    }

    public List<WorkspacesBean> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<WorkspacesBean> workspaces) {
        this.workspaces = workspaces;
    }

    public static class NewBlogPostBean {
    }

    public static class InvitationBean {
    }
}