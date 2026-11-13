package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabProjectJobsArtifactsGetFileTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabProjectJobsArtifactsGetFileType.values())
                .map(GitLabProjectJobsArtifactsGetFileType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "accessibility",
                        "api_fuzzing",
                        "archive",
                        "cobertura",
                        "jacoco",
                        "codequality",
                        "container_scanning",
                        "dast",
                        "dependency_scanning",
                        "dotenv",
                        "junit",
                        "license_scanning",
                        "lsif",
                        "metrics",
                        "performance",
                        "browser_performance",
                        "load_performance",
                        "sast",
                        "secret_detection",
                        "requirements",
                        "requirements_v2",
                        "cluster_image_scanning",
                        "cyclonedx",
                        "sarif");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabProjectJobsArtifactsGetFileType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabProjectJobsArtifactsGetFileType constant) {
        final GitLabProjectJobsArtifactsGetFileType decoded =
                GitLabProjectJobsArtifactsGetFileType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectJobsArtifactsGetFileType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown = catchThrowable(() -> GitLabProjectJobsArtifactsGetFileType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
