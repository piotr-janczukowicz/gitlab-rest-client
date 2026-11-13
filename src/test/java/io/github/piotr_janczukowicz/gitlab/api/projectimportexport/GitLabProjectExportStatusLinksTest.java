package io.github.piotr_janczukowicz.gitlab.api.projectimportexport;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectExportStatusLinksTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabProjectExportStatusLinksBuilder builder = GitLabProjectExportStatusLinksBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatusLinks())
                .apiUrl(null);

        final GitLabProjectExportStatusLinks built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabProjectExportStatusLinksBuilder builder = GitLabProjectExportStatusLinksBuilder.builder(
                        ProjectimportexportCatalogFixtures.projectExportStatusLinks())
                .webUrl(null);

        final GitLabProjectExportStatusLinks built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectExportStatusLinks value = ProjectimportexportCatalogFixtures.projectExportStatusLinks();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("https://gitlab.example.com/api/v4/projects/1/export/download");
            softly.assertThat(value.webUrl())
                    .isEqualTo("https://gitlab.example.com/gitlab-org/gitlab-test/download_export");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectExportStatusLinks original = ProjectimportexportCatalogFixtures.projectExportStatusLinks();

        final GitLabProjectExportStatusLinks rebuilt =
                GitLabProjectExportStatusLinksBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectExportStatusLinks.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "webUrl");
    }
}
