package io.github.piotr_janczukowicz.gitlab.api.orbit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabOrbitContextResponseFormatTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabOrbitContextResponseFormat.values())
                .map(GitLabOrbitContextResponseFormat::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("raw", "llm");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabOrbitContextResponseFormat.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabOrbitContextResponseFormat constant) {
        final GitLabOrbitContextResponseFormat decoded =
                GitLabOrbitContextResponseFormat.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabOrbitContextResponseFormat.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabOrbitContextResponseFormat.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
