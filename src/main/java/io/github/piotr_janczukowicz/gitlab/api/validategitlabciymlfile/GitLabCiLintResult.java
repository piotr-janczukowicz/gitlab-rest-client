package io.github.piotr_janczukowicz.gitlab.api.validategitlabciymlfile;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab ci lint result.
 *
 * @param valid the valid
 * @param errors the errors
 * @param warnings the warnings
 * @param mergedYaml the merged yaml
 * @param includes the includes
 * @param jobs the jobs
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCiLintResult")
public record GitLabCiLintResult(
        @Nullable Boolean valid,
        @Nullable List<String> errors,
        @Nullable List<String> warnings,
        @Nullable String mergedYaml,
        @Nullable List<GitLabCiLintResultInclude> includes,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        List<Map<String, Object>> jobs) {}
