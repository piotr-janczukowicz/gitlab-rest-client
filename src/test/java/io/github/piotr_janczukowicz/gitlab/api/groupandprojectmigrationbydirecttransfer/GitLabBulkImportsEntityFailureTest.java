package io.github.piotr_janczukowicz.gitlab.api.groupandprojectmigrationbydirecttransfer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBulkImportsEntityFailureTest {

    @Test
    void constructor_shouldAcceptNull_whenRelationIsNullable() {
        final GitLabBulkImportsEntityFailureBuilder builder = GitLabBulkImportsEntityFailureBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure())
                .relation(null);

        final GitLabBulkImportsEntityFailure built = builder.build();

        assertThat(built.relation()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExceptionMessageIsNullable() {
        final GitLabBulkImportsEntityFailureBuilder builder = GitLabBulkImportsEntityFailureBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure())
                .exceptionMessage(null);

        final GitLabBulkImportsEntityFailure built = builder.build();

        assertThat(built.exceptionMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExceptionClassIsNullable() {
        final GitLabBulkImportsEntityFailureBuilder builder = GitLabBulkImportsEntityFailureBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure())
                .exceptionClass(null);

        final GitLabBulkImportsEntityFailure built = builder.build();

        assertThat(built.exceptionClass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCorrelationIdValueIsNullable() {
        final GitLabBulkImportsEntityFailureBuilder builder = GitLabBulkImportsEntityFailureBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure())
                .correlationIdValue(null);

        final GitLabBulkImportsEntityFailure built = builder.build();

        assertThat(built.correlationIdValue()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceUrlIsNullable() {
        final GitLabBulkImportsEntityFailureBuilder builder = GitLabBulkImportsEntityFailureBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure())
                .sourceUrl(null);

        final GitLabBulkImportsEntityFailure built = builder.build();

        assertThat(built.sourceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceTitleIsNullable() {
        final GitLabBulkImportsEntityFailureBuilder builder = GitLabBulkImportsEntityFailureBuilder.builder(
                        GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure())
                .sourceTitle(null);

        final GitLabBulkImportsEntityFailure built = builder.build();

        assertThat(built.sourceTitle()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBulkImportsEntityFailure value =
                GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure();

        assertSoftly(softly -> {
            softly.assertThat(value.relation()).isEqualTo("label");
            softly.assertThat(value.exceptionMessage()).isEqualTo("error message");
            softly.assertThat(value.exceptionClass()).isEqualTo("Exception");
            softly.assertThat(value.correlationIdValue()).isEqualTo("dfcf583058ed4508e4c7c617bd7f0edd");
            softly.assertThat(value.sourceUrl()).isEqualTo("https://source.gitlab.com/group/-/epics/1");
            softly.assertThat(value.sourceTitle()).isEqualTo("title");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBulkImportsEntityFailure original =
                GroupandprojectmigrationbydirecttransferCatalogFixtures.bulkImportsEntityFailure();

        final GitLabBulkImportsEntityFailure rebuilt =
                GitLabBulkImportsEntityFailureBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBulkImportsEntityFailure.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "relation",
                        "exceptionMessage",
                        "exceptionClass",
                        "correlationIdValue",
                        "sourceUrl",
                        "sourceTitle");
    }
}
