package io.github.piotr_janczukowicz.gitlab.api.avatar;

public final class AvatarCatalogFixtures {

    private AvatarCatalogFixtures() {}

    public static GitLabAvatar avatar() {
        return GitLabAvatarBuilder.builder()
                .avatarUrl("https://example.com/avatar.png")
                .build();
    }
}
