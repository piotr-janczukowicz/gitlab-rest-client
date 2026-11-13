package io.github.piotr_janczukowicz.gitlab.api.organizations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabOrganizationsUpdateUserAccessLevelTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabOrganizationsUpdateUserAccessLevel.values())
                .map(GitLabOrganizationsUpdateUserAccessLevel::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("default", "owner");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabOrganizationsUpdateUserAccessLevel.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabOrganizationsUpdateUserAccessLevel constant) {
        final GitLabOrganizationsUpdateUserAccessLevel decoded =
                GitLabOrganizationsUpdateUserAccessLevel.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabOrganizationsUpdateUserAccessLevel.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabOrganizationsUpdateUserAccessLevel.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
