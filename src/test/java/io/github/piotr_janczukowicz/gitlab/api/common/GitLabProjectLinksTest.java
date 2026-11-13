package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .self(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .issues(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.issues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .mergeRequests(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.mergeRequests()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepoBranchesIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .repoBranches(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.repoBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .labels(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .events(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembersIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .members(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.members()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterAgentsIsNullable() {
        final GitLabProjectLinksBuilder builder = GitLabProjectLinksBuilder.builder(
                        CommonCatalogFixtures.projectLinks())
                .clusterAgents(null);

        final GitLabProjectLinks built = builder.build();

        assertThat(built.clusterAgents()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectLinks value = CommonCatalogFixtures.projectLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("https://gitlab.example.com/api/v4/projects/4");
            softly.assertThat(value.issues()).isEqualTo("https://gitlab.example.com/api/v4/projects/4/issues");
            softly.assertThat(value.mergeRequests())
                    .isEqualTo("https://gitlab.example.com/api/v4/projects/4/merge_requests");
            softly.assertThat(value.repoBranches())
                    .isEqualTo("https://gitlab.example.com/api/v4/projects/4/repository/branches");
            softly.assertThat(value.labels()).isEqualTo("https://gitlab.example.com/api/v4/projects/4/labels");
            softly.assertThat(value.events()).isEqualTo("https://gitlab.example.com/api/v4/projects/4/events");
            softly.assertThat(value.members()).isEqualTo("https://gitlab.example.com/api/v4/projects/4/members");
            softly.assertThat(value.clusterAgents())
                    .isEqualTo("https://gitlab.example.com/api/v4/projects/4/cluster_agents");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectLinks original = CommonCatalogFixtures.projectLinks();

        final GitLabProjectLinks rebuilt =
                GitLabProjectLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "self",
                        "issues",
                        "mergeRequests",
                        "repoBranches",
                        "labels",
                        "events",
                        "members",
                        "clusterAgents");
    }
}
