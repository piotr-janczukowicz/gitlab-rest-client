package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload())
                        .body(null);

        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload())
                        .createdAt(null);

        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload value =
                NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload original =
                NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload();

        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload rebuilt =
                GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateSnippetsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateSnippetsDiscussionsNotesPayload())
                        .createdAt(instant);

        final GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectNotesCreateSnippetsDiscussionsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "createdAt");
    }
}
