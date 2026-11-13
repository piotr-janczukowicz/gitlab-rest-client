package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDeploymentsListMergeRequestsViewTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDeploymentsListMergeRequestsView.values())
                .map(GitLabProjectDeploymentsListMergeRequestsView::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("simple");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDeploymentsListMergeRequestsView.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDeploymentsListMergeRequestsView constant) {
        final GitLabProjectDeploymentsListMergeRequestsView decoded =
                GitLabProjectDeploymentsListMergeRequestsView.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeploymentsListMergeRequestsView.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDeploymentsListMergeRequestsView.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
