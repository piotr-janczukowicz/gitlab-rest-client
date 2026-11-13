package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserSupportPinTest {

    @Test
    void constructor_shouldAcceptNull_whenPinIsNullable() {
        final GitLabUserSupportPinBuilder builder = GitLabUserSupportPinBuilder.builder(
                        UsersCatalogFixtures.userSupportPin())
                .pin(null);

        final GitLabUserSupportPin built = builder.build();

        assertThat(built.pin()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenExpiresAtIsNullable() {
        final GitLabUserSupportPinBuilder builder = GitLabUserSupportPinBuilder.builder(
                        UsersCatalogFixtures.userSupportPin())
                .expiresAt(null);

        final GitLabUserSupportPin built = builder.build();

        assertThat(built.expiresAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserSupportPin value = UsersCatalogFixtures.userSupportPin();

        assertSoftly(softly -> {
            softly.assertThat(value.pin()).isEqualTo("pin");
            softly.assertThat(value.expiresAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserSupportPin original = UsersCatalogFixtures.userSupportPin();

        final GitLabUserSupportPin rebuilt =
                GitLabUserSupportPinBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserSupportPin.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("pin", "expiresAt");
    }
}
