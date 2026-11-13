package io.github.piotr_janczukowicz.gitlab.api.draftnotes;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDraftNotesCreatePositionLineRangeTest {

    @Test
    void constructor_shouldAcceptNull_whenStartIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRange())
                        .start(null);

        final GitLabProjectDraftNotesCreatePositionLineRange built = builder.build();

        assertThat(built.start()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndIsNullable() {
        final GitLabProjectDraftNotesCreatePositionLineRangeBuilder builder =
                GitLabProjectDraftNotesCreatePositionLineRangeBuilder.builder(
                                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRange())
                        .end(null);

        final GitLabProjectDraftNotesCreatePositionLineRange built = builder.build();

        assertThat(built.end()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDraftNotesCreatePositionLineRange value =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRange();

        assertSoftly(softly -> {
            softly.assertThat(value.start())
                    .isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeStart());
            softly.assertThat(value.end())
                    .isEqualTo(DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRangeEnd());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDraftNotesCreatePositionLineRange original =
                DraftnotesCatalogFixtures.projectDraftNotesCreatePositionLineRange();

        final GitLabProjectDraftNotesCreatePositionLineRange rebuilt =
                GitLabProjectDraftNotesCreatePositionLineRangeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectDraftNotesCreatePositionLineRange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("start", "end");
    }
}
