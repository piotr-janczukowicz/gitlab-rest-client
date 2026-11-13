package io.github.piotr_janczukowicz.gitlab.api.conanv1distributions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanUploadUrlsTest {

    @Test
    void constructor_shouldAcceptNull_whenUploadUrlsIsNullable() {
        final GitLabPackageConanUploadUrlsBuilder builder = GitLabPackageConanUploadUrlsBuilder.builder(
                        Conanv1distributionsCatalogFixtures.packageConanUploadUrls())
                .uploadUrls(null);

        final GitLabPackageConanUploadUrls built = builder.build();

        assertThat(built.uploadUrls()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanUploadUrls value = Conanv1distributionsCatalogFixtures.packageConanUploadUrls();

        assertThat(value.uploadUrls()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanUploadUrls original = Conanv1distributionsCatalogFixtures.packageConanUploadUrls();

        final GitLabPackageConanUploadUrls rebuilt =
                GitLabPackageConanUploadUrlsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanUploadUrls.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("uploadUrls");
    }
}
