package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static io.github.piotr_janczukowicz.util.ValidationUtils.requireNonNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.github.piotr_janczukowicz.openapi.model.CatalogSchema;
import io.github.piotr_janczukowicz.util.EnumUtils;

/** The values of git lab project conan v1 distributions authorize v1 files package file name. */
@CatalogSchema(
        "operations/putApiV4PackagesConanV1FilesPackageNamePackageVersionPackageUsernamePackageChannelRecipeRevisionPackageConanPackageReferencePackageRevisionFileNameAuthorize/parameters/file_name/schema")
public enum GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName {
    CONANFILE_PY("conanfile.py"),
    CONANMANIFEST_TXT("conanmanifest.txt"),
    CONAN_SOURCES_TGZ("conan_sources.tgz"),
    CONAN_EXPORT_TGZ("conan_export.tgz"),
    CONANINFO_TXT("conaninfo.txt"),
    CONAN_PACKAGE_TGZ("conan_package.tgz");

    private static final EnumUtils.WireIndex<GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName>
            WIRE_INDEX = EnumUtils.index(
                    GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName.class,
                    GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName::wireValue);

    private final String wireValue;

    GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName(final String wireValue) {
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
    public static GitLabProjectConanV1DistributionsAuthorizeV1FilesPackageFileName fromWire(final String value) {
        requireNonNull(value, "value");

        return WIRE_INDEX.fromWire(value).orElseThrow(() -> new IllegalArgumentException("Unknown value: " + value));
    }
}
