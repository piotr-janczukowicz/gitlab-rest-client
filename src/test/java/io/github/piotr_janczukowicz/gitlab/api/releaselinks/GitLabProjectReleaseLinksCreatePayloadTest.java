package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectReleaseLinksCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectReleaseLinksCreatePayloadBuilder builder =
                GitLabProjectReleaseLinksCreatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload())
                        .name(null);

        final GitLabProjectReleaseLinksCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabProjectReleaseLinksCreatePayloadBuilder builder =
                GitLabProjectReleaseLinksCreatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload())
                        .url(null);

        final GitLabProjectReleaseLinksCreatePayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDirectAssetPathIsNullable() {
        final GitLabProjectReleaseLinksCreatePayloadBuilder builder =
                GitLabProjectReleaseLinksCreatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload())
                        .directAssetPath(null);

        final GitLabProjectReleaseLinksCreatePayload built = builder.build();

        assertThat(built.directAssetPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFilepathIsNullable() {
        final GitLabProjectReleaseLinksCreatePayloadBuilder builder =
                GitLabProjectReleaseLinksCreatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload())
                        .filepath(null);

        final GitLabProjectReleaseLinksCreatePayload built = builder.build();

        assertThat(built.filepath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabProjectReleaseLinksCreatePayloadBuilder builder =
                GitLabProjectReleaseLinksCreatePayloadBuilder.builder(
                                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload())
                        .linkType(null);

        final GitLabProjectReleaseLinksCreatePayload built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectReleaseLinksCreatePayload value =
                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.directAssetPath()).isEqualTo("direct_asset_path");
            softly.assertThat(value.filepath()).isEqualTo("filepath");
            softly.assertThat(value.linkType()).isEqualTo(GitLabProjectReleaseLinksCreateLinkType.OTHER);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectReleaseLinksCreatePayload original =
                ReleaselinksCatalogFixtures.projectReleaseLinksCreatePayload();

        final GitLabProjectReleaseLinksCreatePayload rebuilt =
                GitLabProjectReleaseLinksCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectReleaseLinksCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "url", "directAssetPath", "filepath", "linkType");
    }
}
