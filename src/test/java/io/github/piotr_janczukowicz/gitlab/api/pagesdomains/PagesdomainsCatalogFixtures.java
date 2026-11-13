package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

public final class PagesdomainsCatalogFixtures {

    private PagesdomainsCatalogFixtures() {}

    public static GitLabPagesDomain pagesDomain() {
        return GitLabPagesDomainBuilder.builder()
                .domain("domain")
                .url("url")
                .verified("verified")
                .verificationCode("verification_code")
                .enabledUntil("enabled_until")
                .autoSslEnabled("auto_ssl_enabled")
                .certificate(PagesdomainsCatalogFixtures.pagesDomainCertificate())
                .build();
    }

    public static GitLabPagesDomainBasic pagesDomainBasic() {
        return GitLabPagesDomainBasicBuilder.builder()
                .domain("domain")
                .url("url")
                .projectId("project_id")
                .verified("verified")
                .verificationCode("verification_code")
                .enabledUntil("enabled_until")
                .autoSslEnabled("auto_ssl_enabled")
                .certificateExpiration(PagesdomainsCatalogFixtures.pagesDomainCertificateExpiration())
                .build();
    }

    public static GitLabPagesDomainCertificate pagesDomainCertificate() {
        return GitLabPagesDomainCertificateBuilder.builder()
                .subject("subject")
                .expired("expired")
                .certificate("certificate")
                .certificateText("certificate_text")
                .build();
    }

    public static GitLabPagesDomainCertificateExpiration pagesDomainCertificateExpiration() {
        return GitLabPagesDomainCertificateExpirationBuilder.builder()
                .expired("expired")
                .expiration("expiration")
                .build();
    }

    public static GitLabProjectPagesDomainsCreatePayload projectPagesDomainsCreatePayload() {
        return GitLabProjectPagesDomainsCreatePayloadBuilder.builder()
                .domain("domain")
                .certificate("text")
                .key("text")
                .autoSslEnabled(true)
                .userProvidedCertificate("user_provided_certificate")
                .userProvidedKey("user_provided_key")
                .build();
    }

    public static GitLabProjectPagesDomainsUpdatePayload projectPagesDomainsUpdatePayload() {
        return GitLabProjectPagesDomainsUpdatePayloadBuilder.builder()
                .certificate("text")
                .key("text")
                .autoSslEnabled(true)
                .build();
    }
}
