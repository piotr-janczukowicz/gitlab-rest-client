package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsHarborPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabGroupGroupIntegrationsHarborPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload())
                        .url(null);

        final GitLabGroupGroupIntegrationsHarborPayload built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProjectNameIsNullable() {
        final GitLabGroupGroupIntegrationsHarborPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload())
                        .projectName(null);

        final GitLabGroupGroupIntegrationsHarborPayload built = builder.build();

        assertThat(built.projectName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupGroupIntegrationsHarborPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload())
                        .username(null);

        final GitLabGroupGroupIntegrationsHarborPayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabGroupGroupIntegrationsHarborPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload())
                        .password(null);

        final GitLabGroupGroupIntegrationsHarborPayload built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsHarborPayloadBuilder builder =
                GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsHarborPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsHarborPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.projectName()).isEqualTo("project_name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsHarborPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload();

        final GitLabGroupGroupIntegrationsHarborPayload rebuilt =
                GitLabGroupGroupIntegrationsHarborPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabGroupGroupIntegrationsHarborPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsHarborPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsHarborPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("url", "projectName", "username", "password", "useInheritedSettings");
    }
}
