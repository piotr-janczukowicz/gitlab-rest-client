package io.github.piotr_janczukowicz.gitlab.api.groupwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupWikisCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabGroupGroupWikisCreatePayloadBuilder builder = GitLabGroupGroupWikisCreatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisCreatePayload())
                .title(null);

        final GitLabGroupGroupWikisCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFrontMatterIsNullable() {
        final GitLabGroupGroupWikisCreatePayloadBuilder builder = GitLabGroupGroupWikisCreatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisCreatePayload())
                .frontMatter(null);

        final GitLabGroupGroupWikisCreatePayload built = builder.build();

        assertThat(built.frontMatter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabGroupGroupWikisCreatePayloadBuilder builder = GitLabGroupGroupWikisCreatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisCreatePayload())
                .content(null);

        final GitLabGroupGroupWikisCreatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabGroupGroupWikisCreatePayloadBuilder builder = GitLabGroupGroupWikisCreatePayloadBuilder.builder(
                        GroupwikisCatalogFixtures.groupGroupWikisCreatePayload())
                .format(null);

        final GitLabGroupGroupWikisCreatePayload built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupWikisCreatePayload value = GroupwikisCatalogFixtures.groupGroupWikisCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.frontMatter())
                    .isEqualTo(GroupwikisCatalogFixtures.groupGroupWikisCreateFrontMatter());
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.format()).isEqualTo(GitLabGroupGroupWikisCreateFormat.MARKDOWN);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupWikisCreatePayload original = GroupwikisCatalogFixtures.groupGroupWikisCreatePayload();

        final GitLabGroupGroupWikisCreatePayload rebuilt =
                GitLabGroupGroupWikisCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupWikisCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "frontMatter", "content", "format");
    }
}
