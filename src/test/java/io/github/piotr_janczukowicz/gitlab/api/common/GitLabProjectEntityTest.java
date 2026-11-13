package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectEntityTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectEntityBuilder builder = GitLabProjectEntityBuilder.builder(
                        CommonCatalogFixtures.projectEntity())
                .id(null);

        final GitLabProjectEntity built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectEntityBuilder builder = GitLabProjectEntityBuilder.builder(
                        CommonCatalogFixtures.projectEntity())
                .name(null);

        final GitLabProjectEntity built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabProjectEntityBuilder builder = GitLabProjectEntityBuilder.builder(
                        CommonCatalogFixtures.projectEntity())
                .fullPath(null);

        final GitLabProjectEntity built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullNameIsNullable() {
        final GitLabProjectEntityBuilder builder = GitLabProjectEntityBuilder.builder(
                        CommonCatalogFixtures.projectEntity())
                .fullName(null);

        final GitLabProjectEntity built = builder.build();

        assertThat(built.fullName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefsUrlIsNullable() {
        final GitLabProjectEntityBuilder builder = GitLabProjectEntityBuilder.builder(
                        CommonCatalogFixtures.projectEntity())
                .refsUrl(null);

        final GitLabProjectEntity built = builder.build();

        assertThat(built.refsUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenForkedIsNullable() {
        final GitLabProjectEntityBuilder builder = GitLabProjectEntityBuilder.builder(
                        CommonCatalogFixtures.projectEntity())
                .forked(null);

        final GitLabProjectEntity built = builder.build();

        assertThat(built.forked()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectEntity value = CommonCatalogFixtures.projectEntity();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("GitLab");
            softly.assertThat(value.fullPath()).isEqualTo("gitlab-org/gitlab");
            softly.assertThat(value.fullName()).isEqualTo("GitLab Org / GitLab");
            softly.assertThat(value.refsUrl()).isEqualTo("refs_url");
            softly.assertThat(value.forked()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectEntity original = CommonCatalogFixtures.projectEntity();

        final GitLabProjectEntity rebuilt =
                GitLabProjectEntityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectEntity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "fullPath", "fullName", "refsUrl", "forked");
    }
}
