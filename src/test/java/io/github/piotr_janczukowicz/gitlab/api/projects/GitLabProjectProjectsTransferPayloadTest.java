package io.github.piotr_janczukowicz.gitlab.api.projects;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectsTransferPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectProjectsTransferPayloadBuilder builder = GitLabProjectProjectsTransferPayloadBuilder.builder(
                        ProjectsCatalogFixtures.projectProjectsTransferPayload())
                .namespace(null);

        final GitLabProjectProjectsTransferPayload built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectsTransferPayload value = ProjectsCatalogFixtures.projectProjectsTransferPayload();

        assertThat(value.namespace()).isEqualTo("gitlab");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectsTransferPayload original = ProjectsCatalogFixtures.projectProjectsTransferPayload();

        final GitLabProjectProjectsTransferPayload rebuilt =
                GitLabProjectProjectsTransferPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectsTransferPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("namespace");
    }
}
