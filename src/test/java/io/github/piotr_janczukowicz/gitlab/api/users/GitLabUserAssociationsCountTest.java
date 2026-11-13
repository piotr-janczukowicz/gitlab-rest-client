package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserAssociationsCountTest {

    @Test
    void constructor_shouldAcceptNull_whenGroupsCountIsNullable() {
        final GitLabUserAssociationsCountBuilder builder = GitLabUserAssociationsCountBuilder.builder(
                        UsersCatalogFixtures.userAssociationsCount())
                .groupsCount(null);

        final GitLabUserAssociationsCount built = builder.build();

        assertThat(built.groupsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectsCountIsNullable() {
        final GitLabUserAssociationsCountBuilder builder = GitLabUserAssociationsCountBuilder.builder(
                        UsersCatalogFixtures.userAssociationsCount())
                .projectsCount(null);

        final GitLabUserAssociationsCount built = builder.build();

        assertThat(built.projectsCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssuesCountIsNullable() {
        final GitLabUserAssociationsCountBuilder builder = GitLabUserAssociationsCountBuilder.builder(
                        UsersCatalogFixtures.userAssociationsCount())
                .issuesCount(null);

        final GitLabUserAssociationsCount built = builder.build();

        assertThat(built.issuesCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMergeRequestsCountIsNullable() {
        final GitLabUserAssociationsCountBuilder builder = GitLabUserAssociationsCountBuilder.builder(
                        UsersCatalogFixtures.userAssociationsCount())
                .mergeRequestsCount(null);

        final GitLabUserAssociationsCount built = builder.build();

        assertThat(built.mergeRequestsCount()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserAssociationsCount value = UsersCatalogFixtures.userAssociationsCount();

        assertSoftly(softly -> {
            softly.assertThat(value.groupsCount()).isEqualTo(1);
            softly.assertThat(value.projectsCount()).isEqualTo(1);
            softly.assertThat(value.issuesCount()).isEqualTo(1);
            softly.assertThat(value.mergeRequestsCount()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserAssociationsCount original = UsersCatalogFixtures.userAssociationsCount();

        final GitLabUserAssociationsCount rebuilt =
                GitLabUserAssociationsCountBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserAssociationsCount.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("groupsCount", "projectsCount", "issuesCount", "mergeRequestsCount");
    }
}
