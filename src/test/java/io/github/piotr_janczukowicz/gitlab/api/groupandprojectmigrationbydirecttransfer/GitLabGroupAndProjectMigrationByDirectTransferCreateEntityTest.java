package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAndProjectMigrationByDirectTransferCreateEntityTest {

    @Test
    void constructor_shouldRefuseNull_whenSourceTypeIsNull() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .sourceType(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("sourceType");
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceFullPathIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .sourceFullPath(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity built = builder.build();

        assertThat(built.sourceFullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationNamespaceIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .destinationNamespace(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity built = builder.build();

        assertThat(built.destinationNamespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationSlugIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .destinationSlug(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity built = builder.build();

        assertThat(built.destinationSlug()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationNameIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .destinationName(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity built = builder.build();

        assertThat(built.destinationName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMigrateProjectsIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .migrateProjects(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity built = builder.build();

        assertThat(built.migrateProjects()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMigrateMembershipsIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateEntity())
                        .migrateMemberships(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity built = builder.build();

        assertThat(built.migrateMemberships()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity value =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreateEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceType())
                    .isEqualTo(GitLabGroupAndProjectMigrationByDirectTransferCreateEntitySourceType.GROUP_ENTITY);
            softly.assertThat(value.sourceFullPath())
                    .isEqualTo("'source/full/path' not 'https://example.com/source/full/path'");
            softly.assertThat(value.destinationNamespace())
                    .isEqualTo("'destination_namespace' or 'destination/namespace'");
            softly.assertThat(value.destinationSlug()).isEqualTo("'destination_slug' not 'destination/slug'");
            softly.assertThat(value.destinationName()).isEqualTo("'destination_slug' not 'destination/slug'");
            softly.assertThat(value.migrateProjects()).isEqualTo(true);
            softly.assertThat(value.migrateMemberships()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity original =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreateEntity();

        final GitLabGroupAndProjectMigrationByDirectTransferCreateEntity rebuilt =
                GitLabGroupAndProjectMigrationByDirectTransferCreateEntityBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupAndProjectMigrationByDirectTransferCreateEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "sourceType",
                        "sourceFullPath",
                        "destinationNamespace",
                        "destinationSlug",
                        "destinationName",
                        "migrateProjects",
                        "migrateMemberships");
    }
}
