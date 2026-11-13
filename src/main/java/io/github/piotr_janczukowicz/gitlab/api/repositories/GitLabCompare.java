package io.github.piotr_janczukowicz.gitlab.api.repositories;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabCommit;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabDiff;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab compare.
 *
 * @param commit the commit
 * @param commits the commits
 * @param diffs the diffs
 * @param compareTimeout the compare timeout
 * @param compareSameRef the compare same ref
 * @param webUrl the web url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/APIEntitiesCompare")
public record GitLabCompare(
        @Nullable GitLabCommit commit,
        @Nullable List<GitLabCommit> commits,
        @Nullable List<GitLabDiff> diffs,
        @Nullable Boolean compareTimeout,
        @Nullable Boolean compareSameRef,
        @Nullable String webUrl) {}
