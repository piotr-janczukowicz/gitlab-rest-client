package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDiscussionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabDiscussionBuilder builder = GitLabDiscussionBuilder.builder(DiscussionsCatalogFixtures.discussion())
                .id(null);

        final GitLabDiscussion built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIndividualNoteIsNullable() {
        final GitLabDiscussionBuilder builder = GitLabDiscussionBuilder.builder(DiscussionsCatalogFixtures.discussion())
                .individualNote(null);

        final GitLabDiscussion built = builder.build();

        assertThat(built.individualNote()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvableIsNullable() {
        final GitLabDiscussionBuilder builder = GitLabDiscussionBuilder.builder(DiscussionsCatalogFixtures.discussion())
                .resolvable(null);

        final GitLabDiscussion built = builder.build();

        assertThat(built.resolvable()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenResolvedIsNullable() {
        final GitLabDiscussionBuilder builder = GitLabDiscussionBuilder.builder(DiscussionsCatalogFixtures.discussion())
                .resolved(null);

        final GitLabDiscussion built = builder.build();

        assertThat(built.resolved()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotesIsNullable() {
        final GitLabDiscussionBuilder builder = GitLabDiscussionBuilder.builder(DiscussionsCatalogFixtures.discussion())
                .notes(null);

        final GitLabDiscussion built = builder.build();

        assertThat(built.notes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDiscussion value = DiscussionsCatalogFixtures.discussion();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("6a9c1750b37d513a43987b574953fceb50b03ce7");
            softly.assertThat(value.individualNote()).isEqualTo(true);
            softly.assertThat(value.resolvable()).isEqualTo(true);
            softly.assertThat(value.resolved()).isEqualTo(true);
            softly.assertThat(value.notes()).isEqualTo(List.of(CommonCatalogFixtures.note()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDiscussion original = DiscussionsCatalogFixtures.discussion();

        final GitLabDiscussion rebuilt =
                GitLabDiscussionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDiscussion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "individualNote", "resolvable", "resolved", "notes");
    }
}
