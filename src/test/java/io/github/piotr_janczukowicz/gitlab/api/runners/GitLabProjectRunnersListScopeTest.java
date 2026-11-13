package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectRunnersListScopeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectRunnersListScope.values())
                .map(GitLabProjectRunnersListScope::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "specific",
                        "shared",
                        "instance_type",
                        "group_type",
                        "project_type",
                        "active",
                        "paused",
                        "online",
                        "offline",
                        "never_contacted",
                        "stale");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectRunnersListScope.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabProjectRunnersListScope constant) {
        final GitLabProjectRunnersListScope decoded = GitLabProjectRunnersListScope.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectRunnersListScope.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectRunnersListScope.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
