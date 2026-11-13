package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateEcdsaKeyRestrictionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabSettingsUpdateEcdsaKeyRestriction.values())
                .mapToInt(GitLabSettingsUpdateEcdsaKeyRestriction::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 256, 384, 521, -1);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateEcdsaKeyRestriction.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateEcdsaKeyRestriction constant) {
        final GitLabSettingsUpdateEcdsaKeyRestriction decoded =
                GitLabSettingsUpdateEcdsaKeyRestriction.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateEcdsaKeyRestriction.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
