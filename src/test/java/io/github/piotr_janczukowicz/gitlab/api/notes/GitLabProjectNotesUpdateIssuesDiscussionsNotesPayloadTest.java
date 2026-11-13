package io.github.piotr_janczukowicz.gitlab.api.notes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload())
                        .body(null);

        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadBuilder builder =
                GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadBuilder.builder(
                                NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload())
                        .resolved(null);

        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload value =
                NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.resolved()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload original =
                NotesCatalogFixtures.projectNotesUpdateIssuesDiscussionsNotesPayload();

        final GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload rebuilt =
                GitLabProjectNotesUpdateIssuesDiscussionsNotesPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectNotesUpdateIssuesDiscussionsNotesPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "resolved");
    }
}
