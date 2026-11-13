package io.github.piotr_janczukowicz.gitlab.api.issues;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabIssuableMetricImageTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabIssuableMetricImageBuilder builder = GitLabIssuableMetricImageBuilder.builder(
                        IssuesCatalogFixtures.issuableMetricImage())
                .id(null);

        final GitLabIssuableMetricImage built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabIssuableMetricImageBuilder builder = GitLabIssuableMetricImageBuilder.builder(
                        IssuesCatalogFixtures.issuableMetricImage())
                .createdAt(null);

        final GitLabIssuableMetricImage built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilenameIsNullable() {
        final GitLabIssuableMetricImageBuilder builder = GitLabIssuableMetricImageBuilder.builder(
                        IssuesCatalogFixtures.issuableMetricImage())
                .filename(null);

        final GitLabIssuableMetricImage built = builder.build();

        assertThat(built.filename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabIssuableMetricImageBuilder builder = GitLabIssuableMetricImageBuilder.builder(
                        IssuesCatalogFixtures.issuableMetricImage())
                .filePath(null);

        final GitLabIssuableMetricImage built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabIssuableMetricImageBuilder builder = GitLabIssuableMetricImageBuilder.builder(
                        IssuesCatalogFixtures.issuableMetricImage())
                .url(null);

        final GitLabIssuableMetricImage built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlTextIsNullable() {
        final GitLabIssuableMetricImageBuilder builder = GitLabIssuableMetricImageBuilder.builder(
                        IssuesCatalogFixtures.issuableMetricImage())
                .urlText(null);

        final GitLabIssuableMetricImage built = builder.build();

        assertThat(built.urlText()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabIssuableMetricImage value = IssuesCatalogFixtures.issuableMetricImage();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.filename()).isEqualTo("image.png");
            softly.assertThat(value.filePath()).isEqualTo("/uploads/-/system/issuable_metric_image/file/1/image.png");
            softly.assertThat(value.url()).isEqualTo("https://gitlab.example.com/example");
            softly.assertThat(value.urlText()).isEqualTo("Example URL");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabIssuableMetricImage original = IssuesCatalogFixtures.issuableMetricImage();

        final GitLabIssuableMetricImage rebuilt =
                GitLabIssuableMetricImageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabIssuableMetricImage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "createdAt", "filename", "filePath", "url", "urlText");
    }
}
