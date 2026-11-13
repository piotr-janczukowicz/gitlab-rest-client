package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsPublishCatalogPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenMetadataIsNullable() {
        final GitLabProjectProjectsPublishCatalogPayloadBuilder builder =
                GitLabProjectProjectsPublishCatalogPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload())
                        .metadata(null);

        final GitLabProjectProjectsPublishCatalogPayload built = builder.build();

        assertThat(built.metadata()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsPublishCatalogPayload value =
                ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload();

        assertThat(value.metadata()).isEqualTo(Map.of("key", "value"));
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsPublishCatalogPayload original =
                ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload();

        final GitLabProjectProjectsPublishCatalogPayload rebuilt =
                GitLabProjectProjectsPublishCatalogPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldCopyTheMap_whenMetadataSourceChangesLater() {
        final Map<String, Object> source = new LinkedHashMap<>(Map.of("key", "value"));
        final GitLabProjectProjectsPublishCatalogPayload built =
                GitLabProjectProjectsPublishCatalogPayloadBuilder.builder(
                                ProjectsCatalogFixtures.projectProjectsPublishCatalogPayload())
                        .metadata(source)
                        .build();
        source.clear();

        assertThat(built.metadata()).isNotEmpty();
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsPublishCatalogPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("metadata");
    }
}
