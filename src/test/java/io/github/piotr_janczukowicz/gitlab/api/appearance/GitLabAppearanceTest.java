package io.github.piotr_janczukowicz.gitlab.api.appearance;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabAppearanceTest {

    @Test
    void constructor_shouldAcceptNull_whenTitleIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .title(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.title()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenDescriptionIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .description(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.description()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPwaNameIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .pwaName(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.pwaName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPwaShortNameIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .pwaShortName(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.pwaShortName()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPwaDescriptionIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .pwaDescription(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.pwaDescription()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenLogoIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .logo(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.logo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenPwaIconIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .pwaIcon(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.pwaIcon()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeaderLogoIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .headerLogo(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.headerLogo()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFaviconIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .favicon(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.favicon()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenNewProjectGuidelinesIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .newProjectGuidelines(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.newProjectGuidelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMemberGuidelinesIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .memberGuidelines(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.memberGuidelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenProfileImageGuidelinesIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .profileImageGuidelines(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.profileImageGuidelines()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenHeaderMessageIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .headerMessage(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.headerMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenFooterMessageIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .footerMessage(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.footerMessage()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageBackgroundColorIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .messageBackgroundColor(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.messageBackgroundColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenMessageFontColorIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .messageFontColor(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.messageFontColor()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenEmailHeaderAndFooterEnabledIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .emailHeaderAndFooterEnabled(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.emailHeaderAndFooterEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenSiteNameIsNullable() {
        final GitLabAppearanceBuilder builder = GitLabAppearanceBuilder.builder(AppearanceCatalogFixtures.appearance())
                .siteName(null);

        final GitLabAppearance built = builder.build();

        assertThat(built.siteName()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabAppearance value = AppearanceCatalogFixtures.appearance();

        assertSoftly(softly -> {
            softly.assertThat(value.title()).isEqualTo("GitLab Community Edition");
            softly.assertThat(value.description()).isEqualTo("Open source software to collaborate on code");
            softly.assertThat(value.pwaName()).isEqualTo("GitLab");
            softly.assertThat(value.pwaShortName()).isEqualTo("GitLab");
            softly.assertThat(value.pwaDescription()).isEqualTo("GitLab as PWA");
            softly.assertThat(value.logo()).isEqualTo("/uploads/-/system/appearance/logo/1/logo.png");
            softly.assertThat(value.pwaIcon()).isEqualTo("/uploads/-/system/appearance/pwa_icon/1/icon.png");
            softly.assertThat(value.headerLogo()).isEqualTo("/uploads/-/system/appearance/header_logo/1/header.png");
            softly.assertThat(value.favicon()).isEqualTo("/uploads/-/system/appearance/favicon/1/favicon.png");
            softly.assertThat(value.newProjectGuidelines()).isEqualTo("Please read the FAQs for help.");
            softly.assertThat(value.memberGuidelines()).isEqualTo("Please read the member guidelines.");
            softly.assertThat(value.profileImageGuidelines()).isEqualTo("Custom profile image guidelines");
            softly.assertThat(value.headerMessage()).isEqualTo("This is a header message");
            softly.assertThat(value.footerMessage()).isEqualTo("This is a footer message");
            softly.assertThat(value.messageBackgroundColor()).isEqualTo("#e75e40");
            softly.assertThat(value.messageFontColor()).isEqualTo("#ffffff");
            softly.assertThat(value.emailHeaderAndFooterEnabled()).isEqualTo(true);
            softly.assertThat(value.siteName()).isEqualTo("GitLab");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabAppearance original = AppearanceCatalogFixtures.appearance();

        final GitLabAppearance rebuilt =
                GitLabAppearanceBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabAppearance.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "title",
                        "description",
                        "pwaName",
                        "pwaShortName",
                        "pwaDescription",
                        "logo",
                        "pwaIcon",
                        "headerLogo",
                        "favicon",
                        "newProjectGuidelines",
                        "memberGuidelines",
                        "profileImageGuidelines",
                        "headerMessage",
                        "footerMessage",
                        "messageBackgroundColor",
                        "messageFontColor",
                        "emailHeaderAndFooterEnabled",
                        "siteName");
    }
}
