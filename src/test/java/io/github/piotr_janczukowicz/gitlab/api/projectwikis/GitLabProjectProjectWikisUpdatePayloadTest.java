package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWikisUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectWikisUpdatePayloadBuilder builder =
                GitLabProjectProjectWikisUpdatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisUpdatePayload())
                        .title(null);

        final GitLabProjectProjectWikisUpdatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFrontMatterIsNullable() {
        final GitLabProjectProjectWikisUpdatePayloadBuilder builder =
                GitLabProjectProjectWikisUpdatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisUpdatePayload())
                        .frontMatter(null);

        final GitLabProjectProjectWikisUpdatePayload built = builder.build();

        assertThat(built.frontMatter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectWikisUpdatePayloadBuilder builder =
                GitLabProjectProjectWikisUpdatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisUpdatePayload())
                        .content(null);

        final GitLabProjectProjectWikisUpdatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabProjectProjectWikisUpdatePayloadBuilder builder =
                GitLabProjectProjectWikisUpdatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisUpdatePayload())
                        .format(null);

        final GitLabProjectProjectWikisUpdatePayload built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWikisUpdatePayload value =
                ProjectwikisCatalogFixtures.projectProjectWikisUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.frontMatter())
                    .isEqualTo(ProjectwikisCatalogFixtures.projectProjectWikisUpdateFrontMatter());
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.format()).isEqualTo(GitLabProjectProjectWikisUpdateFormat.MARKDOWN);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWikisUpdatePayload original =
                ProjectwikisCatalogFixtures.projectProjectWikisUpdatePayload();

        final GitLabProjectProjectWikisUpdatePayload rebuilt =
                GitLabProjectProjectWikisUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWikisUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "frontMatter", "content", "format");
    }
}
