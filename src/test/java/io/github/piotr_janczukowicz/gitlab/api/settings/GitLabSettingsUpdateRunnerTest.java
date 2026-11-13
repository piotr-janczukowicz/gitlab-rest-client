package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSettingsUpdateRunnerTest {

    @Test
    void constructor_shouldAcceptNull_whenRunnerTokenExpirationIntervalIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerTokenExpirationInterval(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerTokenExpirationInterval()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobListCompletedStatusesLimitPerUserIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerJobListCompletedStatusesLimitPerUser(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerJobListCompletedStatusesLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobListProjectFilteredLimitPerUserIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerJobListProjectFilteredLimitPerUser(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerJobListProjectFilteredLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerManagerListLimitPerUserIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerManagerListLimitPerUser(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerManagerListLimitPerUser()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobsEndpointsApiLimitIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerJobsEndpointsApiLimit(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerJobsEndpointsApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobsPatchTraceApiLimitIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerJobsPatchTraceApiLimit(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerJobsPatchTraceApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerJobsRequestApiLimitIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerJobsRequestApiLimit(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerJobsRequestApiLimit()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerManagerCreationLimitIsNullable() {
        final GitLabSettingsUpdateRunnerBuilder builder = GitLabSettingsUpdateRunnerBuilder.builder(
                        SettingsCatalogFixtures.settingsUpdateRunner())
                .runnerManagerCreationLimit(null);

        final GitLabSettingsUpdateRunner built = builder.build();

        assertThat(built.runnerManagerCreationLimit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSettingsUpdateRunner value = SettingsCatalogFixtures.settingsUpdateRunner();

        assertSoftly(softly -> {
            softly.assertThat(value.runnerTokenExpirationInterval()).isEqualTo(1);
            softly.assertThat(value.runnerJobListCompletedStatusesLimitPerUser())
                    .isEqualTo(1);
            softly.assertThat(value.runnerJobListProjectFilteredLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.runnerManagerListLimitPerUser()).isEqualTo(1);
            softly.assertThat(value.runnerJobsEndpointsApiLimit()).isEqualTo("runner_jobs_endpoints_api_limit");
            softly.assertThat(value.runnerJobsPatchTraceApiLimit()).isEqualTo("runner_jobs_patch_trace_api_limit");
            softly.assertThat(value.runnerJobsRequestApiLimit()).isEqualTo("runner_jobs_request_api_limit");
            softly.assertThat(value.runnerManagerCreationLimit()).isEqualTo("runner_manager_creation_limit");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSettingsUpdateRunner original = SettingsCatalogFixtures.settingsUpdateRunner();

        final GitLabSettingsUpdateRunner rebuilt =
                GitLabSettingsUpdateRunnerBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSettingsUpdateRunner.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "runnerTokenExpirationInterval",
                        "runnerJobListCompletedStatusesLimitPerUser",
                        "runnerJobListProjectFilteredLimitPerUser",
                        "runnerManagerListLimitPerUser",
                        "runnerJobsEndpointsApiLimit",
                        "runnerJobsPatchTraceApiLimit",
                        "runnerJobsRequestApiLimit",
                        "runnerManagerCreationLimit");
    }
}
