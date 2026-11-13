package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupNotesUpdateDiscussionsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabGroupNotesUpdateDiscussionsNotesPayloadBuilder builder =
                GitLabGroupNotesUpdateDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload())
                        .body(null);

        final GitLabGroupNotesUpdateDiscussionsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabGroupNotesUpdateDiscussionsNotesPayloadBuilder builder =
                GitLabGroupNotesUpdateDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload())
                        .resolved(null);

        final GitLabGroupNotesUpdateDiscussionsNotesPayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupNotesUpdateDiscussionsNotesPayload value =
                NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.resolved()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupNotesUpdateDiscussionsNotesPayload original =
                NotesCatalogFixtures.groupNotesUpdateDiscussionsNotesPayload();

        final GitLabGroupNotesUpdateDiscussionsNotesPayload rebuilt =
                GitLabGroupNotesUpdateDiscussionsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupNotesUpdateDiscussionsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "resolved");
    }
}
