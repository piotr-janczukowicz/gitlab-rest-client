package io.github.piotr_janczukowicz.gitlab.api.common;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab ci job artifact file type. */
@CatalogSchema("components/schemas/APIEntitiesCiJobArtifact/properties/file_type")
public enum GitLabCiJobArtifactFileType {
    ARCHIVE("archive"),
    METADATA("metadata"),
    TRACE("trace"),
    JUNIT("junit"),
    SAST("sast"),
    DEPENDENCY_SCANNING("dependency_scanning"),
    CONTAINER_SCANNING("container_scanning"),
    DAST("dast"),
    CODEQUALITY("codequality"),
    LICENSE_SCANNING("license_scanning"),
    PERFORMANCE("performance"),
    METRICS("metrics"),
    METRICS_REFEREE("metrics_referee"),
    NETWORK_REFEREE("network_referee"),
    LSIF("lsif"),
    DOTENV("dotenv"),
    COBERTURA("cobertura"),
    TERRAFORM("terraform"),
    ACCESSIBILITY("accessibility"),
    CLUSTER_APPLICATIONS("cluster_applications"),
    SECRET_DETECTION("secret_detection"),
    REQUIREMENTS("requirements"),
    COVERAGE_FUZZING("coverage_fuzzing"),
    BROWSER_PERFORMANCE("browser_performance"),
    LOAD_PERFORMANCE("load_performance"),
    API_FUZZING("api_fuzzing"),
    CLUSTER_IMAGE_SCANNING("cluster_image_scanning"),
    CYCLONEDX("cyclonedx"),
    REQUIREMENTS_V2("requirements_v2"),
    ANNOTATIONS("annotations"),
    REPOSITORY_XRAY("repository_xray"),
    JACOCO("jacoco"),
    SARIF("sarif"),
    /** A value this library version does not know. */
    UNRECOGNIZED("unrecognized");

    private static final EnumUtils.WireIndex<GitLabCiJobArtifactFileType> WIRE_INDEX =
            EnumUtils.index(GitLabCiJobArtifactFileType.class, GitLabCiJobArtifactFileType::wireValue);

    private final String wireValue;

    GitLabCiJobArtifactFileType(final String wireValue) {
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
     */
    @JsonCreator
    public static GitLabCiJobArtifactFileType fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value, UNRECOGNIZED);
    }
}
