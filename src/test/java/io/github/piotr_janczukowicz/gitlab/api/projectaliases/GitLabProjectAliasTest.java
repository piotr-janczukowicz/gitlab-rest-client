package io.github.piotr_janczukowicz.gitlab.api.projectaliases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAliasTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabProjectAliasBuilder builder = GitLabProjectAliasBuilder.builder(
                        ProjectaliasesCatalogFixtures.projectAlias())
                .id(null);

        final GitLabProjectAlias built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectAliasBuilder builder = GitLabProjectAliasBuilder.builder(
                        ProjectaliasesCatalogFixtures.projectAlias())
                .projectId(null);

        final GitLabProjectAlias built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectAliasBuilder builder = GitLabProjectAliasBuilder.builder(
                        ProjectaliasesCatalogFixtures.projectAlias())
                .name(null);

        final GitLabProjectAlias built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAlias value = ProjectaliasesCatalogFixtures.projectAlias();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("gitlab");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAlias original = ProjectaliasesCatalogFixtures.projectAlias();

        final GitLabProjectAlias rebuilt =
                GitLabProjectAliasBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAlias.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "projectId", "name");
    }
}
