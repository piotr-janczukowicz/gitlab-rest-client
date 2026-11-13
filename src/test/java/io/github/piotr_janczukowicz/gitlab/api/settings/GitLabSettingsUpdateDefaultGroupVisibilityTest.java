package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateDefaultGroupVisibilityTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabSettingsUpdateDefaultGroupVisibility.values())
                .map(GitLabSettingsUpdateDefaultGroupVisibility::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("private", "internal", "public");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateDefaultGroupVisibility.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateDefaultGroupVisibility constant) {
        final GitLabSettingsUpdateDefaultGroupVisibility decoded =
                GitLabSettingsUpdateDefaultGroupVisibility.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateDefaultGroupVisibility.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabSettingsUpdateDefaultGroupVisibility.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
