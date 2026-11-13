package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabClusterAgentTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabClusterAgentBuilder builder = GitLabClusterAgentBuilder.builder(
                        CommonCatalogFixtures.clusterAgent())
                .id(null);

        final GitLabClusterAgent built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabClusterAgentBuilder builder = GitLabClusterAgentBuilder.builder(
                        CommonCatalogFixtures.clusterAgent())
                .name(null);

        final GitLabClusterAgent built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfigProjectIsNullable() {
        final GitLabClusterAgentBuilder builder = GitLabClusterAgentBuilder.builder(
                        CommonCatalogFixtures.clusterAgent())
                .configProject(null);

        final GitLabClusterAgent built = builder.build();

        assertThat(built.configProject()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabClusterAgentBuilder builder = GitLabClusterAgentBuilder.builder(
                        CommonCatalogFixtures.clusterAgent())
                .createdAt(null);

        final GitLabClusterAgent built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedByUserIdIsNullable() {
        final GitLabClusterAgentBuilder builder = GitLabClusterAgentBuilder.builder(
                        CommonCatalogFixtures.clusterAgent())
                .createdByUserId(null);

        final GitLabClusterAgent built = builder.build();

        assertThat(built.createdByUserId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIsReceptiveIsNullable() {
        final GitLabClusterAgentBuilder builder = GitLabClusterAgentBuilder.builder(
                        CommonCatalogFixtures.clusterAgent())
                .isReceptive(null);

        final GitLabClusterAgent built = builder.build();

        assertThat(built.isReceptive()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabClusterAgent value = CommonCatalogFixtures.clusterAgent();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.configProject()).isEqualTo(CommonCatalogFixtures.projectIdentity());
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.createdByUserId()).isEqualTo(1L);
            softly.assertThat(value.isReceptive()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabClusterAgent original = CommonCatalogFixtures.clusterAgent();

        final GitLabClusterAgent rebuilt =
                GitLabClusterAgentBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabClusterAgent.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "configProject", "createdAt", "createdByUserId", "isReceptive");
    }
}
