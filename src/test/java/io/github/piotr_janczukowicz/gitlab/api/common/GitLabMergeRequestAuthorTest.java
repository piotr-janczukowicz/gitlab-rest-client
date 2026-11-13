package io.github.piotr_janczukowicz.gitlab.api.common;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabMergeRequestAuthorTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .id(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .username(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .publicEmail(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .name(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .state(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .locked(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .avatarUrl(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .avatarPath(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .customAttributes(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .webUrl(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenBotIsNullable() {
        final GitLabMergeRequestAuthorBuilder builder = GitLabMergeRequestAuthorBuilder.builder(
                        CommonCatalogFixtures.mergeRequestAuthor())
                .bot(null);

        final GitLabMergeRequestAuthor built = builder.build();

        assertThat(built.bot()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabMergeRequestAuthor value = CommonCatalogFixtures.mergeRequestAuthor();

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
            softly.assertThat(value.bot()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabMergeRequestAuthor original = CommonCatalogFixtures.mergeRequestAuthor();

        final GitLabMergeRequestAuthor rebuilt =
                GitLabMergeRequestAuthorBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabMergeRequestAuthor.class.getRecordComponents())
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
                        "webUrl",
                        "bot");
    }
}
