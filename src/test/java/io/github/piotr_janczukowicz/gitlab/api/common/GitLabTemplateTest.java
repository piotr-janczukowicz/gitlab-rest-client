package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTemplateTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTemplateBuilder builder =
                GitLabTemplateBuilder.builder(CommonCatalogFixtures.template()).name(null);

        final GitLabTemplate built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabTemplateBuilder builder =
                GitLabTemplateBuilder.builder(CommonCatalogFixtures.template()).content(null);

        final GitLabTemplate built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTemplate value = CommonCatalogFixtures.template();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("Ruby");
            softly.assertThat(value.content()).isEqualTo("# Ruby gitignore template");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTemplate original = CommonCatalogFixtures.template();

        final GitLabTemplate rebuilt = GitLabTemplateBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTemplate.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "content");
    }
}
