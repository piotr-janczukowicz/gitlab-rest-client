package io.github.piotr_janczukowicz.gitlab.api.userapplications;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserApplicationsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserApplicationsCreatePayloadBuilder builder = GitLabUserApplicationsCreatePayloadBuilder.builder(
                        UserapplicationsCatalogFixtures.userApplicationsCreatePayload())
                .name(null);

        final GitLabUserApplicationsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRedirectUriIsNullable() {
        final GitLabUserApplicationsCreatePayloadBuilder builder = GitLabUserApplicationsCreatePayloadBuilder.builder(
                        UserapplicationsCatalogFixtures.userApplicationsCreatePayload())
                .redirectUri(null);

        final GitLabUserApplicationsCreatePayload built = builder.build();

        assertThat(built.redirectUri()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenScopesIsNullable() {
        final GitLabUserApplicationsCreatePayloadBuilder builder = GitLabUserApplicationsCreatePayloadBuilder.builder(
                        UserapplicationsCatalogFixtures.userApplicationsCreatePayload())
                .scopes(null);

        final GitLabUserApplicationsCreatePayload built = builder.build();

        assertThat(built.scopes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenConfidentialIsNullable() {
        final GitLabUserApplicationsCreatePayloadBuilder builder = GitLabUserApplicationsCreatePayloadBuilder.builder(
                        UserapplicationsCatalogFixtures.userApplicationsCreatePayload())
                .confidential(null);

        final GitLabUserApplicationsCreatePayload built = builder.build();

        assertThat(built.confidential()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserApplicationsCreatePayload value =
                UserapplicationsCatalogFixtures.userApplicationsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("MyApplication");
            softly.assertThat(value.redirectUri()).isEqualTo("https://redirect.uri");
            softly.assertThat(value.scopes()).isEqualTo("scopes");
            softly.assertThat(value.confidential()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserApplicationsCreatePayload original =
                UserapplicationsCatalogFixtures.userApplicationsCreatePayload();

        final GitLabUserApplicationsCreatePayload rebuilt =
                GitLabUserApplicationsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserApplicationsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "redirectUri", "scopes", "confidential");
    }
}
