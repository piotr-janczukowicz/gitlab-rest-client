package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespaceBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .id(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .name(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .path(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKindIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .kind(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.kind()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFullPathIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .fullPath(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.fullPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParentIdIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .parentId(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.parentId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .avatarUrl(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabNamespaceBasicBuilder builder = GitLabNamespaceBasicBuilder.builder(
                        CommonCatalogFixtures.namespaceBasic())
                .webUrl(null);

        final GitLabNamespaceBasic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespaceBasic value = CommonCatalogFixtures.namespaceBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("project");
            softly.assertThat(value.path()).isEqualTo("my_project");
            softly.assertThat(value.kind()).isEqualTo("project");
            softly.assertThat(value.fullPath()).isEqualTo("group/my_project");
            softly.assertThat(value.parentId()).isEqualTo(1L);
            softly.assertThat(value.avatarUrl()).isEqualTo("https://example.com/avatar/12345");
            softly.assertThat(value.webUrl()).isEqualTo("https://example.com/group/my_project");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespaceBasic original = CommonCatalogFixtures.namespaceBasic();

        final GitLabNamespaceBasic rebuilt =
                GitLabNamespaceBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespaceBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "path", "kind", "fullPath", "parentId", "avatarUrl", "webUrl");
    }
}
