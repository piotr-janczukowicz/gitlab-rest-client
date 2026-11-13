package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanFilesListTest {

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabPackageConanFilesListBuilder builder = GitLabPackageConanFilesListBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanFilesList())
                .files(null);

        final GitLabPackageConanFilesList built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanFilesList value = Conanv2distributionsCatalogFixtures.packageConanFilesList();

        assertThat(value.files()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanFilesList original = Conanv2distributionsCatalogFixtures.packageConanFilesList();

        final GitLabPackageConanFilesList rebuilt =
                GitLabPackageConanFilesListBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanFilesList.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("files");
    }
}
