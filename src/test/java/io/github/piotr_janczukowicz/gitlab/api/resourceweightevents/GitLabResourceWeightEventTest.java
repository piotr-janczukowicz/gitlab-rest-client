package io.github.piotr_janczukowicz.gitlab.api.resourceweightevents;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabResourceWeightEventTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabResourceWeightEventBuilder builder = GitLabResourceWeightEventBuilder.builder(
                        ResourceweighteventsCatalogFixtures.resourceWeightEvent())
                .id(null);

        final GitLabResourceWeightEvent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserIsNullable() {
        final GitLabResourceWeightEventBuilder builder = GitLabResourceWeightEventBuilder.builder(
                        ResourceweighteventsCatalogFixtures.resourceWeightEvent())
                .user(null);

        final GitLabResourceWeightEvent built = builder.build();

        assertThat(built.user()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabResourceWeightEventBuilder builder = GitLabResourceWeightEventBuilder.builder(
                        ResourceweighteventsCatalogFixtures.resourceWeightEvent())
                .createdAt(null);

        final GitLabResourceWeightEvent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIssueIdIsNullable() {
        final GitLabResourceWeightEventBuilder builder = GitLabResourceWeightEventBuilder.builder(
                        ResourceweighteventsCatalogFixtures.resourceWeightEvent())
                .issueId(null);

        final GitLabResourceWeightEvent built = builder.build();

        assertThat(built.issueId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWeightIsNullable() {
        final GitLabResourceWeightEventBuilder builder = GitLabResourceWeightEventBuilder.builder(
                        ResourceweighteventsCatalogFixtures.resourceWeightEvent())
                .weight(null);

        final GitLabResourceWeightEvent built = builder.build();

        assertThat(built.weight()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabResourceWeightEvent value = ResourceweighteventsCatalogFixtures.resourceWeightEvent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.user()).isEqualTo(CommonCatalogFixtures.userBasic());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.issueId()).isEqualTo(1L);
            softly.assertThat(value.weight()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabResourceWeightEvent original = ResourceweighteventsCatalogFixtures.resourceWeightEvent();

        final GitLabResourceWeightEvent rebuilt =
                GitLabResourceWeightEventBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabResourceWeightEvent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "user", "createdAt", "issueId", "weight");
    }
}
