package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationWithSecretTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .id(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplicationIdIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .applicationId(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.applicationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplicationNameIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .applicationName(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.applicationName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCallbackUrlIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .callbackUrl(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.callbackUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .confidential(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .scopes(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .granularScopes(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSecretIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .secret(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.secret()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWarningsIsNullable() {
        final GitLabApplicationWithSecretBuilder builder = GitLabApplicationWithSecretBuilder.builder(
                        CommonCatalogFixtures.applicationWithSecret())
                .warnings(null);

        final GitLabApplicationWithSecret built = builder.build();

        assertThat(built.warnings()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplicationWithSecret value = CommonCatalogFixtures.applicationWithSecret();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.applicationId())
                    .isEqualTo("5832fc6e14300a0d962240a8144466eef4ee93ef0d218477e55f11cf12fc3737");
            softly.assertThat(value.applicationName()).isEqualTo("MyApplication");
            softly.assertThat(value.callbackUrl()).isEqualTo("https://redirect.uri");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.scopes()).isEqualTo(List.of("api"));
            softly.assertThat(value.granularScopes()).isEqualTo(List.of(CommonCatalogFixtures.granularScope()));
            softly.assertThat(value.secret())
                    .isEqualTo("ee1dd64b6adc89cf7e2c23099301ccc2c61b441064e9324d963c46902a85ec34");
            softly.assertThat(value.warnings())
                    .isEqualTo(List.of(
                            "Tokens cannot use the MCP server without a user-level scope granting execute_mcp_tool."));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplicationWithSecret original = CommonCatalogFixtures.applicationWithSecret();

        final GitLabApplicationWithSecret rebuilt =
                GitLabApplicationWithSecretBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenSecretIsACredential() {
        final GitLabApplicationWithSecret value = CommonCatalogFixtures.applicationWithSecret();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplicationWithSecret.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "applicationId",
                        "applicationName",
                        "callbackUrl",
                        "confidential",
                        "scopes",
                        "granularScopes",
                        "secret",
                        "warnings");
    }
}
