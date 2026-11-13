package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDeploymentsListMergeRequestsOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDeploymentsListMergeRequestsOrderBy.values())
                .map(GitLabProjectDeploymentsListMergeRequestsOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "created_at",
                        "label_priority",
                        "milestone_due",
                        "popularity",
                        "priority",
                        "title",
                        "updated_at",
                        "merged_at");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDeploymentsListMergeRequestsOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectDeploymentsListMergeRequestsOrderBy constant) {
        final GitLabProjectDeploymentsListMergeRequestsOrderBy decoded =
                GitLabProjectDeploymentsListMergeRequestsOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeploymentsListMergeRequestsOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectDeploymentsListMergeRequestsOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
