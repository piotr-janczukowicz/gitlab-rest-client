package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload())
                        .body(null);

        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload())
                        .createdAt(null);

        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload();

        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload rebuilt =
                GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder builder =
                GitLabProjectDiscussionsCreateSnippetsDiscussionsPayloadBuilder.builder(
                                DiscussionsCatalogFixtures.projectDiscussionsCreateSnippetsDiscussionsPayload())
                        .createdAt(instant);

        final GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateSnippetsDiscussionsPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt");
    }
}
