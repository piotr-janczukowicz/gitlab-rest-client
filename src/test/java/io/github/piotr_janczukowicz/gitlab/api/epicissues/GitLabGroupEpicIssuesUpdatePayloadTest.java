package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupEpicIssuesUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMoveBeforeIdIsNullable() {
        final GitLabGroupEpicIssuesUpdatePayloadBuilder builder = GitLabGroupEpicIssuesUpdatePayloadBuilder.builder(
                        EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload())
                .moveBeforeId(null);

        final GitLabGroupEpicIssuesUpdatePayload built = builder.build();

        assertThat(built.moveBeforeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMoveAfterIdIsNullable() {
        final GitLabGroupEpicIssuesUpdatePayloadBuilder builder = GitLabGroupEpicIssuesUpdatePayloadBuilder.builder(
                        EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload())
                .moveAfterId(null);

        final GitLabGroupEpicIssuesUpdatePayload built = builder.build();

        assertThat(built.moveAfterId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPageIsNullable() {
        final GitLabGroupEpicIssuesUpdatePayloadBuilder builder = GitLabGroupEpicIssuesUpdatePayloadBuilder.builder(
                        EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload())
                .page(null);

        final GitLabGroupEpicIssuesUpdatePayload built = builder.build();

        assertThat(built.page()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPerPageIsNullable() {
        final GitLabGroupEpicIssuesUpdatePayloadBuilder builder = GitLabGroupEpicIssuesUpdatePayloadBuilder.builder(
                        EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload())
                .perPage(null);

        final GitLabGroupEpicIssuesUpdatePayload built = builder.build();

        assertThat(built.perPage()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupEpicIssuesUpdatePayload value = EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.moveBeforeId()).isEqualTo("text");
            softly.assertThat(value.moveAfterId()).isEqualTo("text");
            softly.assertThat(value.page()).isEqualTo(1);
            softly.assertThat(value.perPage()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupEpicIssuesUpdatePayload original = EpicissuesCatalogFixtures.groupEpicIssuesUpdatePayload();

        final GitLabGroupEpicIssuesUpdatePayload rebuilt =
                GitLabGroupEpicIssuesUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupEpicIssuesUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("moveBeforeId", "moveAfterId", "page", "perPage");
    }
}
