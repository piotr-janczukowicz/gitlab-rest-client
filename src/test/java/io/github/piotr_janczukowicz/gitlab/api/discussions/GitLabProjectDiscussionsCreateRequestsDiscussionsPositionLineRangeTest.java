package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeTest {

    @Test
    void constructor_shouldAcceptNull_whenStartIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRange())
                        .start(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange built = builder.build();

        assertThat(built.start()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEndIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRange())
                        .end(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange built = builder.build();

        assertThat(built.end()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRange();

        assertSoftly(softly -> {
            softly.assertThat(value.start())
                    .isEqualTo(
                            DiscussionsCatalogFixtures
                                    .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart());
            softly.assertThat(value.end())
                    .isEqualTo(
                            DiscussionsCatalogFixtures
                                    .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeEnd());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRange();

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange rebuilt =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRange.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("start", "end");
    }
}
