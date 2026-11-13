package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectServiceAccountsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectServiceAccountsCreatePayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePayload())
                        .name(null);

        final GitLabProjectServiceAccountsCreatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectServiceAccountsCreatePayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePayload())
                        .username(null);

        final GitLabProjectServiceAccountsCreatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabProjectServiceAccountsCreatePayloadBuilder builder =
                GitLabProjectServiceAccountsCreatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePayload())
                        .email(null);

        final GitLabProjectServiceAccountsCreatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceAccountsCreatePayload value =
                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.email()).isEqualTo("email");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectServiceAccountsCreatePayload original =
                ServiceaccountsCatalogFixtures.projectServiceAccountsCreatePayload();

        final GitLabProjectServiceAccountsCreatePayload rebuilt =
                GitLabProjectServiceAccountsCreatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectServiceAccountsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "username", "email");
    }
}
