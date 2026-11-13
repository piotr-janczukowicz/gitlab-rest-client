package io.github.piotr_janczukowicz.gitlab.api.groups;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabGroupGroupsCallManagePersonalAccessTokensStateTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabGroupGroupsCallManagePersonalAccessTokensState.values())
                .map(GitLabGroupGroupsCallManagePersonalAccessTokensState::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("all", "active", "inactive");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabGroupGroupsCallManagePersonalAccessTokensState.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabGroupGroupsCallManagePersonalAccessTokensState constant) {
        final GitLabGroupGroupsCallManagePersonalAccessTokensState decoded =
                GitLabGroupGroupsCallManagePersonalAccessTokensState.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsCallManagePersonalAccessTokensState.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabGroupGroupsCallManagePersonalAccessTokensState.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
