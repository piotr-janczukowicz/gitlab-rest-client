package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabInstanceJobsAuthorizeArtifactTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabInstanceJobsAuthorizeArtifactType.values())
                .map(GitLabInstanceJobsAuthorizeArtifactType::wireValue)
                .toArray(String[]::new);

        assertThat(wires)
                .containsExactly(
                        "archive",
                        "metadata",
                        "trace",
                        "junit",
                        "sast",
                        "dependency_scanning",
                        "container_scanning",
                        "dast",
                        "codequality",
                        "license_scanning",
                        "performance",
                        "metrics",
                        "metrics_referee",
                        "network_referee",
                        "lsif",
                        "dotenv",
                        "cobertura",
                        "terraform",
                        "accessibility",
                        "cluster_applications",
                        "secret_detection",
                        "requirements",
                        "coverage_fuzzing",
                        "browser_performance",
                        "load_performance",
                        "api_fuzzing",
                        "cluster_image_scanning",
                        "cyclonedx",
                        "requirements_v2",
                        "annotations",
                        "repository_xray",
                        "jacoco",
                        "sarif");
    }

    @ParameterizedTest
    @EnumSource(value = GitLabInstanceJobsAuthorizeArtifactType.class)
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(
            final GitLabInstanceJobsAuthorizeArtifactType constant) {
        final GitLabInstanceJobsAuthorizeArtifactType decoded =
                GitLabInstanceJobsAuthorizeArtifactType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabInstanceJobsAuthorizeArtifactType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldRefuse_whenTheValueIsUnknown() {
        final Throwable thrown =
                catchThrowable(() -> GitLabInstanceJobsAuthorizeArtifactType.fromWire("unknown-value"));

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}
