package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabUsersCreateRunnerTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabUsersCreateRunnerType.values())
                .map(GitLabUsersCreateRunnerType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("instance_type", "group_type", "project_type");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabUsersCreateRunnerType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabUsersCreateRunnerType constant) {
        final GitLabUsersCreateRunnerType decoded = GitLabUsersCreateRunnerType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersCreateRunnerType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabUsersCreateRunnerType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
