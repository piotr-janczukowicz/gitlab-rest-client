package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectCommitDiscussionCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectCommitDiscussionCreatePayloadBuilder builder =
                GitLabProjectCommitDiscussionCreatePayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload())
                        .body(null);

        final GitLabProjectCommitDiscussionCreatePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectCommitDiscussionCreatePayloadBuilder builder =
                GitLabProjectCommitDiscussionCreatePayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload())
                        .createdAt(null);

        final GitLabProjectCommitDiscussionCreatePayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabProjectCommitDiscussionCreatePayloadBuilder builder =
                GitLabProjectCommitDiscussionCreatePayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload())
                        .position(null);

        final GitLabProjectCommitDiscussionCreatePayload built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectCommitDiscussionCreatePayload value =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.position())
                    .isEqualTo(DiscussionsCatalogFixtures.projectCommitDiscussionCreatePosition());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectCommitDiscussionCreatePayload original =
                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload();

        final GitLabProjectCommitDiscussionCreatePayload rebuilt =
                GitLabProjectCommitDiscussionCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectCommitDiscussionCreatePayloadBuilder builder =
                GitLabProjectCommitDiscussionCreatePayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectCommitDiscussionCreatePayload())
                        .createdAt(instant);

        final GitLabProjectCommitDiscussionCreatePayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectCommitDiscussionCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt", "position");
    }
}
