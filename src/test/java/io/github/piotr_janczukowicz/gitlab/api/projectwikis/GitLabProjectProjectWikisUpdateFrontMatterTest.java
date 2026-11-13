package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWikisUpdateFrontMatterTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectWikisUpdateFrontMatterBuilder builder =
                GitLabProjectProjectWikisUpdateFrontMatterBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisUpdateFrontMatter())
                        .title(null);

        final GitLabProjectProjectWikisUpdateFrontMatter built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWikisUpdateFrontMatter value =
                ProjectwikisCatalogFixtures.projectProjectWikisUpdateFrontMatter();

        assertThat(value.title()).isEqualTo("title");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWikisUpdateFrontMatter original =
                ProjectwikisCatalogFixtures.projectProjectWikisUpdateFrontMatter();

        final GitLabProjectProjectWikisUpdateFrontMatter rebuilt =
                GitLabProjectProjectWikisUpdateFrontMatterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWikisUpdateFrontMatter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title");
    }
}
