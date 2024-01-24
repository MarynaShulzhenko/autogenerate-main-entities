package objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TenantId {
    public String id;
    public String entityType;

    public TenantId(String id, String entityType) {
        this.id = id;
        this.entityType = entityType;
    }
}
