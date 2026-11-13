package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabInstanceServiceAccountsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabInstanceServiceAccountsUpdatePayloadBuilder builder =
                GitLabInstanceServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload())
                        .name(null);

        final GitLabInstanceServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabInstanceServiceAccountsUpdatePayloadBuilder builder =
                GitLabInstanceServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload())
                        .username(null);

        final GitLabInstanceServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabInstanceServiceAccountsUpdatePayloadBuilder builder =
                GitLabInstanceServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload())
                        .email(null);

        final GitLabInstanceServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabInstanceServiceAccountsUpdatePayloadBuilder builder =
                GitLabInstanceServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload())
                        .external(null);

        final GitLabInstanceServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabInstanceServiceAccountsUpdatePayload value =
                ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.email()).isEqualTo("email");
            softly.assertThat(value.external()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabInstanceServiceAccountsUpdatePayload original =
                ServiceaccountsCatalogFixtures.instanceServiceAccountsUpdatePayload();

        final GitLabInstanceServiceAccountsUpdatePayload rebuilt =
                GitLabInstanceServiceAccountsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabInstanceServiceAccountsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "username", "email", "external");
    }
}
