package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespaceStorageLimitExclusionTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabNamespaceStorageLimitExclusionBuilder builder = GitLabNamespaceStorageLimitExclusionBuilder.builder(
                        NamespacesCatalogFixtures.namespaceStorageLimitExclusion())
                .id(null);

        final GitLabNamespaceStorageLimitExclusion built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceIdIsNullable() {
        final GitLabNamespaceStorageLimitExclusionBuilder builder = GitLabNamespaceStorageLimitExclusionBuilder.builder(
                        NamespacesCatalogFixtures.namespaceStorageLimitExclusion())
                .namespaceId(null);

        final GitLabNamespaceStorageLimitExclusion built = builder.build();

        assertThat(built.namespaceId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNamespaceNameIsNullable() {
        final GitLabNamespaceStorageLimitExclusionBuilder builder = GitLabNamespaceStorageLimitExclusionBuilder.builder(
                        NamespacesCatalogFixtures.namespaceStorageLimitExclusion())
                .namespaceName(null);

        final GitLabNamespaceStorageLimitExclusion built = builder.build();

        assertThat(built.namespaceName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenReasonIsNullable() {
        final GitLabNamespaceStorageLimitExclusionBuilder builder = GitLabNamespaceStorageLimitExclusionBuilder.builder(
                        NamespacesCatalogFixtures.namespaceStorageLimitExclusion())
                .reason(null);

        final GitLabNamespaceStorageLimitExclusion built = builder.build();

        assertThat(built.reason()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespaceStorageLimitExclusion value = NamespacesCatalogFixtures.namespaceStorageLimitExclusion();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.namespaceId()).isEqualTo(1L);
            softly.assertThat(value.namespaceName()).isEqualTo("GitLab");
            softly.assertThat(value.reason()).isEqualTo("a reason");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespaceStorageLimitExclusion original =
                NamespacesCatalogFixtures.namespaceStorageLimitExclusion();

        final GitLabNamespaceStorageLimitExclusion rebuilt =
                GitLabNamespaceStorageLimitExclusionBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespaceStorageLimitExclusion.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "namespaceId", "namespaceName", "reason");
    }
}
