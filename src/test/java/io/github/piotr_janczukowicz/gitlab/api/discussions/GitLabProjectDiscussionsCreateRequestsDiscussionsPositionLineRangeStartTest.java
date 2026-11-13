package io.github.piotr_janczukowicz.gitlab.api.discussions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartTest {

    @Test
    void constructor_shouldAcceptNull_whenLineCodeIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart())
                        .lineCode(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart built = builder.build();

        assertThat(built.lineCode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart())
                        .type(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldLineIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart())
                        .oldLine(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart built = builder.build();

        assertThat(built.oldLine()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewLineIsNullable() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder builder =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder.builder(
                                DiscussionsCatalogFixtures
                                        .projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart())
                        .newLine(null);

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart built = builder.build();

        assertThat(built.newLine()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart value =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart();

        assertSoftly(softly -> {
            softly.assertThat(value.lineCode()).isEqualTo("line_code");
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.oldLine()).isEqualTo(1);
            softly.assertThat(value.newLine()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart original =
                DiscussionsCatalogFixtures.projectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart();

        final GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart rebuilt =
                GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStartBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectDiscussionsCreateRequestsDiscussionsPositionLineRangeStart.class
                                .getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("lineCode", "type", "oldLine", "newLine");
    }
}
