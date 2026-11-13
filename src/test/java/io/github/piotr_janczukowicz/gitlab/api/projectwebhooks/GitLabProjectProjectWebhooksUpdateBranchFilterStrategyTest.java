package io.github.piotr_janczukowicz.gitlab.api.projectwebhooks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectProjectWebhooksUpdateBranchFilterStrategyTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.values())
                .map(GitLabProjectProjectWebhooksUpdateBranchFilterStrategy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("wildcard", "regex", "all_branches");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectProjectWebhooksUpdateBranchFilterStrategy constant) {
        final GitLabProjectProjectWebhooksUpdateBranchFilterStrategy decoded =
                GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectProjectWebhooksUpdateBranchFilterStrategy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
