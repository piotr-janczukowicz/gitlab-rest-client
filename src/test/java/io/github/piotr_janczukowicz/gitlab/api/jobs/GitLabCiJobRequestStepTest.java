package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestStepTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabCiJobRequestStepBuilder builder = GitLabCiJobRequestStepBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestStep())
                .name(null);

        final GitLabCiJobRequestStep built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScriptIsNullable() {
        final GitLabCiJobRequestStepBuilder builder = GitLabCiJobRequestStepBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestStep())
                .script(null);

        final GitLabCiJobRequestStep built = builder.build();

        assertThat(built.script()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTimeoutIsNullable() {
        final GitLabCiJobRequestStepBuilder builder = GitLabCiJobRequestStepBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestStep())
                .timeout(null);

        final GitLabCiJobRequestStep built = builder.build();

        assertThat(built.timeout()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWhenIsNullable() {
        final GitLabCiJobRequestStepBuilder builder = GitLabCiJobRequestStepBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestStep())
                .when(null);

        final GitLabCiJobRequestStep built = builder.build();

        assertThat(built.when()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAllowFailureIsNullable() {
        final GitLabCiJobRequestStepBuilder builder = GitLabCiJobRequestStepBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestStep())
                .allowFailure(null);

        final GitLabCiJobRequestStep built = builder.build();

        assertThat(built.allowFailure()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestStep value = JobsCatalogFixtures.ciJobRequestStep();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.script()).isEqualTo(List.of("script"));
            softly.assertThat(value.timeout()).isEqualTo(1);
            softly.assertThat(value.when()).isEqualTo("when");
            softly.assertThat(value.allowFailure()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestStep original = JobsCatalogFixtures.ciJobRequestStep();

        final GitLabCiJobRequestStep rebuilt =
                GitLabCiJobRequestStepBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestStep.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "script", "timeout", "when", "allowFailure");
    }
}
