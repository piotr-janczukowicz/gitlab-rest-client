package io.github.piotr_janczukowicz.gitlab.api.tags;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabTagReleaseTest {

    @Test
    void constructor_shouldAcceptNull_whenTagNameIsNullable() {
        final GitLabTagReleaseBuilder builder = GitLabTagReleaseBuilder.builder(TagsCatalogFixtures.tagRelease())
                .tagName(null);

        final GitLabTagRelease built = builder.build();

        assertThat(built.tagName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabTagReleaseBuilder builder = GitLabTagReleaseBuilder.builder(TagsCatalogFixtures.tagRelease())
                .description(null);

        final GitLabTagRelease built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabTagRelease value = TagsCatalogFixtures.tagRelease();

        assertSoftly(softly -> {
            softly.assertThat(value.tagName()).isEqualTo("1.0.0");
            softly.assertThat(value.description()).isEqualTo("Amazing release. Wow");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabTagRelease original = TagsCatalogFixtures.tagRelease();

        final GitLabTagRelease rebuilt =
                GitLabTagReleaseBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabTagRelease.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("tagName", "description");
    }
}
