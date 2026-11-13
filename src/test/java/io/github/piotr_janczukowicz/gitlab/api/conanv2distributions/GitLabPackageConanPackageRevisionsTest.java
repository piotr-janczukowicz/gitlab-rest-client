package io.github.piotr_janczukowicz.gitlab.api.conanv2distributions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabPackageConanPackageRevisionsTest {

    @Test
    void constructor_shouldAcceptNull_whenPackageReferenceIsNullable() {
        final GitLabPackageConanPackageRevisionsBuilder builder = GitLabPackageConanPackageRevisionsBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanPackageRevisions())
                .packageReference(null);

        final GitLabPackageConanPackageRevisions built = builder.build();

        assertThat(built.packageReference()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRevisionsIsNullable() {
        final GitLabPackageConanPackageRevisionsBuilder builder = GitLabPackageConanPackageRevisionsBuilder.builder(
                        Conanv2distributionsCatalogFixtures.packageConanPackageRevisions())
                .revisions(null);

        final GitLabPackageConanPackageRevisions built = builder.build();

        assertThat(built.revisions()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabPackageConanPackageRevisions value =
                Conanv2distributionsCatalogFixtures.packageConanPackageRevisions();

        assertSoftly(softly -> {
            softly.assertThat(value.packageReference())
                    .isEqualTo(
                            "packageTest/1.2.3@gitlab-org+conan/stable#1883c9f810f2d6e5b59d5285c7141970:133a1f2158ff2cf69739f316ec21143785be54c7");
            softly.assertThat(value.revisions())
                    .isEqualTo(List.of(Conanv2distributionsCatalogFixtures.packageConanRevision()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabPackageConanPackageRevisions original =
                Conanv2distributionsCatalogFixtures.packageConanPackageRevisions();

        final GitLabPackageConanPackageRevisions rebuilt =
                GitLabPackageConanPackageRevisionsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabPackageConanPackageRevisions.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("packageReference", "revisions");
    }
}
