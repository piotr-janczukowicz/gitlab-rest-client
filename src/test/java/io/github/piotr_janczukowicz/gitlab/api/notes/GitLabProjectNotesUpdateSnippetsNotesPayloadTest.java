package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesUpdateSnippetsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesUpdateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload())
                        .body(null);

        final GitLabProjectNotesUpdateSnippetsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabProjectNotesUpdateSnippetsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateSnippetsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload())
                        .confidential(null);

        final GitLabProjectNotesUpdateSnippetsNotesPayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesUpdateSnippetsNotesPayload value =
                NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesUpdateSnippetsNotesPayload original =
                NotesCatalogFixtures.projectNotesUpdateSnippetsNotesPayload();

        final GitLabProjectNotesUpdateSnippetsNotesPayload rebuilt =
                GitLabProjectNotesUpdateSnippetsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectNotesUpdateSnippetsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "confidential");
    }
}
