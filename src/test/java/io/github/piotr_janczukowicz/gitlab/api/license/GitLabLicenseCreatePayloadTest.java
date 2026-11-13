package io.github.piotr_janczukowicz.gitlab.api.license;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabLicenseCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenLicenseIsNullable() {
        final GitLabLicenseCreatePayloadBuilder builder = GitLabLicenseCreatePayloadBuilder.builder(
                        LicenseCatalogFixtures.licenseCreatePayload())
                .license(null);

        final GitLabLicenseCreatePayload built = builder.build();

        assertThat(built.license()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabLicenseCreatePayload value = LicenseCatalogFixtures.licenseCreatePayload();

        assertThat(value.license()).isEqualTo("license");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabLicenseCreatePayload original = LicenseCatalogFixtures.licenseCreatePayload();

        final GitLabLicenseCreatePayload rebuilt =
                GitLabLicenseCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabLicenseCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("license");
    }
}
