package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserSafeTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserSafeBuilder builder =
                GitLabUserSafeBuilder.builder(CommonCatalogFixtures.userSafe()).id(null);

        final GitLabUserSafe built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserSafeBuilder builder =
                GitLabUserSafeBuilder.builder(CommonCatalogFixtures.userSafe()).username(null);

        final GitLabUserSafe built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserSafeBuilder builder =
                GitLabUserSafeBuilder.builder(CommonCatalogFixtures.userSafe()).publicEmail(null);

        final GitLabUserSafe built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserSafeBuilder builder =
                GitLabUserSafeBuilder.builder(CommonCatalogFixtures.userSafe()).name(null);

        final GitLabUserSafe built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserSafe value = CommonCatalogFixtures.userSafe();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.username()).isEqualTo("admin");
            softly.assertThat(value.publicEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.name()).isEqualTo("Administrator");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserSafe original = CommonCatalogFixtures.userSafe();

        final GitLabUserSafe rebuilt = GitLabUserSafeBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserSafe.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("id", "username", "publicEmail", "name");
    }
}
