package io.github.piotr_janczukowicz.gitlab.api.gitlabduo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabDuoCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDiffsIsNullable() {
        final GitLabDuoCreatePayloadBuilder builder = GitLabDuoCreatePayloadBuilder.builder(
                        GitlabduoCatalogFixtures.duoCreatePayload())
                .diffs(null);

        final GitLabDuoCreatePayload built = builder.build();

        assertThat(built.diffs()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrTitleIsNullable() {
        final GitLabDuoCreatePayloadBuilder builder = GitLabDuoCreatePayloadBuilder.builder(
                        GitlabduoCatalogFixtures.duoCreatePayload())
                .mrTitle(null);

        final GitLabDuoCreatePayload built = builder.build();

        assertThat(built.mrTitle()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDescriptionIsNullable() {
        final GitLabDuoCreatePayloadBuilder builder = GitLabDuoCreatePayloadBuilder.builder(
                        GitlabduoCatalogFixtures.duoCreatePayload())
                .mrDescription(null);

        final GitLabDuoCreatePayload built = builder.build();

        assertThat(built.mrDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilesContentIsNullable() {
        final GitLabDuoCreatePayloadBuilder builder = GitLabDuoCreatePayloadBuilder.builder(
                        GitlabduoCatalogFixtures.duoCreatePayload())
                .filesContent(null);

        final GitLabDuoCreatePayload built = builder.build();

        assertThat(built.filesContent()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabDuoCreatePayload value = GitlabduoCatalogFixtures.duoCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.diffs()).isEqualTo("diffs");
            softly.assertThat(value.mrTitle()).isEqualTo("mr_title");
            softly.assertThat(value.mrDescription()).isEqualTo("mr_description");
            softly.assertThat(value.filesContent()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabDuoCreatePayload original = GitlabduoCatalogFixtures.duoCreatePayload();

        final GitLabDuoCreatePayload rebuilt =
                GitLabDuoCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenFilesContentSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabDuoCreatePayload built = GitLabDuoCreatePayloadBuilder.builder(
                        GitlabduoCatalogFixtures.duoCreatePayload())
                .filesContent(source)
                .build();
        source.clear();

        assertThat(built.filesContent()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabDuoCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("diffs", "mrTitle", "mrDescription", "filesContent");
    }
}
