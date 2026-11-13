package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabReleaseLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenClosedIssuesUrlIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .closedIssuesUrl(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.closedIssuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedMergeRequestsUrlIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .closedMergeRequestsUrl(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.closedMergeRequestsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEditUrlIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .editUrl(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.editUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergedMergeRequestsUrlIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .mergedMergeRequestsUrl(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.mergedMergeRequestsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenedIssuesUrlIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .openedIssuesUrl(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.openedIssuesUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOpenedMergeRequestsUrlIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .openedMergeRequestsUrl(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.openedMergeRequestsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabReleaseLinksBuilder builder = GitLabReleaseLinksBuilder.builder(
                        CommonCatalogFixtures.releaseLinks())
                .self(null);

        final GitLabReleaseLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabReleaseLinks value = CommonCatalogFixtures.releaseLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.closedIssuesUrl()).isEqualTo("closed_issues_url");
            softly.assertThat(value.closedMergeRequestsUrl()).isEqualTo("closed_merge_requests_url");
            softly.assertThat(value.editUrl()).isEqualTo("edit_url");
            softly.assertThat(value.mergedMergeRequestsUrl()).isEqualTo("merged_merge_requests_url");
            softly.assertThat(value.openedIssuesUrl()).isEqualTo("opened_issues_url");
            softly.assertThat(value.openedMergeRequestsUrl()).isEqualTo("opened_merge_requests_url");
            softly.assertThat(value.self()).isEqualTo("self");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabReleaseLinks original = CommonCatalogFixtures.releaseLinks();

        final GitLabReleaseLinks rebuilt =
                GitLabReleaseLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabReleaseLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "closedIssuesUrl",
                        "closedMergeRequestsUrl",
                        "editUrl",
                        "mergedMergeRequestsUrl",
                        "openedIssuesUrl",
                        "openedMergeRequestsUrl",
                        "self");
    }
}
