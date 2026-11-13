package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAdvancedSearchRolloutUpdateRollbackPayloadTest {

    @Test
    void constructor_shouldRefuse_whenPercentageIsBelowTheMinimum() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload())
                        .percentage(-1);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPercentageIsTheMinimum() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload())
                        .percentage(0);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuse_whenPercentageIsAboveTheMaximum() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload())
                        .percentage(101);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenPercentageIsTheMaximum() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload())
                        .percentage(100);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldRefuseNull_whenPlanIsNull() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder builder =
                GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder(
                                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload())
                        .plan(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("plan");
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayload value =
                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.percentage()).isEqualTo(1);
            softly.assertThat(value.plan()).isEqualTo(GitLabAdvancedSearchRolloutUpdateRollbackPlan.BRONZE);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAdvancedSearchRolloutUpdateRollbackPayload original =
                AdvancedsearchrolloutCatalogFixtures.advancedSearchRolloutUpdateRollbackPayload();

        final GitLabAdvancedSearchRolloutUpdateRollbackPayload rebuilt =
                GitLabAdvancedSearchRolloutUpdateRollbackPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabAdvancedSearchRolloutUpdateRollbackPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("percentage", "plan");
    }
}
