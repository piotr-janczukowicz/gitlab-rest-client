package io.github.piotr_janczukowicz.gitlab.api.issuesstatistics;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupIssuesStatisticsCallScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupIssuesStatisticsCallScope.values())
                .map(GitLabGroupIssuesStatisticsCallScope::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created-by-me", "assigned-to-me", "created_by_me", "assigned_to_me", "all");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupIssuesStatisticsCallScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabGroupIssuesStatisticsCallScope constant) {
        final GitLabGroupIssuesStatisticsCallScope decoded =
                GitLabGroupIssuesStatisticsCallScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesStatisticsCallScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupIssuesStatisticsCallScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
