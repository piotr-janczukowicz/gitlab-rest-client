package io.github.piotr_janczukowicz.gitlab.api.rollouts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCdRolloutTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabCdRolloutBuilder builder = GitLabCdRolloutBuilder.builder(RolloutsCatalogFixtures.cdRollout())
                .id(null);

        final GitLabCdRollout built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIidIsNullable() {
        final GitLabCdRolloutBuilder builder = GitLabCdRolloutBuilder.builder(RolloutsCatalogFixtures.cdRollout())
                .iid(null);

        final GitLabCdRollout built = builder.build();

        assertThat(built.iid()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabCdRolloutBuilder builder = GitLabCdRolloutBuilder.builder(RolloutsCatalogFixtures.cdRollout())
                .state(null);

        final GitLabCdRollout built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWorkflowRefIsNullable() {
        final GitLabCdRolloutBuilder builder = GitLabCdRolloutBuilder.builder(RolloutsCatalogFixtures.cdRollout())
                .workflowRef(null);

        final GitLabCdRollout built = builder.build();

        assertThat(built.workflowRef()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartedAtIsNullable() {
        final GitLabCdRolloutBuilder builder = GitLabCdRolloutBuilder.builder(RolloutsCatalogFixtures.cdRollout())
                .startedAt(null);

        final GitLabCdRollout built = builder.build();

        assertThat(built.startedAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFinishedAtIsNullable() {
        final GitLabCdRolloutBuilder builder = GitLabCdRolloutBuilder.builder(RolloutsCatalogFixtures.cdRollout())
                .finishedAt(null);

        final GitLabCdRollout built = builder.build();

        assertThat(built.finishedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCdRollout value = RolloutsCatalogFixtures.cdRollout();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.iid()).isEqualTo(1L);
            softly.assertThat(value.state()).isEqualTo("in_progress");
            softly.assertThat(value.workflowRef()).isEqualTo("cd-rollout-1");
            softly.assertThat(value.startedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.finishedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCdRollout original = RolloutsCatalogFixtures.cdRollout();

        final GitLabCdRollout rebuilt = GitLabCdRolloutBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCdRollout.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "iid", "state", "workflowRef", "startedAt", "finishedAt");
    }
}
