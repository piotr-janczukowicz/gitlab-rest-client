package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingContainerTest {

    @Test
    void constructor_shouldAcceptNull_whenContainerExpirationPoliciesEnableHistoricEntriesIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerExpirationPoliciesEnableHistoricEntries(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerExpirationPoliciesEnableHistoricEntries()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryExpirationPoliciesCachingIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryExpirationPoliciesCaching(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryExpirationPoliciesCaching()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryTokenExpireDelayIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryTokenExpireDelay(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryTokenExpireDelay()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryDeleteTagsServiceTimeoutIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryDeleteTagsServiceTimeout(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryDeleteTagsServiceTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryExpirationPoliciesWorkerCapacityIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryExpirationPoliciesWorkerCapacity(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryExpirationPoliciesWorkerCapacity()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryCleanupTagsServiceMaxListSizeIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryCleanupTagsServiceMaxListSize(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryCleanupTagsServiceMaxListSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportMaxTagsCountIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportMaxTagsCount(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportMaxTagsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportMaxRetriesIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportMaxRetries(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportMaxRetries()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportStartMaxRetriesIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportStartMaxRetries(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportStartMaxRetries()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportMaxStepDurationIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportMaxStepDuration(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportMaxStepDuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryPreImportTagsRateIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryPreImportTagsRate(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryPreImportTagsRate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryPreImportTimeoutIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryPreImportTimeout(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryPreImportTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportTimeoutIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportTimeout(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportTimeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportTargetPlanIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportTargetPlan(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportTargetPlan()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContainerRegistryImportCreatedBeforeIsNullable() {
        final GitLabApplicationSettingContainerBuilder builder = GitLabApplicationSettingContainerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingContainer())
                .containerRegistryImportCreatedBefore(null);

        final GitLabApplicationSettingContainer built = builder.build();

        assertThat(built.containerRegistryImportCreatedBefore()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingContainer value = SettingsCatalogFixtures.applicationSettingContainer();

        assertSoftly(softly -> {
            softly.assertThat(value.containerExpirationPoliciesEnableHistoricEntries())
                    .isEqualTo("container_expiration_policies_enable_historic_entries");
            softly.assertThat(value.containerRegistryExpirationPoliciesCaching())
                    .isEqualTo("container_registry_expiration_policies_caching");
            softly.assertThat(value.containerRegistryTokenExpireDelay())
                    .isEqualTo("container_registry_token_expire_delay");
            softly.assertThat(value.containerRegistryDeleteTagsServiceTimeout())
                    .isEqualTo("container_registry_delete_tags_service_timeout");
            softly.assertThat(value.containerRegistryExpirationPoliciesWorkerCapacity())
                    .isEqualTo("container_registry_expiration_policies_worker_capacity");
            softly.assertThat(value.containerRegistryCleanupTagsServiceMaxListSize())
                    .isEqualTo("container_registry_cleanup_tags_service_max_list_size");
            softly.assertThat(value.containerRegistryImportMaxTagsCount())
                    .isEqualTo("container_registry_import_max_tags_count");
            softly.assertThat(value.containerRegistryImportMaxRetries())
                    .isEqualTo("container_registry_import_max_retries");
            softly.assertThat(value.containerRegistryImportStartMaxRetries())
                    .isEqualTo("container_registry_import_start_max_retries");
            softly.assertThat(value.containerRegistryImportMaxStepDuration())
                    .isEqualTo("container_registry_import_max_step_duration");
            softly.assertThat(value.containerRegistryPreImportTagsRate())
                    .isEqualTo("container_registry_pre_import_tags_rate");
            softly.assertThat(value.containerRegistryPreImportTimeout())
                    .isEqualTo("container_registry_pre_import_timeout");
            softly.assertThat(value.containerRegistryImportTimeout()).isEqualTo("container_registry_import_timeout");
            softly.assertThat(value.containerRegistryImportTargetPlan())
                    .isEqualTo("container_registry_import_target_plan");
            softly.assertThat(value.containerRegistryImportCreatedBefore())
                    .isEqualTo("container_registry_import_created_before");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingContainer original = SettingsCatalogFixtures.applicationSettingContainer();

        final GitLabApplicationSettingContainer rebuilt =
                GitLabApplicationSettingContainerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenContainerRegistryTokenExpireDelayIsACredential() {
        final GitLabApplicationSettingContainer value = SettingsCatalogFixtures.applicationSettingContainer();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingContainer.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "containerExpirationPoliciesEnableHistoricEntries",
                        "containerRegistryExpirationPoliciesCaching",
                        "containerRegistryTokenExpireDelay",
                        "containerRegistryDeleteTagsServiceTimeout",
                        "containerRegistryExpirationPoliciesWorkerCapacity",
                        "containerRegistryCleanupTagsServiceMaxListSize",
                        "containerRegistryImportMaxTagsCount",
                        "containerRegistryImportMaxRetries",
                        "containerRegistryImportStartMaxRetries",
                        "containerRegistryImportMaxStepDuration",
                        "containerRegistryPreImportTagsRate",
                        "containerRegistryPreImportTimeout",
                        "containerRegistryImportTimeout",
                        "containerRegistryImportTargetPlan",
                        "containerRegistryImportCreatedBefore");
    }
}
