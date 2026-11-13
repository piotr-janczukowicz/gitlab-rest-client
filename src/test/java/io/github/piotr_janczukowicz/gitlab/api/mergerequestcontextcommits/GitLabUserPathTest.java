package io.github.piotr_janczukowicz.gitlab.api.mergerequestcontextcommits;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabUserPathTest {

    @Test
    void constructor_shouldAcceptNull_whenIdIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .id(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.id()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUsernameIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .username(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.username()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPublicEmailIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .publicEmail(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.publicEmail()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNameIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .name(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.name()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStateIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .state(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.state()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLockedIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .locked(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.locked()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarUrlIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .avatarUrl(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.avatarUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvatarPathIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .avatarPath(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.avatarPath()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCustomAttributesIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .customAttributes(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.customAttributes()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenWebUrlIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .webUrl(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.webUrl()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenStatusTooltipHtmlIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .statusTooltipHtml(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.statusTooltipHtml()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenShowStatusIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .showStatus(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.showStatus()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAvailabilityIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .availability(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.availability()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPathIsNullable() {
        final GitLabUserPathBuilder builder = GitLabUserPathBuilder.builder(
                        MergerequestcontextcommitsCatalogFixtures.userPath())
                .path(null);

        final GitLabUserPath built = builder.build();

        assertThat(built.path()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabUserPath value = MergerequestcontextcommitsCatalogFixtures.userPath();

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
            softly.assertThat(value.statusTooltipHtml()).isEqualTo("status_tooltip_html");
            softly.assertThat(value.showStatus()).isEqualTo("show_status");
            softly.assertThat(value.availability()).isEqualTo("availability");
            softly.assertThat(value.path()).isEqualTo("path");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabUserPath original = MergerequestcontextcommitsCatalogFixtures.userPath();

        final GitLabUserPath rebuilt = GitLabUserPathBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabUserPath.class.getRecordComponents())
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
                        "statusTooltipHtml",
                        "showStatus",
                        "availability",
                        "path");
    }
}
