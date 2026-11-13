package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupServiceAccountsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabGroupServiceAccountsUpdatePayloadBuilder builder =
                GitLabGroupServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload())
                        .name(null);

        final GitLabGroupServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabGroupServiceAccountsUpdatePayloadBuilder builder =
                GitLabGroupServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload())
                        .username(null);

        final GitLabGroupServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabGroupServiceAccountsUpdatePayloadBuilder builder =
                GitLabGroupServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload())
                        .email(null);

        final GitLabGroupServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupServiceAccountsUpdatePayload value =
                ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.email()).isEqualTo("email");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupServiceAccountsUpdatePayload original =
                ServiceaccountsCatalogFixtures.groupServiceAccountsUpdatePayload();

        final GitLabGroupServiceAccountsUpdatePayload rebuilt =
                GitLabGroupServiceAccountsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupServiceAccountsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "username", "email");
    }
}
