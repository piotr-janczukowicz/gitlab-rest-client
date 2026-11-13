package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenWebPathIsNullable() {
        final GitLabPackageLinksBuilder builder = GitLabPackageLinksBuilder.builder(
                        CommonCatalogFixtures.packageLinks())
                .webPath(null);

        final GitLabPackageLinks built = builder.build();

        assertThat(built.webPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDeleteApiPathIsNullable() {
        final GitLabPackageLinksBuilder builder = GitLabPackageLinksBuilder.builder(
                        CommonCatalogFixtures.packageLinks())
                .deleteApiPath(null);

        final GitLabPackageLinks built = builder.build();

        assertThat(built.deleteApiPath()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageLinks value = CommonCatalogFixtures.packageLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.webPath()).isEqualTo("web_path");
            softly.assertThat(value.deleteApiPath()).isEqualTo("delete_api_path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageLinks original = CommonCatalogFixtures.packageLinks();

        final GitLabPackageLinks rebuilt =
                GitLabPackageLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("webPath", "deleteApiPath");
    }
}
