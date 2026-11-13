package io.github.piotr_janczukowicz.gitlab.api.settings;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.github.piotr_janczukowicz.annotation.RecordBuilder;
import io.github.piotr_janczukowicz.gitlab.api.common.GitLabElasticIndexSetting;
import java.util.List;
import org.jspecify.annotations.Nullable;

/**
 * A group of the properties of {@link GitLabApplicationSetting}, flattened into it in JSON.
 *
 * @param elasticsearchAwsAccessKey the elasticsearch aws access key
 * @param elasticsearchAwsRegion the elasticsearch aws region
 * @param elasticsearchAwsRoleArn the elasticsearch aws role arn
 * @param elasticsearchAwsSecretAccessKey the elasticsearch aws secret access key
 * @param elasticsearchAws the elasticsearch aws
 * @param elasticsearchClientAdapter the elasticsearch client adapter
 * @param elasticsearchClientRequestTimeout the elasticsearch client request timeout
 * @param elasticsearchIndexedFieldLengthLimit the elasticsearch indexed field length limit
 * @param elasticsearchIndexedFileSizeLimitKb the elasticsearch indexed file size limit kb
 * @param elasticsearchIndexingTimeoutMinutes the elasticsearch indexing timeout minutes
 * @param elasticsearchIndexing the elasticsearch indexing
 * @param elasticsearchRequeueWorkers the elasticsearch requeue workers
 * @param elasticsearchLimitIndexing the elasticsearch limit indexing
 * @param elasticsearchWorkerNumberOfShards the elasticsearch worker number of shards
 * @param elasticsearchMaxBulkConcurrency the elasticsearch max bulk concurrency
 * @param elasticsearchMaxBulkSizeMb the elasticsearch max bulk size mb
 * @param elasticsearchMaxCodeIndexingConcurrency the elasticsearch max code indexing concurrency
 * @param elasticsearchNamespaceIds the elasticsearch namespace ids
 * @param elasticsearchPauseIndexing the elasticsearch pause indexing
 * @param elasticsearchAdvancedSearchPauseIndexing the elasticsearch advanced search pause indexing
 * @param elasticsearchProjectIds the elasticsearch project ids
 * @param elasticsearchRetryOnFailure the elasticsearch retry on failure
 * @param elasticsearchReplicas the elasticsearch replicas
 * @param elasticsearchSearch the elasticsearch search
 * @param elasticsearchShards the elasticsearch shards
 * @param elasticsearchUrl the elasticsearch url
 * @param elasticsearchUsername the elasticsearch username
 * @param elasticsearchPassword the elasticsearch password
 * @param elasticsearchAnalyzersSmartcnEnabled the elasticsearch analyzers smartcn enabled
 * @param elasticsearchAnalyzersSmartcnSearch the elasticsearch analyzers smartcn search
 * @param elasticsearchAnalyzersKuromojiEnabled the elasticsearch analyzers kuromoji enabled
 * @param elasticsearchAnalyzersKuromojiSearch the elasticsearch analyzers kuromoji search
 * @param elasticsearchCodeScope the elasticsearch code scope
 * @param elasticsearchIndexSettings the elasticsearch index settings
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@RecordBuilder
public record GitLabApplicationSettingElasticsearch(
        @Nullable String elasticsearchAwsAccessKey,
        @Nullable String elasticsearchAwsRegion,
        @Nullable String elasticsearchAwsRoleArn,
        @Nullable String elasticsearchAwsSecretAccessKey,
        @Nullable String elasticsearchAws,
        @Nullable String elasticsearchClientAdapter,
        @Nullable String elasticsearchClientRequestTimeout,
        @Nullable String elasticsearchIndexedFieldLengthLimit,
        @Nullable String elasticsearchIndexedFileSizeLimitKb,
        @Nullable String elasticsearchIndexingTimeoutMinutes,
        @Nullable String elasticsearchIndexing,
        @Nullable String elasticsearchRequeueWorkers,
        @Nullable String elasticsearchLimitIndexing,
        @Nullable String elasticsearchWorkerNumberOfShards,
        @Nullable String elasticsearchMaxBulkConcurrency,
        @Nullable String elasticsearchMaxBulkSizeMb,
        @Nullable String elasticsearchMaxCodeIndexingConcurrency,
        @Nullable String elasticsearchNamespaceIds,
        @Nullable String elasticsearchPauseIndexing,
        @Nullable String elasticsearchAdvancedSearchPauseIndexing,
        @Nullable String elasticsearchProjectIds,
        @Nullable String elasticsearchRetryOnFailure,
        @Nullable String elasticsearchReplicas,
        @Nullable String elasticsearchSearch,
        @Nullable String elasticsearchShards,
        @Nullable String elasticsearchUrl,
        @Nullable String elasticsearchUsername,
        @Nullable String elasticsearchPassword,
        @Nullable String elasticsearchAnalyzersSmartcnEnabled,
        @Nullable String elasticsearchAnalyzersSmartcnSearch,
        @Nullable String elasticsearchAnalyzersKuromojiEnabled,
        @Nullable String elasticsearchAnalyzersKuromojiSearch,
        @Nullable String elasticsearchCodeScope,
        @Nullable List<GitLabElasticIndexSetting> elasticsearchIndexSettings) {
    /**
     * Describes this record without its secret.
     *
     * @return text with {@code elasticsearchAwsSecretAccessKey}, {@code elasticsearchPassword} redacted
     */
    @Override
    public String toString() {
        return "GitLabApplicationSettingElasticsearch[" + "elasticsearchAwsAccessKey=" + elasticsearchAwsAccessKey
                + ", elasticsearchAwsRegion=" + elasticsearchAwsRegion + ", elasticsearchAwsRoleArn="
                + elasticsearchAwsRoleArn + ", elasticsearchAwsSecretAccessKey=<redacted>" + ", elasticsearchAws="
                + elasticsearchAws + ", elasticsearchClientAdapter=" + elasticsearchClientAdapter
                + ", elasticsearchClientRequestTimeout=" + elasticsearchClientRequestTimeout
                + ", elasticsearchIndexedFieldLengthLimit=" + elasticsearchIndexedFieldLengthLimit
                + ", elasticsearchIndexedFileSizeLimitKb=" + elasticsearchIndexedFileSizeLimitKb
                + ", elasticsearchIndexingTimeoutMinutes=" + elasticsearchIndexingTimeoutMinutes
                + ", elasticsearchIndexing=" + elasticsearchIndexing + ", elasticsearchRequeueWorkers="
                + elasticsearchRequeueWorkers + ", elasticsearchLimitIndexing=" + elasticsearchLimitIndexing
                + ", elasticsearchWorkerNumberOfShards=" + elasticsearchWorkerNumberOfShards
                + ", elasticsearchMaxBulkConcurrency=" + elasticsearchMaxBulkConcurrency
                + ", elasticsearchMaxBulkSizeMb=" + elasticsearchMaxBulkSizeMb
                + ", elasticsearchMaxCodeIndexingConcurrency=" + elasticsearchMaxCodeIndexingConcurrency
                + ", elasticsearchNamespaceIds=" + elasticsearchNamespaceIds + ", elasticsearchPauseIndexing="
                + elasticsearchPauseIndexing + ", elasticsearchAdvancedSearchPauseIndexing="
                + elasticsearchAdvancedSearchPauseIndexing + ", elasticsearchProjectIds=" + elasticsearchProjectIds
                + ", elasticsearchRetryOnFailure=" + elasticsearchRetryOnFailure + ", elasticsearchReplicas="
                + elasticsearchReplicas + ", elasticsearchSearch=" + elasticsearchSearch + ", elasticsearchShards="
                + elasticsearchShards + ", elasticsearchUrl=" + elasticsearchUrl + ", elasticsearchUsername="
                + elasticsearchUsername + ", elasticsearchPassword=<redacted>"
                + ", elasticsearchAnalyzersSmartcnEnabled=" + elasticsearchAnalyzersSmartcnEnabled
                + ", elasticsearchAnalyzersSmartcnSearch=" + elasticsearchAnalyzersSmartcnSearch
                + ", elasticsearchAnalyzersKuromojiEnabled=" + elasticsearchAnalyzersKuromojiEnabled
                + ", elasticsearchAnalyzersKuromojiSearch=" + elasticsearchAnalyzersKuromojiSearch
                + ", elasticsearchCodeScope=" + elasticsearchCodeScope + ", elasticsearchIndexSettings="
                + elasticsearchIndexSettings + "]";
    }
}
