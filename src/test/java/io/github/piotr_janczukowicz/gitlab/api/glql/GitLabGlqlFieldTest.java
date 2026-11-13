package io.github.piotr_janczukowicz.gitlab.api.glql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGlqlFieldTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabGlqlFieldBuilder builder =
                GitLabGlqlFieldBuilder.builder(GlqlCatalogFixtures.glqlField()).key(null);

        final GitLabGlqlField built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLabelIsNullable() {
        final GitLabGlqlFieldBuilder builder =
                GitLabGlqlFieldBuilder.builder(GlqlCatalogFixtures.glqlField()).label(null);

        final GitLabGlqlField built = builder.build();

        assertThat(built.label()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGlqlFieldBuilder builder =
                GitLabGlqlFieldBuilder.builder(GlqlCatalogFixtures.glqlField()).name(null);

        final GitLabGlqlField built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFieldIsNullable() {
        final GitLabGlqlFieldBuilder builder =
                GitLabGlqlFieldBuilder.builder(GlqlCatalogFixtures.glqlField()).field(null);

        final GitLabGlqlField built = builder.build();

        assertThat(built.field()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabGlqlFieldBuilder builder =
                GitLabGlqlFieldBuilder.builder(GlqlCatalogFixtures.glqlField()).type(null);

        final GitLabGlqlField built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenParametersIsNullable() {
        final GitLabGlqlFieldBuilder builder =
                GitLabGlqlFieldBuilder.builder(GlqlCatalogFixtures.glqlField()).parameters(null);

        final GitLabGlqlField built = builder.build();

        assertThat(built.parameters()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGlqlField value = GlqlCatalogFixtures.glqlField();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("title");
            softly.assertThat(value.label()).isEqualTo("Title");
            softly.assertThat(value.name()).isEqualTo("title");
            softly.assertThat(value.field()).isEqualTo("title");
            softly.assertThat(value.type()).isEqualTo("dimension");
            softly.assertThat(value.parameters()).isEqualTo(Map.of("key", "value"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGlqlField original = GlqlCatalogFixtures.glqlField();

        final GitLabGlqlField rebuilt = GitLabGlqlFieldBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGlqlField.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "label", "name", "field", "type", "parameters");
    }
}
