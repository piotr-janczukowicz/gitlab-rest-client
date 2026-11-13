package io.github.piotr_janczukowicz.gitlab.api.modelregistry;

public final class ModelregistryCatalogFixtures {

    private ModelregistryCatalogFixtures() {}

    public static GitLabProjectModelRegistryAuthorizeFileByPathPayload
            projectModelRegistryAuthorizeFileByPathPayload() {
        return GitLabProjectModelRegistryAuthorizeFileByPathPayloadBuilder.builder()
                .status(GitLabProjectModelRegistryAuthorizeFileByPathStatus.DEFAULT)
                .build();
    }

    public static GitLabProjectModelRegistryAuthorizeFilePayload projectModelRegistryAuthorizeFilePayload() {
        return GitLabProjectModelRegistryAuthorizeFilePayloadBuilder.builder()
                .status(GitLabProjectModelRegistryAuthorizeFileStatus.DEFAULT)
                .build();
    }
}
