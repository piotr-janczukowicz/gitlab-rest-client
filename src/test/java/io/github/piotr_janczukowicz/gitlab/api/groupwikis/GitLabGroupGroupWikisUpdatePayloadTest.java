package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWikisUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupWikisUpdatePayloadBuilder builder = GitLabGroupGroupWikisUpdatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload())
                .title(null);

        final GitLabGroupGroupWikisUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFrontMatterIsNullable() {
        final GitLabGroupGroupWikisUpdatePayloadBuilder builder = GitLabGroupGroupWikisUpdatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload())
                .frontMatter(null);

        final GitLabGroupGroupWikisUpdatePayload built = builder.build();

        assertThat(built.frontMatter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabGroupGroupWikisUpdatePayloadBuilder builder = GitLabGroupGroupWikisUpdatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload())
                .content(null);

        final GitLabGroupGroupWikisUpdatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabGroupGroupWikisUpdatePayloadBuilder builder = GitLabGroupGroupWikisUpdatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload())
                .format(null);

        final GitLabGroupGroupWikisUpdatePayload built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWikisUpdatePayload value = GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.frontMatter())
                    .isEqualTo(GroupwikisCatalogFixtures.groupGroupWikisUpdateFrontMatter());
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.format()).isEqualTo(GitLabGroupGroupWikisUpdateFormat.MARKDOWN);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWikisUpdatePayload original = GroupwikisCatalogFixtures.groupGroupWikisUpdatePayload();

        final GitLabGroupGroupWikisUpdatePayload rebuilt =
                GitLabGroupGroupWikisUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWikisUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "frontMatter", "content", "format");
    }
}
