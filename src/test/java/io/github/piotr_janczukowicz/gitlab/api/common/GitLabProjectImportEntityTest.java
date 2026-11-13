package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectImportEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .id(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .name(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .fullPath(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullNameIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .fullName(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.fullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefsUrlIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .refsUrl(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.refsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkedIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .forked(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.forked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportSourceIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .importSource(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.importSource()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportStatusIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .importStatus(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.importStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHumanImportStatusNameIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .humanImportStatusName(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.humanImportStatusName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProviderLinkIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .providerLink(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.providerLink()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportErrorIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .importError(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.importError()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenImportWarningIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .importWarning(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.importWarning()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelationTypeIsNullable() {
        final GitLabProjectImportEntityBuilder builder = GitLabProjectImportEntityBuilder.builder(
                        CommonCatalogFixtures.projectImportEntity())
                .relationType(null);

        final GitLabProjectImportEntity built = builder.build();

        assertThat(built.relationType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectImportEntity value = CommonCatalogFixtures.projectImportEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("GitLab");
            softly.assertThat(value.fullPath()).isEqualTo("gitlab-org/gitlab");
            softly.assertThat(value.fullName()).isEqualTo("GitLab Org / GitLab");
            softly.assertThat(value.refsUrl()).isEqualTo("refs_url");
            softly.assertThat(value.forked()).isEqualTo(true);
            softly.assertThat(value.importSource()).isEqualTo("source/source-repo");
            softly.assertThat(value.importStatus()).isEqualTo(GitLabProjectImportEntityImportStatus.SCHEDULED);
            softly.assertThat(value.humanImportStatusName()).isEqualTo("canceled");
            softly.assertThat(value.providerLink()).isEqualTo("/source/source-repo");
            softly.assertThat(value.importError()).isEqualTo("import_error");
            softly.assertThat(value.importWarning()).isEqualTo("import_warning");
            softly.assertThat(value.relationType()).isEqualTo("relation_type");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectImportEntity original = CommonCatalogFixtures.projectImportEntity();

        final GitLabProjectImportEntity rebuilt =
                GitLabProjectImportEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectImportEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "name",
                        "fullPath",
                        "fullName",
                        "refsUrl",
                        "forked",
                        "importSource",
                        "importStatus",
                        "humanImportStatusName",
                        "providerLink",
                        "importError",
                        "importWarning",
                        "relationType");
    }
}
