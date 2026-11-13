package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTreeObjectTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabTreeObjectBuilder builder = GitLabTreeObjectBuilder.builder(
                        RepositoriesCatalogFixtures.treeObject())
                .id(null);

        final GitLabTreeObject built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTreeObjectBuilder builder = GitLabTreeObjectBuilder.builder(
                        RepositoriesCatalogFixtures.treeObject())
                .name(null);

        final GitLabTreeObject built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabTreeObjectBuilder builder = GitLabTreeObjectBuilder.builder(
                        RepositoriesCatalogFixtures.treeObject())
                .type(null);

        final GitLabTreeObject built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabTreeObjectBuilder builder = GitLabTreeObjectBuilder.builder(
                        RepositoriesCatalogFixtures.treeObject())
                .path(null);

        final GitLabTreeObject built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenModeIsNullable() {
        final GitLabTreeObjectBuilder builder = GitLabTreeObjectBuilder.builder(
                        RepositoriesCatalogFixtures.treeObject())
                .mode(null);

        final GitLabTreeObject built = builder.build();

        assertThat(built.mode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastCommitIsNullable() {
        final GitLabTreeObjectBuilder builder = GitLabTreeObjectBuilder.builder(
                        RepositoriesCatalogFixtures.treeObject())
                .lastCommit(null);

        final GitLabTreeObject built = builder.build();

        assertThat(built.lastCommit()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTreeObject value = RepositoriesCatalogFixtures.treeObject();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo("a1e8f8d745cc87e3a9248358d9352bb7f9a0aeba");
            softly.assertThat(value.name()).isEqualTo("html");
            softly.assertThat(value.type()).isEqualTo("tree");
            softly.assertThat(value.path()).isEqualTo("files/html");
            softly.assertThat(value.mode()).isEqualTo("040000");
            softly.assertThat(value.lastCommit()).isEqualTo(CommonCatalogFixtures.commit());
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTreeObject original = RepositoriesCatalogFixtures.treeObject();

        final GitLabTreeObject rebuilt =
                GitLabTreeObjectBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTreeObject.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "type", "path", "mode", "lastCommit");
    }
}
