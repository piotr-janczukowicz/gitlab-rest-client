package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupWebhooksCreateBranchFilterStrategyTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupWebhooksCreateBranchFilterStrategy.values())
                .map(GitLabGroupGroupWebhooksCreateBranchFilterStrategy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("wildcard", "regex", "all_branches");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupWebhooksCreateBranchFilterStrategy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupWebhooksCreateBranchFilterStrategy constant) {
        final GitLabGroupGroupWebhooksCreateBranchFilterStrategy decoded =
                GitLabGroupGroupWebhooksCreateBranchFilterStrategy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupWebhooksCreateBranchFilterStrategy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupWebhooksCreateBranchFilterStrategy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
