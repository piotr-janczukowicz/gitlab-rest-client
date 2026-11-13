package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabSettingsUpdatePayload}, flattened into it in JSON.
 *
 * @param elasticsearchAws the elasticsearch aws
 * @param elasticsearchAwsAccessKey the elasticsearch aws access key
 * @param elasticsearchAwsRegion the elasticsearch aws region
 * @param elasticsearchAwsSecretAccessKey the elasticsearch aws secret access key
 * @param elasticsearchIndexing the elasticsearch indexing
 * @param elasticsearchSearch the elasticsearch search
 * @param elasticsearchPauseIndexing the elasticsearch pause indexing
 * @param elasticsearchAdvancedSearchPauseIndexing the elasticsearch advanced search pause indexing
 * @param elasticsearchUrl the elasticsearch url
 * @param elasticsearchUsername the elasticsearch username
 * @param elasticsearchPassword the elasticsearch password
 * @param elasticsearchLimitIndexing the elasticsearch limit indexing
 * @param elasticsearchNamespaceIds the elasticsearch namespace ids
 * @param elasticsearchProjectIds the elasticsearch project ids
 * @param elasticsearchClientAdapter the elasticsearch client adapter
 * @param elasticsearchIndexedFieldLengthLimit the elasticsearch indexed field length limit
 * @param elasticsearchIndexedFileSizeLimitKb the elasticsearch indexed file size limit kb
 * @param elasticsearchMaxBulkConcurrency the elasticsearch max bulk concurrency
 * @param elasticsearchMaxBulkSizeMb the elasticsearch max bulk size mb
 * @param elasticsearchMaxCodeIndexingConcurrency the elasticsearch max code indexing concurrency
 * @param elasticsearchReplicas the elasticsearch replicas
 * @param elasticsearchRequeueWorkers the elasticsearch requeue workers
 * @param elasticsearchRetryOnFailure the elasticsearch retry on failure
 * @param elasticsearchShards the elasticsearch shards
 * @param elasticsearchWorkerNumberOfShards the elasticsearch worker number of shards
 * @param elasticsearchAwsRoleArn the elasticsearch aws role arn
 * @param elasticsearchClientRequestTimeout the elasticsearch client request timeout
 * @param elasticsearchIndexingTimeoutMinutes the elasticsearch indexing timeout minutes
 * @param elasticsearchAnalyzersSmartcnEnabled the elasticsearch analyzers smartcn enabled
 * @param elasticsearchAnalyzersSmartcnSearch the elasticsearch analyzers smartcn search
 * @param elasticsearchAnalyzersKuromojiEnabled the elasticsearch analyzers kuromoji enabled
 * @param elasticsearchAnalyzersKuromojiSearch the elasticsearch analyzers kuromoji search
 * @param elasticsearchCodeScope the elasticsearch code scope
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabSettingsUpdateElasticsearch(
        @Nullable Boolean elasticsearchAws,
        @Nullable String elasticsearchAwsAccessKey,
        @Nullable String elasticsearchAwsRegion,
        @Nullable String elasticsearchAwsSecretAccessKey,
        @Nullable Boolean elasticsearchIndexing,
        @Nullable Boolean elasticsearchSearch,
        @Nullable Boolean elasticsearchPauseIndexing,
        @Nullable Boolean elasticsearchAdvancedSearchPauseIndexing,
        @Nullable String elasticsearchUrl,
        @Nullable String elasticsearchUsername,
        @Nullable String elasticsearchPassword,
        @Nullable Boolean elasticsearchLimitIndexing,
        @Nullable List<Long> elasticsearchNamespaceIds,
        @Nullable List<Long> elasticsearchProjectIds,
        @Nullable String elasticsearchClientAdapter,
        @Nullable String elasticsearchIndexedFieldLengthLimit,
        @Nullable String elasticsearchIndexedFileSizeLimitKb,
        @Nullable String elasticsearchMaxBulkConcurrency,
        @Nullable String elasticsearchMaxBulkSizeMb,
        @Nullable String elasticsearchMaxCodeIndexingConcurrency,
        @Nullable String elasticsearchReplicas,
        @Nullable String elasticsearchRequeueWorkers,
        @Nullable String elasticsearchRetryOnFailure,
        @Nullable String elasticsearchShards,
        @Nullable String elasticsearchWorkerNumberOfShards,
        @Nullable String elasticsearchAwsRoleArn,
        @Nullable String elasticsearchClientRequestTimeout,
        @Nullable String elasticsearchIndexingTimeoutMinutes,
        @Nullable String elasticsearchAnalyzersSmartcnEnabled,
        @Nullable String elasticsearchAnalyzersSmartcnSearch,
        @Nullable String elasticsearchAnalyzersKuromojiEnabled,
        @Nullable String elasticsearchAnalyzersKuromojiSearch,
        @Nullable String elasticsearchCodeScope) {
    public GitLabSettingsUpdateElasticsearch {
        if (elasticsearchNamespaceIds != null) {
            elasticsearchNamespaceIds = List.copyOf(elasticsearchNamespaceIds);
        }
        if (elasticsearchProjectIds != null) {
            elasticsearchProjectIds = List.copyOf(elasticsearchProjectIds);
        }
    }

    /**
     * Describes this record without its secret.
     *
     * @return text with {@code elasticsearchAwsSecretAccessKey}, {@code elasticsearchPassword} redacted
     */
    @Override
    public String toString() {
        return "GitLabSettingsUpdateElasticsearch[" + "elasticsearchAws=" + elasticsearchAws
                + ", elasticsearchAwsAccessKey=" + elasticsearchAwsAccessKey + ", elasticsearchAwsRegion="
                + elasticsearchAwsRegion + ", elasticsearchAwsSecretAccessKey=<redacted>" + ", elasticsearchIndexing="
                + elasticsearchIndexing + ", elasticsearchSearch=" + elasticsearchSearch
                + ", elasticsearchPauseIndexing=" + elasticsearchPauseIndexing
                + ", elasticsearchAdvancedSearchPauseIndexing=" + elasticsearchAdvancedSearchPauseIndexing
                + ", elasticsearchUrl=" + elasticsearchUrl + ", elasticsearchUsername=" + elasticsearchUsername
                + ", elasticsearchPassword=<redacted>" + ", elasticsearchLimitIndexing=" + elasticsearchLimitIndexing
                + ", elasticsearchNamespaceIds=" + elasticsearchNamespaceIds + ", elasticsearchProjectIds="
                + elasticsearchProjectIds + ", elasticsearchClientAdapter=" + elasticsearchClientAdapter
                + ", elasticsearchIndexedFieldLengthLimit=" + elasticsearchIndexedFieldLengthLimit
                + ", elasticsearchIndexedFileSizeLimitKb=" + elasticsearchIndexedFileSizeLimitKb
                + ", elasticsearchMaxBulkConcurrency=" + elasticsearchMaxBulkConcurrency
                + ", elasticsearchMaxBulkSizeMb=" + elasticsearchMaxBulkSizeMb
                + ", elasticsearchMaxCodeIndexingConcurrency=" + elasticsearchMaxCodeIndexingConcurrency
                + ", elasticsearchReplicas=" + elasticsearchReplicas + ", elasticsearchRequeueWorkers="
                + elasticsearchRequeueWorkers + ", elasticsearchRetryOnFailure=" + elasticsearchRetryOnFailure
                + ", elasticsearchShards=" + elasticsearchShards + ", elasticsearchWorkerNumberOfShards="
                + elasticsearchWorkerNumberOfShards + ", elasticsearchAwsRoleArn=" + elasticsearchAwsRoleArn
                + ", elasticsearchClientRequestTimeout=" + elasticsearchClientRequestTimeout
                + ", elasticsearchIndexingTimeoutMinutes=" + elasticsearchIndexingTimeoutMinutes
                + ", elasticsearchAnalyzersSmartcnEnabled=" + elasticsearchAnalyzersSmartcnEnabled
                + ", elasticsearchAnalyzersSmartcnSearch=" + elasticsearchAnalyzersSmartcnSearch
                + ", elasticsearchAnalyzersKuromojiEnabled=" + elasticsearchAnalyzersKuromojiEnabled
                + ", elasticsearchAnalyzersKuromojiSearch=" + elasticsearchAnalyzersKuromojiSearch
                + ", elasticsearchCodeScope=" + elasticsearchCodeScope + "]";
    }
}
