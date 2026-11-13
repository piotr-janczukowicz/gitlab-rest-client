package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUsersListMembershipsTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUsersListMembershipsType.values())
                .map(GitLabUsersListMembershipsType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("Project", "Namespace");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUsersListMembershipsType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabUsersListMembershipsType constant) {
        final GitLabUsersListMembershipsType decoded = GitLabUsersListMembershipsType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersListMembershipsType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersListMembershipsType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
