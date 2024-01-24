package utils;

import builders.AdditionalInfoBuilder;
import builders.CreateUser;
import builders.LoginUser;
import builders.TenantIdBuilder;
import objects.AdditionalInfo;
import objects.TenantId;

public class BuilderUtil {
    public LoginUser buildLoginUser(String username, String password) {
        return LoginUser.builder()
                .username(username)
                .password(password)
                .build();
    }

    public CreateUser buildCreateUser(String username, String authority, String firstName, String lastName, TenantId tenantId, AdditionalInfo additionalInfo) {
        return CreateUser.builder()
                .email(username)
                .authority(authority)
                .firstName(firstName)
                .lastName(lastName)
                .tenantId(TenantIdBuilder.builder()
                        .id(tenantId.getId())
                        .entityType(tenantId.getEntityType())
                        .build())
                .additionalInfo(AdditionalInfoBuilder.builder()
                        .defaultDashboardFullscreen(additionalInfo.defaultDashboardFullscreen)
                        .defaultDashboardId(additionalInfo.getHomeDashboardId())
                        .description(additionalInfo.getDescription())
                        .homeDashboardHideToolbar(additionalInfo.homeDashboardHideToolbar)
                        .homeDashboardId(additionalInfo.getHomeDashboardId())
                        .build())
                .build();
    }
}
