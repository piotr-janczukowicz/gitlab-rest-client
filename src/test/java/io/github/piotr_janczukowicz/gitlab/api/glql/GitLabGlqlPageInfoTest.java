package io.github.piotr_janczukowicz.gitlab.api.glql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGlqlPageInfoTest {

    @Test
    void constructor_shouldAcceptNull_whenEndCursorIsNullable() {
        final GitLabGlqlPageInfoBuilder builder = GitLabGlqlPageInfoBuilder.builder(GlqlCatalogFixtures.glqlPageInfo())
                .endCursor(null);

        final GitLabGlqlPageInfo built = builder.build();

        assertThat(built.endCursor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasNextPageIsNullable() {
        final GitLabGlqlPageInfoBuilder builder = GitLabGlqlPageInfoBuilder.builder(GlqlCatalogFixtures.glqlPageInfo())
                .hasNextPage(null);

        final GitLabGlqlPageInfo built = builder.build();

        assertThat(built.hasNextPage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHasPreviousPageIsNullable() {
        final GitLabGlqlPageInfoBuilder builder = GitLabGlqlPageInfoBuilder.builder(GlqlCatalogFixtures.glqlPageInfo())
                .hasPreviousPage(null);

        final GitLabGlqlPageInfo built = builder.build();

        assertThat(built.hasPreviousPage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStartCursorIsNullable() {
        final GitLabGlqlPageInfoBuilder builder = GitLabGlqlPageInfoBuilder.builder(GlqlCatalogFixtures.glqlPageInfo())
                .startCursor(null);

        final GitLabGlqlPageInfo built = builder.build();

        assertThat(built.startCursor()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGlqlPageInfo value = GlqlCatalogFixtures.glqlPageInfo();

        assertSoftly(softly -> {
            softly.assertThat(value.endCursor()).isEqualTo("eyJpZCI6IjE3In0");
            softly.assertThat(value.hasNextPage()).isEqualTo(true);
            softly.assertThat(value.hasPreviousPage()).isEqualTo(true);
            softly.assertThat(value.startCursor()).isEqualTo("eyJpZCI6IjE3In0");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGlqlPageInfo original = GlqlCatalogFixtures.glqlPageInfo();

        final GitLabGlqlPageInfo rebuilt =
                GitLabGlqlPageInfoBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGlqlPageInfo.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("endCursor", "hasNextPage", "hasPreviousPage", "startCursor");
    }
}
