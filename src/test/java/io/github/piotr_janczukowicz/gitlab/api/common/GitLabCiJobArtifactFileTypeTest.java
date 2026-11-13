package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

@UnitTest
class GitLabCiJobArtifactFileTypeTest {

    @Test
    void values_shouldMatchTheSpecEnum() {
        final String[] wires = Arrays.stream(GitLabCiJobArtifactFileType.values())
                .filter(constant -> constant != GitLabCiJobArtifactFileType.UNRECOGNIZED)
                .map(GitLabCiJobArtifactFileType::wireValue)
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
    @EnumSource(value = GitLabCiJobArtifactFileType.class, mode = EnumSource.Mode.EXCLUDE, names = "UNRECOGNIZED")
    void fromWire_shouldReturnTheConstant_whenTheWireValueIsGiven(final GitLabCiJobArtifactFileType constant) {
        final GitLabCiJobArtifactFileType decoded = GitLabCiJobArtifactFileType.fromWire(constant.wireValue());

        assertThat(decoded).isEqualTo(constant);
    }

    @Test
    void fromWire_shouldRefuseNull_whenTheValueIsNull() {
        final Throwable thrown = catchThrowable(() -> GitLabCiJobArtifactFileType.fromWire(null));

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("value");
    }

    @Test
    void fromWire_shouldReturnUnrecognized_whenTheValueIsUnknown() {
        final GitLabCiJobArtifactFileType decoded = GitLabCiJobArtifactFileType.fromWire("unknown-value");

        assertThat(decoded).isEqualTo(GitLabCiJobArtifactFileType.UNRECOGNIZED);
    }

    @Test
    void unrecognized_shouldNotShareAWireValueWithAConstant() {
        final long sharing = Arrays.stream(GitLabCiJobArtifactFileType.values())
                .filter(constant -> constant.wireValue().equals(GitLabCiJobArtifactFileType.UNRECOGNIZED.wireValue()))
                .count();

        assertThat(sharing).isEqualTo(1L);
    }
}
