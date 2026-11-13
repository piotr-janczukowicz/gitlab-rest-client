package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectJobsGetArtifactsDownloadModeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectJobsGetArtifactsDownloadMode.values())
                .map(GitLabProjectJobsGetArtifactsDownloadMode::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("proxy", "direct");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectJobsGetArtifactsDownloadMode.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectJobsGetArtifactsDownloadMode constant) {
        final GitLabProjectJobsGetArtifactsDownloadMode decoded =
                GitLabProjectJobsGetArtifactsDownloadMode.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectJobsGetArtifactsDownloadMode.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectJobsGetArtifactsDownloadMode.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
