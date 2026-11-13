package io.github.piotr_janczukowicz.gitlab.api.pagesdomains;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import io.github.piotr_janczukowicz.testsupport.UnitTest;
import java.lang.reflect.RecordComponent;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@UnitTest
class GitLabProjectPagesDomainsUpdatePayloadTest {

    @Test
    void constructor_shouldAcceptNull_whenCertificateIsNullable() {
        final GitLabProjectPagesDomainsUpdatePayloadBuilder builder =
                GitLabProjectPagesDomainsUpdatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload())
                        .certificate(null);

        final GitLabProjectPagesDomainsUpdatePayload built = builder.build();

        assertThat(built.certificate()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenKeyIsNullable() {
        final GitLabProjectPagesDomainsUpdatePayloadBuilder builder =
                GitLabProjectPagesDomainsUpdatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload())
                        .key(null);

        final GitLabProjectPagesDomainsUpdatePayload built = builder.build();

        assertThat(built.key()).isNull();
    }

    @Test
    void constructor_shouldAcceptNull_whenAutoSslEnabledIsNullable() {
        final GitLabProjectPagesDomainsUpdatePayloadBuilder builder =
                GitLabProjectPagesDomainsUpdatePayloadBuilder.builder(
                                PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload())
                        .autoSslEnabled(null);

        final GitLabProjectPagesDomainsUpdatePayload built = builder.build();

        assertThat(built.autoSslEnabled()).isNull();
    }

    @Test
    void constructor_shouldKeepEveryValue_whenAllAreGiven() {
        final GitLabProjectPagesDomainsUpdatePayload value =
                PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload();

        assertSoftly(softly -> {
            softly.assertThat(value.certificate()).isEqualTo("text");
            softly.assertThat(value.key()).isEqualTo("text");
            softly.assertThat(value.autoSslEnabled()).isEqualTo(true);
        });
    }

    @Test
    void builder_shouldBuildTheSameRecord_whenTheSameValuesAreSet() {
        final GitLabProjectPagesDomainsUpdatePayload original =
                PagesdomainsCatalogFixtures.projectPagesDomainsUpdatePayload();

        final GitLabProjectPagesDomainsUpdatePayload rebuilt =
                GitLabProjectPagesDomainsUpdatePayloadBuilder.builder(original).build();

        assertThat(rebuilt).isEqualTo(original);
    }

    @Test
    void components_shouldMatchTheSpecProperties() {
        final String[] names = Arrays.stream(GitLabProjectPagesDomainsUpdatePayload.class.getRecordComponents())
                .map(RecordComponent::getName)
                .toArray(String[]::new);

        assertThat(names).containsExactly("certificate", "key", "autoSslEnabled");
    }
}
