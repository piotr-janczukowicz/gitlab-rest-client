package io.github.piotr_janczukowicz.gitlab.api.groupintegrations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupGroupIntegrationsGitGuardianPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenApiUrlIsNullable() {
        final GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload())
                        .apiUrl(null);

        final GitLabGroupGroupIntegrationsGitGuardianPayload built = builder.build();

        assertThat(built.apiUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenTokenIsNullable() {
        final GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload())
                        .token(null);

        final GitLabGroupGroupIntegrationsGitGuardianPayload built = builder.build();

        assertThat(built.token()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUseInheritedSettingsIsNullable() {
        final GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder builder =
                GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder.builder(
                                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload())
                        .useInheritedSettings(null);

        final GitLabGroupGroupIntegrationsGitGuardianPayload built = builder.build();

        assertThat(built.useInheritedSettings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupGroupIntegrationsGitGuardianPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.apiUrl()).isEqualTo("api_url");
            softly.assertThat(value.token()).isEqualTo("token");
            softly.assertThat(value.useInheritedSettings()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupGroupIntegrationsGitGuardianPayload original =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload();

        final GitLabGroupGroupIntegrationsGitGuardianPayload rebuilt =
                GitLabGroupGroupIntegrationsGitGuardianPayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenTokenIsACredential() {
        final GitLabGroupGroupIntegrationsGitGuardianPayload value =
                GroupintegrationsCatalogFixtures.groupGroupIntegrationsGitGuardianPayload();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupGroupIntegrationsGitGuardianPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("apiUrl", "token", "useInheritedSettings");
    }
}
