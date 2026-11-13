package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectImportEntityImportStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectImportEntityImportStatus.values())
                .filter(constant -> constant != GitLabProjectImportEntityImportStatus.UNRECOGNIZED)
                .map(GitLabProjectImportEntityImportStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("scheduled", "started", "finished", "failed", "canceled");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabProjectImportEntityImportStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectImportEntityImportStatus constant) {
        final GitLabProjectImportEntityImportStatus decoded =
                GitLabProjectImportEntityImportStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectImportEntityImportStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabProjectImportEntityImportStatus decoded =
                GitLabProjectImportEntityImportStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabProjectImportEntityImportStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabProjectImportEntityImportStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabProjectImportEntityImportStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
