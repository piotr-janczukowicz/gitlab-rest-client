package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabRepositoryHealthReferencesTest {

    @Test
    void constructor_shouldAcceptNull_whenLooseCountIsNullable() {
        final GitLabRepositoryHealthReferencesBuilder builder = GitLabRepositoryHealthReferencesBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthReferences())
                .looseCount(null);

        final GitLabRepositoryHealthReferences built = builder.build();

        assertThat(built.looseCount()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPackedSizeIsNullable() {
        final GitLabRepositoryHealthReferencesBuilder builder = GitLabRepositoryHealthReferencesBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthReferences())
                .packedSize(null);

        final GitLabRepositoryHealthReferences built = builder.build();

        assertThat(built.packedSize()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReferenceBackendIsNullable() {
        final GitLabRepositoryHealthReferencesBuilder builder = GitLabRepositoryHealthReferencesBuilder.builder(
                        RepositoriesCatalogFixtures.repositoryHealthReferences())
                .referenceBackend(null);

        final GitLabRepositoryHealthReferences built = builder.build();

        assertThat(built.referenceBackend()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabRepositoryHealthReferences value = RepositoriesCatalogFixtures.repositoryHealthReferences();

        assertSoftly(softly -> {
            softly.assertThat(value.looseCount()).isEqualTo(1);
            softly.assertThat(value.packedSize()).isEqualTo(1L);
            softly.assertThat(value.referenceBackend()).isEqualTo("reference_backend");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabRepositoryHealthReferences original = RepositoriesCatalogFixtures.repositoryHealthReferences();

        final GitLabRepositoryHealthReferences rebuilt =
                GitLabRepositoryHealthReferencesBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabRepositoryHealthReferences.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("looseCount", "packedSize", "referenceBackend");
    }
}
