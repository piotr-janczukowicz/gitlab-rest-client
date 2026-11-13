package io.github.piotr_janczukowicz.gitlab.api.usersshandgpgkeys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUserSSHAndGPGKeysCreateUsageTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUserSSHAndGPGKeysCreateUsageType.values())
                .map(GitLabUserSSHAndGPGKeysCreateUsageType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("auth_and_signing", "auth", "signing");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUserSSHAndGPGKeysCreateUsageType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabUserSSHAndGPGKeysCreateUsageType constant) {
        final GitLabUserSSHAndGPGKeysCreateUsageType decoded =
                GitLabUserSSHAndGPGKeysCreateUsageType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabUserSSHAndGPGKeysCreateUsageType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabUserSSHAndGPGKeysCreateUsageType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
