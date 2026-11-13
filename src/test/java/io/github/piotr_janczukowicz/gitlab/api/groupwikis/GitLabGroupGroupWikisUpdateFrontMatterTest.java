package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWikisUpdateFrontMatterTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupWikisUpdateFrontMatterBuilder builder =
                GitLabGroupGroupWikisUpdateFrontMatterBuilder.builder(
                                GroupwikisCatalogFixtures.groupGroupWikisUpdateFrontMatter())
                        .title(null);

        final GitLabGroupGroupWikisUpdateFrontMatter built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWikisUpdateFrontMatter value =
                GroupwikisCatalogFixtures.groupGroupWikisUpdateFrontMatter();

        assertThat(value.title()).isEqualTo("title");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWikisUpdateFrontMatter original =
                GroupwikisCatalogFixtures.groupGroupWikisUpdateFrontMatter();

        final GitLabGroupGroupWikisUpdateFrontMatter rebuilt =
                GitLabGroupGroupWikisUpdateFrontMatterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWikisUpdateFrontMatter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title");
    }
}
