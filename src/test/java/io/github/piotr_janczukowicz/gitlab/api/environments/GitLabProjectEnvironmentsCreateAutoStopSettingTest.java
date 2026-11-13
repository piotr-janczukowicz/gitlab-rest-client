package io.github.piotr_janczukowicz.gitlab.api.environments;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectEnvironmentsCreateAutoStopSettingTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectEnvironmentsCreateAutoStopSetting.values())
                .map(GitLabProjectEnvironmentsCreateAutoStopSetting::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("always", "with_action");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectEnvironmentsCreateAutoStopSetting.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectEnvironmentsCreateAutoStopSetting constant) {
        final GitLabProjectEnvironmentsCreateAutoStopSetting decoded =
                GitLabProjectEnvironmentsCreateAutoStopSetting.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectEnvironmentsCreateAutoStopSetting.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectEnvironmentsCreateAutoStopSetting.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
