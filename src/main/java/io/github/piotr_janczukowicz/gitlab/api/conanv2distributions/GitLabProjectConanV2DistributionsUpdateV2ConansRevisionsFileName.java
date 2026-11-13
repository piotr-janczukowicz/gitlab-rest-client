package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project conan v2 distributions update v2 conans revisions file name. */
@CatalogSchema(
        "operations/putApiV4ProjectsIdPackagesConanV2ConansPackageNamePackageVersionPackageUsernamePackageChannelRevisionsRecipeRevisionFilesFileName/parameters/file_name/schema")
public enum GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName {
    CONANFILE_PY("conanfile.py"),
    CONANMANIFEST_TXT("conanmanifest.txt"),
    CONAN_SOURCES_TGZ("conan_sources.tgz"),
    CONAN_EXPORT_TGZ("conan_export.tgz"),
    CONANINFO_TXT("conaninfo.txt"),
    CONAN_PACKAGE_TGZ("conan_package.tgz");

    private static final EnumUtils.WireIndex<GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName.class,
                    GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName::wireValue);

    private final String wireValue;

    GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName(final String wireValue) {
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
    public static GitLabProjectConanV2DistributionsUpdateV2ConansRevisionsFileName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
