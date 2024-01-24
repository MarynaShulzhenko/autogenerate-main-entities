package builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdditionalInfoBuilder {

    public boolean defaultDashboardFullscreen;
    public String defaultDashboardId;
    public String description;
    public boolean homeDashboardHideToolbar;
    public String homeDashboardId;
}
