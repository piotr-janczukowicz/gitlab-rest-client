package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci lint result include.
 *
 * @param type the type
 * @param location the location
 * @param blob the blob
 * @param raw the raw
 * @param extra the extra
 * @param contextProject the context project
 * @param contextSha the context sha
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiLintResultInclude")
public record GitLabCiLintResultInclude(
        @Nullable String type,
        @Nullable String location,
        @Nullable String blob,
        @Nullable String raw,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> extra,

        @Nullable String contextProject,
        @Nullable String contextSha) {}
