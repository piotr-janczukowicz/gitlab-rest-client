package io.github.piotr_janczukowicz.gitlab.api.datamanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAdminModelTest {

    @Test
    void constructor_shouldAcceptNull_whenRecordIdentifierIsNullable() {
        final GitLabAdminModelBuilder builder = GitLabAdminModelBuilder.builder(
                        DatamanagementCatalogFixtures.adminModel())
                .recordIdentifier(null);

        final GitLabAdminModel built = builder.build();

        assertThat(built.recordIdentifier()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModelClassIsNullable() {
        final GitLabAdminModelBuilder builder = GitLabAdminModelBuilder.builder(
                        DatamanagementCatalogFixtures.adminModel())
                .modelClass(null);

        final GitLabAdminModel built = builder.build();

        assertThat(built.modelClass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabAdminModelBuilder builder = GitLabAdminModelBuilder.builder(
                        DatamanagementCatalogFixtures.adminModel())
                .createdAt(null);

        final GitLabAdminModel built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFileSizeIsNullable() {
        final GitLabAdminModelBuilder builder = GitLabAdminModelBuilder.builder(
                        DatamanagementCatalogFixtures.adminModel())
                .fileSize(null);

        final GitLabAdminModel built = builder.build();

        assertThat(built.fileSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenChecksumInformationIsNullable() {
        final GitLabAdminModelBuilder builder = GitLabAdminModelBuilder.builder(
                        DatamanagementCatalogFixtures.adminModel())
                .checksumInformation(null);

        final GitLabAdminModel built = builder.build();

        assertThat(built.checksumInformation()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAdminModel value = DatamanagementCatalogFixtures.adminModel();

        assertSoftly(softly -> {
            softly.assertThat(value.recordIdentifier()).isEqualTo("text");
            softly.assertThat(value.modelClass()).isEqualTo("Project");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.fileSize()).isEqualTo(1L);
            softly.assertThat(value.checksumInformation())
                    .isEqualTo(DatamanagementCatalogFixtures.adminModelChecksumInformation());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAdminModel original = DatamanagementCatalogFixtures.adminModel();

        final GitLabAdminModel rebuilt =
                GitLabAdminModelBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAdminModel.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("recordIdentifier", "modelClass", "createdAt", "fileSize", "checksumInformation");
    }
}
