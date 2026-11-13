package io.github.piotr_janczukowicz.gitlab.api.groupwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupWebhooksUpdateBranchFilterStrategyTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.values())
                .map(GitLabGroupGroupWebhooksUpdateBranchFilterStrategy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("wildcard", "regex", "all_branches");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupWebhooksUpdateBranchFilterStrategy constant) {
        final GitLabGroupGroupWebhooksUpdateBranchFilterStrategy decoded =
                GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupWebhooksUpdateBranchFilterStrategy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
