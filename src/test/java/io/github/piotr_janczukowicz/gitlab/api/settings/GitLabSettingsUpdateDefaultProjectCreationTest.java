package io.github.piotr_janczukowicz.gitlab.api.settings;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabSettingsUpdateDefaultProjectCreationTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabSettingsUpdateDefaultProjectCreation.values())
                .mapToInt(GitLabSettingsUpdateDefaultProjectCreation::wireValue)
                .toArray();

        assertThat(wires).containsExactly(0, 3, 4, 1, 2);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabSettingsUpdateDefaultProjectCreation.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabSettingsUpdateDefaultProjectCreation constant) {
        final GitLabSettingsUpdateDefaultProjectCreation decoded =
                GitLabSettingsUpdateDefaultProjectCreation.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabSettingsUpdateDefaultProjectCreation.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
