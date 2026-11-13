package io.github.piotr_janczukowicz.gitlab.api.keys;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabKeysCreateUsersKeyUsageTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabKeysCreateUsersKeyUsageType.values())
                .map(GitLabKeysCreateUsersKeyUsageType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("auth_and_signing", "auth", "signing");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabKeysCreateUsersKeyUsageType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabKeysCreateUsersKeyUsageType constant) {
        final GitLabKeysCreateUsersKeyUsageType decoded =
                GitLabKeysCreateUsersKeyUsageType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabKeysCreateUsersKeyUsageType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabKeysCreateUsersKeyUsageType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
