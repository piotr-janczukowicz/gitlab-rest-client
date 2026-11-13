package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabApplicationTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .id(null);

        final GitLabApplication built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplicationIdIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .applicationId(null);

        final GitLabApplication built = builder.build();

        assertThat(built.applicationId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenApplicationNameIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .applicationName(null);

        final GitLabApplication built = builder.build();

        assertThat(built.applicationName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCallbackUrlIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .callbackUrl(null);

        final GitLabApplication built = builder.build();

        assertThat(built.callbackUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .confidential(null);

        final GitLabApplication built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .scopes(null);

        final GitLabApplication built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenGranularScopesIsNullable() {
        final GitLabApplicationBuilder builder = GitLabApplicationBuilder.builder(CommonCatalogFixtures.application())
                .granularScopes(null);

        final GitLabApplication built = builder.build();

        assertThat(built.granularScopes()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabApplication value = CommonCatalogFixtures.application();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.applicationId())
                    .isEqualTo("5832fc6e14300a0d962240a8144466eef4ee93ef0d218477e55f11cf12fc3737");
            softly.assertThat(value.applicationName()).isEqualTo("MyApplication");
            softly.assertThat(value.callbackUrl()).isEqualTo("https://redirect.uri");
            softly.assertThat(value.confidential()).isEqualTo(true);
            softly.assertThat(value.scopes()).isEqualTo(List.of("api"));
            softly.assertThat(value.granularScopes()).isEqualTo(List.of(CommonCatalogFixtures.granularScope()));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabApplication original = CommonCatalogFixtures.application();

        final GitLabApplication rebuilt =
                GitLabApplicationBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabApplication.class.getRecordComponents())
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
                        "granularScopes");
    }
}
