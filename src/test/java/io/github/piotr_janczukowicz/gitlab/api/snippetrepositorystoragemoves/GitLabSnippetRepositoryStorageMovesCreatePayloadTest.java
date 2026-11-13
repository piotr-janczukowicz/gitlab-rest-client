package io.github.piotr_janczukowicz.gitlab.api.snippetrepositorystoragemoves;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSnippetRepositoryStorageMovesCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenSourceStorageNameIsNull() {
        final GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder.builder(
                                SnippetrepositorystoragemovesCatalogFixtures
                                        .snippetRepositoryStorageMovesCreatePayload())
                        .sourceStorageName(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("sourceStorageName");
    }

    @Test
    void constructor_shouldRefuse_whenSourceStorageNameIsTooShort() {
        final GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder.builder(
                                SnippetrepositorystoragemovesCatalogFixtures
                                        .snippetRepositoryStorageMovesCreatePayload())
                        .sourceStorageName("");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenSourceStorageNameHasTheMinimumLength() {
        final GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder.builder(
                                SnippetrepositorystoragemovesCatalogFixtures
                                        .snippetRepositoryStorageMovesCreatePayload())
                        .sourceStorageName("x".repeat(1));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder.builder(
                                SnippetrepositorystoragemovesCatalogFixtures
                                        .snippetRepositoryStorageMovesCreatePayload())
                        .destinationStorageName(null);

        final GitLabSnippetRepositoryStorageMovesCreatePayload built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSnippetRepositoryStorageMovesCreatePayload value =
                SnippetrepositorystoragemovesCatalogFixtures.snippetRepositoryStorageMovesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceStorageName()).isEqualTo("source_storage_name");
            softly.assertThat(value.destinationStorageName()).isEqualTo("destination_storage_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSnippetRepositoryStorageMovesCreatePayload original =
                SnippetrepositorystoragemovesCatalogFixtures.snippetRepositoryStorageMovesCreatePayload();

        final GitLabSnippetRepositoryStorageMovesCreatePayload rebuilt =
                GitLabSnippetRepositoryStorageMovesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabSnippetRepositoryStorageMovesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceStorageName", "destinationStorageName");
    }
}
