package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectExportStatusExportStatusTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectExportStatusExportStatus.values())
                .filter(constant -> constant != GitLabProjectExportStatusExportStatus.UNRECOGNIZED)
                .map(GitLabProjectExportStatusExportStatus::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("queued", "started", "finished", "failed");
    }

    @ParameterizedTest
    @EnumSource(
            value = GitLabProjectExportStatusExportStatus.class,
            mode = EnumSource.Mode.EXCLUDE,
            names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectExportStatusExportStatus constant) {
        final GitLabProjectExportStatusExportStatus decoded =
                GitLabProjectExportStatusExportStatus.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectExportStatusExportStatus.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabProjectExportStatusExportStatus decoded =
                GitLabProjectExportStatusExportStatus.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabProjectExportStatusExportStatus.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabProjectExportStatusExportStatus.values())
                .filter(constant ->
                        constant.wireValue().equals(GitLabProjectExportStatusExportStatus.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
