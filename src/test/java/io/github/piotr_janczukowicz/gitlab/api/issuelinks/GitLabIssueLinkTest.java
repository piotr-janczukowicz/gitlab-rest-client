package io.github.piotr_janczukowicz.gitlab.api.issuelinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIssueLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIssueLinkBuilder builder = GitLabIssueLinkBuilder.builder(IssuelinksCatalogFixtures.issueLink())
                .id(null);

        final GitLabIssueLink built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIssueIsNullable() {
        final GitLabIssueLinkBuilder builder = GitLabIssueLinkBuilder.builder(IssuelinksCatalogFixtures.issueLink())
                .sourceIssue(null);

        final GitLabIssueLink built = builder.build();

        assertThat(built.sourceIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTargetIssueIsNullable() {
        final GitLabIssueLinkBuilder builder = GitLabIssueLinkBuilder.builder(IssuelinksCatalogFixtures.issueLink())
                .targetIssue(null);

        final GitLabIssueLink built = builder.build();

        assertThat(built.targetIssue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabIssueLinkBuilder builder = GitLabIssueLinkBuilder.builder(IssuelinksCatalogFixtures.issueLink())
                .linkType(null);

        final GitLabIssueLink built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssueLink value = IssuelinksCatalogFixtures.issueLink();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.sourceIssue()).isEqualTo(CommonCatalogFixtures.issueBasic());
            softly.assertThat(value.targetIssue()).isEqualTo(CommonCatalogFixtures.issueBasic());
            softly.assertThat(value.linkType()).isEqualTo("relates_to");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIssueLink original = IssuelinksCatalogFixtures.issueLink();

        final GitLabIssueLink rebuilt = GitLabIssueLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssueLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "sourceIssue", "targetIssue", "linkType");
    }
}
