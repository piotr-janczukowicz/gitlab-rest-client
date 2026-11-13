package io.github.piotr_janczukowicz.gitlab.api.alertmanagementalerts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMetricImageTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMetricImageBuilder builder = GitLabMetricImageBuilder.builder(
                        AlertmanagementalertsCatalogFixtures.metricImage())
                .id(null);

        final GitLabMetricImage built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedAtIsNullable() {
        final GitLabMetricImageBuilder builder = GitLabMetricImageBuilder.builder(
                        AlertmanagementalertsCatalogFixtures.metricImage())
                .createdAt(null);

        final GitLabMetricImage built = builder.build();

        assertThat(built.createdAt()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilenameIsNullable() {
        final GitLabMetricImageBuilder builder = GitLabMetricImageBuilder.builder(
                        AlertmanagementalertsCatalogFixtures.metricImage())
                .filename(null);

        final GitLabMetricImage built = builder.build();

        assertThat(built.filename()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilePathIsNullable() {
        final GitLabMetricImageBuilder builder = GitLabMetricImageBuilder.builder(
                        AlertmanagementalertsCatalogFixtures.metricImage())
                .filePath(null);

        final GitLabMetricImage built = builder.build();

        assertThat(built.filePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabMetricImageBuilder builder = GitLabMetricImageBuilder.builder(
                        AlertmanagementalertsCatalogFixtures.metricImage())
                .url(null);

        final GitLabMetricImage built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlTextIsNullable() {
        final GitLabMetricImageBuilder builder = GitLabMetricImageBuilder.builder(
                        AlertmanagementalertsCatalogFixtures.metricImage())
                .urlText(null);

        final GitLabMetricImage built = builder.build();

        assertThat(built.urlText()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMetricImage value = AlertmanagementalertsCatalogFixtures.metricImage();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.createdAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
            softly.assertThat(value.filename()).isEqualTo("file.png");
            softly.assertThat(value.filePath()).isEqualTo("/uploads/-/system/alert_metric_image/file/23/file.png");
            softly.assertThat(value.url()).isEqualTo("https://example.com/metric");
            softly.assertThat(value.urlText()).isEqualTo("An example metric");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMetricImage original = AlertmanagementalertsCatalogFixtures.metricImage();

        final GitLabMetricImage rebuilt =
                GitLabMetricImageBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMetricImage.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "createdAt", "filename", "filePath", "url", "urlText");
    }
}
