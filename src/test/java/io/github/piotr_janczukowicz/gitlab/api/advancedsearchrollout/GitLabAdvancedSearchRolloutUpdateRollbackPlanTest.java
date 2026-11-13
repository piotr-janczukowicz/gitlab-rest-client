package io.github.piotr_janczukowicz.gitlab.api.advancedsearchrollout;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabAdvancedSearchRolloutUpdateRollbackPlanTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabAdvancedSearchRolloutUpdateRollbackPlan.values())
                .map(GitLabAdvancedSearchRolloutUpdateRollbackPlan::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "bronze",
                        "silver",
                        "premium",
                        "gold",
                        "ultimate",
                        "ultimate_trial",
                        "ultimate_trial_paid_customer",
                        "premium_trial",
                        "opensource");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabAdvancedSearchRolloutUpdateRollbackPlan.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabAdvancedSearchRolloutUpdateRollbackPlan constant) {
        final GitLabAdvancedSearchRolloutUpdateRollbackPlan decoded =
                GitLabAdvancedSearchRolloutUpdateRollbackPlan.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabAdvancedSearchRolloutUpdateRollbackPlan.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabAdvancedSearchRolloutUpdateRollbackPlan.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
