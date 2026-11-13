package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingElasticsearchTest {

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsAccessKeyIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAwsAccessKey(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsRegionIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAwsRegion(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsRegion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsRoleArnIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAwsRoleArn(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsRoleArn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsSecretAccessKeyIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAwsSecretAccessKey(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAws(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAws()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchClientAdapterIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchClientAdapter(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchClientAdapter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchClientRequestTimeoutIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchClientRequestTimeout(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchClientRequestTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexedFieldLengthLimitIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchIndexedFieldLengthLimit(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexedFieldLengthLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexedFileSizeLimitKbIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchIndexedFileSizeLimitKb(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexedFileSizeLimitKb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexingTimeoutMinutesIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchIndexingTimeoutMinutes(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexingTimeoutMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexingIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchIndexing(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchRequeueWorkersIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchRequeueWorkers(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchRequeueWorkers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchLimitIndexingIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchLimitIndexing(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchLimitIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchWorkerNumberOfShardsIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchWorkerNumberOfShards(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchWorkerNumberOfShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchMaxBulkConcurrencyIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchMaxBulkConcurrency(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchMaxBulkConcurrency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchMaxBulkSizeMbIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchMaxBulkSizeMb(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchMaxBulkSizeMb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchMaxCodeIndexingConcurrencyIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchMaxCodeIndexingConcurrency(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchMaxCodeIndexingConcurrency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchNamespaceIdsIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchNamespaceIds(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchPauseIndexingIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchPauseIndexing(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchPauseIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAdvancedSearchPauseIndexingIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAdvancedSearchPauseIndexing(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAdvancedSearchPauseIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchProjectIdsIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchProjectIds(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchProjectIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchRetryOnFailureIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchRetryOnFailure(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchRetryOnFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchReplicasIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchReplicas(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchReplicas()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchSearchIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchSearch(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchShardsIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchShards(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchUrlIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchUrl(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchUsernameIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchUsername(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchPasswordIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchPassword(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchPassword()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersSmartcnEnabledIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAnalyzersSmartcnEnabled(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersSmartcnEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersSmartcnSearchIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAnalyzersSmartcnSearch(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersSmartcnSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersKuromojiEnabledIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAnalyzersKuromojiEnabled(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersKuromojiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersKuromojiSearchIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchAnalyzersKuromojiSearch(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersKuromojiSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchCodeScopeIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchCodeScope(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchCodeScope()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexSettingsIsNullable() {
        final GitLabApplicationSettingElasticsearchBuilder builder =
                GitLabApplicationSettingElasticsearchBuilder.builder(
                                SettingsCatalogFixtures.applicationSettingElasticsearch())
                        .elasticsearchIndexSettings(null);

        final GitLabApplicationSettingElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingElasticsearch value = SettingsCatalogFixtures.applicationSettingElasticsearch();

        assertSoftly(softly -> {
            softly.assertThat(value.elasticsearchAwsAccessKey()).isEqualTo("elasticsearch_aws_access_key");
            softly.assertThat(value.elasticsearchAwsRegion()).isEqualTo("elasticsearch_aws_region");
            softly.assertThat(value.elasticsearchAwsRoleArn()).isEqualTo("elasticsearch_aws_role_arn");
            softly.assertThat(value.elasticsearchAwsSecretAccessKey()).isEqualTo("elasticsearch_aws_secret_access_key");
            softly.assertThat(value.elasticsearchAws()).isEqualTo("elasticsearch_aws");
            softly.assertThat(value.elasticsearchClientAdapter()).isEqualTo("elasticsearch_client_adapter");
            softly.assertThat(value.elasticsearchClientRequestTimeout())
                    .isEqualTo("elasticsearch_client_request_timeout");
            softly.assertThat(value.elasticsearchIndexedFieldLengthLimit())
                    .isEqualTo("elasticsearch_indexed_field_length_limit");
            softly.assertThat(value.elasticsearchIndexedFileSizeLimitKb())
                    .isEqualTo("elasticsearch_indexed_file_size_limit_kb");
            softly.assertThat(value.elasticsearchIndexingTimeoutMinutes())
                    .isEqualTo("elasticsearch_indexing_timeout_minutes");
            softly.assertThat(value.elasticsearchIndexing()).isEqualTo("elasticsearch_indexing");
            softly.assertThat(value.elasticsearchRequeueWorkers()).isEqualTo("elasticsearch_requeue_workers");
            softly.assertThat(value.elasticsearchLimitIndexing()).isEqualTo("elasticsearch_limit_indexing");
            softly.assertThat(value.elasticsearchWorkerNumberOfShards())
                    .isEqualTo("elasticsearch_worker_number_of_shards");
            softly.assertThat(value.elasticsearchMaxBulkConcurrency()).isEqualTo("elasticsearch_max_bulk_concurrency");
            softly.assertThat(value.elasticsearchMaxBulkSizeMb()).isEqualTo("elasticsearch_max_bulk_size_mb");
            softly.assertThat(value.elasticsearchMaxCodeIndexingConcurrency())
                    .isEqualTo("elasticsearch_max_code_indexing_concurrency");
            softly.assertThat(value.elasticsearchNamespaceIds()).isEqualTo("elasticsearch_namespace_ids");
            softly.assertThat(value.elasticsearchPauseIndexing()).isEqualTo("elasticsearch_pause_indexing");
            softly.assertThat(value.elasticsearchAdvancedSearchPauseIndexing())
                    .isEqualTo("elasticsearch_advanced_search_pause_indexing");
            softly.assertThat(value.elasticsearchProjectIds()).isEqualTo("elasticsearch_project_ids");
            softly.assertThat(value.elasticsearchRetryOnFailure()).isEqualTo("elasticsearch_retry_on_failure");
            softly.assertThat(value.elasticsearchReplicas()).isEqualTo("elasticsearch_replicas");
            softly.assertThat(value.elasticsearchSearch()).isEqualTo("elasticsearch_search");
            softly.assertThat(value.elasticsearchShards()).isEqualTo("elasticsearch_shards");
            softly.assertThat(value.elasticsearchUrl()).isEqualTo("elasticsearch_url");
            softly.assertThat(value.elasticsearchUsername()).isEqualTo("elasticsearch_username");
            softly.assertThat(value.elasticsearchPassword()).isEqualTo("elasticsearch_password");
            softly.assertThat(value.elasticsearchAnalyzersSmartcnEnabled())
                    .isEqualTo("elasticsearch_analyzers_smartcn_enabled");
            softly.assertThat(value.elasticsearchAnalyzersSmartcnSearch())
                    .isEqualTo("elasticsearch_analyzers_smartcn_search");
            softly.assertThat(value.elasticsearchAnalyzersKuromojiEnabled())
                    .isEqualTo("elasticsearch_analyzers_kuromoji_enabled");
            softly.assertThat(value.elasticsearchAnalyzersKuromojiSearch())
                    .isEqualTo("elasticsearch_analyzers_kuromoji_search");
            softly.assertThat(value.elasticsearchCodeScope()).isEqualTo("elasticsearch_code_scope");
            softly.assertThat(value.elasticsearchIndexSettings())
                    .isEqualTo(List.of(CommonCatalogFixtures.elasticIndexSetting()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingElasticsearch original =
                SettingsCatalogFixtures.applicationSettingElasticsearch();

        final GitLabApplicationSettingElasticsearch rebuilt =
                GitLabApplicationSettingElasticsearchBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenElasticsearchAwsSecretAccessKeyIsACredential() {
        final GitLabApplicationSettingElasticsearch value = SettingsCatalogFixtures.applicationSettingElasticsearch();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenElasticsearchPasswordIsACredential() {
        final GitLabApplicationSettingElasticsearch value = SettingsCatalogFixtures.applicationSettingElasticsearch();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingElasticsearch.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "elasticsearchAwsAccessKey",
                        "elasticsearchAwsRegion",
                        "elasticsearchAwsRoleArn",
                        "elasticsearchAwsSecretAccessKey",
                        "elasticsearchAws",
                        "elasticsearchClientAdapter",
                        "elasticsearchClientRequestTimeout",
                        "elasticsearchIndexedFieldLengthLimit",
                        "elasticsearchIndexedFileSizeLimitKb",
                        "elasticsearchIndexingTimeoutMinutes",
                        "elasticsearchIndexing",
                        "elasticsearchRequeueWorkers",
                        "elasticsearchLimitIndexing",
                        "elasticsearchWorkerNumberOfShards",
                        "elasticsearchMaxBulkConcurrency",
                        "elasticsearchMaxBulkSizeMb",
                        "elasticsearchMaxCodeIndexingConcurrency",
                        "elasticsearchNamespaceIds",
                        "elasticsearchPauseIndexing",
                        "elasticsearchAdvancedSearchPauseIndexing",
                        "elasticsearchProjectIds",
                        "elasticsearchRetryOnFailure",
                        "elasticsearchReplicas",
                        "elasticsearchSearch",
                        "elasticsearchShards",
                        "elasticsearchUrl",
                        "elasticsearchUsername",
                        "elasticsearchPassword",
                        "elasticsearchAnalyzersSmartcnEnabled",
                        "elasticsearchAnalyzersSmartcnSearch",
                        "elasticsearchAnalyzersKuromojiEnabled",
                        "elasticsearchAnalyzersKuromojiSearch",
                        "elasticsearchCodeScope",
                        "elasticsearchIndexSettings");
    }
}
