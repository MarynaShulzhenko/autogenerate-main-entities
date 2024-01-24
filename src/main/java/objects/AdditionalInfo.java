package objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdditionalInfo {
    public boolean defaultDashboardFullscreen;
    public String defaultDashboardId;
    public String description;
    public boolean homeDashboardHideToolbar;
    public String homeDashboardId;

    public AdditionalInfo(boolean defaultDashboardFullscreen, String defaultDashboardId, String description, boolean homeDashboardHideToolbar, String homeDashboardId) {
        this.defaultDashboardFullscreen = defaultDashboardFullscreen;
        this.defaultDashboardId = defaultDashboardId;
        this.description = description;
        this.homeDashboardHideToolbar = homeDashboardHideToolbar;
        this.homeDashboardId = homeDashboardId;
    }
}
