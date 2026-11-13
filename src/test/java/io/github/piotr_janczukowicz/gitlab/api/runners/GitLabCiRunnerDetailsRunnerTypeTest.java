package io.github.piotr_janczukowicz.gitlab.api.runners;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCiRunnerDetailsRunnerTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCiRunnerDetailsRunnerType.values())
                .filter(constant -> constant != GitLabCiRunnerDetailsRunnerType.UNRECOGNIZED)
                .map(GitLabCiRunnerDetailsRunnerType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("instance_type", "group_type", "project_type");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabCiRunnerDetailsRunnerType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabCiRunnerDetailsRunnerType constant) {
        final GitLabCiRunnerDetailsRunnerType decoded = GitLabCiRunnerDetailsRunnerType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCiRunnerDetailsRunnerType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabCiRunnerDetailsRunnerType decoded = GitLabCiRunnerDetailsRunnerType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabCiRunnerDetailsRunnerType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabCiRunnerDetailsRunnerType.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabCiRunnerDetailsRunnerType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
