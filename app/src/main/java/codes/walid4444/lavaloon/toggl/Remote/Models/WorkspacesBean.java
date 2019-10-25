package codes.walid4444.lavaloon.toggl.Remote.Models;

public  class WorkspacesBean {
    /**
     * id : 3750995
     * name : Walid44443's workspace
     * profile : 0
     * premium : false
     * admin : true
     * default_hourly_rate : 0
     * default_currency : USD
     * only_admins_may_create_projects : false
     * only_admins_see_billable_rates : false
     * only_admins_see_team_dashboard : false
     * projects_billable_by_default : true
     * rounding : 1
     * rounding_minutes : 0
     * api_token : a66174f0e0909c733fa8f850ffa4358b
     * at : 2019-10-24T18:27:10+00:00
     * ical_enabled : true
     */

    private int id;
    private String name;
    private int profile;
    private boolean premium;
    private boolean admin;
    private int default_hourly_rate;
    private String default_currency;
    private boolean only_admins_may_create_projects;
    private boolean only_admins_see_billable_rates;
    private boolean only_admins_see_team_dashboard;
    private boolean projects_billable_by_default;
    private int rounding;
    private int rounding_minutes;
    private String api_token;
    private String at;
    private boolean ical_enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getDefault_hourly_rate() {
        return default_hourly_rate;
    }

    public void setDefault_hourly_rate(int default_hourly_rate) {
        this.default_hourly_rate = default_hourly_rate;
    }

    public String getDefault_currency() {
        return default_currency;
    }

    public void setDefault_currency(String default_currency) {
        this.default_currency = default_currency;
    }

    public boolean isOnly_admins_may_create_projects() {
        return only_admins_may_create_projects;
    }

    public void setOnly_admins_may_create_projects(boolean only_admins_may_create_projects) {
        this.only_admins_may_create_projects = only_admins_may_create_projects;
    }

    public boolean isOnly_admins_see_billable_rates() {
        return only_admins_see_billable_rates;
    }

    public void setOnly_admins_see_billable_rates(boolean only_admins_see_billable_rates) {
        this.only_admins_see_billable_rates = only_admins_see_billable_rates;
    }

    public boolean isOnly_admins_see_team_dashboard() {
        return only_admins_see_team_dashboard;
    }

    public void setOnly_admins_see_team_dashboard(boolean only_admins_see_team_dashboard) {
        this.only_admins_see_team_dashboard = only_admins_see_team_dashboard;
    }

    public boolean isProjects_billable_by_default() {
        return projects_billable_by_default;
    }

    public void setProjects_billable_by_default(boolean projects_billable_by_default) {
        this.projects_billable_by_default = projects_billable_by_default;
    }

    public int getRounding() {
        return rounding;
    }

    public void setRounding(int rounding) {
        this.rounding = rounding;
    }

    public int getRounding_minutes() {
        return rounding_minutes;
    }

    public void setRounding_minutes(int rounding_minutes) {
        this.rounding_minutes = rounding_minutes;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public boolean isIcal_enabled() {
        return ical_enabled;
    }

    public void setIcal_enabled(boolean ical_enabled) {
        this.ical_enabled = ical_enabled;
    }
}
