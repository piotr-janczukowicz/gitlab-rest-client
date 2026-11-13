package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleaseLinksUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectReleaseLinksUpdatePayloadBuilder builder =
                GitLabProjectReleaseLinksUpdatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload())
                        .name(null);

        final GitLabProjectReleaseLinksUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectReleaseLinksUpdatePayloadBuilder builder =
                GitLabProjectReleaseLinksUpdatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload())
                        .url(null);

        final GitLabProjectReleaseLinksUpdatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDirectAssetPathIsNullable() {
        final GitLabProjectReleaseLinksUpdatePayloadBuilder builder =
                GitLabProjectReleaseLinksUpdatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload())
                        .directAssetPath(null);

        final GitLabProjectReleaseLinksUpdatePayload built = builder.build();

        assertThat(built.directAssetPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilepathIsNullable() {
        final GitLabProjectReleaseLinksUpdatePayloadBuilder builder =
                GitLabProjectReleaseLinksUpdatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload())
                        .filepath(null);

        final GitLabProjectReleaseLinksUpdatePayload built = builder.build();

        assertThat(built.filepath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabProjectReleaseLinksUpdatePayloadBuilder builder =
                GitLabProjectReleaseLinksUpdatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload())
                        .linkType(null);

        final GitLabProjectReleaseLinksUpdatePayload built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleaseLinksUpdatePayload value =
                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.directAssetPath()).isEqualTo("direct_asset_path");
            softly.assertThat(value.filepath()).isEqualTo("filepath");
            softly.assertThat(value.linkType()).isEqualTo(GitLabProjectReleaseLinksUpdateLinkType.OTHER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleaseLinksUpdatePayload original =
                ReleaselinksCatalogFixtures.projectReleaseLinksUpdatePayload();

        final GitLabProjectReleaseLinksUpdatePayload rebuilt =
                GitLabProjectReleaseLinksUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleaseLinksUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "url", "directAssetPath", "filepath", "linkType");
    }
}
