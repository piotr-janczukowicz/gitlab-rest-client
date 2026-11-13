package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenConfigurationIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreatePayload())
                        .configuration(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload built = builder.build();

        assertThat(built.configuration()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEntitiesIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreatePayload())
                        .entities(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload built = builder.build();

        assertThat(built.entities()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload value =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.configuration())
                    .isEqualTo(
                            GroupandprojectmigrationbydirecttransferCatalogFixtures
                                    .groupAndProjectMigrationByDirectTransferCreateConfiguration());
            softly.assertThat(value.entities())
                    .isEqualTo(List.of(
                            GroupandprojectmigrationbydirecttransferCatalogFixtures
                                    .groupAndProjectMigrationByDirectTransferCreateEntity()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload original =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreatePayload();

        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload rebuilt =
                GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenEntitiesSourceChangesLater() {
        final List<GitLabGroupAndProjectMigrationByDirectTransferCreateEntity> source = new ArrayList<>(List.of(
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreateEntity()));
        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload built =
                GitLabGroupAndProjectMigrationByDirectTransferCreatePayloadBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreatePayload())
                        .entities(source)
                        .build();
        source.clear();

        assertThat(built.entities()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenEntitiesIsRead() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreatePayload built =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreatePayload();
        final List<GitLabGroupAndProjectMigrationByDirectTransferCreateEntity> values = built.entities();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupAndProjectMigrationByDirectTransferCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("configuration", "entities");
    }
}
