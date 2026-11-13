package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabReleaseSourceTest {

    @Test
    void constructor_shouldAcceptNull_whenFormatIsNullable() {
        final GitLabReleaseSourceBuilder builder = GitLabReleaseSourceBuilder.builder(
                        CommonCatalogFixtures.releaseSource())
                .format(null);

        final GitLabReleaseSource built = builder.build();

        assertThat(built.format()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabReleaseSourceBuilder builder = GitLabReleaseSourceBuilder.builder(
                        CommonCatalogFixtures.releaseSource())
                .url(null);

        final GitLabReleaseSource built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabReleaseSource value = CommonCatalogFixtures.releaseSource();

        assertSoftly(softly -> {
            softly.assertThat(value.format()).isEqualTo("zip");
            softly.assertThat(value.url()).isEqualTo("https://gitlab.example.com/root/app/-/archive/v1.0/app-v1.0.zip");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabReleaseSource original = CommonCatalogFixtures.releaseSource();

        final GitLabReleaseSource rebuilt =
                GitLabReleaseSourceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabReleaseSource.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("format", "url");
    }
}
