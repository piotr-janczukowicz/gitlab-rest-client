package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateDefaultBranchProtectionTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabSettingsUpdateDefaultBranchProtection.values())
                .mapToInt(GitLabSettingsUpdateDefaultBranchProtection::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 3, 1, 2, 4);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateDefaultBranchProtection.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateDefaultBranchProtection constant) {
        final GitLabSettingsUpdateDefaultBranchProtection decoded =
                GitLabSettingsUpdateDefaultBranchProtection.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateDefaultBranchProtection.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
