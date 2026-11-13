package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTemplateListTest {

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabTemplateListBuilder builder = GitLabTemplateListBuilder.builder(
                        CommonCatalogFixtures.templateList())
                .key(null);

        final GitLabTemplateList built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabTemplateListBuilder builder = GitLabTemplateListBuilder.builder(
                        CommonCatalogFixtures.templateList())
                .name(null);

        final GitLabTemplateList built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTemplateList value = CommonCatalogFixtures.templateList();

        assertSoftly(softly -> {
            softly.assertThat(value.key()).isEqualTo("mit");
            softly.assertThat(value.name()).isEqualTo("MIT License");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTemplateList original = CommonCatalogFixtures.templateList();

        final GitLabTemplateList rebuilt =
                GitLabTemplateListBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTemplateList.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("key", "name");
    }
}
