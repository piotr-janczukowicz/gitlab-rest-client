package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryStorageTest {

    @Test
    void constructor_shouldAcceptNull_whenDiskPathIsNullable() {
        final GitLabProjectRepositoryStorageBuilder builder = GitLabProjectRepositoryStorageBuilder.builder(
                        ProjectsCatalogFixtures.projectRepositoryStorage())
                .diskPath(null);

        final GitLabProjectRepositoryStorage built = builder.build();

        assertThat(built.diskPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectIdIsNullable() {
        final GitLabProjectRepositoryStorageBuilder builder = GitLabProjectRepositoryStorageBuilder.builder(
                        ProjectsCatalogFixtures.projectRepositoryStorage())
                .projectId(null);

        final GitLabProjectRepositoryStorage built = builder.build();

        assertThat(built.projectId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRepositoryStorageIsNullable() {
        final GitLabProjectRepositoryStorageBuilder builder = GitLabProjectRepositoryStorageBuilder.builder(
                        ProjectsCatalogFixtures.projectRepositoryStorage())
                .repositoryStorage(null);

        final GitLabProjectRepositoryStorage built = builder.build();

        assertThat(built.repositoryStorage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabProjectRepositoryStorageBuilder builder = GitLabProjectRepositoryStorageBuilder.builder(
                        ProjectsCatalogFixtures.projectRepositoryStorage())
                .createdAt(null);

        final GitLabProjectRepositoryStorage built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryStorage value = ProjectsCatalogFixtures.projectRepositoryStorage();

        assertSoftly(softly -> {
            softly.assertThat(value.diskPath())
                    .isEqualTo("@hashed/6b/86/6b86b273ff34fce19d6b804eff5a3f5747ada4eaa22f1d49c01e52ddb7875b4b");
            softly.assertThat(value.projectId()).isEqualTo(1L);
            softly.assertThat(value.repositoryStorage()).isEqualTo("default");
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryStorage original = ProjectsCatalogFixtures.projectRepositoryStorage();

        final GitLabProjectRepositoryStorage rebuilt =
                GitLabProjectRepositoryStorageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoryStorage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("diskPath", "projectId", "repositoryStorage", "createdAt");
    }
}
