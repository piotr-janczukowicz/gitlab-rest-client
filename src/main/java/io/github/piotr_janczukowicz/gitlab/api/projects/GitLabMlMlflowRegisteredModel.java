package io.github.piotr_janczukowicz.gitlab.api.projects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ml mlflow registered model.
 *
 * @param name the name
 * @param creationTimestamp the creation timestamp
 * @param lastUpdatedTimestamp the last updated timestamp
 * @param description the description
 * @param userId the user id
 * @param tags the tags
 * @param latestVersions the latest versions
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesMlMlflowRegisteredModel")
public record GitLabMlMlflowRegisteredModel(
        @Nullable String name,
        @Nullable Integer creationTimestamp,
        @Nullable Integer lastUpdatedTimestamp,
        @Nullable String description,
        @Nullable String userId,
        @Nullable List<GitLabMlMlflowKeyValue> tags,
        @Nullable List<GitLabMlMlflowModelVersion> latestVersions) {}
