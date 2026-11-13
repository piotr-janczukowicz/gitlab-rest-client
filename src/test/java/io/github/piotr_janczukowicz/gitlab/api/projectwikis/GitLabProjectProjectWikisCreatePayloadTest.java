package io.github.piotr_janczukowicz.gitlab.api.projectwikis;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectProjectWikisCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabProjectProjectWikisCreatePayloadBuilder builder =
                GitLabProjectProjectWikisCreatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisCreatePayload())
                        .title(null);

        final GitLabProjectProjectWikisCreatePayload built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFrontMatterIsNullable() {
        final GitLabProjectProjectWikisCreatePayloadBuilder builder =
                GitLabProjectProjectWikisCreatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisCreatePayload())
                        .frontMatter(null);

        final GitLabProjectProjectWikisCreatePayload built = builder.build();

        assertThat(built.frontMatter()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenContentIsNullable() {
        final GitLabProjectProjectWikisCreatePayloadBuilder builder =
                GitLabProjectProjectWikisCreatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisCreatePayload())
                        .content(null);

        final GitLabProjectProjectWikisCreatePayload built = builder.build();

        assertThat(built.content()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabProjectProjectWikisCreatePayloadBuilder builder =
                GitLabProjectProjectWikisCreatePayloadBuilder.builder(
                                ProjectwikisCatalogFixtures.projectProjectWikisCreatePayload())
                        .format(null);

        final GitLabProjectProjectWikisCreatePayload built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectProjectWikisCreatePayload value =
                ProjectwikisCatalogFixtures.projectProjectWikisCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("title");
            softly.assertThat(value.frontMatter())
                    .isEqualTo(ProjectwikisCatalogFixtures.projectProjectWikisCreateFrontMatter());
            softly.assertThat(value.content()).isEqualTo("content");
            softly.assertThat(value.format()).isEqualTo(GitLabProjectProjectWikisCreateFormat.MARKDOWN);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectProjectWikisCreatePayload original =
                ProjectwikisCatalogFixtures.projectProjectWikisCreatePayload();

        final GitLabProjectProjectWikisCreatePayload rebuilt =
                GitLabProjectProjectWikisCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectProjectWikisCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("title", "frontMatter", "content", "format");
    }
}
