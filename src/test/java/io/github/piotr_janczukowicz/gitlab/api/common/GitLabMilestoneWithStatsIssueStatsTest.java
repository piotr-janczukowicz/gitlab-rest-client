package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMilestoneWithStatsIssueStatsTest {

    @Test
    void constructor_shouldAcceptNull_whenTotalIsNullable() {
        final GitLabMilestoneWithStatsIssueStatsBuilder builder = GitLabMilestoneWithStatsIssueStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStatsIssueStats())
                .total(null);

        final GitLabMilestoneWithStatsIssueStats built = builder.build();

        assertThat(built.total()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenClosedIsNullable() {
        final GitLabMilestoneWithStatsIssueStatsBuilder builder = GitLabMilestoneWithStatsIssueStatsBuilder.builder(
                        CommonCatalogFixtures.milestoneWithStatsIssueStats())
                .closed(null);

        final GitLabMilestoneWithStatsIssueStats built = builder.build();

        assertThat(built.closed()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMilestoneWithStatsIssueStats value = CommonCatalogFixtures.milestoneWithStatsIssueStats();

        assertSoftly(softly -> {
            softly.assertThat(value.total()).isEqualTo(1);
            softly.assertThat(value.closed()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMilestoneWithStatsIssueStats original = CommonCatalogFixtures.milestoneWithStatsIssueStats();

        final GitLabMilestoneWithStatsIssueStats rebuilt =
                GitLabMilestoneWithStatsIssueStatsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMilestoneWithStatsIssueStats.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("total", "closed");
    }
}
