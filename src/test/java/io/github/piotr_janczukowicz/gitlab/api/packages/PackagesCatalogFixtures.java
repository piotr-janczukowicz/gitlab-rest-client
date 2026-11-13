package io.github.piotr_janczukowicz.gitlab.api.packages;

import io.github.piotr_janczukowicz.gitlab.api.common.CommonCatalogFixtures;
import java.time.Instant;
import java.util.List;

public final class PackagesCatalogFixtures {

    private PackagesCatalogFixtures() {}

    public static GitLabPackageFile packageFile() {
        return GitLabPackageFileBuilder.builder()
                .id(1L)
                .packageId(1L)
                .createdAt(Instant.parse("2026-01-01T00:00:00Z"))
                .fileName("my-app-1.5-20181107.152550-1.jar")
                .size(1L)
                .fileMd5("58e6a45a629910c6ff99145a688971ac")
                .fileSha1("ebd193463d3915d7e22219f52740056dfd26cbfe")
                .fileSha256("a903393463d3915d7e22219f52740056dfd26cbfeff321b")
                .pipelines(List.of(CommonCatalogFixtures.packagePipeline()))
                .build();
    }

    public static GitLabProjectPackagesAuthorizeGenericByPathPayload projectPackagesAuthorizeGenericByPathPayload() {
        return GitLabProjectPackagesAuthorizeGenericByPathPayloadBuilder.builder()
                .status(GitLabProjectPackagesAuthorizeGenericByPathStatus.DEFAULT)
                .build();
    }

    public static GitLabProjectPackagesAuthorizeGenericPayload projectPackagesAuthorizeGenericPayload() {
        return GitLabProjectPackagesAuthorizeGenericPayloadBuilder.builder()
                .status(GitLabProjectPackagesAuthorizeGenericStatus.DEFAULT)
                .build();
    }
}
