package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUsersCreateImpersonationTokenGranularScopeAccessTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUsersCreateImpersonationTokenGranularScopeAccess.values())
                .map(GitLabUsersCreateImpersonationTokenGranularScopeAccess::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly("personal_projects", "all_memberships", "selected_memberships", "user", "instance");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUsersCreateImpersonationTokenGranularScopeAccess.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabUsersCreateImpersonationTokenGranularScopeAccess constant) {
        final GitLabUsersCreateImpersonationTokenGranularScopeAccess decoded =
                GitLabUsersCreateImpersonationTokenGranularScopeAccess.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabUsersCreateImpersonationTokenGranularScopeAccess.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabUsersCreateImpersonationTokenGranularScopeAccess.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
