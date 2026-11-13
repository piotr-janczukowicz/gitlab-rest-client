package io.github.piotr_janczukowicz.gitlab.api.namespaces;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabNamespaceExistenceTest {

    @Test
    void constructor_shouldAcceptNull_whenExistsIsNullable() {
        final GitLabNamespaceExistenceBuilder builder = GitLabNamespaceExistenceBuilder.builder(
                        NamespacesCatalogFixtures.namespaceExistence())
                .exists(null);

        final GitLabNamespaceExistence built = builder.build();

        assertThat(built.exists()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuggestsIsNullable() {
        final GitLabNamespaceExistenceBuilder builder = GitLabNamespaceExistenceBuilder.builder(
                        NamespacesCatalogFixtures.namespaceExistence())
                .suggests(null);

        final GitLabNamespaceExistence built = builder.build();

        assertThat(built.suggests()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabNamespaceExistence value = NamespacesCatalogFixtures.namespaceExistence();

        assertSoftly(softly -> {
            softly.assertThat(value.exists()).isEqualTo(true);
            softly.assertThat(value.suggests()).isEqualTo(List.of("my-group1"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabNamespaceExistence original = NamespacesCatalogFixtures.namespaceExistence();

        final GitLabNamespaceExistence rebuilt =
                GitLabNamespaceExistenceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabNamespaceExistence.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("exists", "suggests");
    }
}
