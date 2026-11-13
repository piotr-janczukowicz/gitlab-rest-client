package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * The git lab rollouts create data of a GitLab resource.
 *
 * @param position the position
 * @param stageName the stage name
 * @param environment the environment
 * @param stepType the step type
 * @param service the service
 * @param error the error
 * @param reason the reason
 * @param reply the reply
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4RolloutsId/requestBody/properties/data")
public record GitLabRolloutsCreateData(
        @Nullable List<Integer> position,
        @Nullable String stageName,
        @Nullable String environment,
        @Nullable String stepType,
        @Nullable String service,
        @Nullable String error,
        @Nullable String reason,
        @Nullable String reply) {
    public GitLabRolloutsCreateData {
        if (position != null) {
            position = List.copyOf(position);
        }
        requireMaxLengthIfPresent(stageName, 255, "stageName");
        requireMaxLengthIfPresent(environment, 255, "environment");
        requireMaxLengthIfPresent(stepType, 255, "stepType");
        requireMaxLengthIfPresent(service, 255, "service");
        requireMaxLengthIfPresent(error, 2000, "error");
        requireMaxLengthIfPresent(reason, 2000, "reason");
        requireMaxLengthIfPresent(reply, 255, "reply");
    }
}
