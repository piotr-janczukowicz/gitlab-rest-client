package io.github.piotr_janczukowicz.gitlab.api.releaselinks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabReleaseLinkTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabReleaseLinkBuilder builder = GitLabReleaseLinkBuilder.builder(
                        ReleaselinksCatalogFixtures.releaseLink())
                .id(null);

        final GitLabReleaseLink built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabReleaseLinkBuilder builder = GitLabReleaseLinkBuilder.builder(
                        ReleaselinksCatalogFixtures.releaseLink())
                .name(null);

        final GitLabReleaseLink built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabReleaseLinkBuilder builder = GitLabReleaseLinkBuilder.builder(
                        ReleaselinksCatalogFixtures.releaseLink())
                .url(null);

        final GitLabReleaseLink built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDirectAssetUrlIsNullable() {
        final GitLabReleaseLinkBuilder builder = GitLabReleaseLinkBuilder.builder(
                        ReleaselinksCatalogFixtures.releaseLink())
                .directAssetUrl(null);

        final GitLabReleaseLink built = builder.build();

        assertThat(built.directAssetUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLinkTypeIsNullable() {
        final GitLabReleaseLinkBuilder builder = GitLabReleaseLinkBuilder.builder(
                        ReleaselinksCatalogFixtures.releaseLink())
                .linkType(null);

        final GitLabReleaseLink built = builder.build();

        assertThat(built.linkType()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabReleaseLink value = ReleaselinksCatalogFixtures.releaseLink();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.name()).isEqualTo("app-v1.0.dmg");
            softly.assertThat(value.url())
                    .isEqualTo("https://gitlab.example.com/root/app/-/jobs/688/artifacts/raw/bin/app-v1.0.dmg");
            softly.assertThat(value.directAssetUrl())
                    .isEqualTo("https://gitlab.example.com/root/app/-/releases/v1.0/downloads/app-v1.0.dmg");
            softly.assertThat(value.linkType()).isEqualTo("other");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabReleaseLink original = ReleaselinksCatalogFixtures.releaseLink();

        final GitLabReleaseLink rebuilt =
                GitLabReleaseLinkBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabReleaseLink.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "name", "url", "directAssetUrl", "linkType");
    }
}
