package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceJobsGetArtifactsDownloadModeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceJobsGetArtifactsDownloadMode.values())
                .map(GitLabInstanceJobsGetArtifactsDownloadMode::wireValue)
                .toArray(String[]::new);

        assertThat(wires).containsExactly("proxy", "direct");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceJobsGetArtifactsDownloadMode.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceJobsGetArtifactsDownloadMode constant) {
        final GitLabInstanceJobsGetArtifactsDownloadMode decoded =
                GitLabInstanceJobsGetArtifactsDownloadMode.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceJobsGetArtifactsDownloadMode.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabInstanceJobsGetArtifactsDownloadMode.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
