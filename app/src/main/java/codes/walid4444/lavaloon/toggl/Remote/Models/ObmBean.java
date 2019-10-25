package codes.walid4444.lavaloon.toggl.Remote.Models;

public class ObmBean {
    /**
     * included : false
     * nr : 0
     * actions : tree
     */

    private boolean included;
    private int nr;
    private String actions;

    public boolean isIncluded() {
        return included;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }
}