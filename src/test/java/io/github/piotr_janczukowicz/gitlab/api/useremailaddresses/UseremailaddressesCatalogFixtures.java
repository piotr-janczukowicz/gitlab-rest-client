package io.github.piotr_janczukowicz.gitlab.api.useremailaddresses;

public final class UseremailaddressesCatalogFixtures {

    private UseremailaddressesCatalogFixtures() {}

    public static GitLabUserEmailAddressesCreatePayload userEmailAddressesCreatePayload() {
        return GitLabUserEmailAddressesCreatePayloadBuilder.builder()
                .email("email")
                .build();
    }
}
