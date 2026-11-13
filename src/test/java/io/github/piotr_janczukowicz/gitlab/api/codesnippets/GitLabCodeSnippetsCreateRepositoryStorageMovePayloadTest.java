package io.github.piotr_janczukowicz.gitlab.api.codesnippets;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCodeSnippetsCreateRepositoryStorageMovePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDestinationStorageNameIsNullable() {
        final GitLabCodeSnippetsCreateRepositoryStorageMovePayloadBuilder builder =
                GitLabCodeSnippetsCreateRepositoryStorageMovePayloadBuilder.builder(
                                CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload())
                        .destinationStorageName(null);

        final GitLabCodeSnippetsCreateRepositoryStorageMovePayload built = builder.build();

        assertThat(built.destinationStorageName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCodeSnippetsCreateRepositoryStorageMovePayload value =
                CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload();

        assertThat(value.destinationStorageName()).isEqualTo("destination_storage_name");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCodeSnippetsCreateRepositoryStorageMovePayload original =
                CodesnippetsCatalogFixtures.codeSnippetsCreateRepositoryStorageMovePayload();

        final GitLabCodeSnippetsCreateRepositoryStorageMovePayload rebuilt =
                GitLabCodeSnippetsCreateRepositoryStorageMovePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabCodeSnippetsCreateRepositoryStorageMovePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("destinationStorageName");
    }
}
