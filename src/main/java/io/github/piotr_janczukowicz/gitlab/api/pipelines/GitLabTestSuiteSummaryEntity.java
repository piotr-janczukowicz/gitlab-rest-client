package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab test suite summary entity.
 *
 * @param name the name
 * @param totalTime the total time
 * @param totalCount the total count
 * @param successCount the success count
 * @param failedCount the failed count
 * @param skippedCount the skipped count
 * @param errorCount the error count
 * @param suiteError the suite error
 * @param testCases the test cases
 * @param buildIds the build ids
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/TestSuiteSummaryEntity")
public record GitLabTestSuiteSummaryEntity(
        @Nullable String name,
        @Nullable Integer totalTime,
        @Nullable Integer totalCount,
        @Nullable Integer successCount,
        @Nullable Integer failedCount,
        @Nullable Integer skippedCount,
        @Nullable Integer errorCount,
        @Nullable String suiteError,
        @Nullable List<GitLabTestCaseEntity> testCases,
        @Nullable List<Long> buildIds) {}
