package io.github.piotr_janczukowicz.gitlab.api.analytics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAnalyticsGroupActivityNewMembersCountTest {

    @Test
    void constructor_shouldAcceptNull_whenNewMembersCountIsNullable() {
        final GitLabAnalyticsGroupActivityNewMembersCountBuilder builder =
                GitLabAnalyticsGroupActivityNewMembersCountBuilder.builder(
                                AnalyticsCatalogFixtures.analyticsGroupActivityNewMembersCount())
                        .newMembersCount(null);

        final GitLabAnalyticsGroupActivityNewMembersCount built = builder.build();

        assertThat(built.newMembersCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTooLargeIsNullable() {
        final GitLabAnalyticsGroupActivityNewMembersCountBuilder builder =
                GitLabAnalyticsGroupActivityNewMembersCountBuilder.builder(
                                AnalyticsCatalogFixtures.analyticsGroupActivityNewMembersCount())
                        .tooLarge(null);

        final GitLabAnalyticsGroupActivityNewMembersCount built = builder.build();

        assertThat(built.tooLarge()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAnalyticsGroupActivityNewMembersCount value =
                AnalyticsCatalogFixtures.analyticsGroupActivityNewMembersCount();

        assertSoftly(softly -> {
            softly.assertThat(value.newMembersCount()).isEqualTo(1);
            softly.assertThat(value.tooLarge()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAnalyticsGroupActivityNewMembersCount original =
                AnalyticsCatalogFixtures.analyticsGroupActivityNewMembersCount();

        final GitLabAnalyticsGroupActivityNewMembersCount rebuilt =
                GitLabAnalyticsGroupActivityNewMembersCountBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAnalyticsGroupActivityNewMembersCount.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("newMembersCount", "tooLarge");
    }
}
