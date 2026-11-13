package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesBatchBlobFileTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectRepositoriesBatchBlobFileBuilder builder =
                GitLabProjectRepositoriesBatchBlobFileBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile())
                        .path(null);

        final GitLabProjectRepositoriesBatchBlobFile built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabProjectRepositoriesBatchBlobFileBuilder builder =
                GitLabProjectRepositoriesBatchBlobFileBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile())
                        .ref(null);

        final GitLabProjectRepositoriesBatchBlobFile built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesBatchBlobFile value =
                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile();

        assertSoftly(softly -> {
            softly.assertThat(value.path()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.ref()).isEqualTo("main");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesBatchBlobFile original =
                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile();

        final GitLabProjectRepositoriesBatchBlobFile rebuilt =
                GitLabProjectRepositoriesBatchBlobFileBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesBatchBlobFile.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path", "ref");
    }
}
