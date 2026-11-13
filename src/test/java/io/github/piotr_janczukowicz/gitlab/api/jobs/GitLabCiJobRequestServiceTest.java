package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestServiceTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .name(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntrypointIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .entrypoint(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.entrypoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPortsIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .ports(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.ports()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExecutorOptsIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .executorOpts(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.executorOpts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullPolicyIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .pullPolicy(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.pullPolicy()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAliasIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .alias(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.alias()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCommandIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .command(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.command()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVariablesIsNullable() {
        final GitLabCiJobRequestServiceBuilder builder = GitLabCiJobRequestServiceBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestService())
                .variables(null);

        final GitLabCiJobRequestService built = builder.build();

        assertThat(built.variables()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestService value = JobsCatalogFixtures.ciJobRequestService();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.entrypoint()).isEqualTo("entrypoint");
            softly.assertThat(value.ports()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestPort()));
            softly.assertThat(value.executorOpts()).isEqualTo("executor_opts");
            softly.assertThat(value.pullPolicy()).isEqualTo("pull_policy");
            softly.assertThat(value.alias()).isEqualTo("alias");
            softly.assertThat(value.command()).isEqualTo("command");
            softly.assertThat(value.variables()).isEqualTo("variables");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestService original = JobsCatalogFixtures.ciJobRequestService();

        final GitLabCiJobRequestService rebuilt =
                GitLabCiJobRequestServiceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestService.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name", "entrypoint", "ports", "executorOpts", "pullPolicy", "alias", "command", "variables");
    }
}
