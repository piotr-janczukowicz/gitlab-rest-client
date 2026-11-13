package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload())
                        .body(null);

        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload())
                        .resolved(null);

        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload value =
                NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.resolved()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload original =
                NotesCatalogFixtures.projectNotesUpdateSnippetsDiscussionsNotesPayload();

        final GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload rebuilt =
                GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectNotesUpdateSnippetsDiscussionsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "resolved");
    }
}
