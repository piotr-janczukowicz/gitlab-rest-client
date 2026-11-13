package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCiRunnerWithUuidRunnerTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCiRunnerWithUuidRunnerType.values())
                .filter(constant -> constant != GitLabCiRunnerWithUuidRunnerType.UNRECOGNIZED)
                .map(GitLabCiRunnerWithUuidRunnerType::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("instance_type", "group_type", "project_type");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabCiRunnerWithUuidRunnerType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabCiRunnerWithUuidRunnerType constant) {
        final GitLabCiRunnerWithUuidRunnerType decoded =
                GitLabCiRunnerWithUuidRunnerType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCiRunnerWithUuidRunnerType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabCiRunnerWithUuidRunnerType decoded = GitLabCiRunnerWithUuidRunnerType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabCiRunnerWithUuidRunnerType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabCiRunnerWithUuidRunnerType.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabCiRunnerWithUuidRunnerType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
