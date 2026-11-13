package io.github.piotr_janczukowicz.gitlab.api.jobsartifacts;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project jobs artifacts get file type. */
@CatalogSchema("operations/getApiV4ProjectsIdJobsJobIdArtifacts/parameters/file_type/schema")
public enum GitLabProjectJobsArtifactsGetFileType {
    ACCESSIBILITY("accessibility"),
    API_FUZZING("api_fuzzing"),
    ARCHIVE("archive"),
    COBERTURA("cobertura"),
    JACOCO("jacoco"),
    CODEQUALITY("codequality"),
    CONTAINER_SCANNING("container_scanning"),
    DAST("dast"),
    DEPENDENCY_SCANNING("dependency_scanning"),
    DOTENV("dotenv"),
    JUNIT("junit"),
    LICENSE_SCANNING("license_scanning"),
    LSIF("lsif"),
    METRICS("metrics"),
    PERFORMANCE("performance"),
    BROWSER_PERFORMANCE("browser_performance"),
    LOAD_PERFORMANCE("load_performance"),
    SAST("sast"),
    SECRET_DETECTION("secret_detection"),
    REQUIREMENTS("requirements"),
    REQUIREMENTS_V2("requirements_v2"),
    CLUSTER_IMAGE_SCANNING("cluster_image_scanning"),
    CYCLONEDX("cyclonedx"),
    SARIF("sarif");

    private static final EnumUtils.WireIndex<GitLabProjectJobsArtifactsGetFileType> WIRE_INDEX = EnumUtils.index(
            GitLabProjectJobsArtifactsGetFileType.class, GitLabProjectJobsArtifactsGetFileType::wireValue);

    private final String wireValue;

    GitLabProjectJobsArtifactsGetFileType(final String wireValue) {
        this.wireValue = wireValue;
    }

    /**
     * Value GitLab sends and expects in JSON.
     *
     * @return wire value
     */
    @JsonValue
    public String wireValue() {
        return wireValue;
    }

    /**
     * Resolves the constant from its wire value.
     *
     * @param value JSON value
     * @return matching constant
     * @throws NullPointerException if {@code value} is {@code null}
     * @throws IllegalArgumentException if {@code value} is not a known value
     */
    @JsonCreator
    public static GitLabProjectJobsArtifactsGetFileType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
