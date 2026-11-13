package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceIssuesCallIssuesStatisticsScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceIssuesCallIssuesStatisticsScope.values())
                .map(GitLabInstanceIssuesCallIssuesStatisticsScope::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("created_by_me", "assigned_to_me", "all");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceIssuesCallIssuesStatisticsScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceIssuesCallIssuesStatisticsScope constant) {
        final GitLabInstanceIssuesCallIssuesStatisticsScope decoded =
                GitLabInstanceIssuesCallIssuesStatisticsScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceIssuesCallIssuesStatisticsScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabInstanceIssuesCallIssuesStatisticsScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
