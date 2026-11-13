package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectImportFailedRelationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .id(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .createdAt(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExceptionClassIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .exceptionClass(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.exceptionClass()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSourceIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .source(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.source()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExceptionMessageIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .exceptionMessage(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.exceptionMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRelationNameIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .relationName(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.relationName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLineNumberIsNullable() {
        final GitLabProjectImportFailedRelationBuilder builder = GitLabProjectImportFailedRelationBuilder.builder(
                        CommonCatalogFixtures.projectImportFailedRelation())
                .lineNumber(null);

        final GitLabProjectImportFailedRelation built = builder.build();

        assertThat(built.lineNumber()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectImportFailedRelation value = CommonCatalogFixtures.projectImportFailedRelation();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.exceptionClass()).isEqualTo("StandardError");
            softly.assertThat(value.source()).isEqualTo("ImportRepositoryWorker");
            softly.assertThat(value.exceptionMessage()).isEqualTo("exception_message");
            softly.assertThat(value.relationName()).isEqualTo("issues");
            softly.assertThat(value.lineNumber()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectImportFailedRelation original = CommonCatalogFixtures.projectImportFailedRelation();

        final GitLabProjectImportFailedRelation rebuilt =
                GitLabProjectImportFailedRelationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectImportFailedRelation.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "createdAt",
                        "exceptionClass",
                        "source",
                        "exceptionMessage",
                        "relationName",
                        "lineNumber");
    }
}
