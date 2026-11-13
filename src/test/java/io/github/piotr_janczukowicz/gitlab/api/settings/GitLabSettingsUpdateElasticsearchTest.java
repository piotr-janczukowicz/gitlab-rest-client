package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateElasticsearchTest {

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAws(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAws()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsAccessKeyIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAwsAccessKey(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsRegionIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAwsRegion(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsRegion()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsSecretAccessKeyIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAwsSecretAccessKey(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsSecretAccessKey()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexingIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchIndexing(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchSearchIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchSearch(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchPauseIndexingIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchPauseIndexing(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchPauseIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAdvancedSearchPauseIndexingIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAdvancedSearchPauseIndexing(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAdvancedSearchPauseIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchUrlIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchUrl(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchUsernameIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchUsername(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchUsername()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchPasswordIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchPassword(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchPassword()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchLimitIndexingIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchLimitIndexing(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchLimitIndexing()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchNamespaceIdsIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchNamespaceIds(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchNamespaceIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchProjectIdsIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchProjectIds(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchProjectIds()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchClientAdapterIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchClientAdapter(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchClientAdapter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexedFieldLengthLimitIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchIndexedFieldLengthLimit(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexedFieldLengthLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexedFileSizeLimitKbIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchIndexedFileSizeLimitKb(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexedFileSizeLimitKb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchMaxBulkConcurrencyIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchMaxBulkConcurrency(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchMaxBulkConcurrency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchMaxBulkSizeMbIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchMaxBulkSizeMb(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchMaxBulkSizeMb()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchMaxCodeIndexingConcurrencyIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchMaxCodeIndexingConcurrency(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchMaxCodeIndexingConcurrency()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchReplicasIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchReplicas(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchReplicas()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchRequeueWorkersIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchRequeueWorkers(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchRequeueWorkers()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchRetryOnFailureIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchRetryOnFailure(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchRetryOnFailure()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchShardsIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchShards(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchWorkerNumberOfShardsIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchWorkerNumberOfShards(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchWorkerNumberOfShards()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAwsRoleArnIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAwsRoleArn(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAwsRoleArn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchClientRequestTimeoutIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchClientRequestTimeout(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchClientRequestTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchIndexingTimeoutMinutesIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchIndexingTimeoutMinutes(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchIndexingTimeoutMinutes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersSmartcnEnabledIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAnalyzersSmartcnEnabled(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersSmartcnEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersSmartcnSearchIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAnalyzersSmartcnSearch(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersSmartcnSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersKuromojiEnabledIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAnalyzersKuromojiEnabled(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersKuromojiEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchAnalyzersKuromojiSearchIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchAnalyzersKuromojiSearch(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchAnalyzersKuromojiSearch()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenElasticsearchCodeScopeIsNullable() {
        final GitLabSettingsUpdateElasticsearchBuilder builder = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchCodeScope(null);

        final GitLabSettingsUpdateElasticsearch built = builder.build();

        assertThat(built.elasticsearchCodeScope()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateElasticsearch value = SettingsCatalogFixtures.settingsUpdateElasticsearch();

        assertSoftly(softly -> {
            softly.assertThat(value.elasticsearchAws()).isEqualTo(true);
            softly.assertThat(value.elasticsearchAwsAccessKey()).isEqualTo("elasticsearch_aws_access_key");
            softly.assertThat(value.elasticsearchAwsRegion()).isEqualTo("elasticsearch_aws_region");
            softly.assertThat(value.elasticsearchAwsSecretAccessKey()).isEqualTo("elasticsearch_aws_secret_access_key");
            softly.assertThat(value.elasticsearchIndexing()).isEqualTo(true);
            softly.assertThat(value.elasticsearchSearch()).isEqualTo(true);
            softly.assertThat(value.elasticsearchPauseIndexing()).isEqualTo(true);
            softly.assertThat(value.elasticsearchAdvancedSearchPauseIndexing()).isEqualTo(true);
            softly.assertThat(value.elasticsearchUrl()).isEqualTo("elasticsearch_url");
            softly.assertThat(value.elasticsearchUsername()).isEqualTo("elasticsearch_username");
            softly.assertThat(value.elasticsearchPassword()).isEqualTo("elasticsearch_password");
            softly.assertThat(value.elasticsearchLimitIndexing()).isEqualTo(true);
            softly.assertThat(value.elasticsearchNamespaceIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.elasticsearchProjectIds()).isEqualTo(List.of(1L));
            softly.assertThat(value.elasticsearchClientAdapter()).isEqualTo("elasticsearch_client_adapter");
            softly.assertThat(value.elasticsearchIndexedFieldLengthLimit())
                    .isEqualTo("elasticsearch_indexed_field_length_limit");
            softly.assertThat(value.elasticsearchIndexedFileSizeLimitKb())
                    .isEqualTo("elasticsearch_indexed_file_size_limit_kb");
            softly.assertThat(value.elasticsearchMaxBulkConcurrency()).isEqualTo("elasticsearch_max_bulk_concurrency");
            softly.assertThat(value.elasticsearchMaxBulkSizeMb()).isEqualTo("elasticsearch_max_bulk_size_mb");
            softly.assertThat(value.elasticsearchMaxCodeIndexingConcurrency())
                    .isEqualTo("elasticsearch_max_code_indexing_concurrency");
            softly.assertThat(value.elasticsearchReplicas()).isEqualTo("elasticsearch_replicas");
            softly.assertThat(value.elasticsearchRequeueWorkers()).isEqualTo("elasticsearch_requeue_workers");
            softly.assertThat(value.elasticsearchRetryOnFailure()).isEqualTo("elasticsearch_retry_on_failure");
            softly.assertThat(value.elasticsearchShards()).isEqualTo("elasticsearch_shards");
            softly.assertThat(value.elasticsearchWorkerNumberOfShards())
                    .isEqualTo("elasticsearch_worker_number_of_shards");
            softly.assertThat(value.elasticsearchAwsRoleArn()).isEqualTo("elasticsearch_aws_role_arn");
            softly.assertThat(value.elasticsearchClientRequestTimeout())
                    .isEqualTo("elasticsearch_client_request_timeout");
            softly.assertThat(value.elasticsearchIndexingTimeoutMinutes())
                    .isEqualTo("elasticsearch_indexing_timeout_minutes");
            softly.assertThat(value.elasticsearchAnalyzersSmartcnEnabled())
                    .isEqualTo("elasticsearch_analyzers_smartcn_enabled");
            softly.assertThat(value.elasticsearchAnalyzersSmartcnSearch())
                    .isEqualTo("elasticsearch_analyzers_smartcn_search");
            softly.assertThat(value.elasticsearchAnalyzersKuromojiEnabled())
                    .isEqualTo("elasticsearch_analyzers_kuromoji_enabled");
            softly.assertThat(value.elasticsearchAnalyzersKuromojiSearch())
                    .isEqualTo("elasticsearch_analyzers_kuromoji_search");
            softly.assertThat(value.elasticsearchCodeScope()).isEqualTo("elasticsearch_code_scope");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateElasticsearch original = SettingsCatalogFixtures.settingsUpdateElasticsearch();

        final GitLabSettingsUpdateElasticsearch rebuilt =
                GitLabSettingsUpdateElasticsearchBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenElasticsearchNamespaceIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabSettingsUpdateElasticsearch built = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchNamespaceIds(source)
                .build();
        source.clear();

        assertThat(built.elasticsearchNamespaceIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenElasticsearchNamespaceIdsIsRead() {
        final GitLabSettingsUpdateElasticsearch built = SettingsCatalogFixtures.settingsUpdateElasticsearch();
        final List<Long> values = built.elasticsearchNamespaceIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void constructor_shouldCopyTheList_whenElasticsearchProjectIdsSourceChangesLater() {
        final List<Long> source = new ArrayList<>(List.of(1L));
        final GitLabSettingsUpdateElasticsearch built = GitLabSettingsUpdateElasticsearchBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateElasticsearch())
                .elasticsearchProjectIds(source)
                .build();
        source.clear();

        assertThat(built.elasticsearchProjectIds()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenElasticsearchProjectIdsIsRead() {
        final GitLabSettingsUpdateElasticsearch built = SettingsCatalogFixtures.settingsUpdateElasticsearch();
        final List<Long> values = built.elasticsearchProjectIds();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void toString_shouldMaskTheValue_whenElasticsearchAwsSecretAccessKeyIsACredential() {
        final GitLabSettingsUpdateElasticsearch value = SettingsCatalogFixtures.settingsUpdateElasticsearch();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void toString_shouldMaskTheValue_whenElasticsearchPasswordIsACredential() {
        final GitLabSettingsUpdateElasticsearch value = SettingsCatalogFixtures.settingsUpdateElasticsearch();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateElasticsearch.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "elasticsearchAws",
                        "elasticsearchAwsAccessKey",
                        "elasticsearchAwsRegion",
                        "elasticsearchAwsSecretAccessKey",
                        "elasticsearchIndexing",
                        "elasticsearchSearch",
                        "elasticsearchPauseIndexing",
                        "elasticsearchAdvancedSearchPauseIndexing",
                        "elasticsearchUrl",
                        "elasticsearchUsername",
                        "elasticsearchPassword",
                        "elasticsearchLimitIndexing",
                        "elasticsearchNamespaceIds",
                        "elasticsearchProjectIds",
                        "elasticsearchClientAdapter",
                        "elasticsearchIndexedFieldLengthLimit",
                        "elasticsearchIndexedFileSizeLimitKb",
                        "elasticsearchMaxBulkConcurrency",
                        "elasticsearchMaxBulkSizeMb",
                        "elasticsearchMaxCodeIndexingConcurrency",
                        "elasticsearchReplicas",
                        "elasticsearchRequeueWorkers",
                        "elasticsearchRetryOnFailure",
                        "elasticsearchShards",
                        "elasticsearchWorkerNumberOfShards",
                        "elasticsearchAwsRoleArn",
                        "elasticsearchClientRequestTimeout",
                        "elasticsearchIndexingTimeoutMinutes",
                        "elasticsearchAnalyzersSmartcnEnabled",
                        "elasticsearchAnalyzersSmartcnSearch",
                        "elasticsearchAnalyzersKuromojiEnabled",
                        "elasticsearchAnalyzersKuromojiSearch",
                        "elasticsearchCodeScope");
    }
}
