package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabChangedPathTest {

    @Test
    void constructor_shouldAcceptNull_whenStatusIsNullable() {
        final GitLabChangedPathBuilder builder = GitLabChangedPathBuilder.builder(
                        RepositoriesCatalogFixtures.changedPath())
                .status(null);

        final GitLabChangedPath built = builder.build();

        assertThat(built.status()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabChangedPathBuilder builder = GitLabChangedPathBuilder.builder(
                        RepositoriesCatalogFixtures.changedPath())
                .path(null);

        final GitLabChangedPath built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldPathIsNullable() {
        final GitLabChangedPathBuilder builder = GitLabChangedPathBuilder.builder(
                        RepositoriesCatalogFixtures.changedPath())
                .oldPath(null);

        final GitLabChangedPath built = builder.build();

        assertThat(built.oldPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenOldModeIsNullable() {
        final GitLabChangedPathBuilder builder = GitLabChangedPathBuilder.builder(
                        RepositoriesCatalogFixtures.changedPath())
                .oldMode(null);

        final GitLabChangedPath built = builder.build();

        assertThat(built.oldMode()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewModeIsNullable() {
        final GitLabChangedPathBuilder builder = GitLabChangedPathBuilder.builder(
                        RepositoriesCatalogFixtures.changedPath())
                .newMode(null);

        final GitLabChangedPath built = builder.build();

        assertThat(built.newMode()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabChangedPath value = RepositoriesCatalogFixtures.changedPath();

        assertSoftly(softly -> {
            softly.assertThat(value.status()).isEqualTo("MODIFIED");
            softly.assertThat(value.path()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.oldPath()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.oldMode()).isEqualTo("100644");
            softly.assertThat(value.newMode()).isEqualTo("100644");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabChangedPath original = RepositoriesCatalogFixtures.changedPath();

        final GitLabChangedPath rebuilt =
                GitLabChangedPathBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabChangedPath.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("status", "path", "oldPath", "oldMode", "newMode");
    }
}
