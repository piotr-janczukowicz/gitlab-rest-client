package io.github.piotr_janczukowicz.gitlab.api.importrepositoryfrombitbucketserver;

public final class ImportrepositoryfrombitbucketserverCatalogFixtures {

    private ImportrepositoryfrombitbucketserverCatalogFixtures() {}

    public static GitLabImportRepositoryFromBitbucketServerCreatePayload
            importRepositoryFromBitbucketServerCreatePayload() {
        return GitLabImportRepositoryFromBitbucketServerCreatePayloadBuilder.builder()
                .bitbucketServerUrl("bitbucket_server_url")
                .bitbucketServerUsername("bitbucket_server_username")
                .personalAccessToken("personal_access_token")
                .bitbucketServerProject("bitbucket_server_project")
                .bitbucketServerRepo("bitbucket_server_repo")
                .newName("new_name")
                .newNamespace("new_namespace")
                .timeoutStrategy(GitLabImportRepositoryFromBitbucketServerCreateTimeoutStrategy.OPTIMISTIC)
                .build();
    }
}
