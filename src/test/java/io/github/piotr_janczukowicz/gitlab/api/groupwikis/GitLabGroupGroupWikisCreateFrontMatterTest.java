package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWikisCreateFrontMatterTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupWikisCreateFrontMatterBuilder builder =
                GitLabGroupGroupWikisCreateFrontMatterBuilder.builder(
                                GroupwikisCatalogFixtures.groupGroupWikisCreateFrontMatter())
                        .title(null);

        final GitLabGroupGroupWikisCreateFrontMatter built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWikisCreateFrontMatter value =
                GroupwikisCatalogFixtures.groupGroupWikisCreateFrontMatter();

        assertThat(value.title()).isEqualTo("title");
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWikisCreateFrontMatter original =
                GroupwikisCatalogFixtures.groupGroupWikisCreateFrontMatter();

        final GitLabGroupGroupWikisCreateFrontMatter rebuilt =
                GitLabGroupGroupWikisCreateFrontMatterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWikisCreateFrontMatter.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title");
    }
}
