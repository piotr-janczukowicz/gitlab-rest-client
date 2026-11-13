package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.time.Instant;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserCreditCardValidationsTest {

    @Test
    void constructor_shouldAcceptNull_whenUserIdIsNullable() {
        final GitLabUserCreditCardValidationsBuilder builder = GitLabUserCreditCardValidationsBuilder.builder(
                        UsersCatalogFixtures.userCreditCardValidations())
                .userId(null);

        final GitLabUserCreditCardValidations built = builder.build();

        assertThat(built.userId()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCreditCardValidatedAtIsNullable() {
        final GitLabUserCreditCardValidationsBuilder builder = GitLabUserCreditCardValidationsBuilder.builder(
                        UsersCatalogFixtures.userCreditCardValidations())
                .creditCardValidatedAt(null);

        final GitLabUserCreditCardValidations built = builder.build();

        assertThat(built.creditCardValidatedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserCreditCardValidations value = UsersCatalogFixtures.userCreditCardValidations();

        assertSoftly(softly -> {
            softly.assertThat(value.userId()).isEqualTo("user_id");
            softly.assertThat(value.creditCardValidatedAt()).isEqualTo(Instant.parse("2026-01-01T00:00:00Z"));
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserCreditCardValidations original = UsersCatalogFixtures.userCreditCardValidations();

        final GitLabUserCreditCardValidations rebuilt =
                GitLabUserCreditCardValidationsBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void constructor_shouldKeepTheInstant_whenCreditCardValidatedAtHasNoFormat() {
        final Instant instant = Instant.parse("2026-01-01T00:00:00Z");
        final GitLabUserCreditCardValidationsBuilder builder = GitLabUserCreditCardValidationsBuilder.builder(
                        UsersCatalogFixtures.userCreditCardValidations())
                .creditCardValidatedAt(instant);

        final GitLabUserCreditCardValidations built = builder.build();

        assertThat(built.creditCardValidatedAt()).isEqualTo(instant);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserCreditCardValidations.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("userId", "creditCardValidatedAt");
    }
}
