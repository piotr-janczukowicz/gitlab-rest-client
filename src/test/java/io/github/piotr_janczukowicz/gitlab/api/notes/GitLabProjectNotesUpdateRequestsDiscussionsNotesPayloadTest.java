package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload())
                        .body(null);

        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload())
                        .resolved(null);

        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload value =
                NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.resolved()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload original =
                NotesCatalogFixtures.projectNotesUpdateRequestsDiscussionsNotesPayload();

        final GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload rebuilt =
                GitLabProjectNotesUpdateRequestsDiscussionsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectNotesUpdateRequestsDiscussionsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "resolved");
    }
}
