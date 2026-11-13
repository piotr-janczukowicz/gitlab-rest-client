package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSearchZoektIndexedNamespaceTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSearchZoektIndexedNamespaceBuilder builder = GitLabSearchZoektIndexedNamespaceBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektIndexedNamespace())
                .id(null);

        final GitLabSearchZoektIndexedNamespace built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektShardIdIsNullable() {
        final GitLabSearchZoektIndexedNamespaceBuilder builder = GitLabSearchZoektIndexedNamespaceBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektIndexedNamespace())
                .zoektShardId(null);

        final GitLabSearchZoektIndexedNamespace built = builder.build();

        assertThat(built.zoektShardId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenZoektNodeIdIsNullable() {
        final GitLabSearchZoektIndexedNamespaceBuilder builder = GitLabSearchZoektIndexedNamespaceBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektIndexedNamespace())
                .zoektNodeId(null);

        final GitLabSearchZoektIndexedNamespace built = builder.build();

        assertThat(built.zoektNodeId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabSearchZoektIndexedNamespaceBuilder builder = GitLabSearchZoektIndexedNamespaceBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektIndexedNamespace())
                .namespaceId(null);

        final GitLabSearchZoektIndexedNamespace built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNumberOfReplicasOverrideIsNullable() {
        final GitLabSearchZoektIndexedNamespaceBuilder builder = GitLabSearchZoektIndexedNamespaceBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektIndexedNamespace())
                .numberOfReplicasOverride(null);

        final GitLabSearchZoektIndexedNamespace built = builder.build();

        assertThat(built.numberOfReplicasOverride()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSearchZoektIndexedNamespace value = CodesearchCatalogFixtures.searchZoektIndexedNamespace();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.zoektShardId()).isEqualTo(1L);
            softly.assertThat(value.zoektNodeId()).isEqualTo(1L);
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.numberOfReplicasOverride()).isEqualTo(1);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSearchZoektIndexedNamespace original = CodesearchCatalogFixtures.searchZoektIndexedNamespace();

        final GitLabSearchZoektIndexedNamespace rebuilt =
                GitLabSearchZoektIndexedNamespaceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSearchZoektIndexedNamespace.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "zoektShardId", "zoektNodeId", "namespaceId", "numberOfReplicasOverride");
    }
}
