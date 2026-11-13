package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectModelRegistryCallFileStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectModelRegistryCallFileStatus.values())
                .map(GitLabProjectModelRegistryCallFileStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("default", "hidden");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectModelRegistryCallFileStatus.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectModelRegistryCallFileStatus constant) {
        final GitLabProjectModelRegistryCallFileStatus decoded =
                GitLabProjectModelRegistryCallFileStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectModelRegistryCallFileStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectModelRegistryCallFileStatus.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
