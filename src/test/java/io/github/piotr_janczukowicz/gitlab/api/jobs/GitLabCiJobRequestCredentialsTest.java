package io.github.piotr_janczukowicz.gitlab.api.jobs;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabCiJobRequestCredentialsTest {

    @Test
    void constructor_shouldAcceptNull_whenTypeIsNullable() {
        final GitLabCiJobRequestCredentialsBuilder builder = GitLabCiJobRequestCredentialsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCredentials())
                .type(null);

        final GitLabCiJobRequestCredentials built = builder.build();

        assertThat(built.type()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUrlIsNullable() {
        final GitLabCiJobRequestCredentialsBuilder builder = GitLabCiJobRequestCredentialsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCredentials())
                .url(null);

        final GitLabCiJobRequestCredentials built = builder.build();

        assertThat(built.url()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabCiJobRequestCredentialsBuilder builder = GitLabCiJobRequestCredentialsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCredentials())
                .username(null);

        final GitLabCiJobRequestCredentials built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPasswordIsNullable() {
        final GitLabCiJobRequestCredentialsBuilder builder = GitLabCiJobRequestCredentialsBuilder.builder(
                        JobsCatalogFixtures.ciJobRequestCredentials())
                .password(null);

        final GitLabCiJobRequestCredentials built = builder.build();

        assertThat(built.password()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabCiJobRequestCredentials value = JobsCatalogFixtures.ciJobRequestCredentials();

        assertSoftly(softly -> {
            softly.assertThat(value.type()).isEqualTo("type");
            softly.assertThat(value.url()).isEqualTo("url");
            softly.assertThat(value.username()).isEqualTo("username");
            softly.assertThat(value.password()).isEqualTo("password");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabCiJobRequestCredentials original = JobsCatalogFixtures.ciJobRequestCredentials();

        final GitLabCiJobRequestCredentials rebuilt =
                GitLabCiJobRequestCredentialsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void toString_shouldMaskTheValue_whenPasswordIsACredential() {
        final GitLabCiJobRequestCredentials value = JobsCatalogFixtures.ciJobRequestCredentials();

        final String text = value.toString();

        assertThat(text).contains("<redacted>");
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabCiJobRequestCredentials.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("type", "url", "username", "password");
    }
}
