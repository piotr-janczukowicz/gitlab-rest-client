package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabFeatureDefinitionTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .name(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFeatureIssueUrlIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .featureIssueUrl(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.featureIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntroducedByUrlIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .introducedByUrl(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.introducedByUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRolloutIssueUrlIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .rolloutIssueUrl(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.rolloutIssueUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMilestoneIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .milestone(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.milestone()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLogStateChangesIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .logStateChanges(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.logStateChanges()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .type(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGroupIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .group(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.group()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDefaultEnabledIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .defaultEnabled(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.defaultEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIntendedToRolloutByIsNullable() {
        final GitLabFeatureDefinitionBuilder builder = GitLabFeatureDefinitionBuilder.builder(
                        CommonCatalogFixtures.featureDefinition())
                .intendedToRolloutBy(null);

        final GitLabFeatureDefinition built = builder.build();

        assertThat(built.intendedToRolloutBy()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabFeatureDefinition value = CommonCatalogFixtures.featureDefinition();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.featureIssueUrl()).isEqualTo("feature_issue_url");
            softly.assertThat(value.introducedByUrl()).isEqualTo("introduced_by_url");
            softly.assertThat(value.rolloutIssueUrl()).isEqualTo("rollout_issue_url");
            softly.assertThat(value.milestone()).isEqualTo("milestone");
            softly.assertThat(value.logStateChanges()).isEqualTo(true);
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.group()).isEqualTo("group");
            softly.assertThat(value.defaultEnabled()).isEqualTo(true);
            softly.assertThat(value.intendedToRolloutBy()).isEqualTo("intended_to_rollout_by");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabFeatureDefinition original = CommonCatalogFixtures.featureDefinition();

        final GitLabFeatureDefinition rebuilt =
                GitLabFeatureDefinitionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabFeatureDefinition.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "name",
                        "featureIssueUrl",
                        "introducedByUrl",
                        "rolloutIssueUrl",
                        "milestone",
                        "logStateChanges",
                        "type",
                        "group",
                        "defaultEnabled",
                        "intendedToRolloutBy");
    }
}
