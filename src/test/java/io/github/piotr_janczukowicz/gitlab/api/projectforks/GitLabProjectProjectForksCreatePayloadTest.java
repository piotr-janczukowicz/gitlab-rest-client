package io.github.piotr_janczukowicz.gitlab.api.projectforks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectForksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .namespace(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.namespace()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .namespaceId(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespacePathIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .namespacePath(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.namespacePath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .path(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .name(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .description(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenVisibilityIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .visibility(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.visibility()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMrDefaultTargetSelfIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .mrDefaultTargetSelf(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.mrDefaultTargetSelf()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBranchesIsNullable() {
        final GitLabProjectProjectForksCreatePayloadBuilder builder =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(
                                ProjectforksCatalogFixtures.projectProjectForksCreatePayload())
                        .branches(null);

        final GitLabProjectProjectForksCreatePayload built = builder.build();

        assertThat(built.branches()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectForksCreatePayload value =
                ProjectforksCatalogFixtures.projectProjectForksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.namespace()).isEqualTo("gitlab");
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.namespacePath()).isEqualTo("new_path/gitlab");
            softly.assertThat(value.path()).isEqualTo("fork");
            softly.assertThat(value.name()).isEqualTo("Fork");
            softly.assertThat(value.description()).isEqualTo("Description");
            softly.assertThat(value.visibility()).isEqualTo(GitLabProjectProjectForksCreateVisibility.PRIVATE);
            softly.assertThat(value.mrDefaultTargetSelf()).isEqualTo(true);
            softly.assertThat(value.branches()).isEqualTo("branches");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectForksCreatePayload original =
                ProjectforksCatalogFixtures.projectProjectForksCreatePayload();

        final GitLabProjectProjectForksCreatePayload rebuilt =
                GitLabProjectProjectForksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectForksCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "namespace",
                        "namespaceId",
                        "namespacePath",
                        "path",
                        "name",
                        "description",
                        "visibility",
                        "mrDefaultTargetSelf",
                        "branches");
    }
}
