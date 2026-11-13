package io.github.piotr_janczukowicz.gitlab.api.packages;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPackagesAuthorizeGenericPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabProjectPackagesAuthorizeGenericPayloadBuilder builder =
                GitLabProjectPackagesAuthorizeGenericPayloadBuilder.builder(
                                PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload())
                        .status(null);

        final GitLabProjectPackagesAuthorizeGenericPayload built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPackagesAuthorizeGenericPayload value =
                PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload();

        assertThat(value.status()).isEqualTo(GitLabProjectPackagesAuthorizeGenericStatus.DEFAULT);
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPackagesAuthorizeGenericPayload original =
                PackagesCatalogFixtures.projectPackagesAuthorizeGenericPayload();

        final GitLabProjectPackagesAuthorizeGenericPayload rebuilt =
                GitLabProjectPackagesAuthorizeGenericPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPackagesAuthorizeGenericPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status");
    }
}
