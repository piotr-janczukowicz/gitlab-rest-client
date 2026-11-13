package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.LocalDate;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserActivityTest {

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserActivityBuilder builder = GitLabUserActivityBuilder.builder(UsersCatalogFixtures.userActivity())
                .username(null);

        final GitLabUserActivity built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityOnIsNullable() {
        final GitLabUserActivityBuilder builder = GitLabUserActivityBuilder.builder(UsersCatalogFixtures.userActivity())
                .lastActivityOn(null);

        final GitLabUserActivity built = builder.build();

        assertThat(built.lastActivityOn()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLastActivityAtIsNullable() {
        final GitLabUserActivityBuilder builder = GitLabUserActivityBuilder.builder(UsersCatalogFixtures.userActivity())
                .lastActivityAt(null);

        final GitLabUserActivity built = builder.build();

        assertThat(built.lastActivityAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserActivity value = UsersCatalogFixtures.userActivity();

        assertSoftly(softly -> {
            softly.assertThat(value.username()).isEqualTo("johndoe");
            softly.assertThat(value.lastActivityOn()).isEqualTo(LocalDate.parse("2026-01-01"));
            softly.assertThat(value.lastActivityAt()).isEqualTo(LocalDate.parse("2026-01-01"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserActivity original = UsersCatalogFixtures.userActivity();

        final GitLabUserActivity rebuilt =
                GitLabUserActivityBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserActivity.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("username", "lastActivityOn", "lastActivityAt");
    }
}
