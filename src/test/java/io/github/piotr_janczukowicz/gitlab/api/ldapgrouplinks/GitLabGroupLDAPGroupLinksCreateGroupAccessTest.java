package io.github.piotr_janczukowicz.gitlab.api.ldapgrouplinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupLDAPGroupLinksCreateGroupAccessTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final int[] wires = Arrays.stream(GitLabGroupLDAPGroupLinksCreateGroupAccess.values())
                .mapToInt(GitLabGroupLDAPGroupLinksCreateGroupAccess::wireValue)
                .toArray();

        assertThat(wires).containsExactly(5, 10, 15, 20, 25, 30, 40, 50);
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupLDAPGroupLinksCreateGroupAccess.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupLDAPGroupLinksCreateGroupAccess constant) {
        final GitLabGroupLDAPGroupLinksCreateGroupAccess decoded =
                GitLabGroupLDAPGroupLinksCreateGroupAccess.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabGroupLDAPGroupLinksCreateGroupAccess.fromWire(-12345));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
