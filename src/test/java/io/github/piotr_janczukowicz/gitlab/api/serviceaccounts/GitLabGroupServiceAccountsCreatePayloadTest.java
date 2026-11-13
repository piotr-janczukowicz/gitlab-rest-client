package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupServiceAccountsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupServiceAccountsCreatePayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload())
                        .name(null);

        final GitLabGroupServiceAccountsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupServiceAccountsCreatePayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload())
                        .username(null);

        final GitLabGroupServiceAccountsCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabGroupServiceAccountsCreatePayloadBuilder builder =
                GitLabGroupServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload())
                        .email(null);

        final GitLabGroupServiceAccountsCreatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupServiceAccountsCreatePayload value =
                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.email()).isEqualTo("email");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupServiceAccountsCreatePayload original =
                ServiceaccountsCatalogFixtures.groupServiceAccountsCreatePayload();

        final GitLabGroupServiceAccountsCreatePayload rebuilt =
                GitLabGroupServiceAccountsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupServiceAccountsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "username", "email");
    }
}
