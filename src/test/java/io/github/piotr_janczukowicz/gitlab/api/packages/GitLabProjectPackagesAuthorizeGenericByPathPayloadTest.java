package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesAuthorizeGenericByPathPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectPackagesAuthorizeGenericByPathPayloadBuilder builder =
                GitLabProjectPackagesAuthorizeGenericByPathPayloadBuilder.builder(
                                PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload())
                        .status(null);

        final GitLabProjectPackagesAuthorizeGenericByPathPayload built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesAuthorizeGenericByPathPayload value =
                PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload();

        assertThat(value.status()).isEqualTo(GitLabProjectPackagesAuthorizeGenericByPathStatus.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesAuthorizeGenericByPathPayload original =
                PackagesCatalogFixtures.projectPackagesAuthorizeGenericByPathPayload();

        final GitLabProjectPackagesAuthorizeGenericByPathPayload rebuilt =
                GitLabProjectPackagesAuthorizeGenericByPathPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectPackagesAuthorizeGenericByPathPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }
}
