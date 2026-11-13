package io.github.piotr_janczukowicz.gitlab.api.grouprepositorystoragemoves;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupRepositoryStorageMovesCreatePayloadTest {

    @Test
    void constructor_shouldRefuseNull_whenSourceStorageNameIsNull() {
        final GitLabGroupRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabGroupRepositoryStorageMovesCreatePayloadBuilder.builder(
                                GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload())
                        .sourceStorageName(null);

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(NullPointerException.class).hasMessageContaining("sourceStorageName");
    }

    @Test
    void constructor_shouldRefuse_whenSourceStorageNameIsTooShort() {
        final GitLabGroupRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabGroupRepositoryStorageMovesCreatePayloadBuilder.builder(
                                GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload())
                        .sourceStorageName("");

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void constructor_shouldAccept_whenSourceStorageNameHasTheMinimumLength() {
        final GitLabGroupRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabGroupRepositoryStorageMovesCreatePayloadBuilder.builder(
                                GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload())
                        .sourceStorageName("x".repeat(1));

        final Throwable thrown = catchThrowable(builder::build);

        assertThat(thrown).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabGroupRepositoryStorageMovesCreatePayloadBuilder builder =
                GitLabGroupRepositoryStorageMovesCreatePayloadBuilder.builder(
                                GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload())
                        .destinationStorageName(null);

        final GitLabGroupRepositoryStorageMovesCreatePayload built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupRepositoryStorageMovesCreatePayload value =
                GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.sourceStorageName()).isEqualTo("source_storage_name");
            softly.assertThat(value.destinationStorageName()).isEqualTo("destination_storage_name");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupRepositoryStorageMovesCreatePayload original =
                GrouprepositorystoragemovesCatalogFixtures.groupRepositoryStorageMovesCreatePayload();

        final GitLabGroupRepositoryStorageMovesCreatePayload rebuilt =
                GitLabGroupRepositoryStorageMovesCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupRepositoryStorageMovesCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("sourceStorageName", "destinationStorageName");
    }
}
