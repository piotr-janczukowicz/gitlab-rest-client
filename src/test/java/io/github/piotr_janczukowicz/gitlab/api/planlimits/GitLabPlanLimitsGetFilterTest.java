package io.github.piotr_janczukowicz.gitlab.api.planlimits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPlanLimitsGetFilterTest {

    @Test
    void constructor_shouldAcceptNull_whenPlanNameIsNullable() {
        final GitLabPlanLimitsGetFilterBuilder builder = GitLabPlanLimitsGetFilterBuilder.builder(
                        GitLabPlanLimitsGetFilterBuilder.builder()
                                .planName(GitLabPlanLimitsGetPlanName.DEFAULT)
                                .build())
                .planName(null);

        final GitLabPlanLimitsGetFilter built = builder.build();

        assertThat(built.planName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPlanLimitsGetFilter value = GitLabPlanLimitsGetFilterBuilder.builder()
                .planName(GitLabPlanLimitsGetPlanName.DEFAULT)
                .build();

        assertThat(value.planName()).isEqualTo(GitLabPlanLimitsGetPlanName.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPlanLimitsGetFilter original = GitLabPlanLimitsGetFilterBuilder.builder()
                .planName(GitLabPlanLimitsGetPlanName.DEFAULT)
                .build();

        final GitLabPlanLimitsGetFilter rebuilt =
                GitLabPlanLimitsGetFilterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPlanLimitsGetFilter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("planName");
    }

    @Test
    void empty_shouldHaveNoParameters() {
        final GitLabPlanLimitsGetFilter empty = GitLabPlanLimitsGetFilter.empty();

        final Map<String, String> query = empty.toQueryParameters();

        assertThat(query).isEmpty();
    }

    @Test
    void toQueryParameters_shouldHoldEveryGivenParameterUnderItsWireName() {
        final GitLabPlanLimitsGetFilter filter = GitLabPlanLimitsGetFilterBuilder.builder()
                .planName(GitLabPlanLimitsGetPlanName.DEFAULT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("plan_name", "default"));
    }

    @Test
    void toQueryParameters_shouldSkipNull_whenOnlyOneParameterIsSet() {
        final GitLabPlanLimitsGetFilter filter = GitLabPlanLimitsGetFilterBuilder.builder()
                .planName(GitLabPlanLimitsGetPlanName.DEFAULT)
                .build();

        final Map<String, String> query = filter.toQueryParameters();

        assertThat(query).containsExactly(Map.entry("plan_name", "default"));
    }

    @Test
    void toQueryParameters_shouldBeUnmodifiable_whenRead() {
        final GitLabPlanLimitsGetFilter filter = GitLabPlanLimitsGetFilterBuilder.builder()
                .planName(GitLabPlanLimitsGetPlanName.DEFAULT)
                .build();
        final Map<String, String> query = filter.toQueryParameters();

        final Throwable thrown = catchThrowable(() -> query.put("extra", "value"));

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }
}
