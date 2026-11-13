package io.github.piotr_janczukowicz.gitlab.api.applications;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabApplicationsCreateGranularScopeAccessTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabApplicationsCreateGranularScopeAccess.values())
                .map(GitLabApplicationsCreateGranularScopeAccess::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly("personal_projects", "all_memberships", "selected_memberships", "user", "instance");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabApplicationsCreateGranularScopeAccess.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabApplicationsCreateGranularScopeAccess constant) {
        final GitLabApplicationsCreateGranularScopeAccess decoded =
                GitLabApplicationsCreateGranularScopeAccess.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabApplicationsCreateGranularScopeAccess.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabApplicationsCreateGranularScopeAccess.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
