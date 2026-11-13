package io.github.piotr_janczukowicz.gitlab.api.featureflags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRoleTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.values())
                .map(GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("no_one_allowed", "developer", "maintainer", "owner");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole constant) {
        final GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole decoded =
                GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(
                () -> GitLabProjectFeatureFlagsUpdateFeatureFlagsSettingMinimumRole.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
