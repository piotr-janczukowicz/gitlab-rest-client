package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestImageTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestImageBuilder builder = GitLabCiJobRequestImageBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestImage())
                .name(null);

        final GitLabCiJobRequestImage built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntrypointIsNullable() {
        final GitLabCiJobRequestImageBuilder builder = GitLabCiJobRequestImageBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestImage())
                .entrypoint(null);

        final GitLabCiJobRequestImage built = builder.build();

        assertThat(built.entrypoint()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPortsIsNullable() {
        final GitLabCiJobRequestImageBuilder builder = GitLabCiJobRequestImageBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestImage())
                .ports(null);

        final GitLabCiJobRequestImage built = builder.build();

        assertThat(built.ports()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExecutorOptsIsNullable() {
        final GitLabCiJobRequestImageBuilder builder = GitLabCiJobRequestImageBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestImage())
                .executorOpts(null);

        final GitLabCiJobRequestImage built = builder.build();

        assertThat(built.executorOpts()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPullPolicyIsNullable() {
        final GitLabCiJobRequestImageBuilder builder = GitLabCiJobRequestImageBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestImage())
                .pullPolicy(null);

        final GitLabCiJobRequestImage built = builder.build();

        assertThat(built.pullPolicy()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestImage value = JobsCatalogFixtures.ciJobRequestImage();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.entrypoint()).isEqualTo("entrypoint");
            softly.assertThat(value.ports()).isEqualTo(List.of(JobsCatalogFixtures.ciJobRequestPort()));
            softly.assertThat(value.executorOpts()).isEqualTo("executor_opts");
            softly.assertThat(value.pullPolicy()).isEqualTo("pull_policy");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestImage original = JobsCatalogFixtures.ciJobRequestImage();

        final GitLabCiJobRequestImage rebuilt =
                GitLabCiJobRequestImageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestImage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "entrypoint", "ports", "executorOpts", "pullPolicy");
    }
}
