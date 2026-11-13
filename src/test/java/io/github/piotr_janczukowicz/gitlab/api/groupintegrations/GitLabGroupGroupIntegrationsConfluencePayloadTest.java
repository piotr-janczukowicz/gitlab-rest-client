package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsConfluencePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenConfluenceUrlIsNullable() {
        final GitLabGroupGroupIntegrationsConfluencePayloadBuilder builder =
                GitLabGroupGroupIntegrationsConfluencePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload())
                        .confluenceUrl(null);

        final GitLabGroupGroupIntegrationsConfluencePayload built = builder.build();

        assertThat(built.confluenceUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsConfluencePayloadBuilder builder =
                GitLabGroupGroupIntegrationsConfluencePayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsConfluencePayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsConfluencePayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.confluenceUrl()).isEqualTo("confluence_url");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsConfluencePayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsConfluencePayload();

        final GitLabGroupGroupIntegrationsConfluencePayload rebuilt =
                GitLabGroupGroupIntegrationsConfluencePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsConfluencePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("confluenceUrl", "useInheritedSettings");
    }
}
