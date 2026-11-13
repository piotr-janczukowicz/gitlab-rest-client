package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabEpicLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenSelfIsNullable() {
        final GitLabEpicLinksBuilder builder = GitLabEpicLinksBuilder.builder(CommonCatalogFixtures.epicLinks())
                .self(null);

        final GitLabEpicLinks built = builder.build();

        assertThat(built.self()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEpicIssuesIsNullable() {
        final GitLabEpicLinksBuilder builder = GitLabEpicLinksBuilder.builder(CommonCatalogFixtures.epicLinks())
                .epicIssues(null);

        final GitLabEpicLinks built = builder.build();

        assertThat(built.epicIssues()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabEpicLinksBuilder builder = GitLabEpicLinksBuilder.builder(CommonCatalogFixtures.epicLinks())
                .group(null);

        final GitLabEpicLinks built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIsNullable() {
        final GitLabEpicLinksBuilder builder = GitLabEpicLinksBuilder.builder(CommonCatalogFixtures.epicLinks())
                .parent(null);

        final GitLabEpicLinks built = builder.build();

        assertThat(built.parent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabEpicLinks value = CommonCatalogFixtures.epicLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.self()).isEqualTo("http://gitlab.example.com/api/v4/groups/7/epics/5");
            softly.assertThat(value.epicIssues()).isEqualTo("http://gitlab.example.com/api/v4/groups/7/epics/5/issues");
            softly.assertThat(value.group()).isEqualTo("http://gitlab.example.com/api/v4/groups/7");
            softly.assertThat(value.parent()).isEqualTo("http://gitlab.example.com/api/v4/groups/7/epics/4");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabEpicLinks original = CommonCatalogFixtures.epicLinks();

        final GitLabEpicLinks rebuilt = GitLabEpicLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabEpicLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("self", "epicIssues", "group", "parent");
    }
}
