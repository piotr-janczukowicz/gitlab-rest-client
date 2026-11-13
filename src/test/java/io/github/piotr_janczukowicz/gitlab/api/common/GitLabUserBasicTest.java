package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserBasicTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .id(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .username(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .publicEmail(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .name(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .state(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .locked(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .avatarUrl(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .avatarPath(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .customAttributes(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabUserBasicBuilder builder = GitLabUserBasicBuilder.builder(CommonCatalogFixtures.userBasic())
                .webUrl(null);

        final GitLabUserBasic built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserBasic value = CommonCatalogFixtures.userBasic();

        assertSoftly(softly -> {
            softly.assertThat(value.id()).isEqualTo(1L);
            softly.assertThat(value.username()).isEqualTo("admin");
            softly.assertThat(value.publicEmail()).isEqualTo("john@example.com");
            softly.assertThat(value.name()).isEqualTo("Administrator");
            softly.assertThat(value.state()).isEqualTo("active");
            softly.assertThat(value.locked()).isEqualTo(true);
            softly.assertThat(value.avatarUrl()).isEqualTo("https://gravatar.com/avatar/1");
            softly.assertThat(value.avatarPath()).isEqualTo("/user/avatar/28/The-Big-Lebowski-400-400.png");
            softly.assertThat(value.customAttributes()).isEqualTo(List.of(CommonCatalogFixtures.customAttribute()));
            softly.assertThat(value.webUrl()).isEqualTo("https://gitlab.example.com/root");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserBasic original = CommonCatalogFixtures.userBasic();

        final GitLabUserBasic rebuilt = GitLabUserBasicBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserBasic.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "id",
                        "username",
                        "publicEmail",
                        "name",
                        "state",
                        "locked",
                        "avatarUrl",
                        "avatarPath",
                        "customAttributes",
                        "webUrl");
    }
}
