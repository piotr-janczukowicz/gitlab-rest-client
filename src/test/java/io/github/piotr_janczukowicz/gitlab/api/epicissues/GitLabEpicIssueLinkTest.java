package io.github.piotr_janczukowicz.gitlab.api.epicissues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicIssueLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabEpicIssueLinkBuilder builder = GitLabEpicIssueLinkBuilder.builder(
                        EpicissuesCatalogFixtures.epicIssueLink())
                .id(null);

        final GitLabEpicIssueLink built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelativePositionIsNullable() {
        final GitLabEpicIssueLinkBuilder builder = GitLabEpicIssueLinkBuilder.builder(
                        EpicissuesCatalogFixtures.epicIssueLink())
                .relativePosition(null);

        final GitLabEpicIssueLink built = builder.build();

        assertThat(built.relativePosition()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIsNullable() {
        final GitLabEpicIssueLinkBuilder builder = GitLabEpicIssueLinkBuilder.builder(
                        EpicissuesCatalogFixtures.epicIssueLink())
                .epic(null);

        final GitLabEpicIssueLink built = builder.build();

        assertThat(built.epic()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueIsNullable() {
        final GitLabEpicIssueLinkBuilder builder = GitLabEpicIssueLinkBuilder.builder(
                        EpicissuesCatalogFixtures.epicIssueLink())
                .issue(null);

        final GitLabEpicIssueLink built = builder.build();

        assertThat(built.issue()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicIssueLink value = EpicissuesCatalogFixtures.epicIssueLink();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.relativePosition()).isEqualTo(1);
            softly.assertThat(value.epic()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.issue()).isEqualTo(CommonCatalogFixtures.issueBasic());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicIssueLink original = EpicissuesCatalogFixtures.epicIssueLink();

        final GitLabEpicIssueLink rebuilt =
                GitLabEpicIssueLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicIssueLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "relativePosition", "epic", "issue");
    }
}
