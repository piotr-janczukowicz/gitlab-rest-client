package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenBodyIsNullable() {
        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadBuilder builder =
                GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload())
                        .body(null);

        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload built = builder.build();

        assertThat(built.body()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadBuilder builder =
                GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload())
                        .resolved(null);

        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload value =
                DiscussionsCatalogFixtures.projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.body()).isEqualTo("body");
            softly.assertThat(value.resolved()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload original =
                DiscussionsCatalogFixtures.projectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload();

        final GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload rebuilt =
                GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsUpdateRepositoryCommitsDiscussionsNotePayload.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("body", "resolved");
    }
}
