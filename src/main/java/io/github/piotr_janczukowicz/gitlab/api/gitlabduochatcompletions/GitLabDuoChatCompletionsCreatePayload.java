package io.github.piotr_janczukowicz.gitlab.api.gitlabduochatcompletions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireMaxLengthIfPresent;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.GitLabAnnotationValues;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.openapi.model.CatalogSimpleXor;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * Request body of the operation {@code postApiV4ChatCompletions}.
 *
 * @param content the content
 * @param resourceType the resource type
 * @param resourceId the resource id
 * @param refererUrl the referer url
 * @param clientSubscriptionId the client subscription id
 * @param withCleanHistory the with clean history
 * @param projectId the project id
 * @param currentFile the current file
 * @param additionalContext the additional context
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
@CatalogSchema("operations/postApiV4ChatCompletions/requestBody")
public record GitLabDuoChatCompletionsCreatePayload(
        @Nullable String content,
        @Nullable GitLabDuoChatCompletionsCreateResourceType resourceType,

        @Nullable @CatalogSimpleXor(GitLabAnnotationValues.XOR_STRING_INTEGER)
        String resourceId,

        @Nullable String refererUrl,
        @Nullable String clientSubscriptionId,
        @Nullable Boolean withCleanHistory,
        @Nullable Long projectId,
        @Nullable GitLabDuoChatCompletionsCreateCurrentFile currentFile,
        @Nullable List<GitLabDuoChatCompletionsCreateAdditionalContext> additionalContext) {
    public GitLabDuoChatCompletionsCreatePayload {
        requireMaxLengthIfPresent(content, 1000, "content");
        requireMaxLengthIfPresent(refererUrl, 1000, "refererUrl");
        requireMaxLengthIfPresent(clientSubscriptionId, 500, "clientSubscriptionId");
        if (additionalContext != null) {
            additionalContext = List.copyOf(additionalContext);
        }
    }
}
