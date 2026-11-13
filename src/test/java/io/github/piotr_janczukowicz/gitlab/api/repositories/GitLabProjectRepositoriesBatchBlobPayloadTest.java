package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoriesBatchBlobPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenFilesIsNullable() {
        final GitLabProjectRepositoriesBatchBlobPayloadBuilder builder =
                GitLabProjectRepositoriesBatchBlobPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload())
                        .files(null);

        final GitLabProjectRepositoriesBatchBlobPayload built = builder.build();

        assertThat(built.files()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoriesBatchBlobPayload value =
                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload();

        assertThat(value.files()).isEqualTo(List.of(RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile()));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoriesBatchBlobPayload original =
                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload();

        final GitLabProjectRepositoriesBatchBlobPayload rebuilt =
                GitLabProjectRepositoriesBatchBlobPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheList_whenFilesSourceChangesLater() {
        final List<GitLabProjectRepositoriesBatchBlobFile> source =
                new ArrayList<>(List.of(RepositoriesCatalogFixtures.projectRepositoriesBatchBlobFile()));
        final GitLabProjectRepositoriesBatchBlobPayload built =
                GitLabProjectRepositoriesBatchBlobPayloadBuilder.builder(
                                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload())
                        .files(source)
                        .build();
        source.clear();

        assertThat(built.files()).isNotEmpty();
    }

    @Test
    void constructor_shouldKeepTheListUnmodifiable_whenFilesIsRead() {
        final GitLabProjectRepositoriesBatchBlobPayload built =
                RepositoriesCatalogFixtures.projectRepositoriesBatchBlobPayload();
        final List<GitLabProjectRepositoriesBatchBlobFile> values = built.files();

        final Throwable thrown = catchThrowable(values::clear);

        assertThat(thrown).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectRepositoriesBatchBlobPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("files");
    }
}
