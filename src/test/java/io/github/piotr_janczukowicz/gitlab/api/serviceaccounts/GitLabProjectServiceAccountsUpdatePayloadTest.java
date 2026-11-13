package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectServiceAccountsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabProjectServiceAccountsUpdatePayloadBuilder builder =
                GitLabProjectServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsUpdatePayload())
                        .name(null);

        final GitLabProjectServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabProjectServiceAccountsUpdatePayloadBuilder builder =
                GitLabProjectServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsUpdatePayload())
                        .username(null);

        final GitLabProjectServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabProjectServiceAccountsUpdatePayloadBuilder builder =
                GitLabProjectServiceAccountsUpdatePayloadBuilder.builder(
                                ServiceaccountsCatalogFixtures.projectServiceAccountsUpdatePayload())
                        .email(null);

        final GitLabProjectServiceAccountsUpdatePayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectServiceAccountsUpdatePayload value =
                ServiceaccountsCatalogFixtures.projectServiceAccountsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.name()).isEqualTo("name");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.email()).isEqualTo("email");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectServiceAccountsUpdatePayload original =
                ServiceaccountsCatalogFixtures.projectServiceAccountsUpdatePayload();

        final GitLabProjectServiceAccountsUpdatePayload rebuilt =
                GitLabProjectServiceAccountsUpdatePayloadBuilder.builder(original)
                        .build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectServiceAccountsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("name", "username", "email");
    }
}
