package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAdvancedSearchRolloutUpdateRolloutPayloadTest {

    @Test
    void constructor_shouldRefuse_whenPercentageIsBelowTheMinimum() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload())
                        .percentage(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPercentageIsTheMinimum() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload())
                        .percentage(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenPercentageIsAboveTheMaximum() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload())
                        .percentage(101);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPercentageIsTheMaximum() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload())
                        .percentage(100);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPlanIsNull() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload())
                        .plan(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("plan");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayload value =
                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.percentage()).isEqualTo(1);
            softly.assertThat(value.plan()).isEqualTo(GitLabAdvancedSearchRolloutUpdateRolloutPlan.BRONZE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAdvancedSearchRolloutUpdateRolloutPayload original =
                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRolloutPayload();

        final GitLabAdvancedSearchRolloutUpdateRolloutPayload rebuilt =
                GitLabAdvancedSearchRolloutUpdateRolloutPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabAdvancedSearchRolloutUpdateRolloutPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("percentage", "plan");
    }
}
