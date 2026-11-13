package io.github.piotr_janczukowicz.gitlab.api.vscode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference())
                        .url(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreatedIsNullable() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceBuilder builder =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceBuilder.builder(
                                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference())
                        .created(null);

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference built = builder.build();

        assertThat(built.created()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference value =
                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.created()).isEqualTo("created");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference original =
                VscodeCatalogFixtures.apivsCodeSettingsEntitiesVsCodeSettingReference();

        final GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference rebuilt =
                GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReferenceBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(
                        GitLabAPIVsCodeSettingsEntitiesVsCodeSettingReference.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "created");
    }
}
