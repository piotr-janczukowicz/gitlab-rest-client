package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWikisCreateFrontMatterTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectWikisCreateFrontMatterBuilder builder =
                GitLabProjectProjectWikisCreateFrontMatterBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisCreateFrontMatter())
                        .title(null);

        final GitLabProjectProjectWikisCreateFrontMatter built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWikisCreateFrontMatter value =
                ProjectwikisCatalogFixtures.projectProjectWikisCreateFrontMatter();

        assertThat(value.title()).isEqualTo("title");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWikisCreateFrontMatter original =
                ProjectwikisCatalogFixtures.projectProjectWikisCreateFrontMatter();

        final GitLabProjectProjectWikisCreateFrontMatter rebuilt =
                GitLabProjectProjectWikisCreateFrontMatterBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWikisCreateFrontMatter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title");
    }
}
