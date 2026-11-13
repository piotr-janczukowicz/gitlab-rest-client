package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateConfiguration())
                        .url(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAccessTokenIsNullable() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationBuilder builder =
                GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationBuilder.builder(
                                GroupandprojectmigrationbydirecttransferCatalogFixtures
                                        .groupAndProjectMigrationByDirectTransferCreateConfiguration())
                        .accessToken(null);

        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration built = builder.build();

        assertThat(built.accessToken()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration value =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreateConfiguration();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.accessToken()).isEqualTo("access_token");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration original =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreateConfiguration();

        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration rebuilt =
                GitLabGroupAndProjectMigrationByDirectTransferCreateConfigurationBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenAccessTokenIsACredential() {
        final GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration value =
                GroupandprojectmigrationbydirecttransferCatalogFixtures
                        .groupAndProjectMigrationByDirectTransferCreateConfiguration();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabGroupAndProjectMigrationByDirectTransferCreateConfiguration.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "accessToken");
    }
}
