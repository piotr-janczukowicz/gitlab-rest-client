package io.github.piotr_janczukowicz.gitlab.api.events;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceEventsListUsersEventsTargetTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceEventsListUsersEventsTargetType.values())
                .map(GitLabInstanceEventsListUsersEventsTargetType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "issue", "milestone", "merge_request", "note", "project", "snippet", "user", "wiki", "design");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceEventsListUsersEventsTargetType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceEventsListUsersEventsTargetType constant) {
        final GitLabInstanceEventsListUsersEventsTargetType decoded =
                GitLabInstanceEventsListUsersEventsTargetType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceEventsListUsersEventsTargetType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabInstanceEventsListUsersEventsTargetType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
