package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectWithCatalogLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .self(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .issues(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.issues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .mergeRequests(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.mergeRequests()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepoBranchesIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .repoBranches(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.repoBranches()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelsIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .labels(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.labels()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEventsIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .events(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.events()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMembersIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .members(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.members()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClusterAgentsIsNullable() {
        final GitLabProjectWithCatalogLinksBuilder builder = GitLabProjectWithCatalogLinksBuilder.builder(
                        ProjectsCatalogFixtures.projectWithCatalogLinks())
                .clusterAgents(null);

        final GitLabProjectWithCatalogLinks built = builder.build();

        assertThat(built.clusterAgents()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectWithCatalogLinks value = ProjectsCatalogFixtures.projectWithCatalogLinks();

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
        final GitLabProjectWithCatalogLinks original = ProjectsCatalogFixtures.projectWithCatalogLinks();

        final GitLabProjectWithCatalogLinks rebuilt =
                GitLabProjectWithCatalogLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectWithCatalogLinks.class.getRecordComponents())
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
