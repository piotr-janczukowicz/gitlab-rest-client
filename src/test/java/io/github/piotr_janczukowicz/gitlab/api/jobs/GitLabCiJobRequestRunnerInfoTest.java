package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestRunnerInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenUuidIsNullable() {
        final GitLabCiJobRequestRunnerInfoBuilder builder = GitLabCiJobRequestRunnerInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestRunnerInfo())
                .uuid(null);

        final GitLabCiJobRequestRunnerInfo built = builder.build();

        assertThat(built.uuid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeoutIsNullable() {
        final GitLabCiJobRequestRunnerInfoBuilder builder = GitLabCiJobRequestRunnerInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestRunnerInfo())
                .timeout(null);

        final GitLabCiJobRequestRunnerInfo built = builder.build();

        assertThat(built.timeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRunnerSessionUrlIsNullable() {
        final GitLabCiJobRequestRunnerInfoBuilder builder = GitLabCiJobRequestRunnerInfoBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestRunnerInfo())
                .runnerSessionUrl(null);

        final GitLabCiJobRequestRunnerInfo built = builder.build();

        assertThat(built.runnerSessionUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestRunnerInfo value = JobsCatalogFixtures.ciJobRequestRunnerInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.uuid()).isEqualTo("uuid");
            softly.assertThat(value.timeout()).isEqualTo("timeout");
            softly.assertThat(value.runnerSessionUrl()).isEqualTo("runner_session_url");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestRunnerInfo original = JobsCatalogFixtures.ciJobRequestRunnerInfo();

        final GitLabCiJobRequestRunnerInfo rebuilt =
                GitLabCiJobRequestRunnerInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestRunnerInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("uuid", "timeout", "runnerSessionUrl");
    }
}
