package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabGroupAccessTest {

    @Test
    void constructor_shouldAcceptNull_whenAccessLevelIsNullable() {
        final GitLabGroupAccessBuilder builder = GitLabGroupAccessBuilder.builder(CommonCatalogFixtures.groupAccess())
                .accessLevel(null);

        final GitLabGroupAccess built = builder.build();

        assertThat(built.accessLevel()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNotificationLevelIsNullable() {
        final GitLabGroupAccessBuilder builder = GitLabGroupAccessBuilder.builder(CommonCatalogFixtures.groupAccess())
                .notificationLevel(null);

        final GitLabGroupAccess built = builder.build();

        assertThat(built.notificationLevel()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabGroupAccess value = CommonCatalogFixtures.groupAccess();

        assertSoftly(softly -> {
            softly.assertThat(value.accessLevel()).isEqualTo("access_level");
            softly.assertThat(value.notificationLevel()).isEqualTo("notification_level");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabGroupAccess original = CommonCatalogFixtures.groupAccess();

        final GitLabGroupAccess rebuilt =
                GitLabGroupAccessBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabGroupAccess.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("accessLevel", "notificationLevel");
    }
}
