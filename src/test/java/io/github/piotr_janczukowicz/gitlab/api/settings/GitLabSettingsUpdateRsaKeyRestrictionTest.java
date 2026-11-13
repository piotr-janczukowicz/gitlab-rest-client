package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateRsaKeyRestrictionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabSettingsUpdateRsaKeyRestriction.values())
                .mapToInt(GitLabSettingsUpdateRsaKeyRestriction::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 1024, 2048, 3072, 4096, -1);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateRsaKeyRestriction.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateRsaKeyRestriction constant) {
        final GitLabSettingsUpdateRsaKeyRestriction decoded =
                GitLabSettingsUpdateRsaKeyRestriction.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateRsaKeyRestriction.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
