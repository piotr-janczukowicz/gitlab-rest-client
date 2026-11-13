package io.github.piotr_janczukowicz.gitlab.api.serviceaccounts;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabServiceAccountTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .id(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .username(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .publicEmail(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .name(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .email(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUnconfirmedEmailIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .unconfirmedEmail(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.unconfirmedEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExternalIsNullable() {
        final GitLabServiceAccountBuilder builder = GitLabServiceAccountBuilder.builder(
                        ServiceaccountsCatalogFixtures.serviceAccount())
                .external(null);

        final GitLabServiceAccount built = builder.build();

        assertThat(built.external()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabServiceAccount value = ServiceaccountsCatalogFixtures.serviceAccount();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.username()).isEqualTo("admin");
            softly.assertThat(value.publicEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.name()).isEqualTo("Administrator");
            softly.assertThat(value.email()).isEqualTo("service_account@example.com");
            softly.assertThat(value.unconfirmedEmail()).isEqualTo("updated_service_account@example.com");
            softly.assertThat(value.external()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabServiceAccount original = ServiceaccountsCatalogFixtures.serviceAccount();

        final GitLabServiceAccount rebuilt =
                GitLabServiceAccountBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabServiceAccount.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly("id", "username", "publicEmail", "name", "email", "unconfirmedEmail", "external");
    }
}
