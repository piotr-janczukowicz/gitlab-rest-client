package io.github.piotr_janczukowicz.gitlab.api.codesearch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabSearchZoektNodeTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabSearchZoektNodeBuilder builder = GitLabSearchZoektNodeBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektNode())
                .id(null);

        final GitLabSearchZoektNode built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenIndexBaseUrlIsNullable() {
        final GitLabSearchZoektNodeBuilder builder = GitLabSearchZoektNodeBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektNode())
                .indexBaseUrl(null);

        final GitLabSearchZoektNode built = builder.build();

        assertThat(built.indexBaseUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSearchBaseUrlIsNullable() {
        final GitLabSearchZoektNodeBuilder builder = GitLabSearchZoektNodeBuilder.builder(
                        CodesearchCatalogFixtures.searchZoektNode())
                .searchBaseUrl(null);

        final GitLabSearchZoektNode built = builder.build();

        assertThat(built.searchBaseUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabSearchZoektNode value = CodesearchCatalogFixtures.searchZoektNode();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.indexBaseUrl()).isEqualTo("http://127.0.0.1:6060/");
            softly.assertThat(value.searchBaseUrl()).isEqualTo("http://127.0.0.1:6070/");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabSearchZoektNode original = CodesearchCatalogFixtures.searchZoektNode();

        final GitLabSearchZoektNode rebuilt =
                GitLabSearchZoektNodeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabSearchZoektNode.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "indexBaseUrl", "searchBaseUrl");
    }
}
