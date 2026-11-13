package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload())
                        .body(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload())
                        .createdAt(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPositionIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload())
                        .position(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload built = builder.build();

        assertThat(built.position()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.position())
                    .isEqualTo(DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPosition());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload();

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload rebuilt =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPayload())
                        .createdAt(instant);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateRequestsDiscussionsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt", "position");
    }
}
