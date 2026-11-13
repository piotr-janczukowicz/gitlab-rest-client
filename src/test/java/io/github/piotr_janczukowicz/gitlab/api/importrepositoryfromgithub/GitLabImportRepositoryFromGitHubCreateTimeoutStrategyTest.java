package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfromgithub;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabImportRepositoryFromGitHubCreateTimeoutStrategyTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.values())
                .map(GitLabImportRepositoryFromGitHubCreateTimeoutStrategy::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("optimistic", "pessimistic");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabImportRepositoryFromGitHubCreateTimeoutStrategy constant) {
        final GitLabImportRepositoryFromGitHubCreateTimeoutStrategy decoded =
                GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabImportRepositoryFromGitHubCreateTimeoutStrategy.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
