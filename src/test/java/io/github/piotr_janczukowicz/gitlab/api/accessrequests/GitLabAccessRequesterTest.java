package io.github.piotr_janczukowicz.gitlab.api.accessrequests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAccessRequesterTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .id(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .username(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .publicEmail(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .name(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .state(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .locked(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .avatarUrl(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .avatarPath(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .customAttributes(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .webUrl(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenRequestedAtIsNullable() {
        final GitLabAccessRequesterBuilder builder = GitLabAccessRequesterBuilder.builder(
                        AccessrequestsCatalogFixtures.accessRequester())
                .requestedAt(null);

        final GitLabAccessRequester built = builder.build();

        assertThat(built.requestedAt()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAccessRequester value = AccessrequestsCatalogFixtures.accessRequester();

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
            softly.assertThat(value.requestedAt()).isEqualTo("requested_at");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAccessRequester original = AccessrequestsCatalogFixtures.accessRequester();

        final GitLabAccessRequester rebuilt =
                GitLabAccessRequesterBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAccessRequester.class.getRecordComponents())
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
                        "requestedAt");
    }
}
