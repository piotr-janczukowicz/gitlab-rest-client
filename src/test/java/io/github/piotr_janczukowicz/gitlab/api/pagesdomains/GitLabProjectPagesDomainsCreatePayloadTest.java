package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPagesDomainsCreatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenDomainIsNullable() {
        final GitLabProjectPagesDomainsCreatePayloadBuilder builder =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload())
                        .domain(null);

        final GitLabProjectPagesDomainsCreatePayload built = builder.build();

        assertThat(built.domain()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenCertificateIsNullable() {
        final GitLabProjectPagesDomainsCreatePayloadBuilder builder =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload())
                        .certificate(null);

        final GitLabProjectPagesDomainsCreatePayload built = builder.build();

        assertThat(built.certificate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectPagesDomainsCreatePayloadBuilder builder =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload())
                        .key(null);

        final GitLabProjectPagesDomainsCreatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoSslEnabledIsNullable() {
        final GitLabProjectPagesDomainsCreatePayloadBuilder builder =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload())
                        .autoSslEnabled(null);

        final GitLabProjectPagesDomainsCreatePayload built = builder.build();

        assertThat(built.autoSslEnabled()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserProvidedCertificateIsNullable() {
        final GitLabProjectPagesDomainsCreatePayloadBuilder builder =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload())
                        .userProvidedCertificate(null);

        final GitLabProjectPagesDomainsCreatePayload built = builder.build();

        assertThat(built.userProvidedCertificate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenUserProvidedKeyIsNullable() {
        final GitLabProjectPagesDomainsCreatePayloadBuilder builder =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload())
                        .userProvidedKey(null);

        final GitLabProjectPagesDomainsCreatePayload built = builder.build();

        assertThat(built.userProvidedKey()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPagesDomainsCreatePayload value =
                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.domain()).isEqualTo("domain");
            softly.assertThat(value.certificate()).isEqualTo("text");
            softly.assertThat(value.key()).isEqualTo("text");
            softly.assertThat(value.autoSslEnabled()).isEqualTo(true);
            softly.assertThat(value.userProvidedCertificate()).isEqualTo("user_provided_certificate");
            softly.assertThat(value.userProvidedKey()).isEqualTo("user_provided_key");
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPagesDomainsCreatePayload original =
                PagesdomainsCatalogFixtures.projectPagesDomainsCreatePayload();

        final GitLabProjectPagesDomainsCreatePayload rebuilt =
                GitLabProjectPagesDomainsCreatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPagesDomainsCreatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names)
                .containsExactly(
                        "domain", "certificate", "key", "autoSslEnabled", "userProvidedCertificate", "userProvidedKey");
    }
}
