package io.github.piotr_janczukowicz.gitlab.api.projectrepositorystoragemoves;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectRepositoryStorageMovesCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenSourceStorageNameIsNull() {
        final GitLabProjectRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabProjectRepositoryStorageMovesCreatePayloadBuilder.builder(
                                ProjectrepositorystoragemovesCatalogFixtures
                                        .projectRepositoryStorageMovesCreatePayload())
                        .sourceStorageName(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("sourceStorageName");
    }

    @Test
    void constructor_shouldRefuse_whenSourceStorageNameIsTooShort() {
        final GitLabProjectRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabProjectRepositoryStorageMovesCreatePayloadBuilder.builder(
                                ProjectrepositorystoragemovesCatalogFixtures
                                        .projectRepositoryStorageMovesCreatePayload())
                        .sourceStorageName("");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenSourceStorageNameHasTheMinimumLength() {
        final GitLabProjectRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabProjectRepositoryStorageMovesCreatePayloadBuilder.builder(
                                ProjectrepositorystoragemovesCatalogFixtures
                                        .projectRepositoryStorageMovesCreatePayload())
                        .sourceStorageName("x".repeat(1));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabProjectRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabProjectRepositoryStorageMovesCreatePayloadBuilder.builder(
                                ProjectrepositorystoragemovesCatalogFixtures
                                        .projectRepositoryStorageMovesCreatePayload())
                        .destinationStorageName(null);

        final GitLabProjectRepositoryStorageMovesCreatePayload built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectRepositoryStorageMovesCreatePayload value =
                ProjectrepositorystoragemovesCatalogFixtures.projectRepositoryStorageMovesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceStorageName()).isEqualTo("source_storage_name");
            softly.assertThat(value.destinationStorageName()).isEqualTo("destination_storage_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectRepositoryStorageMovesCreatePayload original =
                ProjectrepositorystoragemovesCatalogFixtures.projectRepositoryStorageMovesCreatePayload();

        final GitLabProjectRepositoryStorageMovesCreatePayload rebuilt =
                GitLabProjectRepositoryStorageMovesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabProjectRepositoryStorageMovesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceStorageName", "destinationStorageName");
    }
}
