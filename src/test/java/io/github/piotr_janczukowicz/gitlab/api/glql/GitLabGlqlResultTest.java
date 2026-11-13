package io.github.piotr_janczukowicz.gitlab.api.glql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGlqlResultTest {

    @Test
    void constructor_shouldAcceptNull_whenDataIsNullable() {
        final GitLabGlqlResultBuilder builder = GitLabGlqlResultBuilder.builder(GlqlCatalogFixtures.glqlResult())
                .data(null);

        final GitLabGlqlResult built = builder.build();

        assertThat(built.data()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenErrorIsNullable() {
        final GitLabGlqlResultBuilder builder = GitLabGlqlResultBuilder.builder(GlqlCatalogFixtures.glqlResult())
                .error(null);

        final GitLabGlqlResult built = builder.build();

        assertThat(built.error()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFieldsIsNullable() {
        final GitLabGlqlResultBuilder builder = GitLabGlqlResultBuilder.builder(GlqlCatalogFixtures.glqlResult())
                .fields(null);

        final GitLabGlqlResult built = builder.build();

        assertThat(built.fields()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSuccessIsNullable() {
        final GitLabGlqlResultBuilder builder = GitLabGlqlResultBuilder.builder(GlqlCatalogFixtures.glqlResult())
                .success(null);

        final GitLabGlqlResult built = builder.build();

        assertThat(built.success()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGlqlResult value = GlqlCatalogFixtures.glqlResult();

        assertSoftly(softly -> {
            softly.assertThat(value.data()).isEqualTo(GlqlCatalogFixtures.glqlData());
            softly.assertThat(value.error()).isEqualTo("error");
            softly.assertThat(value.fields()).isEqualTo(List.of(GlqlCatalogFixtures.glqlField()));
            softly.assertThat(value.success()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGlqlResult original = GlqlCatalogFixtures.glqlResult();

        final GitLabGlqlResult rebuilt =
                GitLabGlqlResultBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGlqlResult.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("data", "error", "fields", "success");
    }
}
