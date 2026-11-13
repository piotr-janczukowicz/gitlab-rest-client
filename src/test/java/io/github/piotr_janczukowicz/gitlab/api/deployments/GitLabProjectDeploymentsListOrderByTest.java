package io.github.piotr_janczukowicz.gitlab.api.deployments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectDeploymentsListOrderByTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectDeploymentsListOrderBy.values())
                .map(GitLabProjectDeploymentsListOrderBy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("id", "iid", "created_at", "updated_at", "finished_at");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectDeploymentsListOrderBy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectDeploymentsListOrderBy constant) {
        final GitLabProjectDeploymentsListOrderBy decoded =
                GitLabProjectDeploymentsListOrderBy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeploymentsListOrderBy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectDeploymentsListOrderBy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
