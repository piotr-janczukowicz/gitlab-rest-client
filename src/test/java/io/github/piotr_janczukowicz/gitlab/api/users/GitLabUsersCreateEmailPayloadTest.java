package io.github.piotr_janczukowicz.gitlab.api.users;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUsersCreateEmailPayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenEmailIsNullable() {
        final GitLabUsersCreateEmailPayloadBuilder builder = GitLabUsersCreateEmailPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateEmailPayload())
                .email(null);

        final GitLabUsersCreateEmailPayload built = builder.build();

        assertThat(built.email()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSkipConfirmationIsNullable() {
        final GitLabUsersCreateEmailPayloadBuilder builder = GitLabUsersCreateEmailPayloadBuilder.builder(
                        UsersCatalogFixtures.usersCreateEmailPayload())
                .skipConfirmation(null);

        final GitLabUsersCreateEmailPayload built = builder.build();

        assertThat(built.skipConfirmation()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUsersCreateEmailPayload value = UsersCatalogFixtures.usersCreateEmailPayload();

        assertSoftly(softly -> {
            softly.assertThat(value.email()).isEqualTo("email");
            softly.assertThat(value.skipConfirmation()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUsersCreateEmailPayload original = UsersCatalogFixtures.usersCreateEmailPayload();

        final GitLabUsersCreateEmailPayload rebuilt =
                GitLabUsersCreateEmailPayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUsersCreateEmailPayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("email", "skipConfirmation");
    }
}
