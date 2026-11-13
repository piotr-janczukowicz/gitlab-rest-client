package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectJobsArtifactsGetDownloadModeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectJobsArtifactsGetDownloadMode.values())
                .map(GitLabProjectJobsArtifactsGetDownloadMode::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("proxy", "direct");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectJobsArtifactsGetDownloadMode.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectJobsArtifactsGetDownloadMode constant) {
        final GitLabProjectJobsArtifactsGetDownloadMode decoded =
                GitLabProjectJobsArtifactsGetDownloadMode.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectJobsArtifactsGetDownloadMode.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabProjectJobsArtifactsGetDownloadMode.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
