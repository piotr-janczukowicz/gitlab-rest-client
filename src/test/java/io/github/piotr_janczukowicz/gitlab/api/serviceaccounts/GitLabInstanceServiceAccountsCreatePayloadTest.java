package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceServiceAccountsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabInstanceServiceAccountsCreatePayloadBuilder builder =
                GitLabInstanceServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload())
                        .name(null);

        final GitLabInstanceServiceAccountsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabInstanceServiceAccountsCreatePayloadBuilder builder =
                GitLabInstanceServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload())
                        .username(null);

        final GitLabInstanceServiceAccountsCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabInstanceServiceAccountsCreatePayloadBuilder builder =
                GitLabInstanceServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload())
                        .email(null);

        final GitLabInstanceServiceAccountsCreatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabInstanceServiceAccountsCreatePayloadBuilder builder =
                GitLabInstanceServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload())
                        .external(null);

        final GitLabInstanceServiceAccountsCreatePayload built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceServiceAccountsCreatePayload value =
                ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.email()).isEqualTo("email");
            softly.assertThat(value.external()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceServiceAccountsCreatePayload original =
                ServiceaccountsCatalogFixtures.instanceServiceAccountsCreatePayload();

        final GitLabInstanceServiceAccountsCreatePayload rebuilt =
                GitLabInstanceServiceAccountsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceServiceAccountsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "username", "email", "external");
    }
}
