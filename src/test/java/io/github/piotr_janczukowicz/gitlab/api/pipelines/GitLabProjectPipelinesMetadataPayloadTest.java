package io.github.piotr_janczukowicz.gitlab.api.pipelines;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPipelinesMetadataPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectPipelinesMetadataPayloadBuilder builder =
                GitLabProjectPipelinesMetadataPayloadBuilder.builder(
                                PipelinesCatalogFixtures.projectPipelinesMetadataPayload())
                        .name(null);

        final GitLabProjectPipelinesMetadataPayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPipelinesMetadataPayload value = PipelinesCatalogFixtures.projectPipelinesMetadataPayload();

        assertThat(value.name()).isEqualTo("Deployment to production");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPipelinesMetadataPayload original =
                PipelinesCatalogFixtures.projectPipelinesMetadataPayload();

        final GitLabProjectPipelinesMetadataPayload rebuilt =
                GitLabProjectPipelinesMetadataPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPipelinesMetadataPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name");
    }
}
