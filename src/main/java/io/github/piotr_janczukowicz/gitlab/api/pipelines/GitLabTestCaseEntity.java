package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.SuppressSchemaTypeMismatch;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * A GitLab test case entity.
 *
 * @param status the status
 * @param name the name
 * @param classname the classname
 * @param file the file
 * @param executionTime the execution time
 * @param systemOutput the system output
 * @param stackTrace the stack trace
 * @param recentFailures the recent failures
 * @param attachmentUrl the attachment url
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("components/schemas/TestCaseEntity")
public record GitLabTestCaseEntity(
        @Nullable String status,
        @Nullable String name,
        @Nullable String classname,
        @Nullable String file,
        @Nullable Integer executionTime,
        @Nullable String systemOutput,
        @Nullable String stackTrace,

        @Nullable @SuppressSchemaTypeMismatch(GitLabAnnotationValues.BARE_OBJECT)
        Map<String, Object> recentFailures,

        @Nullable String attachmentUrl) {}
