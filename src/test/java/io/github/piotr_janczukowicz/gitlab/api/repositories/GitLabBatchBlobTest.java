package io.github.piotr_janczukowicz.gitlab.api.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabBatchBlobTest {

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabBatchBlobBuilder builder = GitLabBatchBlobBuilder.builder(RepositoriesCatalogFixtures.batchBlob())
                .path(null);

        final GitLabBatchBlob built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRefIsNullable() {
        final GitLabBatchBlobBuilder builder = GitLabBatchBlobBuilder.builder(RepositoriesCatalogFixtures.batchBlob())
                .ref(null);

        final GitLabBatchBlob built = builder.build();

        assertThat(built.ref()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSizeIsNullable() {
        final GitLabBatchBlobBuilder builder = GitLabBatchBlobBuilder.builder(RepositoriesCatalogFixtures.batchBlob())
                .size(null);

        final GitLabBatchBlob built = builder.build();

        assertThat(built.size()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTruncatedIsNullable() {
        final GitLabBatchBlobBuilder builder = GitLabBatchBlobBuilder.builder(RepositoriesCatalogFixtures.batchBlob())
                .truncated(null);

        final GitLabBatchBlob built = builder.build();

        assertThat(built.truncated()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEncodingIsNullable() {
        final GitLabBatchBlobBuilder builder = GitLabBatchBlobBuilder.builder(RepositoriesCatalogFixtures.batchBlob())
                .encoding(null);

        final GitLabBatchBlob built = builder.build();

        assertThat(built.encoding()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabBatchBlobBuilder builder = GitLabBatchBlobBuilder.builder(RepositoriesCatalogFixtures.batchBlob())
                .content(null);

        final GitLabBatchBlob built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabBatchBlob value = RepositoriesCatalogFixtures.batchBlob();

        assertSoftly(softly -> {
            softly.assertThat(value.path()).isEqualTo("app/models/user.rb");
            softly.assertThat(value.ref()).isEqualTo("main");
            softly.assertThat(value.size()).isEqualTo(1L);
            softly.assertThat(value.truncated()).isEqualTo(true);
            softly.assertThat(value.encoding()).isEqualTo("base64");
            softly.assertThat(value.content()).isEqualTo("VGhpcyBpcyBhIGZpbGU=");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabBatchBlob original = RepositoriesCatalogFixtures.batchBlob();

        final GitLabBatchBlob rebuilt = GitLabBatchBlobBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabBatchBlob.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("path", "ref", "size", "truncated", "encoding", "content");
    }
}
