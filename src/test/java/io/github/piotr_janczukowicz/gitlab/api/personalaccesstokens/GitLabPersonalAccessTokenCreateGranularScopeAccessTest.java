package io.github.piotr_janczukowicz.gitlab.api.personalaccesstokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabPersonalAccessTokenCreateGranularScopeAccessTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabPersonalAccessTokenCreateGranularScopeAccess.values())
                .map(GitLabPersonalAccessTokenCreateGranularScopeAccess::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly("personal_projects", "all_memberships", "selected_memberships", "user", "instance");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabPersonalAccessTokenCreateGranularScopeAccess.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabPersonalAccessTokenCreateGranularScopeAccess constant) {
        final GitLabPersonalAccessTokenCreateGranularScopeAccess decoded =
                GitLabPersonalAccessTokenCreateGranularScopeAccess.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabPersonalAccessTokenCreateGranularScopeAccess.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabPersonalAccessTokenCreateGranularScopeAccess.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
