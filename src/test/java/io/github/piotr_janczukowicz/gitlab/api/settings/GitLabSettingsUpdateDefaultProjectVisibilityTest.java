package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateDefaultProjectVisibilityTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabSettingsUpdateDefaultProjectVisibility.values())
                .map(GitLabSettingsUpdateDefaultProjectVisibility::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("private", "internal", "public");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateDefaultProjectVisibility.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateDefaultProjectVisibility constant) {
        final GitLabSettingsUpdateDefaultProjectVisibility decoded =
                GitLabSettingsUpdateDefaultProjectVisibility.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateDefaultProjectVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabSettingsUpdateDefaultProjectVisibility.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
