package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectAccessTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabProjectAccessBuilder builder = GitLabProjectAccessBuilder.builder(
                        CommonCatalogFixtures.projectAccess())
                .accessLevel(null);

        final GitLabProjectAccess built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotificationLevelIsNullable() {
        final GitLabProjectAccessBuilder builder = GitLabProjectAccessBuilder.builder(
                        CommonCatalogFixtures.projectAccess())
                .notificationLevel(null);

        final GitLabProjectAccess built = builder.build();

        assertThat(built.notificationLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectAccess value = CommonCatalogFixtures.projectAccess();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo("access_level");
            softly.assertThat(value.notificationLevel()).isEqualTo("notification_level");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectAccess original = CommonCatalogFixtures.projectAccess();

        final GitLabProjectAccess rebuilt =
                GitLabProjectAccessBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectAccess.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "notificationLevel");
    }
}
