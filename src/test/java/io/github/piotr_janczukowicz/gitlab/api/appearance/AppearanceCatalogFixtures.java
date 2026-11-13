package io.github.piotr_janczukowicz.gitlab.api.appearance;

public final class AppearanceCatalogFixtures {

    private AppearanceCatalogFixtures() {}

    public static GitLabAppearance appearance() {
        return GitLabAppearanceBuilder.builder()
                .title("GitLab Community Edition")
                .description("Open source software to collaborate on code")
                .pwaName("GitLab")
                .pwaShortName("GitLab")
                .pwaDescription("GitLab as PWA")
                .logo("/uploads/-/system/appearance/logo/1/logo.png")
                .pwaIcon("/uploads/-/system/appearance/pwa_icon/1/icon.png")
                .headerLogo("/uploads/-/system/appearance/header_logo/1/header.png")
                .favicon("/uploads/-/system/appearance/favicon/1/favicon.png")
                .newProjectGuidelines("Please read the FAQs for help.")
                .memberGuidelines("Please read the member guidelines.")
                .profileImageGuidelines("Custom profile image guidelines")
                .headerMessage("This is a header message")
                .footerMessage("This is a footer message")
                .messageBackgroundColor("#e75e40")
                .messageFontColor("#ffffff")
                .emailHeaderAndFooterEnabled(true)
                .siteName("GitLab")
                .build();
    }
}
