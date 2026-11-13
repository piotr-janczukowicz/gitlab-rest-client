package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow model version.
 *
 * @param name the name
 * @param version the version
 * @param creationTimestamp the creation timestamp
 * @param lastUpdatedTimestamp the last updated timestamp
 * @param userId the user id
 * @param currentStage the current stage
 * @param description the description
 * @param source the source
 * @param runId the run id
 * @param status the status
 * @param statusMessage the status message
 * @param tags the tags
 * @param runLink the run link
 * @param aliases the aliases
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowModelVersion")
public record GitLabMlMlflowModelVersion(
        @Nullable String name,
        @Nullable String version,
        @Nullable Integer creationTimestamp,
        @Nullable Integer lastUpdatedTimestamp,
        @Nullable String userId,
        @Nullable String currentStage,
        @Nullable String description,
        @Nullable String source,
        @Nullable String runId,
        @Nullable String status,
        @Nullable String statusMessage,
        @Nullable List<GitLabMlMlflowKeyValue> tags,
        @Nullable String runLink,
        @Nullable List<String> aliases) {}
