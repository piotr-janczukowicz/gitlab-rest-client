package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUsersListImpersonationTokensStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUsersListImpersonationTokensState.values())
                .map(GitLabUsersListImpersonationTokensState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("all", "active", "inactive");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUsersListImpersonationTokensState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabUsersListImpersonationTokensState constant) {
        final GitLabUsersListImpersonationTokensState decoded =
                GitLabUsersListImpersonationTokensState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersListImpersonationTokensState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabUsersListImpersonationTokensState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
