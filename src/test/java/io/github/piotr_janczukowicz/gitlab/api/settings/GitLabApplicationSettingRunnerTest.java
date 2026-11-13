package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationSettingRunnerTest {

    @Test
    void constructor_shouldAcceptNull_whenRunnerTokenExpirationIntervalIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerTokenExpirationInterval(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobListCompletedStatusesLimitPerUserIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerJobListCompletedStatusesLimitPerUser(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerJobListCompletedStatusesLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobListProjectFilteredLimitPerUserIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerJobListProjectFilteredLimitPerUser(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerJobListProjectFilteredLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerManagerListLimitPerUserIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerManagerListLimitPerUser(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerManagerListLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobsRequestApiLimitIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerJobsRequestApiLimit(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerJobsRequestApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobsPatchTraceApiLimitIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerJobsPatchTraceApiLimit(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerJobsPatchTraceApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobsEndpointsApiLimitIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerJobsEndpointsApiLimit(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerJobsEndpointsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerManagerCreationLimitIsNullable() {
        final GitLabApplicationSettingRunnerBuilder builder = GitLabApplicationSettingRunnerBuilder.builder(
                        SettingsCatalogFixtures.applicationSettingRunner())
                .runnerManagerCreationLimit(null);

        final GitLabApplicationSettingRunner built = builder.build();

        assertThat(built.runnerManagerCreationLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationSettingRunner value = SettingsCatalogFixtures.applicationSettingRunner();

        assertSoftly(softly -> {
            softly.assertThat(value.runnerTokenExpirationInterval()).isEqualTo("runner_token_expiration_interval");
            softly.assertThat(value.runnerJobListCompletedStatusesLimitPerUser())
                    .isEqualTo("runner_job_list_completed_statuses_limit_per_user");
            softly.assertThat(value.runnerJobListProjectFilteredLimitPerUser())
                    .isEqualTo("runner_job_list_project_filtered_limit_per_user");
            softly.assertThat(value.runnerManagerListLimitPerUser()).isEqualTo("runner_manager_list_limit_per_user");
            softly.assertThat(value.runnerJobsRequestApiLimit()).isEqualTo("runner_jobs_request_api_limit");
            softly.assertThat(value.runnerJobsPatchTraceApiLimit()).isEqualTo("runner_jobs_patch_trace_api_limit");
            softly.assertThat(value.runnerJobsEndpointsApiLimit()).isEqualTo("runner_jobs_endpoints_api_limit");
            softly.assertThat(value.runnerManagerCreationLimit()).isEqualTo("runner_manager_creation_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationSettingRunner original = SettingsCatalogFixtures.applicationSettingRunner();

        final GitLabApplicationSettingRunner rebuilt =
                GitLabApplicationSettingRunnerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenRunnerTokenExpirationIntervalIsACredential() {
        final GitLabApplicationSettingRunner value = SettingsCatalogFixtures.applicationSettingRunner();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationSettingRunner.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "runnerTokenExpirationInterval",
                        "runnerJobListCompletedStatusesLimitPerUser",
                        "runnerJobListProjectFilteredLimitPerUser",
                        "runnerManagerListLimitPerUser",
                        "runnerJobsRequestApiLimit",
                        "runnerJobsPatchTraceApiLimit",
                        "runnerJobsEndpointsApiLimit",
                        "runnerManagerCreationLimit");
    }
}
