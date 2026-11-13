package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceFeatureFlagsCreateKeyTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceFeatureFlagsCreateKey.values())
                .map(GitLabInstanceFeatureFlagsCreateKey::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("percentage_of_actors", "percentage_of_time");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceFeatureFlagsCreateKey.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabInstanceFeatureFlagsCreateKey constant) {
        final GitLabInstanceFeatureFlagsCreateKey decoded =
                GitLabInstanceFeatureFlagsCreateKey.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceFeatureFlagsCreateKey.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceFeatureFlagsCreateKey.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
