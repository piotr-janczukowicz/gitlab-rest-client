package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab test report entity.
 *
 * @param totalTime the total time
 * @param totalCount the total count
 * @param successCount the success count
 * @param failedCount the failed count
 * @param skippedCount the skipped count
 * @param errorCount the error count
 * @param testSuites the test suites
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/TestReportEntity")
public record GitLabTestReportEntity(
        @Nullable Integer totalTime,
        @Nullable Integer totalCount,
        @Nullable Integer successCount,
        @Nullable Integer failedCount,
        @Nullable Integer skippedCount,
        @Nullable Integer errorCount,
        @Nullable List<GitLabTestSuiteEntity> testSuites) {}
