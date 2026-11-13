package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDeploymentsListMergeRequestsSortTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDeploymentsListMergeRequestsSort.values())
                .map(GitLabProjectDeploymentsListMergeRequestsSort::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("asc", "desc");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDeploymentsListMergeRequestsSort.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDeploymentsListMergeRequestsSort constant) {
        final GitLabProjectDeploymentsListMergeRequestsSort decoded =
                GitLabProjectDeploymentsListMergeRequestsSort.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeploymentsListMergeRequestsSort.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDeploymentsListMergeRequestsSort.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
