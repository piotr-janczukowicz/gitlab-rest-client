package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesCreateRequestsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesCreateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload())
                        .body(null);

        final GitLabProjectNotesCreateRequestsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectNotesCreateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload())
                        .confidential(null);

        final GitLabProjectNotesCreateRequestsNotesPayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenInternalIsNullable() {
        final GitLabProjectNotesCreateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload())
                        .internal(null);

        final GitLabProjectNotesCreateRequestsNotesPayload built = builder.build();

        assertThat(built.internal()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectNotesCreateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload())
                        .createdAt(null);

        final GitLabProjectNotesCreateRequestsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestDiffHeadShaIsNullable() {
        final GitLabProjectNotesCreateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload())
                        .mergeRequestDiffHeadSha(null);

        final GitLabProjectNotesCreateRequestsNotesPayload built = builder.build();

        assertThat(built.mergeRequestDiffHeadSha()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesCreateRequestsNotesPayload value =
                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.internal()).isEqualTo(true);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.mergeRequestDiffHeadSha()).isEqualTo("merge_request_diff_head_sha");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesCreateRequestsNotesPayload original =
                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload();

        final GitLabProjectNotesCreateRequestsNotesPayload rebuilt =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabProjectNotesCreateRequestsNotesPayloadBuilder builder =
                GitLabProjectNotesCreateRequestsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesCreateRequestsNotesPayload())
                        .createdAt(instant);

        final GitLabProjectNotesCreateRequestsNotesPayload built = builder.build();

        assertThat(built.createdAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesCreateRequestsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential", "internal", "createdAt", "mergeRequestDiffHeadSha");
    }
}
