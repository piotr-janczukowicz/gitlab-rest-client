package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.Map;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAPIVsCodeSettingsEntitiesVsCodeManifestTest {

    @Test
    void constructor_shouldAcceptNull_whenLatestIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifestBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeManifestBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest())
                        .latest(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest built = builder.build();

        assertThat(built.latest()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSessionIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifestBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeManifestBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest())
                        .session(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest built = builder.build();

        assertThat(built.session()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest value =
                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest();

        assertSoftly(softly -> {
            softly.assertThat(value.latest()).isEqualTo(Map.of("key", "value"));
            softly.assertThat(value.session()).isEqualTo("1");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest original =
                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeManifest();

        final GitLabAPIVsCodeSettingsEntitiesVsCodeManifest rebuilt =
                GitLabAPIVsCodeSettingsEntitiesVsCodeManifestBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAPIVsCodeSettingsEntitiesVsCodeManifest.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("latest", "session");
    }
}
