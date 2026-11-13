package io.github.piotr_janczukowicz.gitlab.api.settings;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;

/**
 * A GitLab application setting.
 *
 * @param allow the allow properties
 * @param ci the ci properties
 * @param container the container properties
 * @param defaultValue the default properties
 * @param external the external properties
 * @param lock the lock properties
 * @param max the max properties
 * @param project the project properties
 * @param throttle the throttle properties
 * @param user the user properties
 * @param group the group properties
 * @param users the users properties
 * @param runner the runner properties
 * @param globalValue the global properties
 * @param duo the duo properties
 * @param elasticsearch the elasticsearch properties
 * @param zoekt the zoekt properties
 * @param other the other properties
 * @param otherMore the other_more properties
 * @param otherFurther the other_further properties
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesApplicationSetting")
public record GitLabApplicationSetting(
        @JsonUnwrapped GitLabApplicationSettingAllow allow,
        @JsonUnwrapped GitLabApplicationSettingCi ci,
        @JsonUnwrapped GitLabApplicationSettingContainer container,
        @JsonUnwrapped GitLabApplicationSettingDefault defaultValue,
        @JsonUnwrapped GitLabApplicationSettingExternal external,
        @JsonUnwrapped GitLabApplicationSettingLock lock,
        @JsonUnwrapped GitLabApplicationSettingMax max,
        @JsonUnwrapped GitLabApplicationSettingProject project,
        @JsonUnwrapped GitLabApplicationSettingThrottle throttle,
        @JsonUnwrapped GitLabApplicationSettingUser user,
        @JsonUnwrapped GitLabApplicationSettingGroup group,
        @JsonUnwrapped GitLabApplicationSettingUsers users,
        @JsonUnwrapped GitLabApplicationSettingRunner runner,
        @JsonUnwrapped GitLabApplicationSettingGlobal globalValue,
        @JsonUnwrapped GitLabApplicationSettingDuo duo,
        @JsonUnwrapped GitLabApplicationSettingElasticsearch elasticsearch,
        @JsonUnwrapped GitLabApplicationSettingZoekt zoekt,
        @JsonUnwrapped GitLabApplicationSettingOther other,
        @JsonUnwrapped GitLabApplicationSettingOtherMore otherMore,
        @JsonUnwrapped GitLabApplicationSettingOtherFurther otherFurther) {
    public GitLabApplicationSetting {
        requireNonNull(allow, "allow");
        requireNonNull(ci, "ci");
        requireNonNull(container, "container");
        requireNonNull(defaultValue, "defaultValue");
        requireNonNull(external, "external");
        requireNonNull(lock, "lock");
        requireNonNull(max, "max");
        requireNonNull(project, "project");
        requireNonNull(throttle, "throttle");
        requireNonNull(user, "user");
        requireNonNull(group, "group");
        requireNonNull(users, "users");
        requireNonNull(runner, "runner");
        requireNonNull(globalValue, "globalValue");
        requireNonNull(duo, "duo");
        requireNonNull(elasticsearch, "elasticsearch");
        requireNonNull(zoekt, "zoekt");
        requireNonNull(other, "other");
        requireNonNull(otherMore, "otherMore");
        requireNonNull(otherFurther, "otherFurther");
    }
}
