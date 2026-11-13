package io.github.piotr_janczukowicz.gitlab.api.jobs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci job request git info.
 *
 * @param repoUrl the repo url
 * @param ref the ref
 * @param sha the sha
 * @param beforeSha the before sha
 * @param refType the ref type
 * @param refspecs the refspecs
 * @param depth the depth
 * @param repoObjectFormat the repo object format
 * @param protectedValue the protected
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiJobRequestGitInfo")
public record GitLabCiJobRequestGitInfo(
        @Nullable String repoUrl,
        @Nullable String ref,
        @Nullable String sha,
        @Nullable String beforeSha,
        @Nullable String refType,
        @Nullable String refspecs,
        @Nullable String depth,
        @Nullable String repoObjectFormat,
        @Nullable @JsonProperty("protected") String protectedValue) {}
