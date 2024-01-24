package builders;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import objects.AdditionalInfo;
import objects.TenantId;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateUser {

    public String email;
    public String authority;
    public String firstName;
    public String lastName;
    public TenantIdBuilder tenantId;
    public AdditionalInfoBuilder additionalInfo;
}
