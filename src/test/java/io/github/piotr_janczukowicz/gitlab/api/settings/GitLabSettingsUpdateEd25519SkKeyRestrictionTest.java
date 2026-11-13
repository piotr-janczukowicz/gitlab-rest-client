package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateEd25519SkKeyRestrictionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabSettingsUpdateEd25519SkKeyRestriction.values())
                .mapToInt(GitLabSettingsUpdateEd25519SkKeyRestriction::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 256, -1);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateEd25519SkKeyRestriction.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateEd25519SkKeyRestriction constant) {
        final GitLabSettingsUpdateEd25519SkKeyRestriction decoded =
                GitLabSettingsUpdateEd25519SkKeyRestriction.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateEd25519SkKeyRestriction.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
