package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.time.Instant;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ProjectsIdRepositoryChangelog}.
 *
 * @param fromValue the from
 * @param to the to
 * @param date the date
 * @param trailer the trailer
 * @param configFile the config file
 * @param configFileRef the config file ref
 * @param branch the branch
 * @param file the file
 * @param message the message
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ProjectsIdRepositoryChangelog/requestBody")
public record GitLabProjectRepositoriesCreateChangelogPayload(
        @Nullable @JsonProperty("from") String fromValue,
        @Nullable String to,
        @Nullable Instant date,
        @Nullable String trailer,
        @Nullable String configFile,
        @Nullable String configFileRef,
        @Nullable String branch,
        @Nullable String file,
        @Nullable String message) {}
