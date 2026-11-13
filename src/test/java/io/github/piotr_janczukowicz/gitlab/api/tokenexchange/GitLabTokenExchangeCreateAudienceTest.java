package io.github.piotr_janczukowicz.gitlab.api.tokenexchange;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabTokenExchangeCreateAudienceTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabTokenExchangeCreateAudience.values())
                .map(GitLabTokenExchangeCreateAudience::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("gitlab-artifact-registry", "gitlab-autoflow");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabTokenExchangeCreateAudience.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabTokenExchangeCreateAudience constant) {
        final GitLabTokenExchangeCreateAudience decoded =
                GitLabTokenExchangeCreateAudience.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabTokenExchangeCreateAudience.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabTokenExchangeCreateAudience.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
