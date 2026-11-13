package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code putApiV4ApplicationSettings}.
 *
 * @param defaultValue the default properties
 * @param max the max properties
 * @param project the project properties
 * @param allow the allow properties
 * @param user the user properties
 * @param users the users properties
 * @param runner the runner properties
 * @param group the group properties
 * @param ci the ci properties
 * @param external the external properties
 * @param lock the lock properties
 * @param throttle the throttle properties
 * @param elasticsearch the elasticsearch properties
 * @param duo the duo properties
 * @param globalValue the global properties
 * @param zoekt the zoekt properties
 * @param other the other properties
 * @param otherMore the other_more properties
 * @param otherFurther the other_further properties
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/putApiV4ApplicationSettings/requestBody")
public record GitLabSettingsUpdatePayload(
        @Nullable @JsonUnwrapped GitLabSettingsUpdateDefault defaultValue,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateMax max,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateProject project,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateAllow allow,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateUser user,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateUsers users,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateRunner runner,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateGroup group,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateCi ci,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateExternal external,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateLock lock,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateThrottle throttle,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateElasticsearch elasticsearch,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateDuo duo,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateGlobal globalValue,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateZoekt zoekt,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateOther other,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateOtherMore otherMore,
        @Nullable @JsonUnwrapped GitLabSettingsUpdateOtherFurther otherFurther) {}
