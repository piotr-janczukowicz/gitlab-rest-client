package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectEnvironmentsUpdateAutoStopSettingTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectEnvironmentsUpdateAutoStopSetting.values())
                .map(GitLabProjectEnvironmentsUpdateAutoStopSetting::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("always", "with_action");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectEnvironmentsUpdateAutoStopSetting.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectEnvironmentsUpdateAutoStopSetting constant) {
        final GitLabProjectEnvironmentsUpdateAutoStopSetting decoded =
                GitLabProjectEnvironmentsUpdateAutoStopSetting.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEnvironmentsUpdateAutoStopSetting.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectEnvironmentsUpdateAutoStopSetting.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
